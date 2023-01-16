package one_to_one_uni1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pancard {
	@Id
	private String panid;
	private String name;
	private String address;
	
	public String getPanid() {
		return panid;
	}
	public void setPanid(String panid) {
		this.panid = panid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Pancard [panid=" + panid + ", name=" + name + ", address=" + address + "]";
	}
	
}
