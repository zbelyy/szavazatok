package controller;

import java.util.List;

import model.EgyeniJelolt;
import model.Part;


public interface ValasztasokDAO {


	/**
	 * 	Metódus, mely visszadja az adott azonosítóhoz tartozó pártot.
	 */
	public Part getPartByAzon(int azon);

	/**
	 * 	Metódus, mely visszadja az adott azonosítóhoz tartozó egyéni jelöltet.
	 */
	public EgyeniJelolt getEgyeniJeloltByAzon(int azon);

	/**
	 * Metódus, mely visszadja az adott válsztó kerülethez tartozó jelöltek listáját.
	 */
	public List<EgyeniJelolt> getEgyeniJeloltByValsztokerulet(int valsztokerulet);

	/**
	 * Metódus, mely visszaadja, hogy egy adott párt mennyi szavazatot kapott.
	 */
	public int getSzavazatCountByPart(Part part);

	/**
	 * Metódus, mely visszaadja, hogy egy adott egyéni jelölt mennyi szavazatot kapott.
	 */
	public int getSzavazatCountByEgyeniJelolt(EgyeniJelolt jelolt);


}
