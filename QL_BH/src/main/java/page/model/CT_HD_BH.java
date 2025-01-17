package page.model;

public class CT_HD_BH {
	private int ma_hd_bh;
	private int ma_hang;
	private int so_luong;
	private int gia_ban;
	private String ten_hang;
	private int thanh_tien;

	public String getTen_hang() {
		return ten_hang;
	}

	public void setTen_hang(String ten_hang) {
		this.ten_hang = ten_hang;
	}

	public int getThanh_tien() {
		return thanh_tien;
	}

	public void setThanh_tien(int thanh_tien) {
		this.thanh_tien = thanh_tien;
	}

	public CT_HD_BH(int ma_hang, int so_luong, int gia_ban, String ten_hang, int thanh_tien) {
		super();
		this.ma_hang = ma_hang;
		this.so_luong = so_luong;
		this.gia_ban = gia_ban;
		this.ten_hang = ten_hang;
		this.thanh_tien = thanh_tien;
	}

	public int getGia_ban() {
		return gia_ban;
	}

	public void setGia_ban(int gia_ban) {
		this.gia_ban = gia_ban;
	}

	public CT_HD_BH() {
		super();
	}

	public CT_HD_BH(int ma_hd_bh, int ma_hang, int so_luong, int gia_ban) {
		super();
		this.ma_hd_bh = ma_hd_bh;
		this.ma_hang = ma_hang;
		this.so_luong = so_luong;
		this.gia_ban = gia_ban;
	}

	public int getMa_hd_bh() {
		return ma_hd_bh;
	}

	public void setMa_hd_bh(int ma_hd_bh) {
		this.ma_hd_bh = ma_hd_bh;
	}

	public int getMa_hang() {
		return ma_hang;
	}

	public void setMa_hang(int ma_hang) {
		this.ma_hang = ma_hang;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

}
