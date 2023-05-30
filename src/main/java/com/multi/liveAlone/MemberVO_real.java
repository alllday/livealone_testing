package com.multi.liveAlone;

public class MemberVO_real {
	private String member_id;
	private String address;
	private String nickname;
	private int certification;
	private int point;
	private int count;
	private String password;
	private int mileage;
	private int admin;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getCertification() {
		return certification;
	}
	public void setCertification(int certification) {
		this.certification = certification;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "MemberVO_real [member_id=" + member_id + ", address=" + address + ", nickname=" + nickname
				+ ", certification=" + certification + ", point=" + point + ", count=" + count + ", password="
				+ password + ", mileage=" + mileage + ", admin=" + admin + "]";
	}
	
	
}
