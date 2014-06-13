package view;


import java.util.ArrayList;
import java.util.List;

import model.EgyeniJelolt;
import model.Part;
import controller.ValasztasokDAO;
import controller.ValasztasokService;
import controller.valasztasokServiceImpl;
import controller.valasztasokDAOImpl;



public class Fire {
		
		public static void main(String args[])
		{
			Part P1 = new Part();
			ValasztasokDAO dao = new valasztasokDAOImpl();
			P1 = dao.getPartByAzon(6);
			/*System.out.println(P1.getPartnev());
			
			EgyeniJelolt P2 = new EgyeniJelolt();
			P2 = dao.getEgyeniJeloltByAzon(1);
			System.out.println(P2.getJeloltnev());
			
			List<EgyeniJelolt> P3 = new ArrayList<>();
			P3 = dao.getEgyeniJeloltByValsztokerulet(10);
			for (EgyeniJelolt egyen:P3 ){
				System.out.println(egyen.getJeloltnev());
			}
			
			int P4 = dao.getSzavazatCountByPart(P1);
			System.out.println(P4);
			
			int P5 = dao.getSzavazatCountByEgyeniJelolt(P2);
			System.out.println(P5);*/
			
			ValasztasokService valasztasokService = new valasztasokServiceImpl();
			System.out.println(valasztasokService.getToredekszavazatByPart(P1));
		}
}
