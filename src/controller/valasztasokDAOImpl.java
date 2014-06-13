package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

import model.EgyeniJelolt;
import model.Part;

public class valasztasokDAOImpl extends ConnectionHandler implements ValasztasokDAO{
	protected Connection conn = ConnectionHandler.getConnection();
	@Override
	public Part getPartByAzon(int azon) {
		String SQLText = String.format("select * from valasztas.partok where PART_AZON=%d", azon);
		try{
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery(SQLText);
        rs.next();
		return new Part(rs.getInt("PART_AZON"), rs.getString("PART_NEV"), rs.getString("ROVIDITES"));
		}catch(Exception e){
			Logger.getLogger(Part.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
	}

	@Override
	public EgyeniJelolt getEgyeniJeloltByAzon(int azon) {
		String SQLText = String.format("select * from valasztas.egyeni_jeloltek where jelolt_azon=%d", azon);
		try{
	        Statement stmnt = conn.createStatement();
	        ResultSet rs = stmnt.executeQuery(SQLText);
	        rs.next();
	        
			return new EgyeniJelolt(rs.getInt("JELOLT_AZON"), rs.getString("JELOLT_NEV"), rs.getInt("VALASZTO_KERULET"), getPartByAzon(rs.getInt("PART")));
		}catch (Exception e){
			Logger.getLogger(Part.class.getName()).log(Level.SEVERE, null, e);
		return null;}
	}

	@Override
	public List<EgyeniJelolt> getEgyeniJeloltByValsztokerulet(int valsztokerulet) {
		String SQLText = String.format("select * from valasztas.egyeni_jeloltek where VALASZTO_KERULET=%d", valsztokerulet);
		try{
			List<EgyeniJelolt> jeloltLista = new ArrayList<>();
	        Statement stmnt = conn.createStatement();
	        ResultSet rs = stmnt.executeQuery(SQLText);
	        while(rs.next()){
	        
			jeloltLista.add(new EgyeniJelolt( rs.getInt("JELOLT_AZON"), rs.getString("JELOLT_NEV"), rs.getInt("VALASZTO_KERULET"), getPartByAzon(rs.getInt("PART"))));
	        }
			return jeloltLista;
	        
		}catch (Exception e){
			Logger.getLogger(Part.class.getName()).log(Level.SEVERE, null, e);
		return null;}
	}

	@Override
	public int getSzavazatCountByPart(Part part) {
		int szam = part.getPartazon();
		String SQLText = String.format("select count( PART ) as total from VALASZTAS.SZAVAZATOK where PART=%d", szam );
		int count = 0;
		try{
	        Statement stmnt = conn.createStatement();
	        ResultSet rs = stmnt.executeQuery(SQLText);
	        while(rs.next()){
	        	count = rs.getInt("total");
	        }
	        
			return count;
		}catch (Exception e){
			Logger.getLogger(Part.class.getName()).log(Level.SEVERE, null, e);
		return 0;}
	}

	@Override
	public int getSzavazatCountByEgyeniJelolt(EgyeniJelolt jelolt) {
		int szam = jelolt.getJeloltazon();
		String SQLText = String.format("select count( EGYENI_JELOLT ) as total from VALASZTAS.SZAVAZATOK where EGYENI_JELOLT=%d", szam );
		int count = 0;
		try{
	        Statement stmnt = conn.createStatement();
	        ResultSet rs = stmnt.executeQuery(SQLText);
	        while(rs.next()){
	        	count = rs.getInt("total");
	        }
	        
			return count;
		}catch (Exception e){
			Logger.getLogger(Part.class.getName()).log(Level.SEVERE, null, e);
		return 0;}
	}
	
	

}
