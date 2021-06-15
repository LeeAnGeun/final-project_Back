package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.reviewDao;
import bit.com.a.dto.classSchedulCount;
import bit.com.a.dto.reviewDto;
import bit.com.a.dto.scheduleDto;

@Service
@Transactional
public class reviewService {

	@Autowired
	reviewDao reviewDao;
	public void oneonedayClassWriteReview(int classNum) {
		int n = reviewDao.onedayClassWriteReview(classNum);
		if(n>0)
			System.out.println("== ClassWrite Review Success! == ");
  }
	// 리뷰작성
	public boolean writeReview(reviewDto dto) {
		return reviewDao.writeReview(dto);
	}
	// 리뷰 리스트 가져오기
	public List<reviewDto> getReviewList(reviewDto dto){
		return reviewDao.getReviewList(dto);
	}
	
	// 리뷰 수정
	public boolean updateReview(reviewDto dto) {
		return reviewDao.updateReview(dto);
	}
	
	// 리뷰디테일
	public reviewDto getReview(reviewDto dto) {
		return reviewDao.getReview(dto);
	}
	
	//리뷰 총 평균
	public double getRatingAvg(int classNum) {
		return reviewDao.getRatingAvg(classNum);
	}
	
	//리뷰 각 항목 평균
	public reviewDto getStarsAvg(int classNum) {
		return reviewDao.getStarsAvg(classNum);
	}
	
	// 수강일별 수강생 여부 체크
	public int checkMember(scheduleDto dto) {
		return reviewDao.checkMember(dto);
	}
	
	//수강생의 신청한 클래스 갯수
	public int checkReview(scheduleDto dto) {
		return reviewDao.checkReview(dto);
	}
	
	
	
	// 리뷰 삭제	
	public void reviewDel(reviewDto dto) {
		reviewDao.reviewDel(dto);
	}

}
