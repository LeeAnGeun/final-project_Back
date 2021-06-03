package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.scheduleDao;
import bit.com.a.dto.classSchedulCount;
import bit.com.a.dto.classScheduleDto;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.participateDto;
import bit.com.a.dto.scheduleDto;

@Service
@Transactional
public class scheduleService {
	
	@Autowired
	private scheduleDao scheduleDao;
	
	// mypage.html 에서 해당 월에 schedule을 얻어오기 위함
	public List<scheduleDto> getMySchedule(scheduleDto dto){
		return scheduleDao.getMySchedule(dto);
	}
	
	// mypage.html에서 master에 schedule을 얻어오기 위함
	public List<scheduleDto> myclsScheduleData(int memNum) {
		return scheduleDao.myclsScheduleData(memNum);	
	}
	
	// mypage.html에서 신청한 수업 count
	public int regiCount(scheduleDto dto) {
		return scheduleDao.regiCount(dto);	
	}
	
	// mypage.html에서 수강한 수업 count
	public int appendCount(scheduleDto dto) {
		return scheduleDao.appendCount(dto);	
	}
	
	// classDtail.html에서 classSchedule을 얻기 위함
	public List<classScheduleDto> classScheduleList(onedayClassDto dto){
		// classSchedule List
		List<classScheduleDto> clist = scheduleDao.classScheduleList(dto);
		System.out.println("clist = " + clist);
		
		// classSchedulCount List
		List<classSchedulCount> countlist = scheduleDao.classSchedulCount(dto);
		System.out.println("countlist : " + countlist.toString());
		
		for(int i=0; i<clist.size(); i++) {
			classScheduleDto classdto = clist.get(i);

			// System.out.println((classdto.getRdate()).substring(0, 10));
			for(int j=0; j<countlist.size();j++) {
				classSchedulCount count = countlist.get(j);
				
				if( (classdto.getRdate()).substring(0, 10).equals(count.getRdate())) {
					
					int limitnum = Integer.parseInt( classdto.getLimitNum() ) - count.getCount();
					classdto.setLimitNum(Integer.toString( limitnum ));
					clist.set(i, classdto);
				}
			}
		}
		System.out.println("완성된 clist : " + clist.toString());
		return clist;
	}
	
	// NOCLASSDATE를 얻기 위함
	public List<classScheduleDto> noDateList(onedayClassDto dto){
		return scheduleDao.noDateList(dto);
	}
	
	public int participate(participateDto dto) {
		// 스케줄 추가
		int i = scheduleDao.addSchedule(dto);
		
		// 스탬프 추가
		int j = scheduleDao.addStamp(dto);
		
		// 영수증 추가
		int z = scheduleDao.addReceipt(dto);
		
		return i*j*z;
	}

	public participateDto getReceiptData(participateDto dto) {
		return scheduleDao.getReceiptData(dto);
	}
}
