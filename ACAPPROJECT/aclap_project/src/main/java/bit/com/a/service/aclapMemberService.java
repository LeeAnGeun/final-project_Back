package bit.com.a.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.aclapMemberDao;
import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.aclapParam;

@Service
@Transactional
public class aclapMemberService {
	
	@Autowired
	aclapMemberDao aclapMemberDao;
	
	public int addMember(aclapMemberDto dto) {
		return aclapMemberDao.addMember(dto);
	};
	public int checkEmail(String email) {;
		return aclapMemberDao.checkEmail(email);
	};
	public int checkNickName(String nickName) {
		return aclapMemberDao.checkNickName(nickName);
	};
	public aclapMemberDto login (aclapMemberDto dto) {;
		return aclapMemberDao.login(dto);
	};
	public int findPwdAfUpdate(aclapMemberDto dto) {
		return aclapMemberDao.findPwdAfUpdate(dto);
	};
	public aclapMemberDto googleKakaoLogin(aclapMemberDto dto) {
		return aclapMemberDao.googleKakaoLogin(dto);
	};
	public aclapMemberDto googleKakaoRegi(aclapMemberDto dto) {
		int n = aclapMemberDao.googleKakaoRegi(dto);
		if(n>0) 
			System.out.println("google Kakao Regi Success!");
		return aclapMemberDao.googleKakaoLogin(dto);
	};	
	public aclapMemberDto myPageUserUpdate(aclapMemberDto dto) {
		int n = aclapMemberDao.myPageUserUpdate(dto);
		if(n>0) 
			System.out.println("myPageUserUpdate Success!");
		return aclapMemberDao.login(dto);
	};
	public int memberDropOut(aclapMemberDto dto) {
		return aclapMemberDao.memberDropOut(dto);
	};
	public List<aclapMemberDto> memlist(aclapParam par) {
		return aclapMemberDao.memlist(par);
	}
	public aclapMemberDto myinfo(aclapMemberDto dto) {
		return aclapMemberDao.myinfo(dto);
	}
	
	public void chargePoints(Map<String, Object> chargePoints) {
		aclapMemberDao.chargePoints(chargePoints);
	}

}
