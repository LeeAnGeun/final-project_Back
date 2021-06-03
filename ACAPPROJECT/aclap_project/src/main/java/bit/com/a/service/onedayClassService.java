package bit.com.a.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.aclapMemberDao;
import bit.com.a.dao.onedayClassDao;

import bit.com.a.dto.oneDayClassParam;
import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.myStampDto;

import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.onedayParam;
import bit.com.a.dto.participateDto;

@Service
@Transactional
public class onedayClassService {
	
	@Autowired
	private onedayClassDao onedayClassDao;
	
	public List<onedayClassDto> getClassList(onedayParam par){
		System.out.println("onedayClassService getClassList 왔음 " + new Date());
	//  System.out.println(par.getName() + par.getPage());
		
		return onedayClassDao.getClassList(par);
	}
	
	// 멤버가 만든 클래스 count
	public int masterClassCounter(aclapMemberDto dto) {
		return onedayClassDao.masterClassCounter(dto);
	}
	
	/*
	public int classCount(onedayParam par) {
		System.out.println("onedayClassService classCount 왔음 " + new Date());

		return onedayClassDao.classCount(par);
	}
	*/

	//------------------------------mypage-----------------------------
	public onedayClassDto getOnedayClass(onedayClassDto dto){
		onedayClassDto oClass = onedayClassDao.getOnedayClass(dto);
		System.out.println("onedayClassService oClass = " + oClass.toString());
		return oClass;
	}

	
	
	// 나의 도장판 현황
	public List<myStampDto> myStampList(Map<String, Integer> map){
		List<myStampDto> list = onedayClassDao.myStampList(map);
		return list;
	}
	
	// 나의 도장 갯수
	public int stampCount(myStampDto dto) {
		return onedayClassDao.stampCount(dto);
	}
	

	//----------------------------categoryView-------------------------
	//클래스 리스트 뽑아
	public List<onedayClassDto> classListData(oneDayClassParam param) {
		return onedayClassDao.classListData(param);
	}
	

	//----------------------------home----------------------------------
	// home : 클래스 최신순 리스트 출력
	public List<onedayClassDto> getNewestClassList() {
		return onedayClassDao.getNewestClassList();
	};
	
	// home : 클래스 인기순 출력
	public List<onedayClassDto> getBestClassList() {
		return onedayClassDao.getBestClassList();
	};
	
	// home : 추천 클래스 출력
	public List<onedayClassDto> getRecommendClassList(aclapMemberDto dto){
		return onedayClassDao.getRecommendClassList(dto);
	};


	// 원데이클래스 생성
	public int onedayClassWrite(onedayClassDto dto) {
		int n = onedayClassDao.onedayClassWrite(dto);
		if(n>0)
			System.out.println("=== onedayClassWrite Success ===");
		List<Integer> classSeq = onedayClassDao.onedayClassWriteAfClassNum(dto);
		return classSeq.get(0);
	};		
	
	// 참여자 수를 NewRegNum에 update
	public int updateNewRegNum(participateDto dto) {
		return onedayClassDao.updateNewRegNum(dto);
	}
}
