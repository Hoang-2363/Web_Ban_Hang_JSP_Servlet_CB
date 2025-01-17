package page.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.model.Hang_Hoa;

public class DAO_Hang_Hoa extends ConnectDB {
	// Select hàng hóa
	public List<Hang_Hoa> select_HH() {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT MA_HANG, TEN_HANG, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, GHI_CHU, MA_NHA_CUNG_CAP, MA_LOAI_HANG, ANH FROM HANG_HOA";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select hàng hóa theo mã loại hàng hóa
	public List<Hang_Hoa> select_HH_Ma_LHH(Integer ma_lhh) {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT MA_HANG, TEN_HANG, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, GHI_CHU, MA_NHA_CUNG_CAP, MA_LOAI_HANG, ANH FROM HANG_HOA WHERE MA_LOAI_HANG = ?;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_lhh);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select hàng hóa tên nhà cung cấp, loại hàng hóa theo mã hàng
	public Hang_Hoa select_HH_NCC_LHH_Ma_LHH(Integer ma_hang) {
		String sql = "SELECT MA_HANG, TEN_HANG, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, HANG_HOA.GHI_CHU, NHA_CUNG_CAP.TEN_NHA_CUNG_CAP, LOAI_HH.TEN_LOAI_HANG, HANG_HOA.ANH  "
				+ "FROM HANG_HOA INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP  = NHA_CUNG_CAP.MA_NHA_CUNG_CAP "
				+ "INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG  = LOAI_HH.MA_LOAI_HANG WHERE MA_HANG = ?;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_hang);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
				return nv;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Select hàng hóa theo mã loại hàng hóa
	public List<Hang_Hoa> SP_Tuong_tu(Integer ma_lhh) {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT MA_HANG, TEN_HANG, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, GHI_CHU, MA_NHA_CUNG_CAP, MA_LOAI_HANG, ANH "
				+ "FROM HANG_HOA WHERE MA_LOAI_HANG = (SELECT MA_LOAI_HANG FROM HANG_HOA WHERE MA_HANG = ?);";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_lhh);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select hàng hóa theo mã loại hàng hóa
	public List<Hang_Hoa> select_HH_Ma_NCC(String[] ma_ncc) {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT MA_HANG, TEN_HANG, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, GHI_CHU, MA_NHA_CUNG_CAP, MA_LOAI_HANG, ANH FROM HANG_HOA WHERE 1=1 ";
		if (ma_ncc != null) {
			sql += " AND MA_NHA_CUNG_CAP IN('";
			for (int i = 0; i < ma_ncc.length; i++) {
				sql += ma_ncc[i] + "','";
			}
			if (sql.endsWith(",")) {
				sql = sql.substring(0, sql.length() - 1);
			}
			sql += "')";
		}
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select hàng hóa giá giảm dần
	public List<Hang_Hoa> select_HH_Gia_Giam() {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT MA_HANG, TEN_HANG, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, GHI_CHU, MA_NHA_CUNG_CAP, MA_LOAI_HANG, ANH FROM HANG_HOA order by GIA_BAN desc";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select hàng hóa giá tăng dần
	public List<Hang_Hoa> select_HH_Gia_Tang() {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT MA_HANG, TEN_HANG, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, GHI_CHU, MA_NHA_CUNG_CAP, MA_LOAI_HANG, ANH FROM HANG_HOA order by GIA_BAN asc";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select hàng hóa theo giá
	public List<Hang_Hoa> select_HH_Gia_Ban(Integer gia_ban) {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT MA_HANG, TEN_HANG, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, GHI_CHU, MA_NHA_CUNG_CAP, MA_LOAI_HANG, ANH FROM HANG_HOA WHERE GIA_BAN <= ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, gia_ban);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Tìm kiếm hàng hóa theo mã, tên, số lượng, đơn vị tính, ghi chú
	public List<Hang_Hoa> TK_HH(String key) {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT HH.MA_HANG, HH.TEN_HANG, HH.GIA_BAN, HH.DON_VI_TINH, HH.SO_LUONG_TON, HH.GHI_CHU, HH.MA_NHA_CUNG_CAP, HH.MA_LOAI_HANG, HH.ANH FROM HANG_HOA AS HH WHERE 1=1 ";
		if (key != null && !key.equals("")) {
			sql += " AND (HH.MA_HANG LIKE '%" + key + "%' OR HH.TEN_HANG LIKE '%" + key
					+ "%' OR HH.SO_LUONG_TON LIKE '%" + key + "%' OR HH.DON_VI_TINH LIKE '%" + key
					+ "%' OR HH.GHI_CHU LIKE '%" + key + "%' OR HH.GIA_BAN LIKE '%" + key + "%')";
		}
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Hang_Hoa> getListByPage(ArrayList<Hang_Hoa> sp, int start, int end) {
		ArrayList<Hang_Hoa> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(sp.get(i));
		}
		return arr;
	}

	// Top 6 sản phẩm bán chạy nhất
	public List<Hang_Hoa> top6_SP_BC() {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT HD_BH_CT.MA_HANG, HANG_HOA.TEN_HANG, HANG_HOA.GIA_BAN, HANG_HOA.DON_VI_TINH, HANG_HOA.SO_LUONG_TON, HANG_HOA.GHI_CHU, HANG_HOA.ANH, COUNT(HD_BH_CT.MA_HANG) AS SO_LUONG_DA_BAN FROM HD_BH_CT "
				+ "INNER JOIN HANG_HOA ON HANG_HOA.MA_HANG = HD_BH_CT.MA_HANG GROUP BY HD_BH_CT.MA_HANG HAVING SO_LUONG_DA_BAN >= 1 ORDER BY SO_LUONG_DA_BAN DESC LIMIT 8;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa nv = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
}
