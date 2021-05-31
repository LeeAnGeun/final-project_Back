package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import bit.com.a.FileUploadUtiles;
import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.oneDayClassParam;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.mail.MailSend;
import bit.com.a.service.onedayClassService;

@RestController
public class onedayClassController {
	@Autowired
	onedayClassService onedayClassService;
	
	// mypage.html에서 classDtail 정보를 얻기위함
	@RequestMapping(value = "/classDtail", method = RequestMethod.POST)
	public onedayClassDto classDtail(onedayClassDto dto) {
		System.out.println("classDtail dto =" + dto.toString());
		
		onedayClassDto oClass = onedayClassService.getOnedayClass(dto);
		System.out.println("oClass = " + oClass.toString());
		
		return oClass;
	}

	// TODO 문의메일 발송 
	@RequestMapping(value = "/contactMail", method = RequestMethod.POST)
	public boolean contactMail(String name, String mail, String content) {
		System.out.println("///// MemberController emailSend() /////");
		System.out.println("이름 : "+name);
		System.out.println("메일 : "+mail);
		System.out.println("내용 : "+content);

		boolean b = MailSend.contactMail(name, mail, content);
		if(b) 
			System.out.println("Mail send Success!");
		else
			System.out.println("Mail send Fail!");
		return b;
	}
	
	
	
	
	// 클래스 카테고리별 뷰 에서 클래스 리스트 가져오기
	@RequestMapping(value="/classListData", method = {RequestMethod.GET, RequestMethod.POST})
	public List<onedayClassDto> classListData(oneDayClassParam param){
		System.out.println("oneDayClassController classListData()" + new Date());
		
		System.out.println("파라미터 확인"+ param);
		
		
		List<onedayClassDto> cList = onedayClassService.classListData(param);
		System.out.println("리스트 결과들: " + cList);
		return cList;
		
	}
	
	//클래스 카테고리별 뷰에서 클래스 글 총수 가져오기
	@RequestMapping(value="/classListCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int classListCount(oneDayClassParam param) {
		System.out.println("oneDayClassController classListCount()" + new Date());
		
		int count = onedayClassService.classListCount(param);
		
		System.out.println("갯수 확인: " + count);
		return count;
		
	}
	
	// Home_클래스 최신순 출력 
	@RequestMapping(value="/getNewestClassList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<onedayClassDto> getNewestClassList(){
		System.out.println("////////// oneDayClassController getNewestClassList() //////////");

		List<onedayClassDto> list = onedayClassService.getNewestClassList();
		if(list.size() != 0) 
			System.out.println("getNewestClassList Success");		
		return list;
	}
	
	// Home_클래스 인기순 출력 
	@RequestMapping(value="/getBestClassList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<onedayClassDto> getBestClassList(){
		System.out.println("////////// oneDayClassController getBestClassList() //////////");

		List<onedayClassDto> list = onedayClassService.getBestClassList();
		if(list.size() != 0) 
			System.out.println("getBestClassList Success");		
		return list;
	}

	// 클래스 만들기 
	@RequestMapping(value = "/onedayClassWrite", method = RequestMethod.POST)
	public boolean addMember(onedayClassDto dto, HttpServletRequest req, String noClassDayOfWeek,
							@RequestParam("imageA1") MultipartFile imageA1, @RequestParam("imageA2") MultipartFile imageA2,
							@RequestParam("imageA3") MultipartFile imageA3, @RequestParam("imageA4") MultipartFile imageA4,
							@RequestParam("imageA5") MultipartFile imageA5, @RequestParam("imageB1") MultipartFile imageB1,
							@RequestParam("imageB2") MultipartFile imageB2, @RequestParam("imageB3") MultipartFile imageB3,
							@RequestParam("imageB4") MultipartFile imageB4, @RequestParam("imageB5") MultipartFile imageB5,
							@RequestParam("imageC1") MultipartFile imageC1, @RequestParam("imageC2") MultipartFile imageC2,
							@RequestParam("imageC3") MultipartFile imageC3, @RequestParam("imageC4") MultipartFile imageC4,
							@RequestParam("imageC5") MultipartFile imageC5){
	
		System.out.println("////////// onedayClassDto onedayClassWrite() //////////");
		
		
		
		
		/*
		 * String image1 = ""; String image2 = ""; String image3 = ""; String image4 =
		 * ""; String image5 = "";
		 * 
		 * if(layerSelect=="A") { image1 = imageA1.getOriginalFilename(); image2 =
		 * imageA2.getOriginalFilename(); image3 = imageA3.getOriginalFilename(); image4
		 * = imageA4.getOriginalFilename(); image5 = imageA5.getOriginalFilename(); }
		 * else if(layerSelect=="B") { image1 = imageB1.getOriginalFilename(); image2 =
		 * imageB2.getOriginalFilename(); image3 = imageB3.getOriginalFilename(); image4
		 * = imageB4.getOriginalFilename(); image5 = imageB5.getOriginalFilename(); }
		 * else { image1 = imageC1.getOriginalFilename(); image2 =
		 * imageC2.getOriginalFilename(); image3 = imageC3.getOriginalFilename(); image4
		 * = imageC4.getOriginalFilename(); image5 = imageC5.getOriginalFilename(); }
		 * 
		 * String newFilename1 = FileUploadUtiles.getNewFilename(image1); String
		 * newFilename2 = FileUploadUtiles.getNewFilename(image2); String newFilename3 =
		 * FileUploadUtiles.getNewFilename(image3); String newFilename4 =
		 * FileUploadUtiles.getNewFilename(image4); String newFilename5 =
		 * FileUploadUtiles.getNewFilename(image5);
		 * 
		 * String uploadPath = req.getServletContext().getRealPath("/upload");
		 * 
		 * String filepath1 = uploadPath + File.separator + newFilename1; String
		 * filepath2 = uploadPath + File.separator + newFilename2; String filepath3 =
		 * uploadPath + File.separator + newFilename3; String filepath4 = uploadPath +
		 * File.separator + newFilename4; String filepath5 = uploadPath + File.separator
		 * + newFilename5;
		 * 
		 * System.out.println("Img Path : "+ filepath1); String myPath =
		 * "http://localhost:3000//upload//";
		 * 
		 * // dto.setLayerSelect(layerSelect); dto.setImage1(myPath+newFilename1);
		 * dto.setImage2(myPath+newFilename2); dto.setImage3(myPath+newFilename3);
		 * dto.setImage4(myPath+newFilename4); dto.setImage5(myPath+newFilename5);
		 * 
		 * try { BufferedOutputStream os1 = new BufferedOutputStream(new
		 * FileOutputStream(new File(filepath1))); BufferedOutputStream os2 = new
		 * BufferedOutputStream(new FileOutputStream(new File(filepath2)));
		 * BufferedOutputStream os3 = new BufferedOutputStream(new FileOutputStream(new
		 * File(filepath3))); BufferedOutputStream os4 = new BufferedOutputStream(new
		 * FileOutputStream(new File(filepath4))); BufferedOutputStream os5 = new
		 * BufferedOutputStream(new FileOutputStream(new File(filepath5)));
		 * os1.write(image1.getBytes()); os2.write(image2.getBytes());
		 * os3.write(image3.getBytes()); os4.write(image4.getBytes());
		 * os5.write(image5.getBytes()); os1.close(); os2.close(); os3.close();
		 * os4.close(); os5.close();
		 * 
		 * //db저장 //service.addMember(dto); // 클래스 개설 멤버라고 업데이트 해줘야함 masterNum
		 * 
		 * } catch (Exception e) { e.printStackTrace(); return false; }
		 */
		return true;
	}
	


	
}