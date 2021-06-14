package bit.com.a.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.noClassDateDao;
import bit.com.a.dto.noClassDateDto;
import bit.com.a.dto.onedayClassDto;

@Service
@Transactional
public class noClassDateService {
	
	@Autowired
	noClassDateDao noClassDateDao; 
	
	// 추가
	public void addNoClassDate(noClassDateDto dto) {
		noClassDateDao.addNoClassDate(dto);
		System.out.println("== (Service) addNoClassDate Success! ==");
	};
	
	// 삭제
	public void deleteNoClassDate(onedayClassDto dto) {
		int n = noClassDateDao.deleteNoClassDate(dto);
		if(n>0)
			System.out.println("=== (Service) deleteNoClass Success ===");
	};
	
	// 출력
	public List<String> getNoClassDate(onedayClassDto dto){
		List <String> list = noClassDateDao.getNoClassDate(dto);
		List <String> output = new ArrayList<>();
		if(list!=null) {
			for (String str : list) 
				output.add(str.substring(0, 10));
			System.out.println("=== (Service) getNoClassDate Success ===");
		}
		return output;
	};

}