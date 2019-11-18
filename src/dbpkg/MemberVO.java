package dbpkg;

public class MemberVO {
	//custno, custname, phone, address, joindate, grade, city
	/*custno number(6) not null primary key,
	 *custname varchar2(20),
	 *phone varchar2(13), 
	 * address varchar2(60),
	 * joindate	date,
	 * grade char(1),
	 * city char(2)
	 * 
	 * */
	int custno;
	String custname;
	String phone;
	String address;
	String joindate;
	String grade;
	String city;

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setDate(String joindate) {
		this.joindate = joindate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
