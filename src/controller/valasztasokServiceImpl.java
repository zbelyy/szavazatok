package controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.EgyeniJelolt;
import model.Part;

public class valasztasokServiceImpl extends ConnectionHandler implements ValasztasokService {

	ValasztasokDAO dao = new valasztasokDAOImpl();
	
	@Override
	public int getToredekszavazatByPart(Part p) {
		try{
			int toredekSzavazat=0;
			List<EgyeniJelolt> egyeniJelotlekListaja = null;
			for(int i = 1; i<=10 ; i++ ){
				egyeniJelotlekListaja = dao.getEgyeniJeloltByValsztokerulet(i);
				Map<EgyeniJelolt, Integer> jeloltMap = new HashMap<EgyeniJelolt, Integer>();
				Map.Entry<EgyeniJelolt, Integer> kepviselo = null;
				/*HasMap feltöltése*/
				for(EgyeniJelolt jelolt : egyeniJelotlekListaja){
					jeloltMap.put(jelolt, dao.getSzavazatCountByEgyeniJelolt(jelolt));
				}
				/*Kiszedjük melyik jelölt obj-nak van a legtöbb szavazata, hogy töröljük a listábol*/
				for(Map.Entry<EgyeniJelolt, Integer> jelolt : jeloltMap.entrySet()){
					if( kepviselo == null || (jelolt.getValue().compareTo(kepviselo.getValue())>0) ){
						kepviselo = jelolt;
					}
				}
				egyeniJelotlekListaja.remove(kepviselo.getKey());
				/**/
				for(EgyeniJelolt jelolt : egyeniJelotlekListaja){
					if(jelolt.getPart().equals(p)){
						toredekSzavazat+=jeloltMap.get(jelolt).intValue();
					}
				}
				egyeniJelotlekListaja.clear();
				kepviselo = null;
				jeloltMap = null;
				
			}
			
			return toredekSzavazat;
		}
		catch(Exception e){
			Logger.getLogger(Part.class.getName()).log(Level.SEVERE, null, e);
			return -1;
		}
	}

	@Override
	public Map<Part, Integer> getMandatum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Part getLegtobbMandatum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isParlamentiTobbseg(Part part) {
		// TODO Auto-generated method stub
		return false;
	}

}
