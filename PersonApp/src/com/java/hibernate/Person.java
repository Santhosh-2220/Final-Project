package com.java.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person_table")

public class Person {
	@Id
	@GeneratedValue
	private int Personid;
	
	@Column(name = "Pname", length=30)
	private String PersonName;
	
	@Column(name = "gender")
	private String Gender;
	
	@Column(name = "location", length=20)
	private String Location;
	
	@Column(name = "phn", length=10)
	private String PhoneNumber;
	
	@Column(name = "email", length=100)
	private String Email;

	public int getPersonid() {
		return Personid;
	}

	public void setPersonid(int personid) {
		Personid = personid;
	}

	public String getPersonName() {
		return PersonName;
	}

	public void setPersonName(String personName) {
		PersonName = personName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
