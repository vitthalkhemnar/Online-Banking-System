package com.dao;

import java.lang.reflect.AccessFlag;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.connectionfactory.ConnectionFactory;
import com.entity.Account;

public class AccountDao {
	
	private static ArrayList<Account> al = new ArrayList<>();
	
	public static String insertIntoUserInfo(String fname, String lname, String phone, String email, 
			String address, String dob, String gender, String mar, String uname, String pass, 
			String accno, String ifscno, String branch) {
		String flag = "";
		try {
			String sql = "insert into user_info values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = ConnectionFactory.getcon().prepareStatement(sql);
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, address);
			ps.setString(6, dob);
			ps.setString(7, gender);
			ps.setString(8, mar);
			ps.setString(9, accno);
			ps.setString(10, "MAHB00001" + ifscno);
			ps.setString(11, branch);
			ps.setInt(12, 0);
			ps.setString(13, uname);
			ps.setString(14, pass);
			
			ps.executeUpdate();
			flag = "success";
		} catch (Exception e) {
			flag = "fail";
			e.printStackTrace();
			System.out.println(e);
		} finally {
			return flag;
		}
	}
	
	public static String checkAccount(String uname, String pass) {
		String flag = "";
		try {
			String sql = "select * from user_info";
			Statement st = ConnectionFactory.getcon().createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getString("username").equals(uname) && rs.getString("password").equals(pass)) {
					flag = "success";
					break;
				} else {
					flag = "fail";
				}
			}
		} catch (Exception e) {
			flag = "fail";
			e.printStackTrace();
		} finally {
			return flag;
		}
	}
	
	public static int checkBalance(String username) {
		int bal = 0;
		try {
			String sql = "select * from user_info";
			Statement st = ConnectionFactory.getcon().createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getString("username").equals(username)) {
					bal = rs.getInt("balance");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return bal;
		}
	}
	
	public static String depositAmount(String username, int amount) {
		String flag = "";
		try {
			String sql = "update user_info set balance = balance + ? where username = ?";
			PreparedStatement ps = ConnectionFactory.getcon().prepareStatement(sql);
			
			ps.setInt(1, amount);
			ps.setString(2, username);
			
			ps.executeUpdate();
			flag = "success";
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			return flag;
		}
	}
	
	public static String withdrawAmount(String username, int amount) {
		String flag = "";
		int balance = 0;
		try {			
			if(new AccountDao().checkBalance(username) >= amount) {
				String sql = "update user_info set balance = balance - ? where username = ?";
				PreparedStatement ps = ConnectionFactory.getcon().prepareStatement(sql);
				
				ps.setInt(1, amount);
				ps.setString(2, username);
				
				ps.executeUpdate();
				flag = "success";
			} else {
				flag = "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return flag;
		}
	}
	
	public static String transferAmount(String sender, String reciever, int amount) {
		String flag = "";
		try {
			if(new AccountDao().checkBalance(sender) >= amount) {
				String sql1 = "update user_info set balance = balance - ? where username = ?";
				PreparedStatement ps1 = ConnectionFactory.getcon().prepareStatement(sql1);
				
				ps1.setInt(1, amount);
				ps1.setString(2, sender);
				ps1.executeUpdate();
				
				String sql2 = "update user_info set balance = balance + ? where acc_no = ?";
				PreparedStatement ps2 = ConnectionFactory.getcon().prepareStatement(sql2);
				
				ps2.setInt(1, amount);
				ps2.setString(2, reciever);
				ps2.executeUpdate();
				flag = "success";
			} else {
				flag = "fail";
			}
		} catch (Exception e) {
			flag = "fail";
			e.printStackTrace();
		} finally {
			return flag;
		}
	}
	
	public static ArrayList<Account> readAccountDetails(String username) {
		try {
			String sql = "select * from user_info where username = ?";
			PreparedStatement ps = ConnectionFactory.getcon().prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account a = new Account();
				a.setFname(rs.getString(1));
				a.setLname(rs.getString(2));
				a.setPhone(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setAddress(rs.getString(5));
				a.setDob(rs.getString(6));
				a.setGender(rs.getString(7));
				a.setMar(rs.getString(8));
				a.setAccno(rs.getString(9));
				a.setIfsc(rs.getString(10));
				a.setBranch(rs.getString(11));
				
				al.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			return al;
		}
	}
}
