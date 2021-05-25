package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.aclapParam;

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
	
	// 마이페이지 정보 가져오기
	public aclapMemberDto myinfo(aclapMemberDto dto);
	// 마이페이지_정보수정
	public int myPageUserUpdate(aclapMemberDto dto);
	// 마이페이지_회원탈퇴
	public int memberDropOut(aclapMemberDto dto);
	public void setInterest(aclapMemberDto dto);
	public List<aclapMemberDto> memlist(aclapParam par);

}
