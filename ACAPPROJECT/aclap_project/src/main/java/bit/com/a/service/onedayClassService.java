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
	

	
	//클래스 리스트 뽑아
	public List<onedayClassDto> classListData(oneDayClassParam param) {
		return onedayClassDao.classListData(param);
	}
	//클래스 리스트 갯수
	public int classListCount(oneDayClassParam param) {
		return onedayClassDao.classListCount(param);
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

	public boolean onedayClassWrite() {
		// DB 저장
		int n = onedayClassDao.onedayClassWrite();
		
		// class master Update 
		//int n = aclapMemberDao.classMasterUpdate();
		
		if(n>0)
			System.out.println("onedayClassWrite Success");
		return true;
	};		

}
