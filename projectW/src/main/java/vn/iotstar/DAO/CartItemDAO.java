package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.CartItem;
import vn.iotstar.model.Product;

public class CartItemDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<CartItem> getAllCartItemByUserId(String uid) {
	
		List<CartItem> list = new ArrayList<CartItem>();
		CartDAO cartDAO = new CartDAO();
		if(cartDAO.SearchByUserId(uid)==null)
		{
			cartDAO.Insert(uid);
		}
		String cartId = String.valueOf(cartDAO.SearchByUserId(uid).get_id());
		String sql = " SELECT CartItem.*, Product.* FROM CartItem FULL JOIN Cart ON CartItem._id = Cart._id full JOIN Product ON CartItem.productId = Product._id where CartItem.cartId = ?";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, cartId);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {				
				Product product = new Product();
				product.set_id(rs.getInt("productId"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getFloat("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setImage(rs.getString("image"));
				CartItem cartItem = new CartItem();
				cartItem.set_id(rs.getInt("_id"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setCount_SP(rs.getInt("count_SP"));
				cartItem.setProduct(product);
				list.add(cartItem);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public void PlusQuantity(String pPro, String pCart) {
		String sql = "Update CartItem set count_SP = count_SP + 1 where productId = ? and cartId = ?";
		try {
			// update [_User] set hashed_password= 'èakfakjfa' where _id = 13 String query =
			// "update [_User] set hashed_password= ? where _id = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pPro);
			ps.setString(2, pCart);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public void MinusQuantity(String mPro, String mCart) {
		String sql = "Update CartItem set count_SP = count_SP - 1 where productId = ? and cartId = ?";
		try {
			// update [_User] set hashed_password= 'èakfakjfa' where _id = 13 String query =
			// "update [_User] set hashed_password= ? where _id = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mPro);
			ps.setString(2, mCart);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public int existItem(String uid, String pid) {
		int check = 0;
		List<CartItem> listItem = getAllCartItemByUserId(uid);
		CartDAO cartDAO = new CartDAO();
		String cartId = String.valueOf(cartDAO.SearchByUserId(uid).get_id());
		for (CartItem o : listItem) {
			if (o.getProduct().get_id() == Integer.parseInt(pid)) {
				PlusQuantity(pid, cartId);
				check = 1;
				return check;
			}
		}
		return check;
	}

	public void addItem(String uid, String pid) {
		CartDAO cartDAO = new CartDAO();
		String cartId = String.valueOf(cartDAO.SearchByUserId(uid).get_id());
		int check = existItem(uid, pid);
		if (check == 0) {
			String sql = "insert into CartItem(cartId, productId, count_SP) values (?,?,1)";
			try {
				// mở kết nối
				conn = new DBconnect().getConnection();
				// ném câu query qua sql
				ps = conn.prepareStatement(sql);
				ps.setString(1, cartId);
				ps.setString(2, pid);
				// chạy query và nhận kết quả
				ps.executeUpdate();
				// lấy ResultSet đổ vào list

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void addItemWithQuan(String uid, String pid, String quantity) {
		CartDAO cartDAO = new CartDAO();
		String cartId = String.valueOf(cartDAO.SearchByUserId(uid).get_id());
		int check = existItem(uid, pid);
		if (check == 0) {
			String sql = "insert into CartItem(cartId, productId, count_SP) values (?,?,?)";
			try {
				// mở kết nối
				conn = new DBconnect().getConnection();
				// ném câu query qua sql
				ps = conn.prepareStatement(sql);
				ps.setString(1, cartId);
				ps.setString(2, pid);
				ps.setString(3,quantity);
				// chạy query và nhận kết quả
				ps.executeUpdate();
				// lấy ResultSet đổ vào list

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void removeItem(String uid, String pid) {
		CartDAO cartDAO = new CartDAO();
		String cartId = String.valueOf(cartDAO.SearchByUserId(uid).get_id());
		String sql = "DELETE FROM CartItem WHERE CartItem.cartId=? and productId=?";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, cartId);
			ps.setString(2, pid);
			// chạy query và nhận kết quả
			ps.executeUpdate();
			// lấy ResultSet đổ vào list

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		CartItemDAO dao = new CartItemDAO();
		// int check = user1.checkSignup("Nguyen","Kieu Thanh
		// Thi","nguyenkieuchauanh0908@gmail.com","0966732750","123 Le Thi Hong, Ho Chi
		// Minh","123456");
//		List<CartItem> list = dao.getAllCartItemByUserId("1");
//		for (CartItem o : list) {
//			System.out.println(o.getProduct().get_id());
//		}
		int check = dao.existItem("1", "4");
		System.out.println(check);
	}
}
