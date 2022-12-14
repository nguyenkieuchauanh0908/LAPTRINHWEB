package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.Cart;
import vn.iotstar.model.Product;

public class CartDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Cart SearchByUserId(String uid) {
		Cart cart = new Cart();
		String sql = "select * from Cart where userId = ?";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				return (new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cart;
	}
	public void Insert(String uid) {
		String sql = "Insert into Cart (userId) values (?)";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			// chạy query và nhận kết quả
			ps.executeUpdate();
			// lấy ResultSet đổ vào list
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		CartDAO dao = new CartDAO();
		// int check = user1.checkSignup("Nguyen","Kieu Thanh
		// Thi","nguyenkieuchauanh0908@gmail.com","0966732750","123 Le Thi Hong, Ho Chi
		// Minh","123456");
//		Cart u_id = dao.SearchByUserId("1");
//		System.out.println(u_id.get_id());
		System.out.println(dao.SearchByUserId("1"));
	}
}
