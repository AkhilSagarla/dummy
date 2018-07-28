package com.capgemini.bankapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.bankapp.bean.AccountDetails;

public class AccountDao implements IAccountDao{
	
	static JdbcUtil util=new JdbcUtil();
	 static int acc;
	  int n=0;
	  static String withdrawInfo,depositInfo,transferInfo;
	  
		 
static Connection conn=null;
static PreparedStatement pst=null;
static Statement st;
static ResultSet tempResultSet;
	public int addAccountDetails(AccountDetails pojoacc) {
		// TODO Auto-generated method stub
		  int n=0;
		 
		  PreparedStatement pst=null;
			/*try {
				Class.forName("com.mysql.jdbc.Driver");

				conn = DriverManager
				        .getConnection("jdbc:mysql://localhost:3306/db?"
				                + "user=root&password=Capgemini123");*/
				
				
				   conn=	util.getconnection();
				try {
					pst = conn
					        .prepareStatement("insert into  db.Account values (?, ?, ?)");
					pst.setInt(1,pojoacc.getAccountNo());
					pst.setInt(2, pojoacc.getAccountNo2());
					pst.setDouble(3,pojoacc.getBalance());
					n=pst.executeUpdate();
					System.out.println(n+ "rows inserted");
					
					
			conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
			/*} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    // Setup the connection with the DB
catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return n;
	           
	}

	public double showBalance() {
		
		  Connection conn=	util.getconnection();
			try {
			
				String sqla="select * from Account where accountNo= '"+acc+"'";
				st=conn.createStatement();
		//	double amount=	tempResultSet.getDouble("balance");
			ResultSet rs=	st.executeQuery(sqla);
		//	System.out.println(rs.getInt("accountNo"));
		//	System.out.println(acc);
				
					if(rs.first()) {
					
						System.out.println("entered");
					rs.getDouble("balance");
					System.out.println("------->the amount is "+rs.getDouble("balance"));
					
					return 1;
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
			
	}

	public double withdrawAmount(Double amount) {
		// TODO Auto-generated method stub
		  Connection conn=	util.getconnection();
		try {
			 withdrawInfo="the amount credited is"+amount;
			
		
			st=conn.createStatement();
			String sql="select * from Account where accountNo= '"+acc+"'";
			ResultSet rs2=	st.executeQuery(sql);
			boolean k=rs2.first();
			System.out.println(k);
			if(rs2.first()) {
			double balafter=rs2.getDouble("balance")-amount;
			System.out.println("-------->balance after withdrawing is " +balafter);
			pst=conn.prepareStatement("update Account set balance='"+balafter+"' where accountNo='"+acc+"'");
			n=pst.executeUpdate();
			System.out.println(n+"rows updated");
			return 1;
			}	
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public double depositAmount(double balance) {
		// TODO Auto-generated method stub
		 Connection conn=	util.getconnection();
			try {
				 depositInfo="the amount debited is"+balance;
				
				st=conn.createStatement();
				String sql="select * from Account where accountNo= '"+acc+"'";
				ResultSet rs3=	st.executeQuery(sql);
				boolean k=rs3.first();
				System.out.println(k);
				if(rs3.first()) {
				double balafter=rs3.getDouble("balance")+balance;
				System.out.println("----->balance after depositing is"+balafter);
				pst=conn.prepareStatement("update Account set balance='"+balafter+"' where accountNo='"+acc+"'");
				n=pst.executeUpdate();
				System.out.println(n+"rows updated");
				return 1;
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return 0;
		
		
		
		
	}

	public void fundTransfer(int acc2, double amt) {
		// TODO Auto-generated method stub
		  Connection conn=	util.getconnection();
			try {
				 transferInfo="the amount transfered is"+amt;
				
			
				st=conn.createStatement();
				String sql="select * from Account where accountNo= '"+acc+"'";
				
				ResultSet rs2=	st.executeQuery(sql);
				
				boolean k=rs2.first();
				System.out.println(k);
				if(rs2.first()) {
				double balafter=rs2.getDouble("balance")-amt;
				System.out.println("----->The amount "  +balafter+  "got debited from  account number"+acc);
				pst=conn.prepareStatement("update Account set balance='"+balafter+"' where accountNo='"+acc+"'");
				n=pst.executeUpdate();
				System.out.println(n+"rows updated");
				}
				String sql2="select balance from account where accountNo='"+acc2+"'";
				ResultSet rs3=st.executeQuery(sql2);
				if(rs3.first()) {
				double balafter2=rs3.getDouble("balance")+amt;
				System.out.println("----->the amount "  +balafter2+  "got credited to account number "+acc2);
				pst=conn.prepareStatement("update Account set balance='"+balafter2+"' where accountNo='"+acc2+"'");
				n=pst.executeUpdate();
				System.out.println(n+"rows updated");
				
				
				
				}
				
					
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	public void printTransaction() {
		// TODO Auto-generated method stub
		Connection conn=	util.getconnection();
		try {
			pst=conn.prepareStatement("insert into transactions values(?,?,?,?)");
			pst.setInt(1, acc);
			pst.setString(2,  withdrawInfo);
			pst.setString(3, depositInfo);
			pst.setString(4, transferInfo);
			pst.executeUpdate();
			
			st=conn.createStatement();
			String sql="select * from transactions where accountNo='"+acc+"'";
			ResultSet rs4=st.executeQuery(sql);
			if(rs4.next()) {
				
				System.out.println(rs4.getInt("accountNo"));
				System.out.println(rs4.getString("withdrawInfo"));
				System.out.println(rs4.getString("depositInfo"));
				System.out.println(rs4.getString("transferedinfo"));
			
			}
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public int storingTempResult(String username1, String password1) {
		// TODO Auto-generated method stub
		Connection conn=	util.getconnection();
		try {
			st=conn.createStatement();
			String query=("select * from customer where username='"+username1+"'and password='"+password1+"'");
			tempResultSet=st.executeQuery(query);
			while(tempResultSet.next()) {
				acc=tempResultSet.getInt("accountNo");
				return acc;
			}
			
		conn.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
