package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import bit.com.a.dto.reviewDto;


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
}
