package ihm;

import java.util.ArrayList;
import java.util.List;

import bo.Sceance;

public class SceanceModel {
	private Sceance curent = new Sceance();
	private List<Sceance> list = new ArrayList<>();
	public SceanceModel(Sceance curent, List<Sceance> list) {
		super();
		this.curent = curent;
		this.list = list;
	}
	public SceanceModel() {
		
	}
	public Sceance getCurent() {
		return curent;
	}
	public void setCurent(Sceance curent) {
		this.curent = curent;
	}
	public List<Sceance> getList() {
		return list;
	}
	public void setList(List<Sceance> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "SceanceModel [curent=" + curent + ", list=" + list + "]";
	}

	
}
