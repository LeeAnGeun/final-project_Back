package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.FileUploadUtiles;
import bit.com.a.NoClassUtil;
import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.noClassDateDto;
import bit.com.a.dto.oneDayClassParam;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.mail.MailSend;
import bit.com.a.service.aclapMemberService;
import bit.com.a.service.noClassDateService;
import bit.com.a.service.onedayClassService;
import bit.com.a.service.reviewService;

@RestController
public class onedayClassController {
	
	@Autowired
	onedayClassService onedayClassService;
	@Autowired
	aclapMemberService aclapMemberService;
	@Autowired
	reviewService reviewService;
	@Autowired
	noClassDateService noClassDateService;

	// classDtail 정보를 얻기위함
	@RequestMapping(value = "/classDtail", method = RequestMethod.POST)
	public onedayClassDto classDtail(onedayClassDto dto) {
		System.out.println("classDtail dto =" + dto.toString());

		onedayClassDto oClass = onedayClassService.getOnedayClass(dto);
		System.out.println("oClass = " + oClass.toString());

		return oClass;
	}
	
	// 디테일 뷰. 강사 개설 클래스 및 총 Like 수 
	@RequestMapping(value = "/masterClassCounter", method = RequestMethod.POST)
	public Map<String, Integer> masterClassCounter(int masterNum) {
		
		int allClass = onedayClassService.masterClassCounter(masterNum);
		System.out.println("/// 진행 클래스 : " + allClass +" 개 ///");
		int allLikes = onedayClassService.allLikesCount(masterNum);
		System.out.println("/// Likes Total : " + allLikes +" 개 ///");
		
		Map<String, Integer> map = new HashMap<>();
		map.put("allClass", allClass);
		map.put("allLikes", allLikes);
		return map;
	}

	// TODO 문의메일 발송
	@RequestMapping(value = "/contactMail", method = RequestMethod.POST)
	public boolean contactMail(String name, String mail, String content) {
		System.out.println("///// MemberController contactMail() /////");
		System.out.println("이름 : " + name);
		System.out.println("메일 : " + mail);
		System.out.println("내용 : " + content);

		boolean b = MailSend.contactMail(name, mail, content);
		if (b)
			System.out.println("Mail send Success!");
		else
			System.out.println("Mail send Fail!");
		return b;
	}

	// 클래스 카테고리별 뷰 에서 클래스 리스트 가져오기
	@RequestMapping(value = "/classListData", method = { RequestMethod.GET, RequestMethod.POST })
	public List<onedayClassDto> classListData(oneDayClassParam param) {
		System.out.println("oneDayClassController classListData()" + new Date());

		System.out.println("파라미터 확인" + param);

		List<onedayClassDto> cList = onedayClassService.classListData(param);
		System.out.println("리스트 결과들: " + cList);
		return cList;
	}



	/*
	 * // 클래스 카테고리별 뷰에서 클래스 글 총수 가져오기
	 * 
	 * @RequestMapping(value = "/classListCount", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public int classListCount(oneDayClassParam param) {
	 * System.out.println("oneDayClassController classListCount()" + new Date());
	 * 
	 * // int count = onedayClassService.classListCount(param);
	 * 
	 * // System.out.println("갯수 확인: " + count); // return count; }
	 */


	//----------------------home--------------------------	
	// Home_클래스 최신순 출력
	@RequestMapping(value = "/getNewestClassList", method = { RequestMethod.GET, RequestMethod.POST })
	public List<onedayClassDto> getNewestClassList() {
		System.out.println("////////// oneDayClassController getNewestClassList() //////////");

		List<onedayClassDto> list = onedayClassService.getNewestClassList();
		if (list.size() != 0)
			System.out.println("getNewestClassList Success");
		return list;
	}

	// Home_클래스 인기순 출력
	@RequestMapping(value = "/getBestClassList", method = { RequestMethod.GET, RequestMethod.POST })
	public List<onedayClassDto> getBestClassList() {
		System.out.println("////////// oneDayClassController getBestClassList() //////////");

		List<onedayClassDto> list = onedayClassService.getBestClassList();
		if (list.size() != 0)
			System.out.println("getBestClassList Success");
		return list;
	}
	
	// HOME_추천클래스 출력 
	@RequestMapping(value = "/getRecommendClassList", method = { RequestMethod.GET, RequestMethod.POST })
	public List<onedayClassDto> getRecommendClassList(aclapMemberDto dto) {
		System.out.println("////////// oneDayClassController getRecommendClassList() //////////");
		
		System.out.println("interest1 : " + dto.getInterest1());
		System.out.println("interest2 : " + dto.getInterest2());
		System.out.println("interest3 : " + dto.getInterest3());

		List<onedayClassDto> list = onedayClassService.getRecommendClassList(dto);
		for (onedayClassDto d : list) {
			System.out.println(d.toString());
		}
		if (list.size() != 0)
			System.out.println("getRecommendClassList Success");
		return list;
	}
	
	//-----------------------생성, 수정, 삭제 -----------------------------

	// 클래스 만들기 
	@RequestMapping(value = "/onedayClassWrite", method = RequestMethod.POST)
	public int onedayClassWrite(onedayClassDto dto, HttpServletRequest req,
			@RequestParam("imageA1") MultipartFile imageA1, @RequestParam("imageA2") MultipartFile imageA2,
			@RequestParam("imageA3") MultipartFile imageA3, @RequestParam("imageA4") MultipartFile imageA4,
			@RequestParam("imageA5") MultipartFile imageA5, @RequestParam("imageB1") MultipartFile imageB1,
			@RequestParam("imageB2") MultipartFile imageB2, @RequestParam("imageB3") MultipartFile imageB3,
			@RequestParam("imageB4") MultipartFile imageB4, @RequestParam("imageB5") MultipartFile imageB5,
			@RequestParam("imageC1") MultipartFile imageC1, @RequestParam("imageC2") MultipartFile imageC2,
			@RequestParam("imageC3") MultipartFile imageC3, @RequestParam("imageC4") MultipartFile imageC4,
			@RequestParam("imageC5") MultipartFile imageC5) {

		System.out.println("////////// onedayClassDto onedayClassWrite() //////////");

		// 개행 <br> 추가
		String content = dto.getContent().replace("\n", "<br>");
		String aboutMe = dto.getAboutMe().replace("\n", "<br>");
		String information = dto.getInformation().replace("\n", "<br>");

		dto.setContent(content);
		dto.setAboutMe(aboutMe);
		dto.setInformation(information);
		
		String image1 = ""; 
		String image2 = ""; 
		String image3 = ""; 
		String image4 = ""; 
		String image5 = "";
		
		 // LayerSelect에 따른 image값 저장
		 if(dto.getLayerSelect().equals("A")) { 
			 System.out.println("/// layerSelect = A ///");
			 image1 = imageA1.getOriginalFilename(); 
			 image2 = imageA2.getOriginalFilename(); 
			 image3 = imageA3.getOriginalFilename(); 
			 image4 = imageA4.getOriginalFilename(); 
			 image5 = imageA5.getOriginalFilename(); 
		 }
		 else if(dto.getLayerSelect().equals("B")) { 
			 System.out.println("/// layerSelect = B ///");
			 image1 = imageB1.getOriginalFilename(); 
			 image2 = imageB2.getOriginalFilename(); 
			 image3 = imageB3.getOriginalFilename(); 
			 image4 = imageB4.getOriginalFilename(); 
		     image5 = imageB5.getOriginalFilename(); 
		 }
		 else if(dto.getLayerSelect().equals("C")){ 
			 System.out.println("/// layerSelect = C ///");
		     image1 = imageC1.getOriginalFilename(); 
			 image2 = imageC2.getOriginalFilename(); 
			 image3 = imageC3.getOriginalFilename(); 
			 image4 = imageC4.getOriginalFilename(); 
			 image5 = imageC5.getOriginalFilename(); 
		 }
		 
		 // FewFileName Setting
		 String newFilename1 = FileUploadUtiles.getNewFilename(image1, 1); 
		 String newFilename2 = FileUploadUtiles.getNewFilename(image2, 2); 
		 String newFilename3 = FileUploadUtiles.getNewFilename(image3, 3); 
		 String newFilename4 = FileUploadUtiles.getNewFilename(image4, 4); 
		 String newFilename5 = FileUploadUtiles.getNewFilename(image5, 5);

		 // filepath Setting
		 String uploadPath = req.getServletContext().getRealPath("/upload");
		 String filepath1 = uploadPath + File.separator + newFilename1; 
		 String filepath2 = uploadPath + File.separator + newFilename2; 
		 String filepath3 = uploadPath + File.separator + newFilename3; 
		 String filepath4 = uploadPath + File.separator + newFilename4; 
		 String filepath5 = uploadPath + File.separator + newFilename5;
		 
		 System.out.println("/// 파일이름 체크(1) ///");
		 System.out.println(image1);
		 System.out.println(image2);
		 System.out.println(image3);
		 System.out.println(image4);
		 System.out.println(image5);
		 
		 System.out.println("/// 파일이름 체크(2) ///");
		 System.out.println(newFilename1);
		 System.out.println(newFilename2);
		 System.out.println(newFilename3);
		 System.out.println(newFilename4);
		 System.out.println(newFilename5);
		 
		 System.out.println("/// 파일이름 체크(3) ///");
		 System.out.println("Img Path : "+ filepath1); 
		 System.out.println("Img Path : "+ filepath2); 
		 System.out.println("Img Path : "+ filepath3); 
		 System.out.println("Img Path : "+ filepath4); 
		 System.out.println("Img Path : "+ filepath5); 
		 
	     String myPath = "http://localhost:3000//upload//";
		  
		 // dto에 파일경로+이름 저장
		 dto.setImage1(myPath+newFilename1);
		 dto.setImage2(myPath+newFilename2); 
		 dto.setImage3(myPath+newFilename3);
		 dto.setImage4(myPath+newFilename4); 
		 dto.setImage5(myPath+newFilename5);
		  
		 int classSeq = 0;
		 try { 
			  // 파일 업로드
			  BufferedOutputStream os1 = new BufferedOutputStream(new FileOutputStream(new File(filepath1))); 
			  BufferedOutputStream os2 = new BufferedOutputStream(new FileOutputStream(new File(filepath2)));
			  BufferedOutputStream os3 = new BufferedOutputStream(new FileOutputStream(new File(filepath3))); 
			  BufferedOutputStream os4 = new BufferedOutputStream(new FileOutputStream(new File(filepath4))); 
			  BufferedOutputStream os5 = new BufferedOutputStream(new FileOutputStream(new File(filepath5)));
			  if(dto.getLayerSelect().equals("A")) {
				  os1.write(imageA1.getBytes()); 
				  os2.write(imageA2.getBytes());
				  os3.write(imageA3.getBytes()); 
				  os4.write(imageA4.getBytes());
				  os5.write(imageA5.getBytes()); 
			  }
			  else if(dto.getLayerSelect().equals("B")) {
				  os1.write(imageB1.getBytes()); 
				  os2.write(imageB2.getBytes());
				  os3.write(imageB3.getBytes()); 
				  os4.write(imageB4.getBytes());
				  os5.write(imageB5.getBytes()); 
			  }
			  else if(dto.getLayerSelect().equals("C")) {
				  os1.write(imageC1.getBytes()); 
				  os2.write(imageC2.getBytes());
				  os3.write(imageC3.getBytes()); 
				  os4.write(imageC4.getBytes());
				  os5.write(imageC5.getBytes()); 
			  }
			  os1.close(); 
			  os2.close(); 
			  os3.close();
			  os4.close(); 
			  os5.close();
			  System.out.println("=== Image Upload Success! ===");
			  
			  // DB 저장 
			  classSeq = onedayClassService.onedayClassWrite(dto);
			  
			  // Review 초기화 작성 
			  reviewService.oneonedayClassWriteReview(classSeq);
			  
			  // Member MasterClass Update
			  aclapMemberService.classMasterUpdate(dto.getMasterNum());
	
	    	  // noClassDate 작성
			  noClassDateDto noClass = new noClassDateDto();
			  noClass.setClassNum(classSeq);
	
			  if (dto.getNoClass() == "") {
				  noClass.setNoClassDate("1991-04-02");
			  } 
			  else {
				  List<String> list = NoClassUtil.getNoClassList(dto.getStartDate(), dto.getEndDate(), dto.getNoClass());
				  for (String noDate : list) {
					  noClass.setNoClassDate(noDate);
					  noClassDateService.addNoClassDate(noClass);
				  }
			  }
		  } 
		  catch (Exception e) { 
			  e.printStackTrace(); 
		}
		return classSeq;
	}
	
	
	
	// 클래스 수정 전 정보 뿌려주기
	@RequestMapping(value = "/onedayClassInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public onedayClassDto onedayClassInfo(onedayClassDto dto) {
		System.out.println("////////// onedayClassDto onedayClassInfo() //////////");

		onedayClassDto onedayClass = onedayClassService.onedayClassInfo(dto);
		
		// noClass
		List<String> list = noClassDateService.getNoClassDate(dto);
		String noClass = NoClassUtil.getNoclassDayOfWeek(list);
		onedayClass.setNoClass(noClass);
		
		return onedayClass;
	};
	
	
	
	// 클래스 수정 
	@RequestMapping(value = "/onedayClassUpdate", method = RequestMethod.POST)
	public int onedayClassUpdate(onedayClassDto dto, HttpServletRequest req,
			@RequestParam("imageA1") MultipartFile imageA1, @RequestParam("imageA2") MultipartFile imageA2,
			@RequestParam("imageA3") MultipartFile imageA3, @RequestParam("imageA4") MultipartFile imageA4,
			@RequestParam("imageA5") MultipartFile imageA5, @RequestParam("imageB1") MultipartFile imageB1,
			@RequestParam("imageB2") MultipartFile imageB2, @RequestParam("imageB3") MultipartFile imageB3,
			@RequestParam("imageB4") MultipartFile imageB4, @RequestParam("imageB5") MultipartFile imageB5,
			@RequestParam("imageC1") MultipartFile imageC1, @RequestParam("imageC2") MultipartFile imageC2,
			@RequestParam("imageC3") MultipartFile imageC3, @RequestParam("imageC4") MultipartFile imageC4,
			@RequestParam("imageC5") MultipartFile imageC5) {
		
		System.out.println("////////// onedayClassDto onedayClassUpdate() //////////");
		int classNum = dto.getClassNum();
		System.out.println(dto.toString());
		// 개행 <br> 추가
		String content = dto.getContent().replace("\n", "<br>");
		String aboutMe = dto.getAboutMe().replace("\n", "<br>");
		String information = dto.getInformation().replace("\n", "<br>");
		dto.setContent(content);
		dto.setAboutMe(aboutMe);
		dto.setInformation(information);

		String image1 = ""; 
		String image2 = ""; 
		String image3 = ""; 
		String image4 = ""; 
		String image5 = "";
		
		// LayerSelect에 따른 image값 저장
		if(dto.getLayerSelect().equals("A")) { 
			System.out.println("/// layerSelect = A ///");
			image1 = imageA1.getOriginalFilename(); 
			image2 = imageA2.getOriginalFilename(); 
			image3 = imageA3.getOriginalFilename(); 
			image4 = imageA4.getOriginalFilename(); 
			image5 = imageA5.getOriginalFilename(); 
		}
		else if(dto.getLayerSelect().equals("B")) { 
			System.out.println("/// layerSelect = B ///");
			image1 = imageB1.getOriginalFilename(); 
			image2 = imageB2.getOriginalFilename(); 
			image3 = imageB3.getOriginalFilename(); 
			image4 = imageB4.getOriginalFilename(); 
			image5 = imageB5.getOriginalFilename(); 
		}
		else if(dto.getLayerSelect().equals("C")){ 
			System.out.println("/// layerSelect = C ///");
			image1 = imageC1.getOriginalFilename(); 
			image2 = imageC2.getOriginalFilename(); 
			image3 = imageC3.getOriginalFilename(); 
			image4 = imageC4.getOriginalFilename(); 
			image5 = imageC5.getOriginalFilename(); 
		}
		System.out.println("////////// ClassUpdate(2) //////////");
		
		// 이미지를 하나도 업로드 하지 않은 경우
		if(image1.equals("") && image2.equals("") && image3.equals("") && image4.equals("") && image5.equals("")) {
			System.out.println("=== No ImageFile! ===");			
			// onedayClass Update
			onedayClassService.onedayClassUpdate(dto);
			// noClass Update
			noClassDateService.deleteNoClassDate(dto);
			noClassDateDto noClass = new noClassDateDto();
			noClass.setClassNum(classNum);
			  if (dto.getNoClass() == "") {
				  noClass.setNoClassDate("1991-04-02");
			  } 
			  else {
				  List<String> list = NoClassUtil.getNoClassList(dto.getStartDate(), dto.getEndDate(), dto.getNoClass());
				  for (String noDate : list) {
					  System.out.println("=== noClassDate : " +noDate+" ===");
					  noClass.setNoClassDate(noDate);
					  noClassDateService.addNoClassDate(noClass);
				  }
			  }
		}
		//이미지를 하나라도 업로드했다면
		else {
			// FewFileName Setting
			String newFilename1 = FileUploadUtiles.getNewFilename(image1, 1); 
			String newFilename2 = FileUploadUtiles.getNewFilename(image2, 2); 
			String newFilename3 = FileUploadUtiles.getNewFilename(image3, 3); 
			String newFilename4 = FileUploadUtiles.getNewFilename(image4, 4); 
			String newFilename5 = FileUploadUtiles.getNewFilename(image5, 5);
			
			// filepath Setting
			String uploadPath = req.getServletContext().getRealPath("/upload");
			String filepath1 = uploadPath + File.separator + newFilename1; 
			String filepath2 = uploadPath + File.separator + newFilename2; 
			String filepath3 = uploadPath + File.separator + newFilename3; 
			String filepath4 = uploadPath + File.separator + newFilename4; 
			String filepath5 = uploadPath + File.separator + newFilename5;
			
			System.out.println("Img Path : "+ filepath1); 
			String myPath = "http://localhost:3000//upload//";
			
			System.out.println("/// 파일이름 체크(1) ///");
			System.out.println("1 = "+image1);
			System.out.println("2 = "+image2);
			System.out.println("3 = "+image3);
			System.out.println("4 = "+image4);
			System.out.println("5 = "+image5);
			 
			System.out.println("/// 파일이름 체크(2) ///");
			System.out.println("1 = "+newFilename1);
			System.out.println("2 = "+newFilename2);
			System.out.println("3 = "+newFilename3);
			System.out.println("4 = "+newFilename4);
			System.out.println("5 = "+newFilename5);
			 
			System.out.println("/// 파일이름 체크(3) ///");
			System.out.println("1 = "+filepath1);
			System.out.println("2 = "+filepath2);
			System.out.println("3 = "+filepath3);
			System.out.println("4 = "+filepath4);
			System.out.println("5 = "+filepath5);

			// 업로드한 이미지만 체크해서 DB셋팅 
			if(!newFilename1.contains(".back")) 
				dto.setImage1(myPath+newFilename1);
			if(!newFilename2.contains(".back")) 
				dto.setImage2(myPath+newFilename2); 
			if(!newFilename3.contains(".back")) 
				dto.setImage3(myPath+newFilename3);
			if(!newFilename4.contains(".back")) 
				dto.setImage4(myPath+newFilename4); 
			if(!newFilename1.contains(".back")) 
				dto.setImage5(myPath+newFilename5);
			
			System.out.println("/// 파일이름 체크(4) ///");
			System.out.println("1 : "+dto.getImage1());
			System.out.println("2 : "+dto.getImage2());
			System.out.println("3 : "+dto.getImage3());
			System.out.println("4 : "+dto.getImage4());
			System.out.println("5 : "+dto.getImage5());
			
			try { 
				// 파일 업로드
				BufferedOutputStream os1 = new BufferedOutputStream(new FileOutputStream(new File(filepath1))); 
				BufferedOutputStream os2 = new BufferedOutputStream(new FileOutputStream(new File(filepath2)));
				BufferedOutputStream os3 = new BufferedOutputStream(new FileOutputStream(new File(filepath3))); 
				BufferedOutputStream os4 = new BufferedOutputStream(new FileOutputStream(new File(filepath4))); 
				BufferedOutputStream os5 = new BufferedOutputStream(new FileOutputStream(new File(filepath5)));
				if(dto.getLayerSelect().equals("A")) {
					os1.write(imageA1.getBytes()); 
					os2.write(imageA2.getBytes());
					os3.write(imageA3.getBytes()); 
					os4.write(imageA4.getBytes());
					os5.write(imageA5.getBytes()); 
				}
				else if(dto.getLayerSelect().equals("B")) {
					os1.write(imageB1.getBytes()); 
					os2.write(imageB2.getBytes());
					os3.write(imageB3.getBytes()); 
					os4.write(imageB4.getBytes());
					os5.write(imageB5.getBytes()); 
				}
				else if(dto.getLayerSelect().equals("C")) {
					os1.write(imageC1.getBytes()); 
					os2.write(imageC2.getBytes());
					os3.write(imageC3.getBytes()); 
					os4.write(imageC4.getBytes());
					os5.write(imageC5.getBytes()); 
				}
				os1.close(); 
				os2.close(); 
				os3.close();
				os4.close(); 
				os5.close();
				System.out.println("=== Image Upload Success! ===");

				// onedayClass Update
				onedayClassService.onedayClassUpdate(dto);
				// noClass Update
				noClassDateService.deleteNoClassDate(dto);
				noClassDateDto noClass = new noClassDateDto();
				noClass.setClassNum(classNum);
				  if (dto.getNoClass() == "") {
					  noClass.setNoClassDate("1991-04-02");
				  } 
				  else {
					  List<String> list = NoClassUtil.getNoClassList(dto.getStartDate(), dto.getEndDate(), dto.getNoClass());
					  for (String noDate : list) {
						  System.out.println("=== noClassDate : " +noDate+" ===");
						  noClass.setNoClassDate(noDate);
						  noClassDateService.addNoClassDate(noClass);
					  }
				  }
			} 
			catch (Exception e) { 
				e.printStackTrace(); 
			}
		}
		return classNum;
	}
	
	
	// 클래스 중단
	@RequestMapping(value = "/onedayClassDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean onedayClassDelete(onedayClassDto dto) {
		System.out.println("////////// onedayClassDto onedayClassDelete() //////////");
		System.out.println("/// 중단할 classNum : "+dto.getClassNum() + " ///");
		boolean result = false;
		int n = onedayClassService.onedayClassDelete(dto);
		if(n>0)
			result = true;
		return result;
	}
	
	// 클래스 재개
	@RequestMapping(value = "/onedayClassRestart", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean onedayClassRestart(onedayClassDto dto) {
		System.out.println("////////// onedayClassDto onedayClassRestart() //////////");
		System.out.println("/// 재개할 classNum : "+dto.getClassNum() + " ///");
		boolean result = false;
		int n = onedayClassService.onedayClassRestart(dto);
		if(n>0)
			result = true;
		return result;
	}
	
	// endDate가 지난 클래스를 del=1로 처리
	@RequestMapping(value = "/updateEndClass", method = { RequestMethod.GET, RequestMethod.POST })
	public int updateEndClass() {
		System.out.println("updateEndClass");
		
		int count = onedayClassService.updateEndClass();
		
		return count;
	}
}