package admin.model;

public class Nhan_Vien {
	private int id_nv;
	private String ho_ten_nv;
	private String chuc_vu;
	private String dia_chi;
	private String sdt;
	private String anh;
	private String email;
	private String tai_khoan;
	private String mat_khau;
	private int quyen;

	public Nhan_Vien() {
		super();
	}

	public Nhan_Vien(int id_nv, String ho_ten_nv, String chuc_vu, String dia_chi, String sdt, String anh, String email,
			String tai_khoan, String mat_khau) {
		super();
		this.id_nv = id_nv;
		this.ho_ten_nv = ho_ten_nv;
		this.chuc_vu = chuc_vu;
		this.dia_chi = dia_chi;
		this.sdt = sdt;
		this.anh = anh;
		this.email = email;
		this.tai_khoan = tai_khoan;
		this.mat_khau = mat_khau;
	}

	public Nhan_Vien(int id_nv, String ho_ten_nv, String chuc_vu, String dia_chi, String sdt, String anh, String email,
			String tai_khoan, String mat_khau, int quyen) {
		super();
		this.id_nv = id_nv;
		this.ho_ten_nv = ho_ten_nv;
		this.chuc_vu = chuc_vu;
		this.dia_chi = dia_chi;
		this.sdt = sdt;
		this.anh = anh;
		this.email = email;
		this.tai_khoan = tai_khoan;
		this.mat_khau = mat_khau;
		this.quyen = quyen;
	}

	public int getId_nv() {
		return id_nv;
	}

	public void setId_nv(int id_nv) {
		this.id_nv = id_nv;
	}

	public String getHo_ten_nv() {
		return ho_ten_nv;
	}

	public void setHo_ten_nv(String ho_ten_nv) {
		this.ho_ten_nv = ho_ten_nv;
	}

	public String getChuc_vu() {
		return chuc_vu;
	}

	public void setChuc_vu(String chuc_vu) {
		this.chuc_vu = chuc_vu;
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

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}

}
