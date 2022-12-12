package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.Product;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> getAll() {//lấy danh sách các sản phẩm
		List<Product> list = new ArrayList<Product>();
		// khai báo chuỗi truy vấn
		String sql = "select * from Product";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10),rs.getString(11), rs.getInt(12),
						rs.getInt(13), rs.getBoolean(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
			}
		} catch (Exception e) {
			return null;
		}
		return list;

	}

	public List<Product> getTop4Product() {
		List<Product> list = new ArrayList<Product>();
		// khai báo chuỗi truy vấn
		String sql = "select TOP 4 * from Product order by sold DESC";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10),rs.getString(11), rs.getInt(12),
						rs.getInt(13), rs.getBoolean(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	public Product getTop1Product() {
		// khai báo chuỗi truy vấn
		String sql = "select TOP 1 * from Product order by sold DESC";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				return (new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10),rs.getString(11), rs.getInt(12),
						rs.getInt(13), rs.getBoolean(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Product> getLast4Product() {
		List<Product> list = new ArrayList<Product>();
		// khai báo chuỗi truy vấn
		String sql = "SELECT TOP 4 * from Product order by _id DESC";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10),rs.getString(11), rs.getInt(12),
						rs.getInt(13), rs.getBoolean(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	public List<Product> getAllProductByIdC(String cid) {
		List<Product> list = new ArrayList<Product>();
		// khai báo chuỗi truy vấn
		String sql = "select * from Product where categoryId = ?";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10),rs.getString(11), rs.getInt(12),
						rs.getInt(13), rs.getBoolean(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Product getProByIdPro(String pid) {
		// khai báo chuỗi truy vấn
		String sql = "select * from Product where _id = ?";
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
				return (new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10),rs.getString(11), rs.getInt(12),
						rs.getInt(13), rs.getBoolean(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public int insertProduct(Product product) //Insert user và kiểm tra có thành công hay không
	{
		int check = 0;
		try {
			//insert into Product ([name],[description],price,sold,categoryId,quantity) values('Bút chì Muji','Bút chính hãng','15000','0',1,50)
			String query = "insert into Product ([name],[description],price,sold,categoryId,quantity,isDeleted) values(?,?,?,?,?,?,?)";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setFloat(3, product.getPrice());
			ps.setInt(4, 0);
			ps.setInt(5, product.getCategoryId());
			ps.setInt(6, 50);
			ps.setByte(7, (byte) 0);
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
			return 0;
		}
	}

	public int updateProduct(Product product) //cập nhật sản phẩm và kiểm tra xem có thành công hay không
	{
		int check = 0;
		try {
			//update Product set [name] = 'Bút chì Mây', description = 'Chất lượng tuyệt vời', price=15000, categoryId=1 where _id=1
			String query = "update Product set [name] = ?, description = ?, price=?, categoryId=?, isDeleted = ? where _id=?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setFloat(3, product.getPrice());
			ps.setInt(4, product.getCategoryId());
			ps.setBoolean(5,product.getIsDeleted());
			ps.setInt(6, product.get_id());
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
			return 0;
		}
	}
	public int deleteProduct(int pid) { //xóa một sản phẩm theo id và kiểm tra xem đã thành công hay chưa
		int check = 0;
		try {
			ReviewDAO reviewDAO = new ReviewDAO();
			check = reviewDAO.deleteReview(pid);
			//update Product set isDeleted = 1 where _id=1
			String query = "update Product set isDeleted = 1 where _id=?"; //isDelted = 1: không bán mặt hàng đó nữa, 0: còn bán
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
	public static void main(String[] args) { //hàm check
		ProductDAO pDAO =new ProductDAO();
		List<Product> check = pDAO.getAll();
		System.out.print(check.get(1));
	}


}
