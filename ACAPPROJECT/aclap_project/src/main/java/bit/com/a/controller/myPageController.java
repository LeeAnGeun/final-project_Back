package bit.com.a.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.myStampDto;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.participateDto;
import bit.com.a.dto.scheduleDto;
import bit.com.a.service.aclapMemberService;
import bit.com.a.service.myPageService;
import bit.com.a.service.onedayClassService;
import bit.com.a.service.scheduleService;

@RestController
public class myPageController {	
	@Autowired
	aclapMemberService aclapMemberService;
	
	@Autowired
	scheduleService scheduleService;
	
	@Autowired
	onedayClassService onedayClassService;
	
	@RequestMapping(value = "/myinfo", method = RequestMethod.POST)
	public aclapMemberDto myinfo(aclapMemberDto dto) {
		System.out.println("myinfo dto = " + dto.toString());
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
		
		Date date = new Date();
		
		String sdate = format.format(date);
		System.out.println(sdate);
		
		// aclapMemberDto mem = myPageService.login(dto);
		aclapMemberDto myinfo = aclapMemberService.myinfo(dto);
		
		System.out.println("dto = " + dto.toString());
		
		scheduleDto sdto = new scheduleDto();
		
		sdto.setRdate(sdate);
		sdto.setMemNum(dto.getMemNum());
		
		System.out.println("schedule = " + sdto.toString());
		
		int rCount = scheduleService.regiCount(sdto); 		// 신청한 수업
		int aCount = scheduleService.appendCount(sdto);		 // 수강한 수업
		
		System.out.println("schedule = " + sdto.toString());
		
		System.out.println(rCount + ", " + aCount);
		
		myinfo.setrCount(rCount);
		myinfo.setaCount(aCount);
		System.out.println("myinfo = " + myinfo.toString());
		
		return myinfo;
	}
	
	// 나의 도장 현황
	@RequestMapping(value = "/myStampList", method = RequestMethod.POST)
	public List<myStampDto> myStampList(int memNum, int pageNum){
		System.out.println("myStampList memNum = " + memNum + ", " + pageNum);
		
		List<myStampDto> list = new ArrayList<myStampDto>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("memNum", memNum);
		map.put("pageNum", pageNum);
		
		list = onedayClassService.myStampList(map);
		System.out.println("myStampList list = " + list.toString());
		
		return list;
	}
	
	// 나의 도장 갯수
	@RequestMapping(value = "/stampCount", method = RequestMethod.GET)
	public int stampCount(myStampDto dto) {
		System.out.println("stampCount dto = " + dto.toString());
		
		int count = onedayClassService.stampCount(dto);
		System.out.println("count = " + count);
		return count;
	}
	
	//내가 개설한 클래스 목록 가져오기~
	@RequestMapping(value = "/getMyClassList", method = RequestMethod.GET)
	public List<onedayClassDto> getMyClassList(int masterNum){
		System.out.println("getMyClassList() 파라미터 멤넘: "+masterNum);
		List<onedayClassDto> list = onedayClassService.getMyClassList(masterNum);
		System.out.println("getMyClassList() 결과:"+list.toString());
		
		return list;
		
	}
	
	//내가 개설한 클래스 클릭시 해당 참가자 목록 가져오기
	@RequestMapping(value = "/getMyClassParticipants", method = RequestMethod.GET)
	public List<aclapMemberDto> getMyClassParticipants(participateDto dto){
		System.out.println("getMyClassParticipants() 파라미터 클래스넘: "+ dto.toString());
		List<aclapMemberDto> list = onedayClassService.getMyClassParticipants(dto);
		System.out.println("getMyClassParticipants() 결과:"+list.toString());
		return list;
		
	}
}
