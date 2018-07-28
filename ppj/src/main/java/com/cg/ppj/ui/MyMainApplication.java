package com.cg.ppj.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cg.ppj.dto.Customer;
import com.cg.ppj.dto.Wallet;
import com.cg.ppj.service.WalletService;
import com.cg.ppj.service.WalletServiceImpl;

public class MyMainApplication {

 static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 static Customer cus=new Customer();
 static Wallet wal=new Wallet();
 static WalletService service=new WalletServiceImpl();
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Welcome to payment Wallet");
while(true) {
System.out.println("1.Exsisting user");
System.out.println("2.New user");
System.out.println("Enetr your choice");
try {
	int choice=Integer.parseInt(br.readLine());
	if(choice==1) {
		login();
		
	}else {
		createAccount();
		
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



public static void createAccount() {
	System.out.println("Enter your Name");
	try {
		String name=br.readLine();
		System.out.println("Enter your MobileNo");
		long phone=Integer.parseInt(br.readLine());
		System.out.println("Enter your EmailId");
		String email=br.readLine();
		System.out.println("Enter your gender");
		String gender=br.readLine();
		System.out.println("Enter your Aadhar No");
		long aadharno=Integer.parseInt(br.readLine());
		System.out.println("Enter your account no");
		int accountno=Integer.parseInt(br.readLine());
		System.out.println("Set your userName");
		String userName=br.readLine();
		System.out.println("Set Your Password");
		String password=br.readLine();
		
		cus.setName(name);
		cus.setAadhar(aadharno);
		cus.setEmail(email);
		cus.setGender(gender);
		cus.setMobileNo(phone);
		cus.setPassword(password);
		cus.setUserName(userName);
		wal.setAccountno(accountno);
		wal.setBalance(0);
		
		System.out.println("Account successfully created");
		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void login() {
	System.out.println("Enter user name");
	try {
		String username=br.readLine();
		WalletServiceImpl service=new WalletServiceImpl();
		
		System.out.println("enter password");
		String password=br.readLine();
		if(cus.getUserName().equals(username)&&cus.getPassword().equals(password)) {
			System.out.println("login success");
			System.out.println("1.Withdraw amount");
			System.out.println("2.Deposit amount");
			System.out.println("3.Transfer funds");
			System.out.println("4.show balance");
			System.out.println("5.Print Transactions");
			System.out.println("Enter any choice");
			int choice1=Integer.parseInt(br.readLine());
			switch(choice1) {
			case 1: System.out.println("Enter amount to withdraw");
			double amount=Double.parseDouble(br.readLine());
			service.withdrawAmount(amount);
			break;
			
			case 2: System.out.println("Enter amount to Deposit");
			double amount1=Double.parseDouble(br.readLine());
			service.depositAmount(amount1);
			break;
			
			case 3: 
				Wallet wal2=new Wallet();
				System.out.println(" Enter Target Accoount No");
			int accountno=Integer.parseInt(br.readLine());
			wal2.setAccountno(accountno);
			
			System.out.println("Enter Amount to Transfer");
			double balance=Double.parseDouble(br.readLine());
			service.fundtransfer(balance);
			break;
			
			case 4: System.out.println("Show Balance");
		
			service.showbalance();
			break;
			
			case 5: System.out.println("Print Transactions");
			service.printtransaction();
			break;
			}
		
	}
		else {
			System.out.println("Enter correct choice");
		}
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	


}
}
