package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.classSchedulCount;
import bit.com.a.dto.classScheduleDto;
import bit.com.a.dto.onedayClassDto;
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
	
	// classDtail.html에서 해당 일에 신청자 수를 얻기 위함
	public List<classSchedulCount> classSchedulCount(onedayClassDto dto);
	
	// NOCLASSDATE를 얻기 위함
	public List<classScheduleDto> noDateList(onedayClassDto dto);
}
