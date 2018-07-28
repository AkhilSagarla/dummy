package com.capgemini.bankapp.service;

import com.capgemini.bankapp.exception.DetailsNotValid;

public class ValidatingCustomerDetails {
	

	

		public boolean validateFirstname(String firstname) {
			if (firstname.isEmpty()||firstname.matches("1234567890")) {
				try {
					throw new DetailsNotValid();
				}catch(DetailsNotValid c) {
					System.err.println(c);
				}
				return false;
			}
				return true;
			
			

		}
	  public boolean validateLastname(String lastname) {
		  if(lastname.isEmpty()|| lastname.contains("1234567890")) {
			  System.out.println("lastname cannot be empty and cannot have digits");
				try {
					throw new DetailsNotValid();
				}catch(DetailsNotValid c) {
					System.err.println(c);
				}
			  return false;
		  }
		  return true;
	  }
	  public boolean validateGender(String gender) {
		  if(gender.equalsIgnoreCase("female")||gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("others")) {
			  return true;
		  }
		  else {
			  System.out.println("enter correct gender");
			  try {
					throw new DetailsNotValid();
				}catch(DetailsNotValid c) {
					System.err.println(c);
				}
			  return false;
		  }
		  
		  
	  }
	  public boolean validateAge(int age) {
		  if(age>18) {
			  return true;
		  }else {
			  System.out.println("the person should be major");
			
			  try { throw new DetailsNotValid(); }catch(DetailsNotValid c) {
			 System.err.println(c); }
			 
			  return false;
		  }
	  }
	  public boolean validateAddress(String address) {
		  if(address.isEmpty()) {
			  System.out.println("address field cannot be empty");
			  try {
					throw new DetailsNotValid();
				}catch(DetailsNotValid c) {
					System.err.println(c);
				}
			  return false;
		  }return true;
	  }
	  public boolean validatePhonenumber(int phonenumber) {
		  char c[]=String.valueOf(phonenumber).toCharArray();
		  if(c.length==10) {
			  return true;
		  }
		  else {
			  System.out.println("enter correct phone number");
			  try {
					throw new DetailsNotValid();
				}catch(DetailsNotValid k) {
					System.err.println(k);
				}
			  return false;
		  }
	  }
	  public boolean validateAadharcardNumber(int aadharcardNumber) {
		  char c[]=String.valueOf(aadharcardNumber).toCharArray();
		  if(c.length==10)
		  {
			  return true;
		  }else {
			  System.out.println("enter correct aadharcardNumber");
			  try {
					throw new DetailsNotValid();
				}catch(DetailsNotValid k) {
					System.err.println(k);
				}
			  return false;
		  }
	  }
	  public boolean validateEmailId(String emailId)
	  {
		  if(emailId.isEmpty()) {
			  System.out.println("emailId cannot be empty");
			  try {
					throw new DetailsNotValid();
				}catch(DetailsNotValid c) {
					System.err.println(c);
				}
			  return false;
			  
		  }return true;
	  }
	  public boolean validateUsername(String username) {
		  if(username.isEmpty()) {
			  System.out.println("username cannot be empty");
			  return true;
			  
		  }else {
			  try {
					throw new DetailsNotValid();
				}catch(DetailsNotValid c) {
					System.err.println(c);
				}
			  return false;
		  }
	  }
	  public boolean validatePassword(String password) {
		  if(password.isEmpty()) {
			  System.out.println("password cannot be empty");
			  try {
					throw new DetailsNotValid();
				}catch(DetailsNotValid c) {
					System.err.println(c);
				}
			  return false;
		  }
		  return true;
	  }
	}


