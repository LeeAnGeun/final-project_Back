package bit.com.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.FileUploadUtiles;
import bit.com.a.RadomPasswordUtil;
import bit.com.a.dto.aclapMemberDto;
import bit.com.a.dto.onedayClassDto;
import bit.com.a.mail.MailSend;
import bit.com.a.service.aclapMemberService;

@RestController
public class aclapMemberController {

	@Autowired
	aclapMemberService service;

	// TODO 로그인 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public aclapMemberDto login(aclapMemberDto dto) {
		System.out.println("////////// MemberController login() //////////");
		aclapMemberDto mem = service.login(dto);
		if(mem != null) {
			if(mem.getDel()==1) 
				System.out.println("/// memNum : "+dto.getMemNum() +" 삭제된 계정 ///");
			else 
				System.out.println("/// memNum : "+dto.getMemNum() +" 정상적인 계정 ///");
		}
		return mem;
	}

	// TODO 이메일 중복 체크
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public int checkEmail(String email) {
		System.out.println("////////// MemberController checkEmail() //////////");
		int n = service.checkEmail(email);

		if(n==0) 
			System.out.println(email + " : DB에 저장되지 않은 이메일");
		else
			System.out.println(email + " : DB에 저장된 이메일");
		return n;
	}
	
	// TODO 이메일 인증번호 보내기
	@RequestMapping(value = "/emailSend", method = RequestMethod.POST)
	public void emailSend(String email, int num) {
		System.out.println("///// MemberController emailSend() /////");
		System.out.println("이메일 : "+ email);
		System.out.println("인증번호 : "+ num);

		String result = MailSend.mailSend(email, num, "", "code");
		System.out.println(result);
	}

	// TODO 닉네임 중복 체크
	@RequestMapping(value = "/checkNickName", method = RequestMethod.POST)
	public int checkNickName(String nickName) {
		System.out.println("////////// MemberController checkNickName() //////////");
		int n = service.checkNickName(nickName);
		
		if(n==0) 
			System.out.println(nickName + " : DB에 저장되지 않은 닉네임");
		else
			System.out.println(nickName + " : DB에 저장된 닉네임");
		return n;
	}
	
	
	// TODO 임시 비밀번호 발급
	@RequestMapping(value = "/findPwdAfUpdate", method = RequestMethod.POST)
	public void findPwdAfUpdate(aclapMemberDto dto) {
		System.out.println("////////// MemberController findPwdAfUpdate() //////////");

		String newPwd = RadomPasswordUtil.randomPwd(10);
		System.out.println("생성된 임시 비밀번호 : "+newPwd);
		
		dto.setPwd(newPwd);
		String result = MailSend.mailSend(dto.getEmail(), 0, newPwd, "newPwd");
		System.out.println(result);

		service.findPwdAfUpdate(dto);
		
	}


	// TODO 일반 회원가입
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public boolean addMember(aclapMemberDto dto, HttpServletRequest req,
							@RequestParam("fileload") MultipartFile uploadFile){
			
		System.out.println("////////// aclapMemberController addMember() //////////");
		System.out.println("Email : " + dto.getEmail());
		System.out.println("Pwd : " + dto.getPwd());
		System.out.println("Name : " + dto.getUserName());
		System.out.println("NickName : " + dto.getNickName());
		System.out.println("Phone : " + dto.getPhoneNum());
			
		// 프로필 이미지 불러오기
		String f = uploadFile.getOriginalFilename();
		// 업로드한 이미지가 없으면 기본 이미지로 설정
		if(f == "") {
			dto.setProfilePic("http://localhost:3000//upload//sample.png");
			service.addMember(dto);
			return true;
		}
		else {
						
			String uploadPath = req.getServletContext().getRealPath("/upload"); 	
			String newFilename = FileUploadUtiles.getNewFilename(f, 1);
		 // String newFilename = "sample.png"; 샘플 프로필 이미지 서버 저장용 (서버 생성 시 미리 웹에 저장할 것)
				
			String filepath = uploadPath + File.separator + newFilename;
			System.out.println("Img Path : "+ filepath);
			
			String myPath = "http://localhost:3000//upload//"; // 출력용 
			dto.setProfilePic(myPath+newFilename);
			try {
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				os.write(uploadFile.getBytes());
				os.close();
				service.addMember(dto);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}			
			return true;
		}
	}
	
	
	// TODO 구글 & 카카오 로그인 
	@RequestMapping(value = "/googleKakaoLogin", method = RequestMethod.POST)
	public aclapMemberDto googleKakaoLogin(aclapMemberDto dto){
		System.out.println("////////// aclapMemberController googleKakaoLogin() //////////");
		aclapMemberDto mem = service.googleKakaoLogin(dto);
		 
		return mem;
	}
	
	// TODO 구글 & 카카오 회원가입 
	@RequestMapping(value = "/googleKakaoRegi", method = RequestMethod.POST)
	public aclapMemberDto googleKakaoRegi(aclapMemberDto dto){
		System.out.println("////////// aclapMemberController googleKakaoRegi() //////////");

		System.out.println("Email : " + dto.getEmail());
		System.out.println("Name : " + dto.getUserName());
		System.out.println("NickName : " + dto.getNickName());
		System.out.println("ProfilePic : " + dto.getProfilePic());
		//비밀번호 생성
		String newPwd = RadomPasswordUtil.randomPwd(10);
		System.out.println("생성한 비밀번호 : "+ newPwd);
		dto.setPwd(newPwd);
		
		aclapMemberDto mem = service.googleKakaoRegi(dto);
		
		return mem;
	}
		
	

	
	// TODO 회원정보 수정
	@RequestMapping(value = "/myPageUserUpdate", method = RequestMethod.POST)
	public aclapMemberDto myPageUserUpdate(aclapMemberDto dto, String oldProfilePic, HttpServletRequest req,
							@RequestParam("fileload") MultipartFile uploadFile){
			
		System.out.println("////////// aclapMemberController myPageUserUpdate() //////////");
		System.out.println("memNum : " + dto.getMemNum());
		System.out.println("Email : " + dto.getEmail());
		System.out.println("Pwd : " + dto.getPwd());
		System.out.println("Name : " + dto.getUserName());
		System.out.println("NickName : " + dto.getNickName());
		System.out.println("Phone : " + dto.getPhoneNum());
		System.out.println("oldProfilePic : " + oldProfilePic);
			
		aclapMemberDto mem = new aclapMemberDto();
		
		// 프로필 이미지 불러오기
		String f = uploadFile.getOriginalFilename();
		// 업로드한 이미지가 없으면 회원가입에 사용된 이미지 사용
		if(f == "") {
			dto.setProfilePic(oldProfilePic);
			mem = service.myPageUserUpdate(dto);
			return mem;
		}
		else {
						
			String uploadPath = req.getServletContext().getRealPath("/upload"); 	
			String newFilename = FileUploadUtiles.getNewFilename(f, 1);
		 // String newFilename = "sample.png"; 샘플 프로필 이미지 서버 저장용 (서버 생성 시 미리 웹에 저장할 것)
				
			String filepath = uploadPath + File.separator + newFilename;
			System.out.println("Img Path : "+ filepath);
			
			String myPath = "http://localhost:3000//upload//"; // 출력용 
			dto.setProfilePic(myPath+newFilename);
			
			
			try {
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
				os.write(uploadFile.getBytes());
				os.close();
				System.out.println("File upload Success");
				mem = service.myPageUserUpdate(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return mem;
		}
	}
	
	
	// TODO 회원탈퇴
	@RequestMapping(value = "/memberDropOut", method = RequestMethod.POST)
	public int memberDropOut(aclapMemberDto dto){
		System.out.println("////////// aclapMemberController memberDropOut() //////////");
		System.out.println("/// MemNum : "+dto.getMemNum()+" ///");
		return service.memberDropOut(dto);
	}
	
	// TODO 포인트 충전
	@RequestMapping(value="/chargePoints", method = {RequestMethod.GET, RequestMethod.POST})
	public int chargePoints(aclapMemberDto dto, int money ) {
		System.out.println("aclapMemberController chargePoints 왔음" + new Date());
		System.out.println("이메일" + dto.getEmail() + " 충전할 돈 " + money );
		
		Map<String, Object> chargePoints = new HashMap<String, Object>();
		String email = dto.getEmail();
		
		chargePoints.put("email", email);
		chargePoints.put("money", money);
		
		service.chargePoints(chargePoints);
		
		int mypoint = money + dto.getMyPoint();
		System.out.println("충전 후 포인트: " + mypoint);
		
		return mypoint;
	}
	
	//------------------------------- 관심사 설정완료~------------------------
	@RequestMapping(value = "/interestComplete", method = RequestMethod.POST)
	public int setInterest(String interest1, String interest2, String interest3, int memNum){
		System.out.println("////////// aclapMemberController setInterest() //////////");
		
		System.out.println("파라미터확인 : " + interest1+"&&"+interest2+"&&"+interest3+"&&"+memNum);
		
		aclapMemberDto dto = new aclapMemberDto(memNum, interest1, interest2, interest3);
		service.setInterest(dto);
		return 1;
	}
	
	// 나의 정보 가져오기
	@RequestMapping(value = "/getMemberDto", method = RequestMethod.POST)
	public aclapMemberDto getMemberDto(aclapMemberDto dto){
		System.out.println("getMemberDto dto = " + dto.toString());
		
		aclapMemberDto memDto = service.getMemberDto(dto);
		
		return memDto;
	}
	
	//로그인시 노티 뱃지 show/hide 체크
	@RequestMapping(value="/checkAlertBadge", method = {RequestMethod.GET, RequestMethod.POST})
	public List<onedayClassDto> checkAlertBadge(int memNum) {
		System.out.println("checkAlertBadge() 메소드 도착 파라미터 확인==" +memNum);
		List<onedayClassDto> chkBadge = service.checkAlertBadge(memNum);
		
		for(int i=0; i < chkBadge.size(); i++) {
			onedayClassDto dto = chkBadge.get(i);
			System.out.println("뱃지뜨게하기 결과 확인하기: oldNum "+dto.getOldRegNum());
			System.out.println("");
			System.err.println("뱃지뜨게하기 결과 확인하기: newNum "+dto.getNewRegNum());
		}
		
		return chkBadge;
		
	}
	
}