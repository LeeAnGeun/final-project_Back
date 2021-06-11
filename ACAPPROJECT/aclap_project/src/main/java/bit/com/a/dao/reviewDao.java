package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.classSchedulCount;
import bit.com.a.dto.reviewDto;
import bit.com.a.dto.scheduleDto;


@Mapper
@Repository
public interface reviewDao {
	
	// class 생성 후 리뷰 초기화
	public int onedayClassWriteReview(int classNum);

	// 리뷰쓰기 
	boolean writeReview (reviewDto dto);
	
	// 리뷰 리스트 가져오기
	public List<reviewDto> getReviewList(reviewDto dto);

	
	// 리뷰 수정
	public boolean updateReview (reviewDto dto);
	
	// 리뷰 디테일
	public reviewDto getReview(reviewDto dto);

	public double getRatingAvg(int classNum);

	public reviewDto getStarsAvg(int classNum);
	// 수강생 여부 체크
	public int checkMember(scheduleDto dto);
	// 리뷰 삭제
	public void reviewDel(reviewDto dto);
	//수강생의 신청한 클래스 갯수
	public int checkReview(scheduleDto dto);
}
