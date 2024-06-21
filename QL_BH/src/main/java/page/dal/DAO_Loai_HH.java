package page.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.model.Loai_HH;
import page.model.Nha_CC;

public class DAO_Loai_HH extends ConnectDB {
	// Select loại hàng hóa
	public List<Loai_HH> selec_Loai_HH() {
		List<Loai_HH> list = new ArrayList<>();
		String sql = "SELECT TEN_LOAI_HANG, ANH FROM LOAI_HH";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Loai_HH nv = new Loai_HH(rs.getString(1), rs.getString(2));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select tên loại hàng hóa và số lượng sản phẩm
	public List<Loai_HH> selec_Loai_HH_SL() {
		List<Loai_HH> list = new ArrayList<>();
		String sql = "SELECT LOAI_HH.MA_LOAI_HANG, LOAI_HH.TEN_LOAI_HANG, COUNT(*) AS SO_LUONG FROM HANG_HOA INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG GROUP BY HANG_HOA.MA_LOAI_HANG";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Loai_HH lhh_sl = new Loai_HH(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(lhh_sl);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// In danh sách nhà cung cấp
	public List<Nha_CC> select_NCC() {
		List<Nha_CC> list = new ArrayList<>();
		String sql = "SELECT MA_NHA_CUNG_CAP, TEN_NHA_CUNG_CAP FROM NHA_CUNG_CAP";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Nha_CC ncc = new Nha_CC(rs.getString(1), rs.getString(2));
				list.add(ncc);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
}
