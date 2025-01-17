package admin.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.model.Nha_CC;

public class DAO_NCC extends ConnectDB {
	// Select loại hàng hóa
	public List<Nha_CC> selec_Nha_CC() {
		List<Nha_CC> list = new ArrayList<>();
		String sql = "SELECT * FROM NHA_CUNG_CAP";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Nha_CC ncc = new Nha_CC(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				list.add(ncc);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select tên ncc
	public List<String> select_NCC() {
		List<String> list = new ArrayList<>();
		String sql = "SELECT TEN_NHA_CUNG_CAP FROM NHA_CUNG_CAP";
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
	public String select_ma_ncc(String ten_lhh) {
		String sql = "SELECT MA_NHA_CUNG_CAP FROM NHA_CUNG_CAP WHERE TEN_NHA_CUNG_CAP = ?";
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

	// Select theo mã MA_Nha_CC
	public Nha_CC getNCCByMaNCC(String ma_Nha_CC) {
		String sql = "SELECT * FROM NHA_CUNG_CAP WHERE MA_NHA_CUNG_CAP = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ma_Nha_CC);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Nha_CC ncc = new Nha_CC(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				return ncc;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Select theo tên TEN_Nha_CC, sđt SDT, email EMAIL
	public Nha_CC getNCCByTenNCC(String ten_Nha_CC, String sdt, String email) {
		String sql = "SELECT * FROM NHA_CUNG_CAP WHERE TEN_NHA_CUNG_CAP = ? OR SDT = ? OR EMAIL = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ten_Nha_CC);
			st.setString(2, sdt);
			st.setString(3, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Nha_CC lhh = new Nha_CC(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				return lhh;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Sửa nhà cung cấp
	public void sua_NCC(Nha_CC ncc) {
		String sql = "UPDATE NHA_CUNG_CAP SET TEN_NHA_CUNG_CAP = ?, DIA_CHI = ?, SDT = ?, EMAIL = ? WHERE MA_NHA_CUNG_CAP = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, ncc.getTen_nha_cung_cap());
			st.setString(2, ncc.getDia_chi());
			st.setString(3, ncc.getSdt());
			st.setString(4, ncc.getEmail());
			st.setString(5, ncc.getMa_nha_cung_cap());

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Thêm nhà cung cấp
	public void them_NCC(Nha_CC ncc) {
		String sql = "INSERT INTO NHA_CUNG_CAP VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, ncc.getMa_nha_cung_cap());
			st.setString(2, ncc.getTen_nha_cung_cap());
			st.setString(3, ncc.getDia_chi());
			st.setString(4, ncc.getSdt());
			st.setString(5, ncc.getEmail());

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Xóa nhà cung cấp
	public void xoa_NCC(String ma_Nha_CC) {
		String sql = "DELETE FROM NHA_CUNG_CAP WHERE MA_NHA_CUNG_CAP = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, ma_Nha_CC);

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
