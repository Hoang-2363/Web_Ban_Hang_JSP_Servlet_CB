package admin.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.model.Loai_HH;

public class DAO_Loai_HH extends ConnectDB {
	// Select loại hàng hóa
	public List<Loai_HH> selec_Loai_HH() {
		List<Loai_HH> list = new ArrayList<>();
		String sql = "SELECT * FROM LOAI_HH";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Loai_HH nv = new Loai_HH(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select tên loại hàng hóa
	public List<String> select_LHH() {
		List<String> list = new ArrayList<>();
		String sql = "SELECT TEN_LOAI_HANG FROM LOAI_HH";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String ten_lhh = rs.getString(1);
				list.add(ten_lhh);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Tìm kiếm mã loại hh theo tên loại hàng hóa
	public String select_ma_lhh(String ten_lhh) {
		String sql = "SELECT MA_LOAI_HANG FROM LOAI_HH WHERE TEN_LOAI_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ten_lhh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Select theo mã LHH
	public Loai_HH getLHHByMaLHH(int ma_lhh) {
		String sql = "SELECT * FROM LOAI_HH WHERE MA_LOAI_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_lhh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Loai_HH lhh = new Loai_HH(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return lhh;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Select theo mã LHH
	public Loai_HH getLHHByTenLHH(String ten_lhh) {
		String sql = "SELECT * FROM LOAI_HH WHERE TEN_LOAI_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ten_lhh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Loai_HH lhh = new Loai_HH(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return lhh;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Sửa loại hàng hóa
	public void sua_LHH(Loai_HH lhh) {
		String sql = "UPDATE LOAI_HH SET TEN_LOAI_HANG = ?, ANH = ?, GHI_CHU = ? WHERE MA_LOAI_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, lhh.getTen_loai_hang());
			st.setString(2, lhh.getAnh());
			st.setString(3, lhh.getGhi_chu());
			st.setInt(4, lhh.getMa_lhh());

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Thêm LHH
	public void them_LHH(String ten_loai_hang, String anh, String ghi_chu) {
		String sql = "INSERT INTO LOAI_HH(TEN_LOAI_HANG, ANH, GHI_CHU) VALUES (?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, ten_loai_hang);
			st.setString(2, anh);
			st.setString(3, ghi_chu);

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Xóa LHH
	public void xoa_LHH(int ma_loai_hh) {
		String sql = "DELETE FROM LOAI_HH WHERE MA_LOAI_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setInt(1, ma_loai_hh);

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
