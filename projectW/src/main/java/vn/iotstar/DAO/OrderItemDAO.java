package vn.iotstar.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.OrderItem;
import vn.iotstar.model.Product;
public class OrderItemDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<OrderItem> search (int orderId) {
		List<OrderItem> ordersItems = new ArrayList<OrderItem>();
		String sql = "SELECT \r\n"
				+ "OrderItem._id,\r\n"
				+ " OrderItem.orderId,\r\n"
				+ " OrderItem.productId,\r\n"
				+ "OrderItem.count_SP,\r\n"
				+ " OrderItem.createdAt,\r\n "
				+ "OrderItem.updatedAT,\r\n "
				+ "Product._id,\r\n"
				+ "Product.name,\r\n"
				+ "Product.description,\r\n"
				+ "Product.price,\r\n"
				+ "Product.promotionalPrice\r\n"
				+ " FROM OrderItem INNER JOIN Product ON OrderItem.productId= Product._id where orderId = ?";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductDAO productService = new ProductDAO();
				OrderItem orderItem = new OrderItem();
				Product product = new Product();
				product = productService.findById(rs.getInt("productId"));
				orderItem.set_id(rs.getInt("_id"));
				orderItem.setOrderId(rs.getInt("orderId"));
				orderItem.setProductId(rs.getInt("productId"));
				orderItem.setCount_SP(rs.getInt("count_SP"));
				orderItem.setCreatedAt(rs.getDate("createdAt"));
				orderItem.setUpdatedAt(rs.getDate("updatedAT"));
				orderItem.setProduct(product);
				ordersItems.add(orderItem);
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
			}
		return ordersItems;
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
}


