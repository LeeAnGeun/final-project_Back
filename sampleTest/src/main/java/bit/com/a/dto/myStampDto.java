package bit.com.a.dto;

public class myStampDto {
	private int myStampNum;
	private int memNum;
	private int classNum;
	private String primaryCategory;
	private String secondaryCategory;
	private String title;
	
	public myStampDto() {
	}

	public myStampDto(int myStampNum, int memNum, int classNum, String primaryCategory, String secondaryCategory,
			String title) {
		super();
		this.myStampNum = myStampNum;
		this.memNum = memNum;
		this.classNum = classNum;
		this.primaryCategory = primaryCategory;
		this.secondaryCategory = secondaryCategory;
		this.title = title;
	}

	public int getMyStampNum() {
		return myStampNum;
	}

	public void setMyStampNum(int myStampNum) {
		this.myStampNum = myStampNum;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
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

	@Override
	public String toString() {
		return "myStamp [myStampNum=" + myStampNum + ", memNum=" + memNum + ", classNum=" + classNum
				+ ", primaryCategory=" + primaryCategory + ", secondaryCategory=" + secondaryCategory + ", title="
				+ title + "]";
	}
}
