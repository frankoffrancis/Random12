package apollo.model;

public class Shoes {

	private Integer shoeID;
	private String shoeName;
	private Integer shoeSize;
	private Double price;
	private String gender;
	private String categoryName;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getShoeID() {
		return shoeID;
	}
	public void setShoeID(Integer shoeID) {
		this.shoeID = shoeID;
	}
	public String getShoeName() {
		return shoeName;
	}
	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}
	public Integer getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(Integer shoeSize) {
		this.shoeSize = shoeSize;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
