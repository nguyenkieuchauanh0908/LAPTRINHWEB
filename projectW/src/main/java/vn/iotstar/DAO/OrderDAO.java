package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.Order;
import java.sql.Date;
import vn.iotstar.model.User;

public class OrderDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// public List<Order> getAll() { // lấy danh sách tất cả đơn hàng
	// 								// Khai bao List de luu danh sách đơn hàng
	// 	List<Order> list = new ArrayList<Order>();
	// 	// khai bao chuoi truy van
	// 	String sql = "SELECT * FROM _Order";
	// 	try {
	// 		// mo ket noi DB
	// 		conn = new DBconnect().getConnection();
	// 		// nem cau querry qua SQL
	// 		ps = conn.prepareStatement(sql);
	// 		// chay querry va nhan ket qua
	// 		rs = ps.executeQuery();
	// 		// lay tu resultset do vao list
	// 		while (rs.next()) {
	// 			list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
	// 					rs.getString(6), rs.getInt(7), rs.getString(8), rs.getByte(9), rs.getInt(10), rs.getInt(11),
	// 					rs.getInt(12), rs.getDate(13), rs.getDate(14)));

	// 		}
	// 	} catch (Exception e) {
	// 		// TODO: handle exception
	// 	}
	// 	return list;
	// }

	public void insert(String userId, String address, String phone) {
		String sql = "insert into _Order (userId,address, phone,status,createdAt,updatedAT) values (?,?,?,N'Cần xử lí',getdate(),DATEADD(day , 3, getdate()))";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, address);
			ps.setString(3, phone);
			// chay querry va nhan ket qua
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int getIDMaxbyUser(String uid) {
		String sql = "select max(_id) from _Order where userId = ?";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public List<Order> getAllOrderbyUserId(String uid){
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from _Order where userId = ? order by _id DESC";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.set_id(rs.getInt("_id"));
				
				order.setUserId(rs.getInt("userId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getInt("phone"));
				order.setStatus(rs.getString("status"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAT"));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static void main(String[] args) {
		OrderDAO dao = new OrderDAO();
		// int check = user1.checkSignup("Nguyen","Kieu Thanh
		// Thi","nguyenkieuchauanh0908@gmail.com","0966732750","123 Le Thi Hong, Ho Chi
		// Minh","123456");
//		Cart u_id = dao.SearchByUserId("1");
//		System.out.println(u_id.get_id());
		
		//dao.insert("11", "1", "1");
		//List<Order> orders = dao.getAllOrderbyUserId("11");
//		for(Order o: orders) {
//			System.out.println(o);
//		}
		
	}
//}

	public List<Order> findOrderstoStatus(String status) {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		String sql = "SELECT *FROM _Order INNER JOIN _User ON _Order.userId = _User._id where status = ? ";
		try {
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Order order = new Order();
				User user = new User();
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setAddresses(rs.getString("addresses"));
				order.set_id(rs.getInt("_id"));
				order.setStoreId(rs.getInt("storeId"));
				order.setUserId(rs.getInt("userId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getInt("phone"));
				order.setStatus(rs.getString("status"));
				order.setIsPaidBefore(rs.getByte("isPaidBefore"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAT"));
				order.setUser(user);
				orders.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return orders;

	}
	public Order findtoOid(int orderid) {
		Order order = new Order();
		String sql = "SELECT * FROM _Order where _id = ?";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order.set_id(rs.getInt("_id"));
				order.setStoreId(rs.getInt("storeId"));
				order.setUserId(rs.getInt("userId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getInt("phone"));
				order.setStatus(rs.getString("status"));
				order.setIsPaidBefore(rs.getByte("isPaidBefore"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;
	}

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

	public void update(Order order) {
		String sql = "Update _Order SET address = ?, phone = ?, status = ?, isPaidBefore = ?, updatedAt = ? where _id = ?";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, order.getDeliveryId());
			ps.setString(1, order.getAddress());
			ps.setInt(2, order.getPhone());
			ps.setString(3, order.getStatus());
			ps.setByte(4, order.getIsPaidBefore());
			ps.setDate(5, (Date) order.getUpdatedAt());
			ps.setInt(6, order.get_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public List<Order> findAllPageToStatus(String status, int indexp) {
		
		List<Order> orders = new ArrayList<Order>();
		String sql = "SELECT *FROM _Order INNER JOIN _User ON _Order.userId = _User._id Where status = ? ORDER BY _Order._id DESC OFFSET ? rows fetch next 6 rows only"; 
		try {
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Order order = new Order();
				User user = new User();
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setAddresses(rs.getString("addresses"));
				order.set_id(rs.getInt("_id"));
				order.setStoreId(rs.getInt("storeId"));
				order.setUserId(rs.getInt("userId"));
				order.setDeliveryId(rs.getInt("deliveryId"));
				order.setCommissionId(rs.getInt("commissionId"));
				order.setAddress(rs.getString("address"));
				order.setPhone(rs.getInt("phone"));
				order.setStatus(rs.getString("status"));
				order.setIsPaidBefore(rs.getByte("isPaidBefore"));
				order.setAmountFromStore(rs.getInt("amountFromStore"));
				order.setAmountFromUser(rs.getInt("amountFromUser"));
				order.setAmountToGD(rs.getInt("amountToGD"));
				order.setAmountToStore(rs.getInt("amountToStore"));
				order.setCreatedAt(rs.getDate("createdAt"));
				order.setUpdatedAt(rs.getDate("updatedAT"));
				order.setUser(user);
				orders.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return orders;
	}
	

	public int countOrderToStatus(String status) {
		String sql = "select count(*) from _Order where status = ?";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}
}