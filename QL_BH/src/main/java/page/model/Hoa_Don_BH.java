package page.model;

public class Hoa_Don_BH {
	private int ma_hd_bh;
	private String ngay_xuat_hd;
	private int tong_tien;
	private int ma_kh;
	private int id_nv;
	private String trang_thai;
	private String ten_kh;
	private String ten_nv;

	public String getTen_kh() {
		return ten_kh;
	}

	public void setTen_kh(String ten_kh) {
		this.ten_kh = ten_kh;
	}

	public String getTen_nv() {
		return ten_nv;
	}

	public void setTen_nv(String ten_nv) {
		this.ten_nv = ten_nv;
	}

	public Hoa_Don_BH() {
		super();
	}

	public Hoa_Don_BH(int ma_hd_bh, String ngay_xuat_hd, String trang_thai) {
		super();
		this.ma_hd_bh = ma_hd_bh;
		this.ngay_xuat_hd = ngay_xuat_hd;
		this.trang_thai = trang_thai;
	}

	public Hoa_Don_BH(int ma_hd_bh, String ngay_xuat_hd, int tong_tien, int ma_kh, int id_nv, String trang_thai,
			String ten_kh, String ten_nv) {
		super();
		this.ma_hd_bh = ma_hd_bh;
		this.ngay_xuat_hd = ngay_xuat_hd;
		this.tong_tien = tong_tien;
		this.ma_kh = ma_kh;
		this.id_nv = id_nv;
		this.trang_thai = trang_thai;
		this.ten_kh = ten_kh;
		this.ten_nv = ten_nv;
	}

	public Hoa_Don_BH(int ma_hd_bh, String ngay_xuat_hd, int tong_tien, int ma_kh, int id_nv, String trang_thai) {
		super();
		this.ma_hd_bh = ma_hd_bh;
		this.ngay_xuat_hd = ngay_xuat_hd;
		this.tong_tien = tong_tien;
		this.ma_kh = ma_kh;
		this.id_nv = id_nv;
		this.trang_thai = trang_thai;
	}

	public int getMa_hd_bh() {
		return ma_hd_bh;
	}

	public void setMa_hd_bh(int ma_hd_bh) {
		this.ma_hd_bh = ma_hd_bh;
	}

	public String getNgay_xuat_hd() {
		return ngay_xuat_hd;
	}

	public void setNgay_xuat_hd(String ngay_xuat_hd) {
		this.ngay_xuat_hd = ngay_xuat_hd;
	}

	public int getTong_tien() {
		return tong_tien;
	}

	public void setTong_tien(int tong_tien) {
		this.tong_tien = tong_tien;
	}

	public int getMa_kh() {
		return ma_kh;
	}

	public void setMa_kh(int ma_kh) {
		this.ma_kh = ma_kh;
	}

	public int getId_nv() {
		return id_nv;
	}

	public void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}

	public String getTrang_thai() {
		return trang_thai;
	}

	public void setTrang_thai(String trang_thai) {
		this.trang_thai = trang_thai;
	}

}
