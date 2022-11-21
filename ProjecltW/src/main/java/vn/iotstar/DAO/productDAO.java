package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.product;

public class productDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<product> getAll() {
		List<product> list = new ArrayList<product>();
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
				list.add(new product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getDate(7), rs.getString(8),rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}
	public List<product> getTop4Product() {
		List<product> list = new ArrayList<product>();
		// khai báo chuỗi truy vấn
		String sql = "select TOP 4 * from Product order by Sold DESC";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getDate(7), rs.getString(8),rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	public product getTop1Product() {
		// khai báo chuỗi truy vấn
		String sql = "select TOP 1 * from Product order by Sold DESC";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				return (new product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getDate(7), rs.getString(8),rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public List<product> getLast4Product() {
		List<product> list = new ArrayList<product>();
		// khai báo chuỗi truy vấn
		String sql = "SELECT TOP 4 * from Product order by ProductId DESC";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				list.add(new product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getDate(7), rs.getString(8),rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	public List<product> getAllProductByIdC(String cid) {
		List<product> list = new ArrayList<product>();
		// khai báo chuỗi truy vấn
		String sql = "select * from Product where CategoryId = ?";
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
				list.add(new product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getDate(7), rs.getString(8),rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public product getProByIdPro(String pid) {
		// khai báo chuỗi truy vấn
		String sql = "select * from Product where ProductId = ?";
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
				return (new product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDouble(6), rs.getDate(7), rs.getString(8),rs.getInt(9)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public static void main(String[] args) {
		productDAO dao = new productDAO();
		List<product> list = dao.getAll();
		//product o = dao.getProByIdPro("1");
		for (product o : list) {
			System.out.println(o);
		}
	}
}
