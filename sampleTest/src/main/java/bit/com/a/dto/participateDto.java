package bit.com.a.dto;

public class participateDto {
	private int classNum;
	private int memNum;
	private String payDate;		// 결제 한 날
	private String classDate;	// 수업 받는 날
	private String name;
	private int rPoint;	// 결제 금액
	private String primaryCategory;
	private String secondaryCategory;
	private String title;
	private int participants;	// 신청한 사람 수
	
	
	
	public participateDto() {
	}

	public participateDto(int classNum, int memNum, String payDate, String classDate, String name, int rPoint,
			String primaryCategory, String secondaryCategory, String title, int participants) {
		super();
		this.classNum = classNum;
		this.memNum = memNum;
		this.payDate = payDate;
		this.classDate = classDate;
		this.name = name;
		this.rPoint = rPoint;
		this.primaryCategory = primaryCategory;
		this.secondaryCategory = secondaryCategory;
		this.title = title;
		this.participants = participants;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getrPoint() {
		return rPoint;
	}

	public void setrPoint(int rPoint) {
		this.rPoint = rPoint;
	}

	public String getPrimaryCategory() {
		return primaryCategory;
	}

	public void setPrimaryCategory(String primaryCategory) {
		this.primaryCategory = primaryCategory;
	}

	public String getSecondaryCategory() {
		return secondaryCategory;
	}

	public void setSecondaryCategory(String secondaryCategory) {
		this.secondaryCategory = secondaryCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "participateDto [classNum=" + classNum + ", memNum=" + memNum + ", payDate=" + payDate + ", classDate="
				+ classDate + ", name=" + name + ", rPoint=" + rPoint + ", primaryCategory=" + primaryCategory
				+ ", secondaryCategory=" + secondaryCategory + ", title=" + title + ", participants=" + participants
				+ "]";
	}

}
