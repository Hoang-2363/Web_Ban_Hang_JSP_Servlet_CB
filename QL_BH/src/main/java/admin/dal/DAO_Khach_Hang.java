package admin.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.model.Khach_Hang;

public class DAO_Khach_Hang extends ConnectDB {
	// Select khách hàng
	public List<Khach_Hang> selec_KH() {
		List<Khach_Hang> list = new ArrayList<>();
		String sql = "SELECT * FROM KHACH_HANG;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Khach_Hang kh = new Khach_Hang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				list.add(kh);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select theo mã khách hàng
	public Khach_Hang getkhByMakh(int ma_kh) {
		String sql = "SELECT * FROM KHACH_HANG WHERE MA_KH = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_kh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Khach_Hang kh = new Khach_Hang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				return kh;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Select theo tên khách hàng, số điện thoại
	public Khach_Hang getkhByTenkh(String ten_kh, String sdt) {
		String sql = "SELECT * FROM KHACH_HANG WHERE TEN_KH = ? OR SDT = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ten_kh);
			st.setString(2, sdt);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Khach_Hang lhh = new Khach_Hang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				return lhh;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Sửa khách hàng
	public void sua_kh(Khach_Hang kh) {
		String sql = "UPDATE KHACH_HANG SET TEN_KH = ?, ANH = ?, SDT = ?, DIA_CHI = ? WHERE MA_KH = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, kh.getTen_kh());
			st.setString(2, kh.getAnh());
			st.setString(3, kh.getSdt());
			st.setString(4, kh.getDia_chi());
			st.setInt(5, kh.getMa_kh());

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Thêm khách hàng
	public void them_kh(String ten_kh, String anh, String sdt, String dia_chi) {
		String sql = "INSERT INTO KHACH_HANG(TEN_KH, ANH, SDT, DIA_CHI) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, ten_kh);
			st.setString(2, anh);
			st.setString(3, sdt);
			st.setString(4, dia_chi);

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Xóa khách hàng
	public void xoa_kh(int ma_kh) {
		String sql = "DELETE FROM KHACH_HANG WHERE MA_KH = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setInt(1, ma_kh);

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
