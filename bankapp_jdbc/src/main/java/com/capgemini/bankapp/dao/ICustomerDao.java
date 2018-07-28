package com.capgemini.bankapp.dao;

import com.capgemini.bankapp.bean.CustomerDetails;

public interface ICustomerDao {
	public int addCustomerDetails(CustomerDetails pojocust);
	public boolean loginValidation(String username1, String password1);
}
