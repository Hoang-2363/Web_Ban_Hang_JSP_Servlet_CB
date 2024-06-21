package page.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.model.Khach_Hang;

public class DAO_Khach_Hang extends ConnectDB {

	// Kiểm tra mật khẩu tài khoản
	public Khach_Hang dang_nhap(String tai_khoan, String mat_khau) {
		String sql = "SELECT KH_ADMIN.MA_KH, TEN_KH, ANH, SDT, DIA_CHI, TAI_KHOAN, MAT_KHAU "
				+ "FROM KHACH_HANG INNER JOIN KH_ADMIN ON KHACH_HANG.MA_KH = KH_ADMIN.MA_KH "
				+ "WHERE TAI_KHOAN = ? AND MAT_KHAU = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, tai_khoan);
			st.setString(2, mat_khau);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Khach_Hang kh = new Khach_Hang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
				return kh;
			}
		} catch (Exception e) {
		}
		return null;
	}

	// In số điện thoại
	public String sdt(String sdt) {
		String sql = "SELECT SDT FROM KHACH_HANG WHERE SDT = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, sdt);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// In họ tên khách hàng
	public String ho_ten_KH(String ten_kh, String sdt, String tai_khoan) {
		String sql = "SELECT TEN_KH FROM KHACH_HANG INNER JOIN KH_ADMIN ON KHACH_HANG.MA_KH = KH_ADMIN.MA_KH "
				+ "WHERE TEN_KH = ? AND SDT = ? OR TAI_KHOAN = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ten_kh);
			st.setString(2, sdt);
			st.setString(3, tai_khoan);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// In tên tài khoản
	public String ten_TK(String ten_kh, String sdt, String tai_khoan) {
		String sql = "SELECT TAI_KHOAN FROM KHACH_HANG INNER JOIN KH_ADMIN ON KHACH_HANG.MA_KH = KH_ADMIN.MA_KH "
				+ "WHERE TEN_KH = ? AND SDT = ? AND TAI_KHOAN = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ten_kh);
			st.setString(2, sdt);
			st.setString(3, tai_khoan);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Thêm tài khoản khách hàng
	public void them_tk_kh(String ten_kh, String sdt, String dia_chi, String tai_khoan, String mat_khau) {
		String sql1 = "INSERT INTO KHACH_HANG(TEN_KH, ANH, SDT, DIA_CHI) VALUES (?, '', ?, ?)";
		try {
			PreparedStatement st1 = connection.prepareStatement(sql1);
			st1.setString(1, ten_kh);
			st1.setString(2, sdt);
			st1.setString(3, dia_chi);
			st1.executeUpdate();

			// Lấy Mã khách hàng vừa thêm
			String sql2 = "SELECT MA_KH FROM KHACH_HANG WHERE TEN_KH = ? AND SDT = ? AND DIA_CHI = ?";
			try {
				PreparedStatement st2 = connection.prepareStatement(sql2);
				st2.setString(1, ten_kh);
				st2.setString(2, sdt);
				st2.setString(3, dia_chi);
				ResultSet rs = st2.executeQuery();
				if (rs.next()) {
					String ma_kh = rs.getString(1);
					String sql3 = "INSERT INTO KH_ADMIN VALUES (?, ?, ?)";
					try {
						PreparedStatement st3 = connection.prepareStatement(sql3);
						st3.setString(1, tai_khoan);
						st3.setString(2, mat_khau);
						st3.setString(3, ma_kh);
						st3.executeUpdate();
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Đổi mật khẩu
	public void doi_mk(String ten_kh, String sdt, String tai_khoan, String mat_khau) {
		String sql = "SELECT MA_KH FROM KHACH_HANG WHERE SDT = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, sdt);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String ma_kh = rs.getString(1);
				String sql2 = "UPDATE KH_ADMIN INNER JOIN KHACH_HANG ON KH_ADMIN.MA_KH = KHACH_HANG.MA_KH SET KH_ADMIN.MAT_KHAU = ? "
						+ "WHERE KH_ADMIN.MA_KH = ? AND KH_ADMIN.TAI_KHOAN = ? AND KHACH_HANG.TEN_KH = ? AND KHACH_HANG.SDT = ?;";
				try {
					PreparedStatement st2 = connection.prepareStatement(sql2);
					st2.setString(1, mat_khau);
					st2.setString(2, ma_kh);
					st2.setString(3, tai_khoan);
					st2.setString(4, ten_kh);
					st2.setString(5, sdt);
					st2.executeUpdate();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Cập nhật tài khoản
	public void cap_nhat(String ten_kh, String sdt, String anh, String dia_chi, String tai_khoan, String mat_khau,
			int ma_kh) {
		String sql = "UPDATE KH_ADMIN INNER JOIN KHACH_HANG ON KH_ADMIN.MA_KH = KHACH_HANG.MA_KH "
				+ "SET KH_ADMIN.TAI_KHOAN = ?, KH_ADMIN.MAT_KHAU = ?, KHACH_HANG.TEN_KH = ?, "
				+ "KHACH_HANG.SDT = ?, KHACH_HANG.ANH = ?, KHACH_HANG.DIA_CHI = ? WHERE KH_ADMIN.MA_KH = ?;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, tai_khoan);
			st.setString(2, mat_khau);
			st.setString(3, ten_kh);
			st.setString(4, sdt);
			st.setString(5, anh);
			st.setString(6, dia_chi);
			st.setInt(7, ma_kh);
			st.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// In danh sách phản hồi
	public List<Khach_Hang> select_PH() {
		List<Khach_Hang> list = new ArrayList<>();
		String sql = "SELECT KHACH_HANG.TEN_KH, KHACH_HANG.ANH, KHACH_HANG.SDT, TIN_NHAN, DATE_FORMAT(THOI_GIAN, '%H:%i:%s %d/%m/%Y') AS THOI_GIAN "
				+ "FROM PHAN_HOI_KH INNER JOIN KHACH_HANG ON PHAN_HOI_KH.MA_KH = KHACH_HANG.MA_KH;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Khach_Hang nv = new Khach_Hang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Thêm phản hồi khách hàng
	public void them_PH(String sdt, String tin_nhan) {
		String sql = "SELECT MA_KH FROM KHACH_HANG WHERE SDT = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, sdt);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String ma_kh = rs.getString(1);
				String sql3 = "INSERT INTO PHAN_HOI_KH VALUES (?, NOW(), ?)";
				try {
					PreparedStatement st3 = connection.prepareStatement(sql3);
					st3.setString(1, tin_nhan);
					st3.setString(2, ma_kh);
					st3.executeUpdate();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
