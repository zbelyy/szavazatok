package model;

public class Part{

	private int partazon;
	private String partnev;
	private String rovidites;
	
	public Part() {
	}
	
	public Part(int partazon, String partnev, String rovidites) {
		super();
		this.partazon = partazon;
		this.partnev = partnev;
		this.rovidites = rovidites;
	}
	
	public int getPartazon() {
		return partazon;
	}
	
	public void setPartazon(int partazon) {
		this.partazon = partazon;
	}
	
	public String getPartnev() {
		return partnev;
	}
	
	public void setPartnev(String partnev) {
		this.partnev = partnev;
	}
	
	public String getRovidites() {
		return rovidites;
	}
	
	public void setRovidites(String rovidites) {
		this.rovidites = rovidites;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Part other = (Part) obj;
		if (partazon != other.partazon)
			return false;
		return true;
	}
	
	
	
}
