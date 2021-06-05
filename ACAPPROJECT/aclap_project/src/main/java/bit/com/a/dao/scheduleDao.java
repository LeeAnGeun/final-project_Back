package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.classSchedulCount;
import bit.com.a.dto.classScheduleDto;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.participateDto;
import bit.com.a.dto.scheduleDto;

@Mapper
@Repository
public interface scheduleDao {

	// mypage.html 에서 해당 월에 schedule을 얻어오기 위함
	public List<scheduleDto> getMySchedule(scheduleDto dto);
	
	// mypage.html에서 master에 schedule을 얻어오기 위함
	public List<scheduleDto> myclsScheduleData(int memNum);
	
	// mypage.html에서 신청한 수업 count
	public int regiCount(scheduleDto dto);
	
	// mypage.html에서 수강한 수업 count
	public int appendCount(scheduleDto dto);
	
	// classDtail.html에서 classSchedule을 얻기 위함
	public List<classScheduleDto> classScheduleList(onedayClassDto dto);
	
	// 해당 수업 스케줄 당 참가자를 얻기 위함
	public List<scheduleDto> classParticipantsList(onedayClassDto dto);
	
	// classDtail.html에서 해당 일에 신청자 수를 얻기 위함
	public List<classSchedulCount> classSchedulCount(onedayClassDto dto);
	
	// NOCLASSDATE를 얻기 위함
	public List<classScheduleDto> noDateList(onedayClassDto dto);
	
	// 이미 있는 스케줄인지 검사
	public int getIncludSchedule(participateDto dto);
	
	// 다시 해당일자에 신청할때 업데이트를 위함
	public int updateSchedule(participateDto dto);
	
	// 스케줄 추가
	public int addSchedule(participateDto dto);
	
	// 스탬프 추가
	public int addStamp(participateDto dto);
	
	// 다시 해당일자에 신청할때 영수증 업데이트를 위함
	public int updateReceipt(participateDto dto);
	
	// 영수증 추가
	public int addReceipt(participateDto dto);

	// 해당 일자 영수증 가져오기
	public participateDto getReceiptData(participateDto dto);

	public int updateDelSchedule(participateDto dto);

	public int deleteStamp(participateDto dto);

	public int getIncludMember(scheduleDto dto);


}
