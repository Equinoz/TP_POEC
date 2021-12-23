package ihm;

import java.util.ArrayList;
import java.util.List;

import bo.Sceance;

public class SceanceModel {
	private Sceance curent = new Sceance();
	private List<Sceance> list = new ArrayList<>();
	private String jSonListAllSceance = "";
	
	
	/**
	 * @param curent
	 * @param list
	 * @param jSonListAllSceance
	 */
	public SceanceModel(Sceance curent, List<Sceance> list, String jSonListAllSceance) {
		this.curent = curent;
		this.list = list;
		this.jSonListAllSceance = jSonListAllSceance;
	}
	public SceanceModel(Sceance curent, List<Sceance> list) {
		super();
		this.curent = curent;
		this.list = list;
	}
	public SceanceModel() {
		
	}
	
	/**
	 * @return the jSonListAllSceance
	 */
	public String getjSonListAllSceance() {
		return jSonListAllSceance;
	}
	/**
	 * @param jSonListAllSceance the jSonListAllSceance to set
	 */
	public void setjSonListAllSceance(String jSonListAllSceance) {
		this.jSonListAllSceance = jSonListAllSceance;
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
		return "SceanceModel [curent=" + curent + ", list=" + list + ", jSonListAllSceance=" + jSonListAllSceance + "]";
	}

	
}
