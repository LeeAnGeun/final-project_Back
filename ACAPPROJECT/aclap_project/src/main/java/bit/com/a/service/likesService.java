package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.likesDao;
import bit.com.a.dto.likeClassParam;
import bit.com.a.dto.likesDto;
import bit.com.a.dto.onedayClassDto;

@Service
@Transactional
public class likesService {
	
	@Autowired
	likesDao likesDao;
	
	public int checkLike(likesDto dto) {
		return likesDao.checkLike(dto);
	};
	public int addLike(likesDto dto) {
		
		int count1 = likesDao.addLike(dto);
		int count2 = likesDao.plusClsLikeCount(dto); // 회원이 like를 누르면 class에 likeCount + 1 를 한다.
		return count1 * count2;
	};
	public int delLike(likesDto dto) {
		int count1 = likesDao.delLike(dto);
		int count2 = likesDao.minusClsLikeCount(dto);
		return count1 * count2;
	};
	public List<onedayClassDto> getLikeClassList(likeClassParam parma){
		return likesDao.getLikeClassList(parma);
	};
	public int getLikeClassCount(likeClassParam parma) {
		return likesDao.getLikeClassCount(parma);
	};
}