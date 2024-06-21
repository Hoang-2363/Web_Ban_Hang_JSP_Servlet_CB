package admin.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.model.Nhan_Vien;

public class DAO_Nhan_Vien extends ConnectDB {

	// In thông tin tài khoản
	public Nhan_Vien check(String tai_khoan, String mat_khau) {
		String sql = "SELECT NV.ID_NV, NV.HO_TEN_NV, NV.CHUC_VU, NV.DIA_CHI, NV.SDT, NV.ANH, NV.EMAIL, ND.TAI_KHOAN, ND.MAT_KHAU, ND.QUYEN "
				+ "FROM NHAN_VIEN AS NV " + "INNER JOIN NGUOI_DUNG_ADMIN AS ND ON NV.ID_NV = ND.ID_NV "
				+ "WHERE ND.TAI_KHOAN = ? AND ND.MAT_KHAU = ?;";

		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, tai_khoan);
			st.setString(2, mat_khau);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Nhan_Vien nv = new Nhan_Vien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10));
				return nv;
			}
		} catch (Exception e) {
		}
		return null;
	}

	// In thông tin tài khoản
	public Nhan_Vien getNVByID(String ma_nv) {
		String sql = "SELECT NV.ID_NV, NV.HO_TEN_NV, NV.CHUC_VU, NV.DIA_CHI, NV.SDT, NV.ANH, NV.EMAIL, ND.TAI_KHOAN, ND.MAT_KHAU, ND.QUYEN "
				+ "FROM NHAN_VIEN AS NV " + "INNER JOIN NGUOI_DUNG_ADMIN AS ND ON NV.ID_NV = ND.ID_NV "
				+ "WHERE NV.ID_NV = ?;";

		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ma_nv);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Nhan_Vien nv = new Nhan_Vien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getInt(10));
				return nv;
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	// Sửa hàng hóa
	public void sua_nv(Nhan_Vien nv) {
		String sql = "UPDATE NHAN_VIEN AS NV INNER JOIN NGUOI_DUNG_ADMIN AS ND ON NV.ID_NV = ND.ID_NV "
				+ "SET NV.HO_TEN_NV = ?, NV.CHUC_VU = ?, NV.DIA_CHI = ?, NV.SDT = ?, NV.ANH = ?, NV.EMAIL = ?, ND.TAI_KHOAN = ?, ND.MAT_KHAU = ? "
				+ "WHERE NV.ID_NV = ?;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, nv.getHo_ten_nv());
			st.setString(2, nv.getChuc_vu());
			st.setString(3, nv.getDia_chi());
			st.setString(4, nv.getSdt());
			st.setString(5, nv.getAnh());
			st.setString(6, nv.getEmail());
			st.setString(7, nv.getTai_khoan());
			st.setString(8, nv.getMat_khau());
			st.setInt(9, nv.getId_nv());

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
