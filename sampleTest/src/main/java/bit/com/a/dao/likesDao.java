package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.likeClassParam;
import bit.com.a.dto.likesDto;
import bit.com.a.dto.onedayClassDto;

@Mapper
@Repository
public interface likesDao {
	
	public int checkLike(likesDto dto);
	public int addLike(likesDto dto);
	public int delLike(likesDto dto);
	public List<onedayClassDto> getLikeClassList(likeClassParam parma);
	public int getLikeClassCount(likeClassParam parma);
	// 회원이 like를 누르면 class에 likeCount + 1 를 한다.
	public int plusClsLikeCount(likesDto dto);
	// 회원이 ♡ 누르면 class에 likeCount - 1 를 한다.
	public int minusClsLikeCount(likesDto dto);
	// 선생님의 전체 LIKE 갯수 가져오기(onedayClassDetail)
	public int getLikeClassForDetail(int classNum);
	
}