package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.category;
import vn.iotstar.model.inventory;

public class inventoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public inventory getInvenByIdPro(String pid) {
		// Khai bao List de luu danh sach sp
		inventory inven = new inventory();
		// khai bao chuoi truy van
		String sql = "select * from Inventory where ProductId=?";
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
				return (new inventory(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getInt(4)));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inven;
	}
	public static void main (String[] args) {
		inventoryDAO dao = new inventoryDAO();
//        List<category> list = dao.getAll();
		inventory o = dao.getInvenByIdPro("1");
//        for (category o : list) {
//            System.out.println(o);
        //}
		System.out.println(o);
    }
}
