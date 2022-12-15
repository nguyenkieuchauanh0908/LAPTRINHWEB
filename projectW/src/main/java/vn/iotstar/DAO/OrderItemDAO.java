package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.Order;
import vn.iotstar.model.OrderItem;
import vn.iotstar.model.Product;

public class OrderItemDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void insert(OrderItem ordersItem) {
		String sql = "INSERT INTO OrderItem (orderId, productId, count_SP) VALUES (?,?,?)";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ordersItem.get_id());
			ps.setInt(2, ordersItem.getProductId());
			ps.setInt(3, ordersItem.getCount_SP());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<OrderItem> getAllOrderItembyUserId(int oid) {
		List<OrderItem> list = new ArrayList<OrderItem>();
		String sql = "select * from OrderItem FULL JOIN Product ON OrderItem.productId = Product._id where orderId = ?";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.set_id(rs.getInt("productId"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getFloat("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setImage(rs.getString("image"));
				OrderItem orderItem = new OrderItem();
				orderItem.set_id(rs.getInt("_id"));
				orderItem.setOrderId(rs.getInt("orderId"));
				orderItem.setProductId(rs.getInt("productId"));
				orderItem.setCount_SP(rs.getInt("count_SP"));
				orderItem.setProduct(product);

				list.add(orderItem);
			}
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	public static void main(String[] args) {
		// int check = user1.checkSignup("Nguyen","Kieu Thanh
		// Thi","nguyenkieuchauanh0908@gmail.com","0966732750","123 Le Thi Hong, Ho Chi
		// Minh","123456");
//		Cart u_id = dao.SearchByUserId("1");
//		System.out.println(u_id.get_id());

		// dao.insert("11", "1", "1");
		OrderDAO orderDao=new OrderDAO();
		OrderItemDAO orderItemDao = new OrderItemDAO();
		List<Order> orders = orderDao.getAllOrderbyUserId("1");
		List<List<OrderItem>> listorderItems = new ArrayList<>();
		for(Order o: orders) {
			List<OrderItem> orderItems = orderItemDao.getAllOrderItembyUserId(o.get_id());
			listorderItems.add(orderItems);
			for(OrderItem oi: orderItems) {
				System.out.println(oi);
			}
				
		}

	}
}
