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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getInt(11),
						rs.getInt(12), rs.getByte(13), rs.getInt(14), rs.getDate(15), rs.getDate(16)));
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getInt(11),
						rs.getInt(12), rs.getByte(13), rs.getInt(14), rs.getDate(15), rs.getDate(16)));
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getInt(11),
						rs.getInt(12), rs.getByte(13), rs.getInt(14), rs.getDate(15), rs.getDate(16)));
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getInt(11),
						rs.getInt(12), rs.getByte(13), rs.getInt(14), rs.getDate(15), rs.getDate(16)));
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getInt(11),
						rs.getInt(12), rs.getByte(13), rs.getInt(14), rs.getDate(15), rs.getDate(16)));
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
						rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getByte(9), rs.getByte(10), rs.getInt(11),
						rs.getInt(12), rs.getByte(13), rs.getInt(14), rs.getDate(15), rs.getDate(16)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
