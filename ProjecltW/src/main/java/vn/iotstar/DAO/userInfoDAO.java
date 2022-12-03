package vn.iotstar.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.lang3.RandomStringUtils;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.user;

public class userInfoDAO 
{
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static String new_pass = null;

	public user checkLogin(String user, String pass) 
	{
		try 
		{
			String query = "Select * from [User] where UserName = ? and Password = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next())
			{
				user a = new user(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getByte(10)
						);
				return a;
				//Nếu a null tức là người dùng đã nhập sai, query chạy không ra
				//Nếu a không null tức là người dùng nhập đúng, query chạy ra kết quả
			}
					
		} 
		catch (Exception e) 
		{
			
		}
		return null;
	}
	public int checkSignup(String fname,String lname,String email,String contact,String address,String username,String password) 
	{
		int result = 0;
		try 
		{
			//Insert into [User] values('thienquoc','123456','Nguyen','Binh Thien Quoc', 'Dong Nai','quoc@gmail.com','1243532459','',2)
			String query = "Insert into [User] values(?,?,?,?,?,?,?,?,?)";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, address);
			ps.setString(6,email);
			ps.setString(7, contact);
			ps.setString(8, "NULL");
			ps.setInt(9, 2);
			//rs = ps.executeQuery();
			result = ps.executeUpdate();
			if (result !=  0)
			{
				return 1;
			}
			else
			{

				return 0;
			}			
		} 
		catch (Exception e) 
		{
			return 0;
		}
	
	}
	public int findByEmail (String email) //Tìm người dùng ứng với email nhập vào
	{
		//email ="nguyenkieuchauanh0908@gmail.com";
		int result = 0;
		try 
		{
			//select * from [user] where Email = 'nguyenkieuchauanh0908@gmail.com' and [Role]=0
			String query = "select * from [user] where Email = ? and [Role]=?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setInt(2, 0);
			rs = ps.executeQuery();
			while (rs.next())
			{
				result = rs.getInt(1);
				user a = new user(rs.getInt(1), rs.getString(2),
				rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
				rs.getString(7), rs.getString(8), rs.getString(9), rs.getByte(10) ); 
				return result;
			}
		} 
		catch (Exception e) 
		{
			return -1;
		}
		return result;
		
	}
	public String resetCustomerPassword(String email) 
	{
		/*
		 * user user_reset_pass = userInfoDAO.findByEmail(email);
		 * 
		 * userInfoDAO user = new userInfoDAO(); user user_reset_pass = new user();
		 * user_reset_pass = userInfoDAO.findByEmail();
		 * 
		 * int u_id = user_reset_pass.getUserid();
		 */
	    String randomPassword = RandomStringUtils.randomAlphanumeric(10);
	    //userInfoDAO.update(randomPassword,u_id);
	    return randomPassword;
	}
	public void update(String randomPassword,int u_id) 
	{
		try 
		{
			String query = "update [User] set Password= ? where UserId = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, randomPassword);
			ps.setInt(2, u_id);
			rs = ps.executeQuery();
		} 
		catch (Exception e) 
		{
		}
		
	}
	
	/*
	 * public static void main(String[] args) { userInfoDAO user1 = new
	 * userInfoDAO(); user user_reset_pass = new user(); user_reset_pass =
	 * user1.findByEmail("nguyenkieuchauanh0908@gmail.com");
	 * System.out.println(user_reset_pass.getUserid()); }
	 */
	 
}

	
