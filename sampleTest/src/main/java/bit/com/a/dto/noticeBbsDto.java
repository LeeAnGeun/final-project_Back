package bit.com.a.dto;

import java.io.Serializable;

public class noticeBbsDto implements Serializable{
	
	/*
	 * NOTICENUM NUMBER PRIMARY KEY, MEMNUM NUMBER, NTITLE VARCHAR2(50) NOT NULL,
	 * NCONTENT VARCHAR2(4000) NULL, WDATE DATE NOT NULL, NIMG VARCHAR2(50) NULL,
	 * DEL NUMBER(1) NOT NULL, ANSWER NUMBER(1) NOT NULL,
	 */
    


	private int noticeNum;
	private int memNum;
	private String nTitle;
	private String nContent;
	private String wDate;
	private int del;
	private int answer;
	
	private String username;
	private String email;
	
	public noticeBbsDto() {
		// TODO Auto-generated constructor stub
	}

	public noticeBbsDto(int noticeNum, int memNum, String nTitle, String nContent, String wDate, int del,
			int answer, String username, String email) {
		super();
		this.noticeNum = noticeNum;
		this.memNum = memNum;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.wDate = wDate;
		this.del = del;
		this.answer = answer;
		this.username = username;
		this.email = email;
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getwDate() {
		return wDate;
	}

	public void setwDate(String wDate) {
		this.wDate = wDate;
	}


	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "noticeBbsDto [noticeNum=" + noticeNum + ", memNum=" + memNum + ", nTitle=" + nTitle + ", nContent="
				+ nContent + ", wDate=" + wDate + ", del=" + del + ", answer=" + answer
				+ ", username=" + username + ", email=" + email + "]";
	}
	
}