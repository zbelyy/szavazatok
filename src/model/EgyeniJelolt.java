package model;

public class EgyeniJelolt {

	private int jeloltazon;
	private String jeloltnev;
	private int valsztokerulet;
	private Part part;
	
	public EgyeniJelolt() {
	}

	public EgyeniJelolt(int jeloltazon, String jeloltnev,
			int valsztokerulet, Part part) {
		super();
		this.jeloltazon = jeloltazon;
		this.jeloltnev = jeloltnev;
		this.valsztokerulet = valsztokerulet;
		this.part = part;
	}

	public int getJeloltazon() {
		return jeloltazon;
	}

	public void setJeloltazon(int jeloltazon) {
		this.jeloltazon = jeloltazon;
	}

	public String getJeloltnev() {
		return jeloltnev;
	}

	public void setJeloltnev(String jeloltnev) {
		this.jeloltnev = jeloltnev;
	}

	public int getValsztokerulet() {
		return valsztokerulet;
	}

	public void setValsztokerulet(int valsztokerulet) {
		this.valsztokerulet = valsztokerulet;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EgyeniJelolt other = (EgyeniJelolt) obj;
		if (jeloltazon != other.jeloltazon)
			return false;
		return true;
	}
	
	
}
