package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.Category;
import vn.iotstar.model.Product;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> getAll() {
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getByte(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
			}
		} catch (Exception e) {
			// TODO: handle exception
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getByte(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getByte(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getByte(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getByte(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getString(11),
						rs.getInt(12), rs.getInt(13), rs.getByte(14), rs.getInt(15), rs.getDate(16), rs.getDate(17)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Product findById(int _id) {
		Product product = new Product();
		String sql = "Select Product._id,\r\n" + "Product.name,\r\n" + "Product.description,\r\n" + "Product.price,\r\n"
				+ "Product.promotionalPrice,\r\n" + "Product.quantity,\r\n" + "Product.sold,\r\n" + "Product.image,\r\n"
				+ "Product.isActive,\r\n" + "Product.createdAt,\r\n " + "Product.updatedAt,\r\n "
				+ "Category._id as cate_Id\r\n " + "				from Product\r\n"
				+ "				INNER JOIN Category ON Category._id = Product.categoryId\r\n"
				+ "				where Product._id = ?";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, _id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CategoryDAO CategoryService = new CategoryDAO();
				Category category = CategoryService.findOne(rs.getInt("cate_Id"));
				// Style style = StyleService.findOne(rs.getInt("style_Id"));
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setImage(rs.getNString("image"));
				product.setIsActive(rs.getByte("isActive"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setCategory(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public Product findOne(int id) {
		Product product = new Product();
		String sql = "SELECT * FROM Product WHERE _id = ?";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDAO CategoryService = new CategoryDAO();
				Category category = CategoryService.findOne(rs.getInt("cate_Id"));
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setImage(rs.getNString("image"));
				product.setIsActive(rs.getByte("isActive"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setCategory(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public void delete(int id) {
		String sql = "DELETE FROM Product WHERE _id = ?";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				CategoryDAO CategoryService = new CategoryDAO();
				Category category = CategoryService.findOne(rs.getInt("cate_Id"));
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setImage(rs.getNString("image"));
				product.setIsActive(rs.getByte("isActive"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setCategory(category);

				products.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public int countAll() {
		String sql = "select count(*) from Product";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	public List<Product> findAllPage(int indexp) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "Select Product._id,\r\n" + "Product.name,\r\n" + "Product.description,\r\n" + "Product.price,\r\n"
				+ "Product.promotionalPrice,\r\n" + "Product.quantity,\r\n" + "Product.sold,\r\n" + "Product.image,\r\n"
				+ "Product.isActive,\r\n" + "Product.createdAt,\r\n " + "Product.updatedAt,\r\n "
				+ "Category._id as cate_Id\r\n " + "				from Product\r\n"
				+ "				INNER JOIN Category ON Category._id = Product.categoryId\r\n"
				+ "ORDER BY _id DESC OFFSET ? rows fetch next 8 rows only";

		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, indexp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryDAO CategoryService = new CategoryDAO();
				Category category = CategoryService.findOne(rs.getInt("cate_Id"));
				Product product = new Product();
				product.set_id(rs.getInt("_id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setPromotionalPrice(rs.getFloat("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setImage(rs.getNString("image"));
				product.setIsActive(rs.getByte("isActive"));
				product.setUpdatedAt(rs.getDate("updatedAt"));
				product.setCreatedAt(rs.getDate("createdAt"));
				product.setCategory(category);

				productList.add(product);

				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	public void update(Product product) {
		String sql = "Update product SET name=?, description=?, price=?, promotionalPrice=?, quantity=?, sold=?, image=?, createdAt=? where _id = ?";
		try {
			conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setFloat(3, product.getPrice());
			ps.setFloat(4, product.getPromotionalPrice());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getSold());
			ps.setString(7, product.getImage());
			ps.setDate(8, (Date) product.getUpdatedAt());
			ps.setInt(9, product.get_id());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
