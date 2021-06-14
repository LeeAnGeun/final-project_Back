package bit.com.a.controller;


import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import bit.com.a.FileUploadUtiles;
import bit.com.a.dto.reviewDto;
import bit.com.a.dto.scheduleDto;
import bit.com.a.service.reviewService;

@RestController
public class reviewController {
	
	@Autowired
	reviewService rService;
	
	// 리뷰 쓰기
			@RequestMapping(value = "/writeReview", method = RequestMethod.POST)
			public String writeReview(reviewDto dto, MultipartHttpServletRequest req,
									@RequestParam("uploadFile") List<MultipartFile> files) throws Exception {
				
				System.out.println("oneDayClassController writeReview() 리뷰쓰기 " + new Date());
				System.out.println(dto.toString());
			

				String uploadPath = req.getServletContext().getRealPath("/upload"); 					
				

				List<String> filenames = new ArrayList<>();
				
				 // 파일 업로드 처리 부분
			    for(MultipartFile file : files) {
			    	//이미지 파일 이름
			        String originalName = file.getOriginalFilename();
			        String newFilename = FileUploadUtiles.getNewFilename(originalName, 1);
			        			        
			        String filepath = uploadPath + File.separator + newFilename;
			        System.out.println("Img Path : "+ filepath);
					
			        String myPath = "http://localhost:3000//upload//"; // 출력용 
			        
			        filenames.add(myPath + newFilename);		        
			        System.out.println(originalName);		 
			        			        
			        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
					os.write(file.getBytes());
					os.close();
			         
			    }	     
			       		

			  //dto 이미지경로 세팅
			  
			     if (filenames.size() == 1) {
			    	dto.setImage1(filenames.get(0));
			    	dto.setImage2("");
			    	dto.setImage3("");
			    }
			    else if (filenames.size() == 2) {
			    	dto.setImage1(filenames.get(0));
			    	dto.setImage2(filenames.get(1));
			    	dto.setImage3("");
			    }
			    else if (filenames.size() == 3) {
			    	dto.setImage1(filenames.get(0));
			    	dto.setImage2(filenames.get(1));
			    	dto.setImage3(filenames.get(2));
			    }else if (filenames.size() >= 4) {
			    	return "error";
			    }	    

			    rService.writeReview(dto);
			    System.out.println(dto);
			    
				return "uploaded";
			}


		// 리뷰 리스트
		@RequestMapping(value = "/getReviewList", method = RequestMethod.GET)
		public List<reviewDto> getReviewList(reviewDto dto){
			System.out.println("reviewController reviewList() "+ new Date());
			List<reviewDto> list = rService.getReviewList(dto);
			System.out.println(list.toString());
			
			return list;
		}
		
		//리뷰 수정
		@RequestMapping(value = "/updateReview", method = RequestMethod.POST)
		public String updateReview(reviewDto dto, MultipartHttpServletRequest req,
				@RequestParam("uploadFile") List<MultipartFile> files) throws Exception {
			System.out.println("reviewController updateReview() 리뷰수정하기 "+ new Date());
			System.out.println(dto.toString());
			
			String uploadPath = req.getServletContext().getRealPath("/upload"); 					
			

			List<String> filenames = new ArrayList<>();
			
			 // 파일 업로드 처리 부분
		    for(MultipartFile file : files) {
		    	//이미지 파일 이름
		        String originalName = file.getOriginalFilename();
		        String newFilename = FileUploadUtiles.getNewFilename(originalName, 1);
		        
		        String filepath = uploadPath + File.separator + newFilename;
		        System.out.println("Img Path : "+ filepath);
				
		        String myPath = "http://localhost:3000//upload//"; // 출력용 
		        
		        filenames.add(myPath + newFilename);		        
		        System.out.println(originalName);		 
		        
		        
		        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				os.write(file.getBytes());
				os.close();
		         
		    }	     	

		  //dto 이미지경로 세팅
		    if (filenames.size() == 0) {
		    	dto.setImage1("");
		    	dto.setImage2("");
		    	dto.setImage3("");
		    }
		    else if (filenames.size() == 1) {
		    	dto.setImage1(filenames.get(0));
		    	dto.setImage2("");
		    	dto.setImage3("");
		    }
		    else if (filenames.size() == 2) {
		    	dto.setImage1(filenames.get(0));
		    	dto.setImage2(filenames.get(1));
		    	dto.setImage3("");
		    }
		    else if (filenames.size() == 3) {
		    	dto.setImage1(filenames.get(0));
		    	dto.setImage2(filenames.get(1));
		    	dto.setImage3(filenames.get(2));
		    }else if (filenames.size() >= 4) {
		    	return "error";
		    }	    
		    
		    // 텍스트 개행
		    String content = dto.getrContent().replace("\n", "<br>");
		    dto.setrContent(content);		    
		    
		    
		    rService.updateReview(dto);
		    System.out.println(dto);
		    
			return "updated";
			
		}
		
		//작성한 리뷰 보기
		@RequestMapping(value = "/getReview", method = {RequestMethod.GET, RequestMethod.POST})
		public reviewDto getReview(reviewDto dto) {
			System.out.println("reviewController getReview() "+ new Date());
			reviewDto review = rService.getReview(dto);			
			return review;
		}
		
		// 클래스별 별점 평균
		@RequestMapping(value = "/getAvg", method = {RequestMethod.GET, RequestMethod.POST})
		public Map<String, Object> getRatingAvg(int classNum) {
			System.out.println("reviewController 클래스별 별점 평균() "+ new Date());
			System.out.println("클래스 번호(classNum)" + classNum);

			Map<String, Object> map = new HashMap<String, Object>(); 		
			reviewDto dto = new reviewDto();
			double avg = 0;
			reviewDto sAvg = new reviewDto();
			
			dto.setClassNum(classNum);
			// 리뷰 유무 확인 
			List <reviewDto> check = rService.getReviewList(dto);
			if(check.size()==0) {
				System.out.println("/// Review Null ///");
				
			}
			else {
				//클래스 총 별점 평균
				avg = rService.getRatingAvg(classNum);
				// 클래스 항목별 별점 평균
				sAvg = rService.getStarsAvg(classNum);
			}
			System.out.println(sAvg.toString());
			map.put("avg", avg);
			map.put("sAvg", sAvg);
			
			return map;
		}
		
		// 리뷰작성 가능 여부
		@RequestMapping(value = "/checkMember", method = {RequestMethod.GET, RequestMethod.POST})
		public boolean checkMember(scheduleDto dto) {
			System.out.println("checkMember = " + dto.toString());
			
			int count1 = rService.checkMember(dto);	// 리뷰 작성 갯수
			int count2 = rService.checkReview(dto);	// 리뷰 작성 가능 갯수
			System.out.println("count1 = " + count1 + ", count2 =" +count2);
			if(count1 == count2 ) {	// 작성 불가
				System.out.println("false");
				return false;
			}else {	// 작성 가능
				System.out.println("true");
				return true;
			}
		}
		
		// 리뷰 삭제 
		@RequestMapping(value = "/reviewDel", method = {RequestMethod.GET, RequestMethod.POST})
		public void reviewDel(reviewDto dto) {
			System.out.println("리뷰삭제 " + new Date() );
			System.out.println(dto.toString());
			
			rService.reviewDel(dto);
		}
		
}
