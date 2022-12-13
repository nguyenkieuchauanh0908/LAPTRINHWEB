package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.Order;

public class OrderDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Order> getAll() 
	{ //lấy danh sách tất cả đơn hàng
		// Khai bao List de luu danh sách đơn hàng
		List<Order> list = new ArrayList<Order>();
		// khai bao chuoi truy van
		String sql = "SELECT * FROM _Order";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
				list.add(new Order(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getInt(5),
						rs.getString(6), 
						rs.getInt(7), 
						rs.getString(8),
						rs.getByte(9),
						rs.getInt(10),
						rs.getInt(11),
						rs.getInt(12),
						rs.getDate(13),
						rs.getDate(14)));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
