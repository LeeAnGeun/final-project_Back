package bit.com.a.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.aclapParam;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.dto.onedayParam;
import bit.com.a.dto.participateDto;


@Mapper
@Repository
public interface aclapMemberDao {

	public int addMember(aclapMemberDto dto);
	public int checkEmail(String email);
	public int checkNickName(String nickName);
	public aclapMemberDto login (aclapMemberDto dto);
	public int findPwdAfUpdate(aclapMemberDto dto);
	public aclapMemberDto googleKakaoLogin(aclapMemberDto dto);
	public int googleKakaoRegi(aclapMemberDto dto);
	public int classMasterUpdate(int memNum);
	
  // 관심사 조사하기
	public String getYourInterest(int seq);
	// 마이페이지 정보 가져오기
	public aclapMemberDto myinfo(aclapMemberDto dto);
	// 마이페이지_정보수정
	public int myPageUserUpdate(aclapMemberDto dto);
	// 마이페이지_회원탈퇴
	public int memberDropOut(aclapMemberDto dto);
	//선호도
	public void setInterest(aclapMemberDto dto);
	//관리자페이지 유저 리스트
	public List<aclapMemberDto> memlist(aclapParam par);
	// 포인트충전 업데이트
	public void chargePoints (Map<String, Object> chargePoints);

  // 포인트 차감
	public int minusMyPoint(participateDto dto);
	// 포인트 가산
	public int plusMyPoint(participateDto dto);
	//노티뱃지유무확인
	public List<onedayClassDto> checkAlertBadge(int memNum);
	// 유저 count
	public int userCount(onedayParam par);

}
