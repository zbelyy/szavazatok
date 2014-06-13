package model;

public class Szavazat {

	private int szavazatazon;
	private Part part;
	private EgyeniJelolt egyenijelolt;
	
	public Szavazat() {
	
	}

	public Szavazat(int szavazatazon, Part part, EgyeniJelolt egyenijelolt) {
		super();
		this.szavazatazon = szavazatazon;
		this.part = part;
		this.egyenijelolt = egyenijelolt;
	}

	public int getSzavazatazon() {
		return szavazatazon;
	}

	public void setSzavazatazon(int szavazatazon) {
		this.szavazatazon = szavazatazon;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public EgyeniJelolt getEgyenijelolt() {
		return egyenijelolt;
	}

	public void setEgyenijelolt(EgyeniJelolt egyenijelolt) {
		this.egyenijelolt = egyenijelolt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Szavazat other = (Szavazat) obj;
		if (szavazatazon != other.szavazatazon)
			return false;
		return true;
	}
	
	
	
}
