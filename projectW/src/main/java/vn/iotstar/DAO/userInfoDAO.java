package vn.iotstar.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.lang3.RandomStringUtils;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.User;

public class userInfoDAO {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static String new_pass = null;
	public User checkLogin(String email, String pass) 
	{
		User a = null;
		try 
		{
			//select * from [_User] where email = '20110234@student.hcmute.edu.vn' and hashed_password = 'chauanh123'
			String query = "Select * from [_User] where email = ? and hashed_password = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			  while (rs.next()) 
			  { 
				  a = new User( 
					  rs.getInt(1), 
					  rs.getString(2),
					  rs.getString(3), 
					  rs.getString(4), 
					  rs.getString(5), 
					  rs.getString(6),
					  rs.getString(7), 
					  rs.getByte(8), 
					  rs.getByte(9), 
					  rs.getString(10),
					  rs.getString(11), 
					  rs.getString(12), 
					  rs.getString(13), 
					  rs.getString(14),
					  rs.getString(15), 
					  rs.getInt(16), 
					  rs.getFloat(17), 
					  rs.getDate(18),
					  rs.getDate(19) ); 
				  	  return a;
			  //Nếu a null tức là ngưòi dùng đã nhập sai, query chạy không ra 
			  //Nếu a không null tức là người dùng nhập đúng, query chạy ra kết quả
			  }
			 
			
		} 
		catch (Exception e) 
		{
			
		}
		return a;
	}
	public int checkSignup(String fname, String lname, String email, String phone, String address,String password) 
	{
		int check = 0;
		try 
		{
			//insert into [_User](firstname,lastname, email, phone, hashed_password, _role,addresses) values('Nguyen','Kieu Chau Anh','20110234@student.hcmute.edu.vn','0913935810','chauanh123',1,'123 Le Thi Hong, Ho Chi Minh')
			String query = "insert into [_User](firstname,lastname, email, phone, hashed_password, _role,addresses) values(?,?,?,?,?,?,?)";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			//rs = ps.executeQuery();
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5,password);
			ps.setInt(6, 1);
			ps.setString(7,address);
			check = ps.executeUpdate();
			if (check !=  0) //Nếu thực thi query thành công thì trả về check = 1
			{
				return 1; 
			}
			else //Nếu thất bại trả về check = 0
			{

				return 0;
			}			
		} 
		catch (Exception e) 
		{
			return 0;
		}
	
	}
	public int findByEmail (String email) //Tìm id của người dùng ứng với email nhập vào
	{
		int uId = 0;
		try 
		{
			//select * from [_User] where email = '20110234@student.hcmute.edu.vn' and [_role] = 1
			String query = "select * from [_User] where email = ? and [_role] = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setInt(2, 1);
			rs = ps.executeQuery();
			while (rs.next()) 
			  { 
				uId = rs.getInt(1);
				return uId;	  
			  
			  }
			
		} 
		catch (Exception e) 
		{
			return -1;
		}
		return uId;
	}
	public String resetCustomerPassword(String email) //tạo mật khẩu mới random
	{
	    String randomPassword = RandomStringUtils.randomAlphanumeric(10);
	    return randomPassword;
	}
	public void update(String randomPassword,int u_id) //cập nhật mật khẩu người dùng theo id
	{
		try 
		{
			//update [_User] set hashed_password= 'èakfakjfa' where _id = 13
			String query = "update [_User] set hashed_password= ? where _id = ?";
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
	
	
	  public static void main(String[] args) { 
		  userInfoDAO user1 = new userInfoDAO(); 
		  //int check = user1.checkSignup("Nguyen","Kieu Thanh Thi","nguyenkieuchauanh0908@gmail.com","0966732750","123 Le Thi Hong, Ho Chi Minh","123456");
		  int u_id = user1.findByEmail("20110234@student.hcmute.edu.vn");
		  System.out.println(u_id);
	  }
	  
	  
	  
	  
	  
	public User getUser(String i) {// t đổi sang string 
		 String query = "Select * from [_User] WHERE _id LIKE ?";

	        try {
	            conn = new DBconnect().getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setString(1, "%" + i + "%");
	            rs = ps.executeQuery();

	            while (rs.next()) {
	                return new User(
	                	  rs.getInt(1), 
	   					  rs.getString(2),
	   					  rs.getString(3), 
	   					  rs.getString(4), 
	   					  rs.getString(5), 
	   					  rs.getString(6),
	   					  rs.getString(7), 
	   					  rs.getByte(8), 
	   					  rs.getByte(9), 
	   					  rs.getString(10),
	   					  rs.getString(11), 
	   					  rs.getString(12), 
	   					  rs.getString(13), 
	   					  rs.getString(14),
	   					  rs.getString(15), 
	   					  rs.getInt(16), 
	   					  rs.getFloat(17), 
	   					  rs.getDate(18),
	   					  rs.getDate(19) ); 
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	        return null;
	    }
	 
	 
	 
}

	
