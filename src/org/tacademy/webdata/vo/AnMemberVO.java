package org.tacademy.webdata.vo;

public class AnMemberVO {
	int num;
	String name;
	String id;
	String pw;
	String tel;
	String address;
	String comment;
	String idate;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	@Override
	public String toString() {
		return "AnMemberVO [num=" + num + ", name=" + name + ", id=" + id + ", pw=" + pw + ", tel=" + tel + ", address="
				+ address + ", comment=" + comment + ", idate=" + idate + "]";
	}

}
