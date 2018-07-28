
package com.cg.ppj.dto;
import java.math.BigDecimal;

public class Wallet{
private double balance;
private int accountno;


public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public int getAccountno() {
	return accountno;
}
public void setAccountno(int accountno) {
	this.accountno = accountno;
}
@Override
public String toString() {
	return "Wallet [balance=" + balance + ", accountno=" + accountno + "]";
}



}



