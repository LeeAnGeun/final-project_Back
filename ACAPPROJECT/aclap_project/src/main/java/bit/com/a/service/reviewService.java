package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.reviewDao;

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
}
