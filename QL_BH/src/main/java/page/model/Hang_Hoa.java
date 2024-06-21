package page.model;

public class Hang_Hoa {
	private int ma_hang;
	private String ten_hang;
	private int gia_ban;
	private int gia_nhap;
	private String don_vi_tinh;
	private int so_luong;
	private String ghi_chu;
	private String ma_nha_cung_cap;
	private int ma_loai_hang;
	private String ten_nha_cung_cap;
	private String ten_loai_hang;
	private String anh;
	
	private int so_luong_ban_chay;

	public int getSo_luong_ban_chay() {
		return so_luong_ban_chay;
	}

	public void setSo_luong_ban_chay(int so_luong_ban_chay) {
		this.so_luong_ban_chay = so_luong_ban_chay;
	}

	public int getGia_nhap() {
		return gia_nhap;
	}

	public void setGia_nhap(int gia_nhap) {
		this.gia_nhap = gia_nhap;
	}

	public Hang_Hoa(int ma_hang, String ten_hang, int gia_nhap, int gia_ban, String don_vi_tinh, int so_luong,
			String ghi_chu, String ma_nha_cung_cap, int ma_loai_hang, String anh) {
		super();
		this.ma_hang = ma_hang;
		this.ten_hang = ten_hang;
		this.gia_ban = gia_ban;
		this.gia_nhap = gia_nhap;
		this.don_vi_tinh = don_vi_tinh;
		this.so_luong = so_luong;
		this.ghi_chu = ghi_chu;
		this.ma_nha_cung_cap = ma_nha_cung_cap;
		this.ma_loai_hang = ma_loai_hang;
		this.anh = anh;
	}

	public Hang_Hoa(int ma_hang, String ten_hang, int gia_ban, String don_vi_tinh, int so_luong, String ghi_chu,
			String ten_nha_cung_cap, String ten_loai_hang, String anh) {
		super();
		this.ma_hang = ma_hang;
		this.ten_hang = ten_hang;
		this.gia_ban = gia_ban;
		this.don_vi_tinh = don_vi_tinh;
		this.so_luong = so_luong;
		this.ghi_chu = ghi_chu;
		this.ten_nha_cung_cap = ten_nha_cung_cap;
		this.ten_loai_hang = ten_loai_hang;
		this.anh = anh;
	}

	public String getTen_nha_cung_cap() {
		return ten_nha_cung_cap;
	}

	public void setTen_nha_cung_cap(String ten_nha_cung_cap) {
		this.ten_nha_cung_cap = ten_nha_cung_cap;
	}

	public String getTen_loai_hang() {
		return ten_loai_hang;
	}

	public void setTen_loai_hang(String ten_loai_hang) {
		this.ten_loai_hang = ten_loai_hang;
	}

	public Hang_Hoa() {
		super();
	}

	public Hang_Hoa(int ma_hang, String ten_hang, int gia_ban, String don_vi_tinh, int so_luong, String ghi_chu,
			String ma_nha_cung_cap, int ma_loai_hang, String anh) {
		super();
		this.ma_hang = ma_hang;
		this.ten_hang = ten_hang;
		this.gia_ban = gia_ban;
		this.don_vi_tinh = don_vi_tinh;
		this.so_luong = so_luong;
		this.ghi_chu = ghi_chu;
		this.ma_nha_cung_cap = ma_nha_cung_cap;
		this.ma_loai_hang = ma_loai_hang;
		this.anh = anh;
	}

	public Hang_Hoa(int ma_hang, String ten_hang, int gia_ban, String don_vi_tinh, int so_luong, String ghi_chu,
			String anh, int so_luong_ban_chay) {
		super();
		this.ma_hang = ma_hang;
		this.ten_hang = ten_hang;
		this.gia_ban = gia_ban;
		this.don_vi_tinh = don_vi_tinh;
		this.so_luong = so_luong;
		this.ghi_chu = ghi_chu;
		this.anh = anh;
		this.so_luong_ban_chay = so_luong_ban_chay;
	}

	public int getMa_hang() {
		return ma_hang;
	}

	public void setMa_hang(int ma_hang) {
		this.ma_hang = ma_hang;
	}

	public String getTen_hang() {
		return ten_hang;
	}

	public void setTen_hang(String ten_hang) {
		this.ten_hang = ten_hang;
	}

	public int getGia_ban() {
		return gia_ban;
	}

	public void setGia_ban(int gia_ban) {
		this.gia_ban = gia_ban;
	}

	public String getDon_vi_tinh() {
		return don_vi_tinh;
	}

	public void setDon_vi_tinh(String don_vi_tinh) {
		this.don_vi_tinh = don_vi_tinh;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

	public String getMa_nha_cung_cap() {
		return ma_nha_cung_cap;
	}

	public void setMa_nha_cung_cap(String ma_nha_cung_cap) {
		this.ma_nha_cung_cap = ma_nha_cung_cap;
	}

	public int getMa_loai_hang() {
		return ma_loai_hang;
	}

	public void setMa_loai_hang(int ma_loai_hang) {
		this.ma_loai_hang = ma_loai_hang;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

}
