package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.likeClassParam;
import bit.com.a.dto.likesDto;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.service.likesService;

@RestController
public class likesController {
	@Autowired
	likesService likesService;
	
	

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
	public int getLikeClassList(likeClassParam param){
		System.out.println("/////////////// likesController getLikeClassList() ///////////////");
		System.out.println("memNum : "+param.getMemNum());
		System.out.println("page : "+param.getPage());
		
		int start = param.getPage() * 5 + 1;
		int end = (param.getPage()+1) * 5 ;
		System.out.println("Start : " + start);
		System.out.println("End : " + end);
		
		param.setStart(start);
		param.setEnd(end);
		
		List<onedayClassDto> list = likesService.getLikeClassList(param);
		System.out.println("가져온 리스트 : "+list.size());
		
		
		if(list.size() != 0)
			System.out.println("getLikeClassList success!");
		return 0;
	}
}