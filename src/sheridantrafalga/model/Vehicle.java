package sheridantrafalga.model;

public class Student {

	
	// POJO class for model
	private int studentid;
	private String fname;
	private String lname;
	private String city;
	private String province;
	private String postalcode;
	private Double gpa;
	
		
	public int getStudentid() {
		return studentid;
	}
	
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getPostalcode() {
		return postalcode;
	}
	
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
	public Double getGpa() {
		return gpa;
	}
	
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentid + ", fname=" + fname + ", lname=" + lname + ", city=" + city
				+ ", province=" + province + ", postalcode=" + postalcode + ", gpa=" + gpa + "]";
	}
}
