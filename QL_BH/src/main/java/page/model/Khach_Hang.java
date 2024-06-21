package page.model;

public class Khach_Hang {
	private int ma_kh;
	private String ma_kh_string;
	private String ten_kh;
	private String anh;
	private String sdt;
	private String dia_chi;
	private String tin_nhan;
	private String thoi_gian;
	private String tai_khoan;
	private String mat_khau;

	public String getMa_kh_string() {
		return ma_kh_string;
	}

	public void setMa_kh_string(String ma_kh_string) {
		this.ma_kh_string = ma_kh_string;
	}

	public String getTin_nhan() {
		return tin_nhan;
	}

	public void setTin_nhan(String tin_nhan) {
		this.tin_nhan = tin_nhan;
	}

	public String getThoi_gian() {
		return thoi_gian;
	}

	public void setThoi_gian(String thoi_gian) {
		this.thoi_gian = thoi_gian;
	}

	public Khach_Hang(String ten_kh, String anh, String sdt, String tin_nhan, String thoi_gian) {
		super();
		this.ten_kh = ten_kh;
		this.anh = anh;
		this.sdt = sdt;
		this.tin_nhan = tin_nhan;
		this.thoi_gian = thoi_gian;
	}

	public Khach_Hang(String ma_kh_string, String ten_kh, String sdt, String dia_chi) {
		super();
		this.ma_kh_string = ma_kh_string;
		this.ten_kh = ten_kh;
		this.sdt = sdt;
		this.dia_chi = dia_chi;
	}

	public Khach_Hang(int ma_kh, String ten_kh, String anh, String sdt, String dia_chi) {
		super();
		this.ma_kh = ma_kh;
		this.ten_kh = ten_kh;
		this.anh = anh;
		this.sdt = sdt;
		this.dia_chi = dia_chi;
	}

	public Khach_Hang(int ma_kh, String ten_kh, String anh, String sdt, String dia_chi, String tai_khoan,
			String mat_khau) {
		super();
		this.ma_kh = ma_kh;
		this.ten_kh = ten_kh;
		this.anh = anh;
		this.sdt = sdt;
		this.dia_chi = dia_chi;
		this.tai_khoan = tai_khoan;
		this.mat_khau = mat_khau;
	}

	public Khach_Hang() {
		super();
	}

	public int getMa_kh() {
		return ma_kh;
	}

	public void setMa_kh(int ma_kh) {
		this.ma_kh = ma_kh;
	}

	public String getTen_kh() {
		return ten_kh;
	}

	public void setTen_kh(String ten_kh) {
		this.ten_kh = ten_kh;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getTai_khoan() {
		return tai_khoan;
	}

	public void setTai_khoan(String tai_khoan) {
		this.tai_khoan = tai_khoan;
	}

	public String getMat_khau() {
		return mat_khau;
	}

	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}

}
