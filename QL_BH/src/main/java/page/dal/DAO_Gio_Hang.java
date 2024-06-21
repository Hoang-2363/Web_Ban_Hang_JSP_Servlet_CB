package page.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.model.Gio_Hang;
import page.model.Hang_Hoa;
import page.model.Hoa_Don_BH;
import page.model.TT_HH_Mua;

public class DAO_Gio_Hang extends ConnectDB {
	public void them_HD(String ma_kh, Gio_Hang gio_hang) {
		try {
			String sql = "INSERT INTO HOA_DON_BH(NGAY_XUAT_HD, MA_KH, ID_NV, TRANG_THAI, TONG_TIEN_HD) VALUES (NOW(), ?, NULL, 'Đang xử lý', ?)";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ma_kh);
			st.setInt(2, gio_hang.getTong_Tien_GH());
			st.executeUpdate();

			// Lấy id hóa đơn vừa tạo
			String sql1 = "SELECT MA_HD_BH FROM HOA_DON_BH ORDER BY MA_HD_BH DESC LIMIT 1";
			PreparedStatement st1 = connection.prepareStatement(sql1);
			ResultSet rs1 = st1.executeQuery();
			if (rs1.next()) {
				int ma_hd_bh = rs1.getInt(1);
				for (TT_HH_Mua i : gio_hang.getItems()) {
					String sql2 = "INSERT INTO HD_BH_CT VALUES (?, ?, ?, ?)";
					PreparedStatement st2 = connection.prepareStatement(sql2);
					st2.setInt(1, ma_hd_bh);
					st2.setInt(2, i.getHang_hoa().getMa_hang());
					st2.setInt(3, i.getSo_luong());
					st2.setInt(4, i.getGia_ban());
					st2.executeUpdate();
				}
			}

			// Cập nhật lại sản phẩm số lượng
			String sql3 = "UPDATE HANG_HOA SET SO_LUONG_TON = SO_LUONG_TON - ? WHERE MA_HANG = ?";
			PreparedStatement st3 = connection.prepareStatement(sql3);
			for (TT_HH_Mua i : gio_hang.getItems()) {
				st3.setInt(1, i.getSo_luong());
				st3.setInt(2, i.getHang_hoa().getMa_hang());
				st3.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Select hóa đơn bán hàng
	public List<Hoa_Don_BH> select_HH_BH_Ma_KH(int ma_kh) {
		List<Hoa_Don_BH> list = new ArrayList<>();
		String sql = "SELECT MA_HD_BH, DATE_FORMAT(NGAY_XUAT_HD, '%H:%i:%s %d/%m/%Y') AS NGAY_XUAT_HD, TRANG_THAI, TONG_TIEN_HD, KH.TEN_KH, NV.HO_TEN_NV, KH.MA_KH, NV.ID_NV "
				+ "FROM HOA_DON_BH AS HD_BH INNER JOIN KHACH_HANG AS KH ON KH.MA_KH = HD_BH.MA_KH "
				+ "LEFT JOIN NHAN_VIEN AS NV ON NV.ID_NV = HD_BH.ID_NV WHERE KH.MA_KH  = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_kh);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hoa_Don_BH hd = new Hoa_Don_BH(rs.getInt("MA_HD_BH"), rs.getString("NGAY_XUAT_HD"),
						rs.getInt("TONG_TIEN_HD"), rs.getInt("MA_KH"), rs.getInt("ID_NV"), rs.getString("TRANG_THAI"),
						rs.getString("TEN_KH"), rs.getString("HO_TEN_NV"));
				list.add(hd);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select hóa đơn bán hàng chưa giao hàng thành công
	public List<Hoa_Don_BH> select_HH_BH_Ma_KH_Chua_GTC(int ma_kh) {
		List<Hoa_Don_BH> list = new ArrayList<>();
		String sql = "SELECT MA_HD_BH, DATE_FORMAT(NGAY_XUAT_HD, '%H:%i:%s %d/%m/%Y') AS NGAY_XUAT_HD, TRANG_THAI, TONG_TIEN_HD, KH.TEN_KH, NV.HO_TEN_NV, KH.MA_KH, NV.ID_NV "
				+ "FROM HOA_DON_BH AS HD_BH INNER JOIN KHACH_HANG AS KH ON KH.MA_KH = HD_BH.MA_KH "
				+ "LEFT JOIN NHAN_VIEN AS NV ON NV.ID_NV = HD_BH.ID_NV WHERE KH.MA_KH  = ? AND TRANG_THAI != 'Giao hàng thành công';";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_kh);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hoa_Don_BH hd = new Hoa_Don_BH(rs.getInt("MA_HD_BH"), rs.getString("NGAY_XUAT_HD"),
						rs.getInt("TONG_TIEN_HD"), rs.getInt("MA_KH"), rs.getInt("ID_NV"), rs.getString("TRANG_THAI"),
						rs.getString("TEN_KH"), rs.getString("HO_TEN_NV"));
				list.add(hd);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select mã hóa đơn, ngày xuất hóa đơn
	public Hoa_Don_BH mn_HDBH_Ma_KH(int ma_kh) {
		String sql = "SELECT MA_HD_BH, DATE_FORMAT(NGAY_XUAT_HD, '%H:%i:%s %d/%m/%Y') AS NGAY_XUAT_HD, TRANG_THAI FROM HOA_DON_BH WHERE MA_KH = ? ORDER BY MA_HD_BH DESC LIMIT 1;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_kh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Hoa_Don_BH nv = new Hoa_Don_BH(rs.getInt(1), rs.getString(2), rs.getString(3));
				return nv;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Hiển thị số lượng tồn hàng hóa theo mã hàng
	public Integer so_luong(int ma_hang) {
		String sql = "SELECT SO_LUONG_TON FROM HANG_HOA WHERE MA_HANG = ?;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_hang);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Hang_Hoa hh = new Hang_Hoa();
				hh.setSo_luong(rs.getInt(1));
				return hh.getSo_luong();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
}
