package bit.com.a.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import bit.com.a.dto.oneDayClassParam;
import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.myStampDto;

import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.onedayParam;

@Mapper
@Repository
public interface onedayClassDao {
	
		// 관리자 페이지 리스트
		public List<onedayClassDto> getClassList(onedayParam par);
		
		//my page
		public onedayClassDto getOnedayClass(onedayClassDto dto);
		

		

		// 나의 도장판 현황
		public List<myStampDto> myStampList(Map<String, Integer> map);
		
		// 도장 갯수
		public int stampCount(myStampDto dto);
		
		//클래스 리스트 가져오기
		public List<onedayClassDto> classListData(oneDayClassParam param);
		
		
		
		
		
		// home : 클래스 최신순 리스트 출력
		public List<onedayClassDto> getNewestClassList();
		
		// home : 클래스 인기순 출력
		public List<onedayClassDto> getBestClassList();
		
		// 클래스 생성하기 
		public int onedayClassWrite(onedayClassDto dto);	
		
		// 생성한 클래스 seq 가져오기
		public List<Integer> onedayClassWriteAfClassNum(onedayClassDto dto);
}
