package bit.com.a.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.classSchedulCount;
import bit.com.a.dto.classScheduleDto;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.scheduleDto;

import bit.com.a.service.onedayClassService;
import bit.com.a.service.scheduleService;

@RestController
public class scheduleController {

	@Autowired
	scheduleService scheduleService;
	
	@Autowired
	onedayClassService onedayClassService;
	
	// mypage.html에서 나의 수업 스케줄을 얻기 위함
	@RequestMapping(value = "/mySchedule", method = RequestMethod.POST)
	public List<scheduleDto> mySchedule(scheduleDto dto) {
		System.out.println("mySchedule dto = " + dto.toString());
		
		List<scheduleDto> list = new ArrayList<scheduleDto>();
		list = scheduleService.getMySchedule(dto);
		
		return list;
	}
		
	
	 //클래스 마스터가 마이페이지에 본인이 개설한 클래스의 스케줄 확인 
	 @RequestMapping(value="/myclsScheduleData", method = {RequestMethod.GET, RequestMethod.POST}) 
	 public List<scheduleDto> myclsScheduleData(int memNum){ 
		 System.out.println("myclsScheduleData() " + new Date());
		 System.out.println("파라미터 확인: "+memNum); 
		 List<scheduleDto> list = scheduleService.myclsScheduleData(memNum);
		  
		 System.out.println("확인"+list.toString()); return list;
		  
	 }
	
	// classDtail.html에서 classSchedule을 얻기 위함
	@RequestMapping(value="/classSchedulList", method = {RequestMethod.GET, RequestMethod.POST}) 
	public Map<String, Object> classSchedulList(onedayClassDto dto){ 
		System.out.println("classSchedulList dto = " + dto);
		
		Map<String, Object> clsMap = new HashMap<String, Object>();
		
		// classSchedule List
		List<classScheduleDto> clist = new ArrayList<classScheduleDto>();
		
		clist = scheduleService.classScheduleList(dto);
		System.out.println("classSchedulList : " + clist.toString());
		
		List<classScheduleDto> noDateList = new ArrayList<classScheduleDto>();
		noDateList = scheduleService.noDateList(dto);
		System.out.println("noDateList = " + noDateList.toString());
		clsMap.put("clist", clist);
		clsMap.put("noDateList", noDateList);
		return clsMap;
	}
	 
}
