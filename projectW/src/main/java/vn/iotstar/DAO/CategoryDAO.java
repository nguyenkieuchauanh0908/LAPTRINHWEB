package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.Category;

public class CategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Category> getAll() { //lấy danh sách tất cả loại sản phẩm
		// Khai bao List de luu danh sach sp
		List<Category> list = new ArrayList<Category>();
		// khai bao chuoi truy van
		String sql = "SELECT * FROM Category";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getByte(6), rs.getDate(7), rs.getDate(8)));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Category getCateByIdC(String cid) { //lấy loại sản phẩm theo id
		// Khai bao List de luu danh sach sp
		Category cate = new Category();
		// khai bao chuoi truy van
		String sql = "select * from Category where _id = ?";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
				return (new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getByte(6), rs.getDate(7), rs.getDate(8)));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cate;

	}
	public Category getCateByIdPro(String pid) { //lấy loại sản phẩm dựa vào id của sản phẩm
		// Khai bao List de luu danh sach sp
		Category cate = new Category();
		// khai bao chuoi truy van
		String sql = "select Category.* from Category, Product where Product.categoryId=Category._id and Product._id = ?";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
				return (new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getByte(6), rs.getDate(7), rs.getDate(8)));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cate;

	}

	public int insertCategory(Category cate) { //Insert category và kiểm tra xem thực thi có thành công hay không
		int check = 0;
		try {
			//Insert into Category (_name) values ('Giáo trình')
			String query = "Insert into Category (_name) values (?)";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cate.get_name());
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
	public static void main(String[] args) { //hàm check
		CategoryDAO cateDAO = new CategoryDAO();
		Category cate = new Category();
		cate.set_name("Dụng cụ học tập");
		int check = cateDAO.insertCategory(cate);
		System.out.print(check);
	}

	public int updateCategory(Category cate) {//Cập nhật thông tin loại sản phẩm 
		int check = 0;
		try {
			//update Category set _name = 'Bút chì' where _id=1
			String query = "update Category set _name = ? where _id = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cate.get_name());
			ps.setInt(2, cate.get_id());
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
	
	public Category findOne(int _id) {
		// TODO Auto-generated method stub
		Category category = new Category();
		String sql = "SELECT * FROM Category where _id = ?";
		try {
			// mo ket noi DB
			conn = new DBconnect().getConnection();
			// nem cau querry qua SQL
			ps = conn.prepareStatement(sql);
			ps.setInt(1, _id);
			// chay querry va nhan ket qua
			rs = ps.executeQuery();
			// lay tu resultset do vao list
			while (rs.next()) {
				return (new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getByte(6), rs.getDate(7), rs.getDate(8)));

			}
		}
		catch (Exception e) {
			e.printStackTrace();
			}
		return category;
	}
}
