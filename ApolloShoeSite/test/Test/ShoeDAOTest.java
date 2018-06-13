package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import apollo.dao.ShoesDAO;
import apollo.model.Shoes;

public class ShoeDAOTest {

/*	
	@Test
	public void getAllShoesByGenderTest() throws SQLException {
		ShoesDAO shoesDAO = new ShoesDAO();
		List<Shoes> listShoes = new ArrayList<Shoes> ();
		
		listShoes = shoesDAO.getAllShoesByGender("male");
		for(Shoes s  : listShoes) {
		System.out.println(s.getShoeName()+" "+ s.getCategoryName()+  " "+s.getShoeSize()+" "+s.getGender());
	}
	}
	

		
	
	@Test
	public void getAllShoesTest() throws SQLException {
		ShoesDAO shoesDAO = new ShoesDAO();

		List<Shoes> listShoes = new ArrayList<Shoes> ();
		
		listShoes = shoesDAO.getAllShoes();
		for(Shoes s  : listShoes) {
		System.out.println(s.getShoeName()+" "+ s.getCategoryName()+  " "+s.getShoeSize()+" "+s.getGender());
		}
	}
	

		
	*/
/*	@Test
	public void getALLShoeByPriceRangeTest() throws SQLException {
		ShoesDAO shoesDAO = new ShoesDAO();
		Shoes shoes = new Shoes();
		List<Shoes> listShoes = new ArrayList<Shoes> ();
		listShoes = shoesDAO.getAllShoesByPriceRange(100);
		
		listShoes.add(shoes);
		for(Shoes s  : listShoes) {
			System.out.println(s.getShoeName()+" "+s.getPrice()+" "+s.getGender());
		}
		
		
	}*/
	@Test
	public void getALLShoeByID() throws SQLException {
		ShoesDAO shoesDAO = new ShoesDAO();
		List<Shoes> listShoes = new ArrayList<Shoes> ();
		listShoes = shoesDAO.getAllShoesByCategoryID(2);
		Shoes s;
		s = listShoes.get(0);
		//for(Shoes s  : listShoes) 
		System.out.println(s.getShoeName()+" "+s.getPrice()+" "+s.getGender());
		s = listShoes.get(1);
		System.out.println(s.getShoeName()+" "+s.getPrice()+" "+s.getGender());
		
		
		
	}
}

