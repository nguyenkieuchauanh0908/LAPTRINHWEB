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

	public List<Category> getAll() {
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

	public Category getCateByIdC(String cid) {
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

	public Category getCateByIdPro(String pid) {
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
