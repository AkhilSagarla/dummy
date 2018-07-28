package com.capgemini.bank.app.jdbc.bankapp_jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.capgemini.bankapp.bean.AccountDetails;
import com.capgemini.bankapp.bean.CustomerDetails;
import com.capgemini.bankapp.exception.WrongChoice;
import com.capgemini.bankapp.service.AccountService;
import com.capgemini.bankapp.service.CustomerService;
import com.capgemini.bankapp.service.ValidatingCustomerDetails;


public class App 
{
static 	CustomerService custService = new CustomerService();
static 	AccountService accService = new AccountService();
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static CustomerDetails pojocust = new CustomerDetails();
		static AccountDetails pojoacc = new AccountDetails();
static int accno;
		// static BankappService service=new BankappService();
		public static void main(String[] args) {
			while (true) {
				System.out.println("^^^^^^^^^^^welcome to the e bank app^^^^^^^^^^^");
				System.out.println("1.new user");
				System.out.println("2.I already have account");
				System.out.println("enter your choice");
				try {
					int choice = Integer.parseInt(br.readLine());
					if (choice == 1) {
						customerDetails();
					} else if(choice==2){
						testLogin();
					}else {
						try {
							throw new WrongChoice();
						}catch (WrongChoice e) {
							System.err.println(e);
							
							
						}
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public static void customerDetails() {
			ValidatingCustomerDetails isvalid = new ValidatingCustomerDetails();
			System.out.println("fill the below details to create an account");
			System.out.println("enter your firstname(could not be empty)");
			try {
				String firstname = br.readLine();
				boolean isvalidFname = isvalid.validateFirstname(firstname);
				System.out.println("enter lastname(could not be empty)");
				String lastname = br.readLine();
				boolean isvalidLname = isvalid.validateLastname(lastname);

				System.out.println("enter your gender(male/female/other)");
				String gender = br.readLine();
				boolean isvalidGender = isvalid.validateGender(gender);
				System.out.println("enter your age(>18)");
				int age = Integer.parseInt(br.readLine());
				boolean isvalidAge = isvalid.validateAge(age);
				System.out.println("enter address(only characters)");
				String address = br.readLine();
				boolean isvalidAddress = isvalid.validateAddress(address);
				System.out.println("enter your aadharcard number(length=10)");
				int aadharcardNumber = Integer.parseInt(br.readLine());
				boolean isvalidAadharNo = isvalid.validateAadharcardNumber(aadharcardNumber);
				System.out.println("enter phone number");
				int phonenumber = Integer.parseInt(br.readLine());
				boolean isvalidPhoneNo = isvalid.validatePhonenumber(phonenumber);
				System.out.println("enter email Id");
				String emailId = br.readLine();
				boolean isvalidEmailId = isvalid.validateEmailId(emailId);
				System.out.println("enter accountnumber");
				int accountNo = Integer.parseInt(br.readLine());
				System.out.println("enter username to login");
				String username = br.readLine();
				System.out.println("enter password(atleast eight characters)");
				String password = br.readLine();

				if (isvalidAadharNo && isvalidAddress && isvalidAge && isvalidEmailId && isvalidFname && isvalidGender
						&& isvalidLname && isvalidPhoneNo) {
					System.out.println("the details entered are valid");
					pojocust.setAadharcardNumber(aadharcardNumber);
					pojoacc.setAccountNo(accountNo);
					pojocust.setAddress(address);
					pojocust.setAge((int) age);
					pojocust.setEmailId(emailId);
					pojocust.setFirstname(firstname);
					pojocust.setLastname(lastname);
					pojocust.setGender(gender);
					pojocust.setPassword(password);
					pojocust.setPhonenumber(phonenumber);
					pojocust.setUsername(username);
					pojocust.setAccountNo(accountNo);
					pojoacc.setBalance(1000);
					pojocust.setAccountNo(accountNo);
					custService.addCustomerDetails(pojocust);
					accService.addAccountDetails(pojoacc);
					System.out.println("^^^^^^account is successfully created^^^^^^^");

				} else {
					System.out.println("enter correct details");
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public static void testLogin() {
			

			System.out.println("please enter your username");
			try {
				String username1 = br.readLine();
				System.out.println("enter password");
				String password1 = br.readLine();
				boolean isCorrect=custService.loginValidation(username1,password1);
				
				if (isCorrect) {
				System.out.println(	accService.storingTempResult(username1,password1));
					
					System.out.println("login success");
					System.out.println("&&&&&&&&& the service offered are &&&&&&&&");
					System.out.println("--> 1.show balance in my account");
					System.out.println("--> 2.withdraw amount");
					System.out.println("--> 3.deposit amount");
					System.out.println("--> 4.transfer funds");
					System.out.println("--> 5.print transactions");
					System.out.println("enter your own choice");
					
					
		
					int yourChoice = Integer.parseInt(br.readLine());
					switch (yourChoice) {
					case 1:
						
						
						accService.showBalance();
						
						break;
					case 2:
						System.out.println("enter amount withdraw");
						double amount=Double.parseDouble(br.readLine());
						accService.withdrawAmount(amount);
						break;
					case 3:
						System.out.println("enter amount to deposit");
						double amount1=Double.parseDouble(br.readLine());
						accService.depositAmount(amount1);
						break;
					case 4:
						AccountDetails pojo2=new AccountDetails();
						System.out.println("enter accountnumber of the other person");
						int acc2=Integer.parseInt(br.readLine());
						pojo2.setAccountNo2(acc2);
						
						System.out.println("enter amount to transfer");
						double amt=Double.parseDouble(br.readLine());
						accService.fundTransfer(acc2, amt);
						break;
					case 5:
						accService.printTransaction();
						break;
						default:
							System.out.println("wrong choice");
					}

				} else {
					System.out.println("enter correct credentials");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
