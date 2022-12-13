package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import vn.iotstar.connection.DBconnect;
import vn.iotstar.model.User;

public class UserDAO {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static String new_pass = null;

	public User getUser(String userId) { //lấy thông tin của user theo ID nhận vào
		// khai báo chuỗi truy vấn
		String sql = "select * from [_User] where _id = ?";
		try {
			// mở kết nối
			conn = new DBconnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy ResultSet đổ vào list
			while (rs.next()) {
				return (new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getByte(8), rs.getByte(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getInt(16), rs.getFloat(17), rs.getDate(18), rs.getDate(19)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public User checkLogin(String email, String pass) {//kiểm tra mật khẩu và password có đúng không
		User a = null;
		try {
			// select * from [_User] where email = '20110234@student.hcmute.edu.vn' and
			// hashed_password = 'chauanh123'
			String query = "Select * from [_User] where email = ? and hashed_password = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				a = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getByte(8), rs.getByte(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getInt(16), rs.getFloat(17), rs.getDate(18), rs.getDate(19));
				return a;
				// Nếu a null tức là ngưòi dùng đã nhập sai, query chạy không ra
				// Nếu a không null tức là người dùng nhập đúng, query chạy ra kết quả
			}

		} catch (Exception e) {

		}
		return a;
	}

	public int checkSignup(String email, String password) { //kiểm tra đăng kí có thành công hay không
		int check = 0;
		try {
			// insert into [_User](firstname,lastname, email, phone, hashed_password,
			// _role,addresses) values('Nguyen','Kieu Chau
			// Anh','20110234@student.hcmute.edu.vn','0913935810','chauanh123',1,'123 Le Thi
			// Hong, Ho Chi Minh')
			String query = "insert into [_User](email, hashed_password, _role) values(?,?,?)";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			// rs = ps.executeQuery();
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setInt(3, 1);//Role:1 là khách hàng, chức năng đăng ký chỉ dành cho khách hàng, các role khác admin thêm thủ công
			check = ps.executeUpdate();
			if (check != 0) // Nếu thực thi query thành công thì trả về check = 1
			{
				return 1;
			} else // Nếu thất bại trả về check = 0
			{

				return 0;
			}
		} catch (Exception e) {
			return 0;
		}

	}

	public int findByEmail(String email) // Tìm id của người dùng ứng với email nhập vào
	{
		int uId = 0;
		try {
			// select * from [_User] where email = '20110234@student.hcmute.edu.vn' and
			// [_role] = 1
			String query = "select * from [_User] where email = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				uId = rs.getInt(1);
				return uId;

			}

		} catch (Exception e) {
			return -1;
		}
		return uId;
	}

	public String resetCustomerPassword(String email) // sinh mật khẩu mới ngẫu nhiên
	{
		String randomPassword = RandomStringUtils.randomAlphanumeric(10);
		return randomPassword;
	}

	public int updatePass(String randomPassword, int u_id) // cập nhật mật khẩu người dùng theo id
	{
		int check = 0; //Nếu thành công thì check = 1
		try {
			// update [_User] set hashed_password= 'èakfakjfa' where _id = 13
			String query = "update [_User] set hashed_password= ? where _id = ?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, randomPassword);
			ps.setInt(2, u_id);
			check = ps.executeUpdate();
			return check;
		} 
		catch (Exception e) {
			return check;
		}

	}
	public int checkUpdateInfo(String uid, String fname, String lname, String email, String phone, String addresses) //kiểm tra cập nhật thông tin khách hàng thành công hay không
	{
		int check = 0;
		try {
			// insert into [_User](firstname,lastname, email, phone, hashed_password,
			// _role,addresses) values('Nguyen','Kieu Chau
			// Anh','20110234@student.hcmute.edu.vn','0913935810','chauanh123',1,'123 Le Thi
			// Hong, Ho Chi Minh')
			String query = "update _User set firstname = ? , lastname = ?,email = ?, phone = ?, addresses = ? where _id = ? ";
			conn = new DBconnect().getConnection(); 
			ps = conn.prepareStatement(query);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, addresses);
			ps.setString(6, uid);
			check = ps.executeUpdate();
			if (check != 0) // Nếu thực thi query thành công thì trả về check = 1
			{
				return 1;
			} else // Nếu thất bại trả về check = 0
			{
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}

	}
	public List<User> getCustomer() {//lấy ra danh sách toàn bộ khách hàng (role=1)
		List<User> userList = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM _User where _role=1";
			conn = new DBconnect().getConnection(); 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.set_id(rs.getInt("_id"));
				user.setEmail(rs.getString("email"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setPhone(rs.getString("phone"));
				user.setHashed_password(rs.getString("hashed_password"));
				user.set_role(rs.getString("_role"));
				user.setAddresses(rs.getString("addresses"));
				userList.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	public int insertUser(User user) //Insert user và kiểm tra có thành công hay không
	{
		int check = 0;
		try {
			String query = "insert into [_User](firstname,lastname, email, phone, hashed_password, _role,addresses) values(?,?,?,?,?,?,?)";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			// rs = ps.executeQuery();
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getHashed_password());
			ps.setString(6, user.get_role());
			ps.setString(7, user.getAddresses());
			check = ps.executeUpdate();
			if (check != 0) // Nếu thực thi query thành công thì trả về check = 1
			{
				return 1;
			} else // Nếu thất bại trả về check = 0
			{

				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	
	public List<User> getEmployee() {//lấy ra danh sách toàn bộ nhân viên (role=2)
		List<User> userList = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM _User where _role=2";
			conn = new DBconnect().getConnection(); 
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.set_id(rs.getInt("_id"));
				user.setEmail(rs.getString("email"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setPhone(rs.getString("phone"));
				user.setHashed_password(rs.getString("hashed_password"));
				user.set_role(rs.getString("_role"));
				user.setAddresses(rs.getString("addresses"));
				userList.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	public int deleteEmployee(int uid) {//Xóa nhân viên theo id của nhân viên đó
		int check = 0;
		try {
			//delete from _User where _id=9 and _role=2
			String query = "delete from _User where _id=? and _role=?";
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(query);
			// rs = ps.executeQuery();
			ps.setInt(1, uid);
			ps.setInt(2, 2);
			check = ps.executeUpdate();
			if (check != 0) // Nếu thực thi query thành công thì trả về check = 1
			{
				return 1;
			} else // Nếu thất bại trả về check = 0
			{

				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	public static void main(String[] args) { //hàm check
		UserDAO uDAO = new UserDAO();
		int check = uDAO.deleteEmployee(9);
		System.out.print(check);
	}



}
