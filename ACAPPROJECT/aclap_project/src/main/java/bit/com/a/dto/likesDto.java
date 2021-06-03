package bit.com.a.dto;

public class likesDto {
	private int memNum;
	private int classNum;
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
	public likesDto(int memNum, int classNum) {
		super();
		this.memNum = memNum;
		this.classNum = classNum;
	}
	public likesDto() {
	}
	@Override
	public String toString() {
		return "likesDto [memNum=" + memNum + ", classNum=" + classNum + "]";
	}
	
}
