package com.cognizant.onlinebloodbank.model;

public class Search {
private String state;
private String area;
private  int pincode;
private String bloodgroup;
private String contactnumber;
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public String getBloodgroup() {
	return bloodgroup;
}
public void setBloodgroup(String bloodgroup) {
	this.bloodgroup = bloodgroup;
}
public String getContactnumber() {
	return contactnumber;
}
public void setContactnumber(String contactnumber) {
	this.contactnumber = contactnumber;
}

}
