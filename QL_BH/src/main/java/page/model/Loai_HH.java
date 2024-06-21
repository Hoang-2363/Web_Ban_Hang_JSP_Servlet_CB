package page.model;

public class Loai_HH {
	private String ma_loai_hang;
	private int ma_lhh;
	private String ten_loai_hang;
	private String anh;
	private String ghi_chu;
	private int count;

	public Loai_HH(int ma_lhh, String ten_loai_hang, String anh, String ghi_chu) {
		super();
		this.ma_lhh = ma_lhh;
		this.ten_loai_hang = ten_loai_hang;
		this.anh = anh;
		this.ghi_chu = ghi_chu;
	}

	public int getMa_lhh() {
		return ma_lhh;
	}

	public void setMa_lhh(int ma_lhh) {
		this.ma_lhh = ma_lhh;
	}

	public Loai_HH(String ma_loai_hang, String ten_loai_hang, int count) {
		super();
		this.ma_loai_hang = ma_loai_hang;
		this.ten_loai_hang = ten_loai_hang;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Loai_HH() {
		super();
	}

	public Loai_HH(String ma_loai_hang, String ten_loai_hang, String anh, String ghi_chu) {
		super();
		this.ma_loai_hang = ma_loai_hang;
		this.ten_loai_hang = ten_loai_hang;
		this.anh = anh;
		this.ghi_chu = ghi_chu;
	}

	public Loai_HH(String ten_loai_hang, String anh) {
		super();
		this.ten_loai_hang = ten_loai_hang;
		this.anh = anh;
	}

	public String getMa_loai_hang() {
		return ma_loai_hang;
	}

	public void setMa_loai_hang(String ma_loai_hang) {
		this.ma_loai_hang = ma_loai_hang;
	}

	public String getTen_loai_hang() {
		return ten_loai_hang;
	}

	public void setTen_loai_hang(String ten_loai_hang) {
		this.ten_loai_hang = ten_loai_hang;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

}
