package bit.com.a.dto;

public class reviewDto {

	private int reviewSeq;
	private int classNum;
	private int memNum;
	private double starPoint;
	private String rContent;
	private String name;
	private double cleanness;
	private double satisfy;
	private double rComm;
	private double rLocation;
	private double accuracy;
	private int del;         // default = 0 
	private String wDate;
	private String image1;
	private String image2;
	private String image3;
	
	private String profilePic;
	
	public reviewDto() {
	}

	public reviewDto(int reviewSeq, int classNum, int memNum, double starPoint, String rContent, String name,
			double cleanness, double satisfy, double rComm, double rLocation, double accuracy, int del, String wDate,
			String image1, String image2, String image3, String profilePic) {
		super();
		this.reviewSeq = reviewSeq;
		this.classNum = classNum;
		this.memNum = memNum;
		this.starPoint = starPoint;
		this.rContent = rContent;
		this.name = name;
		this.cleanness = cleanness;
		this.satisfy = satisfy;
		this.rComm = rComm;
		this.rLocation = rLocation;
		this.accuracy = accuracy;
		this.del = del;
		this.wDate = wDate;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.profilePic = profilePic;
	}

	public int getReviewSeq() {
		return reviewSeq;
	}

	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
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

	public double getStarPoint() {
		return starPoint;
	}

	public void setStarPoint(double starPoint) {
		this.starPoint = starPoint;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCleanness() {
		return cleanness;
	}

	public void setCleanness(double cleanness) {
		this.cleanness = cleanness;
	}

	public double getSatisfy() {
		return satisfy;
	}

	public void setSatisfy(double satisfy) {
		this.satisfy = satisfy;
	}

	public double getrComm() {
		return rComm;
	}

	public void setrComm(double rComm) {
		this.rComm = rComm;
	}

	public double getrLocation() {
		return rLocation;
	}

	public void setrLocation(double rLocation) {
		this.rLocation = rLocation;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getwDate() {
		return wDate;
	}

	public void setwDate(String wDate) {
		this.wDate = wDate;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	@Override
	public String toString() {
		return "reviewDto [reviewSeq=" + reviewSeq + ", classNum=" + classNum + ", memNum=" + memNum + ", starPoint="
				+ starPoint + ", rContent=" + rContent + ", name=" + name + ", cleanness=" + cleanness + ", satisfy="
				+ satisfy + ", rComm=" + rComm + ", rLocation=" + rLocation + ", accuracy=" + accuracy + ", del=" + del
				+ ", wDate=" + wDate + ", image1=" + image1 + ", image2=" + image2 + ", image3=" + image3
				+ ", profilePic=" + profilePic + "]";
	}


}

