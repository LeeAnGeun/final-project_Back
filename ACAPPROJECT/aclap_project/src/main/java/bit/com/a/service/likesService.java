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
		return likesDao.addLike(dto);
	};
	public int delLike(likesDto dto) {
		return likesDao.delLike(dto);
	};
	public List<onedayClassDto> getLikeClassList(likeClassParam parma){
		return likesDao.getLikeClassList(parma);
	};
	public int getLikeClassCount(likeClassParam parma) {
		return likesDao.getLikeClassCount(parma);
	};
}