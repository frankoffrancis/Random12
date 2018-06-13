package Test;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import apollo.dao.CategoryDAO;
import apollo.model.Category;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CategoryDAOTest {

	@Test
	public void getAllCategoryTest() throws SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		Category category = new Category();
		List<Category>listOfCategory = new ArrayList<Category>();
		listOfCategory= categoryDAO.getallCategory();
		listOfCategory.add(category);
		String  apple = listOfCategory.toArray().toString();
		String []cat = {"business","outdoor","casual"};
		assertThat(cat, equalTo(apple.toString()));
	}
	
	@Test
	public void getCategoryByName() throws SQLException {
		CategoryDAO categoryDAO = new CategoryDAO();
		Category category = new Category();
		category =categoryDAO.getCategoryByName("business");
		String caetgoryName = "business";
		int id = 1;
		assertThat(id, equalTo(category.getCategoryID()));
		
	}
}
