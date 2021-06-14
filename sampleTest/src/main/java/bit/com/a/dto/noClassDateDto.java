package bit.com.a.dto;

public class noClassDateDto {
	private int noClassDateNum;
	private int classNum;
	private String noClassDate;

	public noClassDateDto() {
	}

	public noClassDateDto(int noClassDateNum, int classNum, String noClassDate) {
		super();
		this.noClassDateNum = noClassDateNum;
		this.classNum = classNum;
		this.noClassDate = noClassDate;
	}

	public int getNoClassDateNum() {
		return noClassDateNum;
	}

	public void setNoClassDateNum(int noClassDateNum) {
		this.noClassDateNum = noClassDateNum;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public String getNoClassDate() {
		return noClassDate;
	}

	public void setNoClassDate(String noClassDate) {
		this.noClassDate = noClassDate;
	}
	
}
