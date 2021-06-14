package bit.com.a.dto;

public class aclapMemberDto {
	private int memNum; 
	private String email;
	private String pwd;
	private String userName;
	private String nickName;
	private String phoneNum;
	private String interest1;
	private String interest2;
	private String interest3;
	private String profilePic;
	private int auth;         	 // manager(9), user(3)
	private int classMaster;  	 // 강사여부 (default==0, 강사 == 1)
	private int myPoint;
	private int rCount;			 // 신청한 수업
	private int aCount;			 // 수강한 수업
	private int del;
	
	/////// 기본 생성자 ///////
	public aclapMemberDto(){
	}
	
	
	/////// 전체 생성자 ///////
	public aclapMemberDto(int memNum, String email, String pwd, String userName, String nickName, String phoneNum,
			String interest1, String interest2, String interest3, String profilePic, int auth, int classMaster,
			int myPoint, int del) {
		super();
		this.memNum = memNum;
		this.email = email;
		this.pwd = pwd;
		this.userName = userName;
		this.nickName = nickName;
		this.phoneNum = phoneNum;
		this.interest1 = interest1;
		this.interest2 = interest2;
		this.interest3 = interest3;
		this.profilePic = profilePic;
		this.auth = auth;
		this.classMaster = classMaster;
		this.myPoint = myPoint;
		this.del = del;
	}
	
	
	/////// 입력용 생성자 ///////
	public aclapMemberDto(String email, String pwd, String userName, String nickName, String phoneNum, String profilePic) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.userName = userName;
		this.nickName = nickName;
		this.phoneNum = phoneNum;
		this.profilePic = profilePic;
	}
	
	
	
	


	public aclapMemberDto(int memNum, String interest1, String interest2, String interest3) {
		super();
		this.memNum = memNum;
		this.interest1 = interest1;
		this.interest2 = interest2;
		this.interest3 = interest3;
	}


	/////// getter & setter ///////
	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getDel() {
		return del;
	}
	
	public void setDel(int del) {
		this.del = del;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getInterest1() {
		return interest1;
	}

	public void setInterest1(String interest1) {
		this.interest1 = interest1;
	}

	public String getInterest2() {
		return interest2;
	}

	public void setInterest2(String interest2) {
		this.interest2 = interest2;
	}

	public String getInterest3() {
		return interest3;
	}

	public void setInterest3(String interest3) {
		this.interest3 = interest3;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public int getClassMaster() {
		return classMaster;
	}

	public void setClassMaster(int classMaster) {
		this.classMaster = classMaster;
	}

	public int getMyPoint() {
		return myPoint;
	}

	public void setMyPoint(int myPoint) {
		this.myPoint = myPoint;
	}

	
	
	public int getrCount() {
		return rCount;
	}


	public void setrCount(int rCount) {
		this.rCount = rCount;
	}


	public int getaCount() {
		return aCount;
	}


	public void setaCount(int aCount) {
		this.aCount = aCount;
	}

	/////// toString ///////
	
	@Override
	public String toString() {
		return "aclapMemberDto [memNum=" + memNum + ", email=" + email + ", pwd=" + pwd + ", userName=" + userName
				+ ", nickName=" + nickName + ", phoneNum=" + phoneNum + ", interest1=" + interest1 + ", interest2="
				+ interest2 + ", interest3=" + interest3 + ", profilePic=" + profilePic + ", auth=" + auth
				+ ", classMaster=" + classMaster + ", myPoint=" + myPoint + ", rCount=" + rCount + ", aCount=" + aCount
				+ "]";
	}



}
