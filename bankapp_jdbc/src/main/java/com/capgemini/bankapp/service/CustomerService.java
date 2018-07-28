package com.capgemini.bankapp.service;

import com.capgemini.bankapp.bean.CustomerDetails;
import com.capgemini.bankapp.dao.CustomerDao;

public class CustomerService implements ICustomerService{
	CustomerDao custDao=new CustomerDao();

	public int addCustomerDetails(CustomerDetails pojocust) {
		// TODO Auto-generated method stub
		return custDao.addCustomerDetails(pojocust);
	}

	public boolean loginValidation(String username1, String password1) {
		return  custDao.loginValidation(username1, password1);
		// TODO Auto-generated method stub
		
	}

}
