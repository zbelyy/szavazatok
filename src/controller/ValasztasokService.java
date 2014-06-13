package controller;

import java.util.Map;

import model.Part;

public interface ValasztasokService {


	/**
	 *	Metódus, mely kiszámítja, hogy egy párt mennyi töredékszavazatot kapott összesen.
	 *	Segítség: A töredékszavazatok számításánál már lesznek olyan egyéni jelöltek akikről tudjuk, hogy mandátumot kapnak.
	 */
	public int getToredekszavazatByPart(Part p);

	/**
	 * Metódus, mely visszadja, hogy az egyes pártok mennyi mandátumot gyűjtöttek.
	 */
	public Map<Part,Integer> getMandatum();

	/**
	 * Metódus, mely visszadja, a legtöbb mandátumot kapott pártot.
	 */
	public Part getLegtobbMandatum();

	/**
	 * Metódus, mely akkor ad vissza igaz értéket, ha a paraméterként megadott párt parlamenti többségben van, azaz birtokolja a mandátumok 50 százalékát + 1 szavazatot.
	 */
	public boolean isParlamentiTobbseg(Part part);
}
