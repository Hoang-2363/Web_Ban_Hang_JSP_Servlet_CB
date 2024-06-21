package page.model;

import java.util.ArrayList;
import java.util.List;

public class Gio_Hang {
	private List<TT_HH_Mua> items;

	public Gio_Hang() {
		items = new ArrayList<>();
	}

	public Gio_Hang(List<TT_HH_Mua> items) {
		super();
		this.items = items;
	}

	public List<TT_HH_Mua> getItems() {
		return items;
	}

	public void setItems(List<TT_HH_Mua> items) {
		this.items = items;
	}

	private TT_HH_Mua getHH_MuaByMa_hang(int ma_hang) {
		for (TT_HH_Mua i : items) {
			if (i.getHang_hoa().getMa_hang() == ma_hang) {
				return i;
			}
		}
		return null;
	}

	public int getSo_LuongByMa_hang(int ma_hang) {
		return getHH_MuaByMa_hang(ma_hang).getSo_luong();
	}

	public void addHH_Mua(TT_HH_Mua t) {
		if (getHH_MuaByMa_hang(t.getHang_hoa().getMa_hang()) != null) {
			TT_HH_Mua m = getHH_MuaByMa_hang(t.getHang_hoa().getMa_hang());
			m.setSo_luong(m.getSo_luong() + t.getSo_luong());
		} else {
			items.add(t);
		}
	}

	public void addHH_Mua(int ma_hang, int so_luong) {
		if (getHH_MuaByMa_hang(ma_hang) != null) {
			TT_HH_Mua m = getHH_MuaByMa_hang(ma_hang);
			m.setSo_luong(m.getSo_luong() + so_luong);
		}
	}

	public void xoa_HH_Mua(int ma_hang) {
		if (getHH_MuaByMa_hang(ma_hang) != null) {
			items.remove(getHH_MuaByMa_hang(ma_hang));
		}
	}

	public int getTong_Tien_GH() {
		int tong = 0;
		for (TT_HH_Mua i : items) {
			tong += i.getSo_luong() * i.getGia_ban();
		}
		return tong;
	}

	private Hang_Hoa getHang_HoaByMa_H(int ma_hang, List<Hang_Hoa> list) {
		for (Hang_Hoa i : list) {
			if (ma_hang == i.getMa_hang()) {
				return i;
			}
		}
		return null;
	}

	public Gio_Hang(String txt, List<Hang_Hoa> list) {
		items = new ArrayList<>();
		try {
			if (txt != null && txt.length() != 0) {
				String[] s = txt.split("\\*");
				for (String i : s) {
					String[] n = i.split(":");
					int ma_hang = Integer.parseInt(n[0]);
					int so_luong = Integer.parseInt(n[1]);
					Hang_Hoa hh = getHang_HoaByMa_H(ma_hang, list);
					TT_HH_Mua t = new TT_HH_Mua(hh, so_luong, hh.getGia_ban());
					addHH_Mua(t);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}
