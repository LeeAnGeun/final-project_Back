package bit.com.a.controller;


import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import bit.com.a.service.reviewService;

@RestController
public class reviewController {
	
	@Autowired
	reviewService rService;

	// 리뷰 쓰기
		@RequestMapping(value = "/writeReview", method = RequestMethod.POST)
		public String writeReview(reviewDto dto, MultipartHttpServletRequest req,
								@RequestParam("uploadFile") List<MultipartFile> files) throws Exception {
			
			System.out.println("oneDayClassController writeReview() " + new Date());
			System.out.println(dto.toString());
		
			String uploadPath = req.getServletContext().getRealPath("/upload"); 					
			
			List<String> filenames = new ArrayList<>();
			
			 // 파일 업로드 처리 부분
		    for(MultipartFile file : files) {
		    	//이미지 파일 이름
		        String originalName = file.getOriginalFilename();
		        String newFilename = FileUploadUtiles.getNewFilename(originalName);
		        
		        String filepath = uploadPath + File.separator + newFilename;
		        System.out.println("Img Path : "+ filepath);
				
		        String myPath = "http://localhost:3000//upload//"; // 출력용 
		        filenames.add(myPath + newFilename);		        
		        System.out.println(originalName);		 
		        
		         for(int i=0; i < files.size(); i++) {
		        
		        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				os.write(files.get(i).getBytes());
				os.close();
		         }        
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
	
}
