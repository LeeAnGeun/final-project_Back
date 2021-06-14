package bit.com.a.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileSystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.likesDao;
import bit.com.a.dao.onedayClassDao;
import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.likesDto;
import bit.com.a.dto.myStampDto;
import bit.com.a.dto.oneDayClassParam;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.onedayParam;
import bit.com.a.dto.participateDto;

@Service
@Transactional
public class onedayClassService {
	
	@Autowired
	onedayClassDao onedayClassDao;
	@Autowired
	likesDao likesDao;
	
	public List<onedayClassDto> getClassList(onedayParam par){
		System.out.println("onedayClassService getClassList 왔음 " + new Date());
	//  System.out.println(par.getName() + par.getPage());
		
		return onedayClassDao.getClassList(par);
	}
	
	// 멤버가 만든 클래스 count
	public int masterClassCounter(int masterNum) {
		return onedayClassDao.masterClassCounter(masterNum);
	}
	
	
	public int classCount(onedayParam par) {
		System.out.println("onedayClassService classCount 왔음 " + new Date());

		return onedayClassDao.classCount(par);
	}
	

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

	//----------------------생성 수정 삭제 ----------------------
	// 원데이클래스 생성
	public int onedayClassWrite(onedayClassDto dto) {
		int n = onedayClassDao.onedayClassWrite(dto);
		if(n>0)
			System.out.println("=== onedayClassWrite Success ===");
		List <Integer>  classSeq = onedayClassDao.onedayClassWriteAfClassNum(dto);
		return classSeq.get(0);
	};		
	
	// 클래스 수정하기
	public void onedayClassUpdate(onedayClassDto dto) {
		int n = onedayClassDao.onedayClassUpdate(dto);
		if(n>0)
			System.out.println("=== onedayClassUpdate Success ===");
	};
	
	// 클래스 수정 전 뿌려줄 모든 정보 
	public onedayClassDto onedayClassInfo(onedayClassDto dto) {
		onedayClassDto d = onedayClassDao.onedayClassInfo(dto);
		if(d != null)
			System.out.println("=== (Service) onedayClassInfo Success ===");
		return onedayClassDao.onedayClassInfo(dto);
	};
	
	// 클래스 중단하기
	public int onedayClassDelete(onedayClassDto dto) {
		int n = onedayClassDao.onedayClassDelete(dto);
		if(n>0)
			System.out.println("=== onedayClassDelete Success ===");
		return n;
	};
	
	// 클래스 재개하기
	public int onedayClassRestart(onedayClassDto dto) {
		int n = onedayClassDao.onedayClassRestart(dto);
		if(n>0)
			System.out.println("=== onedayClassDelete Success ===");
		return n;
	};
	
	
	// 참여자 수를 NewRegNum에 update
	public int updateNewRegNum(participateDto dto) {
		return onedayClassDao.updateNewRegNum(dto);
	}
	
	//내가 개설한 클래스의 정보 가져오기.
	public List<onedayClassDto> getMyClassList(int masterNum) {
		return onedayClassDao.getMyClassList(masterNum);
	}
	//내가 개설한 클래스 클릭시 참가자 보기
	public List<aclapMemberDto> getMyClassParticipants(participateDto dto) {
		// 내가 개설한 클래스 클릭시 OldRegNum을 NewRegNum과 동일한 값으로 update
		onedayClassDao.updateOldRegNum(dto);
		System.out.println("updateOldRegNum도착");
		return onedayClassDao.getMyClassParticipants(dto);
	}

	// endDate가 지난 클래스를 del=1로 처리
	public int updateEndClass() {
		return onedayClassDao.updateEndClass();
	}
	
	// 강사의 모든 Like 수 가져오기
	public int allLikesCount(int masterNum){
		List<Integer> classNum =  onedayClassDao.teacherAllClass(masterNum);
		System.out.println("/////////////////////////classNum" + classNum.toString());
		int allLike = 0;
		
		for(int i=0; i<classNum.size(); i++) {
			System.out.println("classNum = " + classNum.get(i));
			likesDto d = new likesDto();
			d.setClassNum(classNum.get(i));
			d.setMemNum(masterNum);
			
			int tableCheck = likesDao.checkLike(d);
			if(tableCheck != 0 && classNum.get(i) != 1) { 
				allLike += likesDao.getLikeClassForDetail(classNum.get(i));
			}
		}
		System.out.println("all : " + allLike);
		return allLike;
	}

	
}
