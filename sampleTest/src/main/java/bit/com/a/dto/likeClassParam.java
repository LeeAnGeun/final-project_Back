package bit.com.a.dto;

public class likeClassParam {
	private int start;
	private int end;
	private int memNum;
	private int page;
	public likeClassParam() {
	}
	public likeClassParam(int start, int end, int memNum, int page) {
		super();
		this.start = start;
		this.end = end;
		this.memNum = memNum;
		this.page = page;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
