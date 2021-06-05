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
import bit.com.a.dto.participateDto;
import bit.com.a.dto.scheduleDto;
import bit.com.a.service.aclapMemberService;
import bit.com.a.service.onedayClassService;
import bit.com.a.service.scheduleService;

@RestController
public class scheduleController {

	@Autowired
	scheduleService scheduleService;
	
	@Autowired
	onedayClassService onedayClassService;
	
	@Autowired
	aclapMemberService aclapMemberService;
	
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
		  
		 System.out.println("확인"+list.toString()); 
		 
		 return list; 
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
	
	@RequestMapping(value="/getReceiptData", method = {RequestMethod.GET, RequestMethod.POST}) 
	public participateDto getReceiptData(participateDto dto){ 
		System.out.println("getReciptData dto = " + dto.toString());
		
		participateDto receipt = scheduleService.getReceiptData(dto);
		
		return receipt;
	}
	
	// 참여하였을 경우
	@RequestMapping(value="/participate", method = {RequestMethod.GET, RequestMethod.POST}) 
	public String participate(participateDto dto){ 
		System.out.println("participate dto = " + dto.toString());
		
		onedayClassDto oDto = new onedayClassDto();
		oDto.setClassNum(dto.getClassNum());
		onedayClassDto gDto = onedayClassService.getOnedayClass(oDto);
		System.out.println(gDto.toString());
		
		// 나의 포인트 차감
		int count1 = aclapMemberService.minusMyPoint(dto);
		System.out.println("count1 = " + count1);
		
		// 원데이클래스 NewRegNum + 1 
		int count2 = onedayClassService.updateNewRegNum(dto);
		System.out.println("count2 = " + count2);
		
		dto.setTitle(gDto.getTitle());
		dto.setPrimaryCategory(gDto.getPrimaryCategory());
		dto.setSecondaryCategory(gDto.getSecondaryCategory());
		System.out.println(dto.toString());
		
		
		// 스탬프, 포인트, 스케줄, 영수증
		int count3 = scheduleService.participate(dto);
		System.out.println("count3 = " + count3);
		
		if(count1*count2*count3 == 0) {
			return "error";
		}
		
		return "성공이다아~";
	}
	
	// 일정 취소를 하였을 경우
	@RequestMapping(value="/cancelSchedule", method = {RequestMethod.GET, RequestMethod.POST}) 
	public String cancelSchedule(participateDto dto){ 
		System.out.println("cancelSchedule dto = " + dto.toString());
		
		participateDto receipt = scheduleService.getReceiptData(dto);
		System.out.println("receipt = " + receipt.toString());
		//포인트 가산
		int count1 = aclapMemberService.plusMyPoint(receipt);
		
		// 원데이클래스 NewRegNum + 1 
		int count2 = onedayClassService.updateNewRegNum(dto);
		System.out.println("count2 = " + count2);
		
		// 스탬프, 스케줄
		int count3 = scheduleService.cancelSchedule(dto);
		System.out.println("count3 = " + count3);
		

		return "일정이 취소되었습니다.";
	}
	
	@RequestMapping(value="/getIncludMember", method = {RequestMethod.GET, RequestMethod.POST}) 
	public int getIncludMember(scheduleDto dto){ 
		System.out.println("getIncludMember dto = " + dto.toString());
		
		int count = scheduleService.getIncludMember(dto);
		System.out.println("getIncludMember count = " + count);
		return count;
	}
}
