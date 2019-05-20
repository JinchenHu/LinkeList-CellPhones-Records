
public class CellPhone {
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	/**
	 * parameterized constructor receiving four values
	 * @param serialNum serial number
	 * @param brand brand name
	 * @param year released year
	 * @param price price
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	/**
	 * copy constructor that copys the attributes of passed CellPhone except serialNum
	 * @param phone CellPhone
	 * @param serialNum serial number
	 */
	public CellPhone(CellPhone phone, long serialNum) {
		this.serialNum = serialNum;
		this.brand = phone.getBrand();
		this.year = phone.getYear();
		this.price = phone.getPrice();
	}
	/**
	 * method that returns a clone of the revoking object with the exception of the serial number
	 * @param serialNum serial number
	 * @return  CellPhone
	 */
	public CellPhone clone(long serialNum) {
		return new CellPhone(serialNum, this.getBrand(), this.getYear(),this.getPrice());
	}
	/**
	 * accessor to gets serial number
	 * @return serialNum
	 */
	public long getSerialNum() {
		return serialNum;
	}
	/**
	 * mutator that sets the value of serial number 
	 * @param serialNum serial number
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	/**
	 * accessor that gets the value of brand
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * mutator that sets the value of brand
	 * @param brand brand name
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * accessor that gets the value of year
	 * @return year year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * mutator that sets the value of year
	 * @param year year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * accessor that gets the value of price
	 * @return price price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * mutator that sets the value of price
	 * @param price price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * method that returns the value of the attributes of the calling object
	 */
	public String toString() {
		return "["+this.serialNum + ": " + this.brand +" " + this.price + "$ " + this.year+"]";
	}
	/**
	 * returns true if the calling object and the passed object share the same brand, year, and price
	 * @param phone CellPhone
	 * @return true if the have same brand,year,and price
	 */
	public boolean equals(CellPhone phone) {
		return (this.brand.equals(phone.getBrand())) && (this.year == phone.getYear()) && (this.price == phone.getPrice());
	}
}
