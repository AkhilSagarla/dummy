package com.capgemini.bankapp.service;

import com.capgemini.bankapp.bean.CustomerDetails;

public interface ICustomerService {
	public int addCustomerDetails(CustomerDetails pojocust);
	public boolean loginValidation(String username1, String password1);
}
