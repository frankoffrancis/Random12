package Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import apollo.dao.CustomerDAO;
import apollo.model.Customer;

public class CustomerDAOTest {
	
	@Before
	public void testPrep() {
		
		
	}
	
	@Test
	public void gettingCustomerByIDTest() throws SQLException {
		Integer id = 1;
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		String actualEmail= "tim@gmail.com";
		customer =customerDAO.getCustomerByID(id);
		
		assertThat(actualEmail, equalTo(customer.getEmail()));
	}
/*	@Test
	public void registerCustomerTest() throws SQLException {
		CustomerDAO customerDAO = new CustomerDAO();
		//Customer customer = new Customer();
		boolean isLoggedIn= false;
		isLoggedIn =customerDAO.registerCustomer("kate", "kate12", "kate@gmail.com");
		
		assertThat(true, equalTo((isLoggedIn)));
	}*/
/*	@Test
	public void deleteCustomerTest() throws SQLException {
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		boolean isdelted = false;
		isdelted =customerDAO.deleteCustomer(7);
		
		assertThat(true, equalTo(isdelted));
		
	}*/
	@Test
	public void loginCustomerTest() throws SQLException {
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		customer =customerDAO.login("tim@gmail.com", "tim123");
		String email = "tim@gmail.com";
		String password = "tim123";
		String userName ="tim";
		
		assertThat(userName, equalTo(customer.getUserName()));
		assertThat(email, equalTo(customer.getEmail()));
		assertThat(password, equalTo(customer.getPassword()));
	}

	@Test
	public void validateCustomerEmailTest() throws SQLException{
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		customer.setEmail("tim@gmail.com");
		String email = "tim@gmail.com";
		boolean isValid = false;
		isValid = customerDAO.validateUserEmail(customer.getEmail(), email);
		assertThat(true, equalTo(isValid));
		
	}
	
	@Test
	public void validateCustomerUserNameTest() throws SQLException{
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = new Customer();
		customer.setPassword("tim123");
		String user = "tim123";
		boolean isValid = false;
		isValid = customerDAO.validateUserPass(customer.getPassword(), user);
		assertThat(true, equalTo(isValid));
		
	}
}
