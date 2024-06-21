package admin.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import page.model.Hang_Hoa;

public class DAO_Hang_Hoa extends ConnectDB {
	// Select hàng hóa
	public List<Hang_Hoa> select_Hang_Hoa() {
		List<Hang_Hoa> list = new ArrayList<>();
		String sql = "SELECT * FROM HANG_HOA";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Hang_Hoa hh = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
				list.add(hh);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// Select DVT
	public List<String> select_DVT() {
		List<String> list = new ArrayList<>();
		String sql = "SELECT DISTINCT DON_VI_TINH FROM HANG_HOA;";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String donViTinh = rs.getString(1);
				list.add(donViTinh);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	// In tên loại hàng hóa theo mã hàng
	public String ten_lhh(int ma_lhh) {
		String sql = "SELECT TEN_LOAI_HANG FROM LOAI_HH "
				+ "INNER JOIN HANG_HOA ON LOAI_HH.MA_LOAI_HANG = HANG_HOA.MA_LOAI_HANG " + "WHERE MA_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_lhh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// In tên nhà cung cấp theo mã hàng
	public String ten_ncc(int ma_lhh) {
		String sql = "SELECT TEN_NHA_CUNG_CAP FROM NHA_CUNG_CAP  "
				+ "INNER JOIN HANG_HOA ON NHA_CUNG_CAP.MA_NHA_CUNG_CAP = HANG_HOA.MA_NHA_CUNG_CAP "
				+ "WHERE MA_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_lhh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// In ảnh theo mã hàng
	public String anh_hh(int ma_hang) {
		String sql = "SELECT ANH FROM HANG_HOA WHERE MA_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_hang);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Select theo mã HH
	public Hang_Hoa getLHHByMaHH(int ma_hh) {
		String sql = "SELECT * FROM HANG_HOA WHERE MA_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, ma_hh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Hang_Hoa hh = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
				return hh;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Select theo tên hàng hóa, ảnh hàng hóa
	public Hang_Hoa getLHHByTenHH(String ten_hh, String anh) {
		String sql = "SELECT * FROM HANG_HOA WHERE TEN_HANG = ? OR ANH = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, ten_hh);
			st.setString(2, anh);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Hang_Hoa hh = new Hang_Hoa(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
				return hh;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	// Sửa hàng hóa
	public void sua_HH(Hang_Hoa hh) {
		String sql = "UPDATE HANG_HOA SET TEN_HANG = ?, GIA_NHAP = ?, GIA_BAN = ?, DON_VI_TINH = ?, SO_LUONG_TON = ?, GHI_CHU = ?, MA_NHA_CUNG_CAP = ?, MA_LOAI_HANG = ?, ANH = ? WHERE MA_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, hh.getTen_hang());
			st.setInt(2, hh.getGia_nhap());
			st.setInt(3, hh.getGia_ban());
			st.setString(4, hh.getDon_vi_tinh());
			st.setInt(5, hh.getSo_luong());
			st.setString(6, hh.getGhi_chu());
			st.setString(7, hh.getMa_nha_cung_cap());
			st.setInt(8, hh.getMa_loai_hang());
			st.setString(9, hh.getAnh());
			st.setInt(10, hh.getMa_hang());

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Thêm HH
	public void them_HH(String ten_hang, int gia_nhap, int gia_ban, String don_vi_tinh, int so_luong, String ghi_chu,
			String ma_nha_cung_cap, int ma_loai_hang, String anh) {
		String sql = "INSERT INTO HANG_HOA(TEN_HANG, GIA_NHAP, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, GHI_CHU, MA_NHA_CUNG_CAP, MA_LOAI_HANG, ANH) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setString(1, ten_hang);
			st.setInt(2, gia_nhap);
			st.setInt(3, gia_ban);
			st.setString(4, don_vi_tinh);
			st.setInt(5, so_luong);
			st.setString(6, ghi_chu);
			st.setString(7, ma_nha_cung_cap);
			st.setInt(8, ma_loai_hang);
			st.setString(9, anh);

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// Xóa hàng hóa
	public void xoa_HH(int ma_Hang_Hoa) {
		String sql = "DELETE FROM HANG_HOA WHERE MA_HANG = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setInt(1, ma_Hang_Hoa);

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
