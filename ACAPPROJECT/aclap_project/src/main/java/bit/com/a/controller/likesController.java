package bit.com.a.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.likeClassParam;
import bit.com.a.dto.likesDto;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.reviewDto;
import bit.com.a.service.likesService;
import bit.com.a.service.reviewService;

@RestController
public class likesController {
	@Autowired
	likesService likesService;
	@Autowired
	reviewService reviewService;
	    

	// like 유무 체크 : like == true
	@RequestMapping(value="/checkLike", method = {RequestMethod.GET, RequestMethod.POST})
	public boolean checkLike(likesDto dto){		
		boolean result = false;
		int n = likesService.checkLike(dto); 
		if(n>0)
			result = true;
		return result;
	}
	
	
	// like 추가
	@RequestMapping(value="/addLike", method = {RequestMethod.GET, RequestMethod.POST})
	public void addLike(likesDto dto){
		System.out.println("/////////////// likesController addLike() ///////////////");
		System.out.println("memNum : " +dto.getClassNum());
		System.out.println("classNum : "+dto.getMemNum());
		
		  int n = likesService.addLike(dto); 
		  if(n>0)
			  System.out.println("/// Insert Like success ///");
	}
	
	
	// like 삭제
	@RequestMapping(value="/delLike", method = {RequestMethod.GET, RequestMethod.POST})
	public void delLike(likesDto dto){
		System.out.println("/////////////// likesController delLike() ///////////////");
		System.out.println("memNum : " +dto.getClassNum());
		System.out.println("classNum : "+dto.getMemNum());
		
		int n = likesService.delLike(dto);
		if(n>0)
			System.out.println("/// delete Like success ///");
	}
	
	
	// myPage : like Class 총 갯수 불러오기 
	@RequestMapping(value="/getLikeClassCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int getLikeClassCount(likeClassParam param){
		System.out.println("/////////////// likesController getLikeClassCount() ///////////////");
		
		int n = likesService.getLikeClassCount(param);
		if(n>0)
			System.out.println("/// getLikeClassCount Like success : "+n+" ///");
		return n;
	}
	
	// myPage : like Class List 불러오기
	@RequestMapping(value="/getLikeClassList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<onedayClassDto> getLikeClassList(likeClassParam param){
		System.out.println("/////////////// likesController getLikeClassList() ///////////////");
		System.out.println("memNum : "+param.getMemNum());
		System.out.println("page : "+param.getPage());
		
		int start = param.getPage() * 5 + 1;
		int end = (param.getPage()+1) * 5 ;
		
		param.setStart(start);
		param.setEnd(end);
		
		// 클래스 + 클래스 개설자 정보 가져오기 
		List<onedayClassDto> classList = likesService.getLikeClassList(param);
		
		// 각각의 변수를 List에 담기 
		List <Integer> classNum = new ArrayList<>();
		List <String> profilePic = new ArrayList<>();
		List <String> instructor = new ArrayList<>();
		List <String> email = new ArrayList<>();
		List <String> title = new ArrayList<>();
		List <String> primaryCategory = new ArrayList<>();
		List <Integer> price = new ArrayList<>();
		List <Double> avgPoint = new ArrayList<>();
		
		for(int i=0; i<classList.size(); i++) {
			onedayClassDto dto = classList.get(i);
			
			classNum.add(dto.getClassNum());
			profilePic.add(dto.getProfilePic());
			instructor.add(dto.getInstructor());
			email.add(dto.getEmail());
			title.add(dto.getTitle());
			primaryCategory.add(dto.getPrimaryCategory());
			price.add(dto.getPrice());
			
			reviewDto rDto = new reviewDto();
			rDto.setClassNum(dto.getClassNum());
			List <reviewDto> check = reviewService.getReviewList(rDto);
			if(check.size()==0) 
				avgPoint.add(0.0);
			else 
				avgPoint.add(reviewService.getRatingAvg(dto.getClassNum()));
		}
		
		
		// Result List에 담기 
		List <onedayClassDto> result = new ArrayList<>();
		for(int i=0; i<classList.size(); i++) {
			onedayClassDto dto = new onedayClassDto();
			dto.setClassNum(classNum.get(i));
			dto.setProfilePic(profilePic.get(i));
			dto.setInstructor(instructor.get(i));
			dto.setEmail(email.get(i));
			dto.setTitle(title.get(i));
			dto.setPrimaryCategory(primaryCategory.get(i));
			dto.setPrice(price.get(i));
			dto.setAvgPoint(avgPoint.get(i));
			result.add(dto);
		}
		
		if(result.size() != 0)
			System.out.println("getLikeClassList success!");
		return result;
	}
}