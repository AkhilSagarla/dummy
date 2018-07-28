package com.capgemini.bankapp.bean;

public class CustomerDetails {
	private String firstname;
	private String lastname;
	private int age;
	private String gender;
	private String username;
	private String password;
	private String address;
	private int phonenumber;
	private int aadharcardNumber;
	private String emailId;
	private int accountNo;
	
	/**
	 * @return the accountNo
	 */
	public int getAccountNo() {
		return accountNo;
	}
	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phonenumber
	 */
	public int getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the aadharcardNumber
	 */
	public int getAadharcardNumber() {
		return aadharcardNumber;
	}
	/**
	 * @param aadharcardNumber the aadharcardNumber to set
	 */
	public void setAadharcardNumber(int aadharcardNumber) {
		this.aadharcardNumber = aadharcardNumber;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerDetails [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", phonenumber=" + phonenumber + ", aadharcardNumber=" + aadharcardNumber + ", emailId=" + emailId
				+ ", accountNo=" + accountNo + "]";
	}
	
	

}
