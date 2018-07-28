package com.capgemini.bankapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.bankapp.bean.CustomerDetails;

public class CustomerDao implements ICustomerDao {
	CustomerDetails pojocust=new CustomerDetails();
	   private PreparedStatement preparedStatement = null;
	  static Connection connect=null;
	 static  ResultSet rsc;
	
	    private Statement statement = null;
	    
		JdbcUtil util=new JdbcUtil();
	public int addCustomerDetails(CustomerDetails pojocust) {
		// TODO Auto-generated method stub
	     // This will load the MySQL driver, each DB has its own driver
           int n=0;
			
				 connect=util.getconnection();
					try {
						preparedStatement = connect.prepareStatement("insert into  db.Customer values (?,?, ?, ?, ?, ? ,?,?,?,?,?)");
						preparedStatement.setString(1, pojocust.getFirstname());
						preparedStatement.setString(2, pojocust.getLastname());
						preparedStatement.setString(3, pojocust.getAddress());
						preparedStatement.setInt(4, pojocust.getPhonenumber());
						preparedStatement.setInt(5, pojocust.getAge());
						preparedStatement.setString(6, pojocust.getGender());
						preparedStatement.setInt(7, pojocust.getAadharcardNumber());
						preparedStatement.setString(8, pojocust.getUsername());
						preparedStatement.setString(9, pojocust.getPassword());
						preparedStatement.setString(10, pojocust.getEmailId());
						preparedStatement.setInt(11,pojocust.getAccountNo());
						 n=  preparedStatement.executeUpdate();
							
							System.out.println(n+"rows inserted");
							connect.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
				

			
            // Setup the connection with the DB
			return n;
           
		
		
		

}
	public boolean loginValidation(String username1, String password1) {
		// TODO Auto-generated method stub
		
		   connect=	util.getconnection();
		   try {
			   
			  
			statement=connect.createStatement();
			String sql=("Select * from customer");
			rsc=statement.executeQuery(sql);
			while(rsc.next()) {
			rsc.getString("username");
				rsc.getString("password");
			
				if(username1.equals(rsc.getString("username"))&&password1.equals(rsc.getString("password"))){
					System.out.println("login success");
					
				
					
					return true;
					
				}
	
			}
			return false;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
		}
	
		
		
		
	}

