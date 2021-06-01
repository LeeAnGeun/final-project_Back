package bit.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import bit.com.a.dto.reviewDto;


@Mapper
@Repository
public interface reviewDao {
	
	public int onedayClassWriteReview(int classNum);
	

	// 리뷰쓰기 
	boolean writeReview (reviewDto dto);


}
