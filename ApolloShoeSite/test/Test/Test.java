package Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apollo.dao.CategoryDAO;
import apollo.dao.CustomerDAO;
import apollo.model.Category;
import apollo.model.Customer;



public class Test {

	public static void main(String[] args) throws SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		Category category = new Category();
		List<Category>listOfCategory = new ArrayList<Category>();
		listOfCategory= categoryDAO.getallCategory();
		listOfCategory.add(category);
		
		for(Category c : listOfCategory) {
			System.out.println(c.getCategoryName());
			
		}
	}
}
