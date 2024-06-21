package page.model;

public class Nha_CC {
	private String ma_nha_cung_cap;
	private String ten_nha_cung_cap;
	private String dia_chi;
	private String sdt;
	private String email;

	public Nha_CC(String ma_nha_cung_cap, String ten_nha_cung_cap, String dia_chi, String sdt, String email) {
		super();
		this.ma_nha_cung_cap = ma_nha_cung_cap;
		this.ten_nha_cung_cap = ten_nha_cung_cap;
		this.dia_chi = dia_chi;
		this.sdt = sdt;
		this.email = email;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Nha_CC() {
		super();
	}

	public String getMa_nha_cung_cap() {
		return ma_nha_cung_cap;
	}

	public void setMa_nha_cung_cap(String ma_nha_cung_cap) {
		this.ma_nha_cung_cap = ma_nha_cung_cap;
	}

	public String getTen_nha_cung_cap() {
		return ten_nha_cung_cap;
	}

	public void setTen_nha_cung_cap(String ten_nha_cung_cap) {
		this.ten_nha_cung_cap = ten_nha_cung_cap;
	}

	public Nha_CC(String ma_nha_cung_cap, String ten_nha_cung_cap) {
		super();
		this.ma_nha_cung_cap = ma_nha_cung_cap;
		this.ten_nha_cung_cap = ten_nha_cung_cap;
	}

}
