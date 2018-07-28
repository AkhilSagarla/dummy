package com.capgemini.bankapp.service;

import com.capgemini.bankapp.bean.AccountDetails;

public interface IAccountService {
	public int addAccountDetails(AccountDetails pojoacc);
	public double showBalance();
	public double withdrawAmount(Double amount);
	public double depositAmount(double balance);
	public void fundTransfer(int acc2,double amt);
	public void printTransaction();
	public int storingTempResult(String username1, String password1);
}
