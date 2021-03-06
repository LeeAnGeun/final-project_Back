package bit.com.a.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.aclapMemberDao;
import bit.com.a.dao.noticeBbsDao;
import bit.com.a.dao.onedayClassDao;
import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.aclapParam;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.onedayParam;
import bit.com.a.dto.participateDto;

@Service
@Transactional
public class aclapMemberService {
	
	@Autowired
	aclapMemberDao aclapMemberDao;
	@Autowired
	noticeBbsDao noticeBbsDao;
	@Autowired
	onedayClassDao onedayClassDao;
	
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
	/////////////////////////////////////////////////////////
	public int memberDropOut(aclapMemberDto dto) {
		noticeBbsDao.delnoticeBbs(dto);
		System.out.println("/// noticeBbs Delete Success ///");
		onedayClassDao.onedayClassDelete2(dto);
		System.out.println("/// onedayClass Delete Success ///");
		int result = aclapMemberDao.memberDropOut(dto);
		if(result>0) 
			System.out.println("/// memberDropOut Success ///");
		return result;
	};
	//////////////////////////////////////////////////////
	public List<aclapMemberDto> memlist(aclapParam par) {
		return aclapMemberDao.memlist(par);
	}
	public aclapMemberDto myinfo(aclapMemberDto dto) {
		return aclapMemberDao.myinfo(dto);
	}
	
	public void chargePoints(Map<String, Object> chargePoints) {
		aclapMemberDao.chargePoints(chargePoints);
	}
	public void classMasterUpdate(int memNum) {
		aclapMemberDao.classMasterUpdate(memNum);
		System.out.println("== classMasterUpdate Success! == ");
	}

	
	//?????????
	public void setInterest(aclapMemberDto dto) {
		aclapMemberDao.setInterest(dto);
	};
	
	// ????????? ??????
	public int minusMyPoint(participateDto dto) {
		return aclapMemberDao.minusMyPoint(dto);
	}
	
	// ????????? ??????
	public int plusMyPoint(participateDto dto) {
		return aclapMemberDao.plusMyPoint(dto);
	}
	
	// ?????? ?????? ????????????
	public aclapMemberDto getMemberDto(aclapMemberDto dto) {
		return aclapMemberDao.myinfo(dto);
	}
	// ????????? ????????? ???????????? ?????? ?????? ????????? ???????????? ???????????? ?????????
	public String getYourInterest(int seq) {
		return aclapMemberDao.getYourInterest(seq);
	}
	//???????????? ?????? ?????? 
	public List<onedayClassDto> checkAlertBadge(int memNum) {
		return aclapMemberDao.checkAlertBadge(memNum);
	}
	public int userCount(onedayParam par) {
		return aclapMemberDao.userCount(par);
	}
}
