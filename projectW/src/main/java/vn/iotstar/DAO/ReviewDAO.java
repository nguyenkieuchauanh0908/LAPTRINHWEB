package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.Review;
import vn.iotstar.model.User;

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
	public void insert(String uid, String pid, String content, String star) {
		String query = "insert into Review (userId, productId, content, stars,createdAt) values (?,?,?,?,getDate())";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, uid);
			ps.setString(2, pid);
			ps.setString(3, content);
			ps.setString(4, star);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Review> getAllReviewbyPro(String pid){
		List<Review> list = new ArrayList<Review>();
		String sql = "select * from Review full join _User on Review.userId = _User._id where productId = ?";
		try {  
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				Review review = new Review();
				review.set_id(rs.getInt("_id"));
				review.setContent(rs.getString("content"));
				review.setStars(rs.getInt("stars"));
				review.setCreatedAt(rs.getDate("createdAt"));
				User user = new User();
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				review.setUser(user);
				list.add(review);
			}
		} catch (Exception e) {
			return null;
		}
		return list;
	}
	public static void main(String[] args) { //hàm check
		ReviewDAO DAO =  new ReviewDAO();
		List<Review> check = DAO.getAllReviewbyPro("1");
		//int check = pDAO.countAllPro();
		//System.out.print(check);
		for(Review p: check)
		{
			System.out.print(p);
			System.out.print("\n");
		}
		//DAO.insert("11", "1", "good", "3");
	}
}
