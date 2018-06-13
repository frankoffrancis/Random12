package apollo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import apollo.model.Customer;
import apollo.utils.OracleQueries;
import apollo.dao.OracleConnection;

public class CustomerDAO {

	// creating a new customer
	public boolean registerCustomer(String userName, String password, String email) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean isRegistered = false;
		String [] cus = {"customer_ID"};
		ResultSet result = null;
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.REGISTERCUSTOMERS,cus);
			
			stmt.setString(1, userName);
			stmt.setString(2, password);
			stmt.setString(3, email);
			stmt.executeUpdate();
			result = stmt.getGeneratedKeys();
			
			if(result!=null && result.next()) {
				isRegistered = true;
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
		
			e.printStackTrace();
		}finally {
			result.close();
			if(stmt!=null ) {
				stmt.close();
				
			}
			if(conn !=null) {
				conn.close();
			}
		}
		return isRegistered;
	}
	
	// Deleting a customer
	public boolean  deleteCustomer(Integer id) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean isDeleted = false;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.DELTECUSTOMER);
			stmt.setInt(1, id);
			isDeleted = stmt.executeUpdate() >0;
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
	}
	//login
	public Customer login(String email, String password) throws SQLException {
		Customer customer = null;
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn= OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETCUSTOMERBYEMAIL);
			stmt.setString(1, email);
			result = stmt.executeQuery();
			if(result!=null && result.next()) {
				if(password.equals(result.getString(3))) {
					customer = new Customer();
					customer.setCustomerID(result.getInt(1));
					customer.setUserName(result.getString(2));
					customer.setPassword(result.getString(3));
					customer.setEmail(result.getString(4));
				}
				
				
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			result.close();
			if(stmt!=null ) {
				stmt.close();
				
			}
			if(conn !=null) {
				conn.close();
			}
		}
		
		return customer;
	}
	//update
	public boolean updateCustomer(Customer customer) throws SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean isUpdated = false;
		String [] cus = {"customer_id"};
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.UPDATECUSTOMER, cus);
			stmt.setString(1, customer.getUserName());
			stmt.setString(2, customer.getPassword());
			stmt.setString(3, customer.getEmail());
			
			isUpdated = stmt.executeUpdate() >0;
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(stmt!=null ) {
				stmt.close();
				
			}
			if(conn !=null) {
				conn.close();
			}
		}
		
		return isUpdated;
	}
	public boolean validateUserEmail(String emailToValidate, String compareableEmail) {
		boolean validEmail = false;
		
		if(emailToValidate.equals(compareableEmail)) {
			validEmail = true;
		}
		return validEmail;
	}
	
	public boolean validateUserPass(String passToValidate, String compareablePass) {
		boolean validPass = false;
		
		if(passToValidate.equals(compareablePass)) {
			validPass = true;
		}
		return validPass;
	}
	//get a customer
	public Customer getCustomerByID(Integer id) throws SQLException {
		
		Customer customer = new Customer();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETCUSTOMERBYID);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			
			if( result != null && result.next()) {
			
				customer.setUserName(result.getString(1));
				customer.setPassword(result.getString(2));
				customer.setEmail(result.getString(3));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			result.close();
			if(stmt!=null ) {
				stmt.close();
				
			}
			if(conn !=null) {
				conn.close();
			}
		}
		
		return customer;
	}
	/*public boolean validateLogin(String email, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		boolean isvalid =false;
		
	}
	 */
}
