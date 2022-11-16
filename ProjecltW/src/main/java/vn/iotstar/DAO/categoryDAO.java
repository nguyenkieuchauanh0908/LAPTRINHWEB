package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.category;
import vn.iotstar.model.product;

public class categoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<category> getAll() {
		// Khai bao List de luu danh sach sp
		List<category> list = new ArrayList<category>();
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
				list.add(new category(rs.getInt(1), rs.getString(2)));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static void main(String[] args) {
		categoryDAO dao = new categoryDAO();
        List<category> list = dao.getAll();

        for (category o : list) {
            System.out.println(o);
        }
    }
}
