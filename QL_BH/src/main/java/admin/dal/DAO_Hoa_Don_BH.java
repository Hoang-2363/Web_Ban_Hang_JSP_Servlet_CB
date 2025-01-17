package admin.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.model.CT_HD_BH;
import page.model.Hoa_Don_BH;

public class DAO_Hoa_Don_BH extends ConnectDB {
	// Select loại hàng hóa
	public List<Hoa_Don_BH> selec_HD_BH() {
		List<Hoa_Don_BH> list = new ArrayList<>();
		String sql = "SELECT MA_HD_BH,DATE_FORMAT(NGAY_XUAT_HD, '%H:%i:%s %d/%m/%Y') AS NGAY_XUAT_HD, TRANG_THAI, TONG_TIEN_HD, KH.TEN_KH, NV.HO_TEN_NV, KH.MA_KH, NV.ID_NV "
				+ "FROM HOA_DON_BH AS HD_BH INNER JOIN KHACH_HANG AS KH ON KH.MA_KH = HD_BH.MA_KH LEFT JOIN NHAN_VIEN AS NV ON NV.ID_NV = HD_BH.ID_NV;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hoa_Don_BH nv = new Hoa_Don_BH(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(7), rs.getInt(8),
						rs.getString(3), rs.getString(5), rs.getString(6));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Cập nhật hóa đơn Đang giao hàng
	public void cap_nhat_dang_gh(String id_nv, String ma_hd_bh) {
		String sql = "UPDATE HOA_DON_BH SET TRANG_THAI = 'Đang giao hàng', ID_NV = ? WHERE MA_HD_BH = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, id_nv);
			st.setString(2, ma_hd_bh);

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Cập nhật hóa đơn giao hàng thành công
	public void cap_nhat_ghtc(String ma_hd_bh) {
		String sql = "UPDATE HOA_DON_BH SET TRANG_THAI = 'Giao hàng thành công' WHERE MA_HD_BH = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, ma_hd_bh);

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public Hoa_Don_BH selec_HD_BH_By_ID(String ma_hd_bh) {
		String sql = "SELECT MA_HD_BH,DATE_FORMAT(NGAY_XUAT_HD, '%H:%i:%s %d/%m/%Y') AS NGAY_XUAT_HD, TRANG_THAI, TONG_TIEN_HD, KH.TEN_KH, NV.HO_TEN_NV, KH.MA_KH, NV.ID_NV "
				+ "FROM HOA_DON_BH AS HD_BH INNER JOIN KHACH_HANG AS KH ON KH.MA_KH = HD_BH.MA_KH LEFT JOIN NHAN_VIEN AS NV ON NV.ID_NV = HD_BH.ID_NV WHERE MA_HD_BH = ?;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ma_hd_bh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Hoa_Don_BH hdbh = new Hoa_Don_BH(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(7),
						rs.getInt(8), rs.getString(3), rs.getString(5), rs.getString(6));
				return hdbh;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public List<CT_HD_BH> select_CT_HD_BH_By_ID(String ma_hd_bh) {
		List<CT_HD_BH> list = new ArrayList<>();
		String sql = "SELECT HD_BH_CT.MA_HANG, HANG_HOA.TEN_HANG, SO_LUONG_MUA, HD_BH_CT.GIA_BAN, SO_LUONG_MUA*HD_BH_CT.GIA_BAN AS THANH_TIEN FROM HD_BH_CT "
				+ "INNER JOIN HANG_HOA ON HANG_HOA.MA_HANG = HD_BH_CT.MA_HANG WHERE MA_HD_BH = ?;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ma_hd_bh);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				CT_HD_BH nv = new CT_HD_BH(rs.getInt(1), rs.getInt(3), rs.getInt(4), rs.getString(2), rs.getInt(5));
				list.add(nv);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
}
