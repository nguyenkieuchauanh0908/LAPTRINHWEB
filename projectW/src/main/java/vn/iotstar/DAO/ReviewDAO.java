package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBconnect;

public class ReviewDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public int deleteReview(int pid) { 
		int check = 0;
		try {
			String query = "delete from Review where productId=?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, pid);
			check = ps.executeUpdate();
			if (check != 0) // Nếu thực thi query thành công thì trả về check = 1
			{
				return 1;
			} 
			else // Nếu thất bại trả về check = 0
			{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
