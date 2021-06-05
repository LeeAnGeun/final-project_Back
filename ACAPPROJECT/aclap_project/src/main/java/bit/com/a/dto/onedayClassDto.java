package bit.com.a.dto;

public class onedayClassDto {
	   private int classNum;
	   private int masterNum;
	   private String instructor;
	   private String primaryCategory;
	   private String secondaryCategory;
	   private String title;
	   private String content;
	   private String startDate;
	   private String endDate;
	   private int price;
	   private String information;
	   private String duration;
	   private String limitNum;
	   private String preparation;
	   private String aboutMe;
	   private String image1;
	   private String image2;
	   private String image3;
	   private String image4;
	   private String image5;   
	   private String location;
	   private String youtubeLink;
	   private int likeCount;
	   private int del;
	   private int oldRegNum;
	   private int newRegNum;
	   private String layerSelect; //이미지 레이어 타입 ("A", "B", "C")
	   
	   private String profilePic; // master의 프로필 사진 
	   private String email;	// master의 이메일
	   private double avgPoint; 
	   
	   
	private String noClass;
	   public onedayClassDto() {
	   }

	public String getNoClass() {
		return noClass;
	}

	public void setNoClass(String noClass) {
		this.noClass = noClass;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getMasterNum() {
		return masterNum;
	}

	public void setMasterNum(int masterNum) {
		this.masterNum = masterNum;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(String limitNum) {
		this.limitNum = limitNum;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
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

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getYoutubeLink() {
		return youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getOldRegNum() {
		return oldRegNum;
	}

	public void setOldRegNum(int oldRegNum) {
		this.oldRegNum = oldRegNum;
	}

	public int getNewRegNum() {
		return newRegNum;
	}

	public void setNewRegNum(int newRegNum) {
		this.newRegNum = newRegNum;
	}

	public String getLayerSelect() {
		return layerSelect;
	}

	public void setLayerSelect(String layerSelect) {
		this.layerSelect = layerSelect;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getAvgPoint() {
		return avgPoint;
	}

	public void setAvgPoint(double avgPoint) {
		this.avgPoint = avgPoint;
	}

	
	public onedayClassDto(int classNum, int masterNum, String instructor, String primaryCategory,
			String secondaryCategory, String title, String content, String startDate, String endDate, int price,
			String information, String duration, String limitNum, String preparation, String aboutMe, String image1,
			String image2, String image3, String image4, String image5, String location, String youtubeLink,
			int likeCount, int del, int oldRegNum, int newRegNum, String layerSelect, String profilePic, String email,
			double avgPoint, String noClass) {
		super();
		this.classNum = classNum;
		this.masterNum = masterNum;
		this.instructor = instructor;
		this.primaryCategory = primaryCategory;
		this.secondaryCategory = secondaryCategory;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.information = information;
		this.duration = duration;
		this.limitNum = limitNum;
		this.preparation = preparation;
		this.aboutMe = aboutMe;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.location = location;
		this.youtubeLink = youtubeLink;
		this.likeCount = likeCount;
		this.del = del;
		this.oldRegNum = oldRegNum;
		this.newRegNum = newRegNum;
		this.layerSelect = layerSelect;
		this.profilePic = profilePic;
		this.email = email;
		this.avgPoint = avgPoint;
		this.noClass = noClass;
	}

	@Override
	public String toString() {
		return "onedayClassDto [classNum=" + classNum + ", masterNum=" + masterNum + ", instructor=" + instructor
				+ ", primaryCategory=" + primaryCategory + ", secondaryCategory=" + secondaryCategory + ", title="
				+ title + ", content=" + content + ", startDate=" + startDate + ", endDate=" + endDate + ", price="
				+ price + ", information=" + information + ", duration=" + duration + ", limitNum=" + limitNum
				+ ", preparation=" + preparation + ", aboutMe=" + aboutMe + ", image1=" + image1 + ", image2=" + image2
				+ ", image3=" + image3 + ", image4=" + image4 + ", image5=" + image5 + ", location=" + location
				+ ", youtubeLink=" + youtubeLink + ", likeCount=" + likeCount + ", del=" + del + ", oldRegNum="
				+ oldRegNum + ", newRegNum=" + newRegNum + ", layerSelect=" + layerSelect + ", profilePic=" + profilePic
				+ ", email=" + email + ", avgPoint=" + avgPoint + ", noClass=" + noClass + "]";
	}
	
}
