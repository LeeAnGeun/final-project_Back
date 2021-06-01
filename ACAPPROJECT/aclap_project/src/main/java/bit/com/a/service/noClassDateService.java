package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.noClassDateDao;
import bit.com.a.dto.noClassDateDto;

@Service
@Transactional
public class noClassDateService {
	
	@Autowired
	noClassDateDao noClassDateDao; 
	
	public void addNoClassDate(noClassDateDto dto) {
		noClassDateDao.addNoClassDate(dto);
		System.out.println("== addNoClassDate Success! ==");
	};
}