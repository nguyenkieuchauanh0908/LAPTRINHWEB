package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.user;

public class userInfoDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public user getUser(int userId) {
		// khai báo chuỗi truy vấn
		String sql = "select * from [User] where UserID = ?";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				return (new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getByte(10)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public user checkLogin(String user, String pass) 
	{
		try 
		{
			String query = "Select * from [User] where UserName = ? and Password = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			ps.setString(1, user);
			ps.setString(2, pass);
			while (rs.next())
			{
				return (new user(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getByte(10)));
				//Nếu a null tức là người dùng đã nhập sai, query chạy không ra
				//Nếu a không null tức là người dùng nhập đúng, query chạy ra kết quả
			}
					
		} 
		catch (Exception e) 
		{
			
		}
		return null;
	}
	public static void main(String[] args)
	{
		userInfoDAO dao = new userInfoDAO();
		user o = dao.checkLogin("chauanh", "123456");
		System.out.println(o);
	}
}
