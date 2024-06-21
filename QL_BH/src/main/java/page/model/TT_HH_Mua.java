package page.model;

//Thông tin hàng hóa mua trong page
public class TT_HH_Mua {
	private Hang_Hoa hang_hoa;
	private int so_luong;
	private int gia_ban;

	public TT_HH_Mua() {
		super();
	}

	public TT_HH_Mua(Hang_Hoa hang_hoa, int so_luong, int gia_ban) {
		super();
		this.hang_hoa = hang_hoa;
		this.so_luong = so_luong;
		this.gia_ban = gia_ban;
	}

	public Hang_Hoa getHang_hoa() {
		return hang_hoa;
	}

	public void setHang_hoa(Hang_Hoa hang_hoa) {
		this.hang_hoa = hang_hoa;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public int getGia_ban() {
		return gia_ban;
	}

	public void setGia_ban(int gia_ban) {
		this.gia_ban = gia_ban;
	}

}
