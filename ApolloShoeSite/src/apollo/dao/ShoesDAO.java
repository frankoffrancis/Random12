package apollo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apollo.model.Shoes;
import apollo.utils.OracleQueries;


public class ShoesDAO {

	
	public List<Shoes> getAllShoes() throws SQLException{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Shoes> listOfShoes = new ArrayList<Shoes>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLSHOES);
			result = stmt.executeQuery();
			
			while(result.next()) {
				Shoes shoes = new Shoes();
				shoes.setShoeName(result.getString(1));
				shoes.setCategoryName(result.getString(2));
				shoes.setShoeSize(result.getInt(3));
				shoes.setPrice(result.getDouble(4));
			
				shoes.setGender(result.getString(5));
				listOfShoes.add(shoes);
				
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
		
		return listOfShoes;
	}
	
	public List<Shoes> getAllShoesByCategoryID(int ID) throws SQLException{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Shoes> listOfShoes = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLSHOESBYCATEGORYID);
			stmt.setInt(1, ID);
			result = stmt.executeQuery();
			
			while(result !=null && result.next()) {
				Shoes shoes = new Shoes();
				listOfShoes = new ArrayList<Shoes>();
				shoes.setShoeName(result.getString(1));
				shoes.setCategoryName(result.getString(2));
				shoes.setShoeSize(result.getInt(3));
				shoes.setPrice(result.getDouble(4));
			
				shoes.setGender(result.getString(5));
				listOfShoes.add(shoes);
				
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
		
		return listOfShoes;
			
	}
	public List<Shoes> getAllShoesByGender(String gender) throws SQLException{
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Shoes> listOfShoes = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLSHOESBYGENDER);
			stmt.setString(1, gender.toLowerCase());
			result = stmt.executeQuery();
			
			while(result !=null && result.next()) {
				Shoes shoes = new Shoes();
				listOfShoes = new ArrayList<Shoes>();
				shoes.setShoeName(result.getString(1));
				shoes.setCategoryName(result.getString(2));
				shoes.setShoeSize(result.getInt(3));
				shoes.setPrice(result.getDouble(4));
			
				shoes.setGender(result.getString(5));
				listOfShoes.add(shoes);
				
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
		
		return listOfShoes;
			
	}
	
	public List<Shoes> getAllShoesBySize(int size) throws SQLException{
		Shoes shoes = new Shoes();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Shoes> listOfShoes = new ArrayList<Shoes>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLSHOESBYSIZE);
			stmt.setInt(1, size);
			result = stmt.executeQuery();
			
			while(result !=null && result.next()) {
				
				shoes.setShoeName(result.getString(1));
				shoes.setCategoryName(result.getString(2));
				shoes.setShoeSize(result.getInt(3));
				shoes.setPrice(result.getDouble(4));
			
				shoes.setGender(result.getString(5));
				listOfShoes.add(shoes);
				
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
		
		return listOfShoes;
			
	}
	
	public List<Shoes> getAllShoesByPrice(int price) throws SQLException{
		Shoes shoes = new Shoes();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Shoes> listOfShoes = new ArrayList<Shoes>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLSHOESBYPRICE);
			stmt.setInt(1, price);
			result = stmt.executeQuery();
			
			while(result !=null && result.next()) {
				
				shoes.setShoeName(result.getString(1));
				shoes.setCategoryName(result.getString(2));
				shoes.setShoeSize(result.getInt(3));
				shoes.setPrice(result.getDouble(4));
			
				shoes.setGender(result.getString(5));
				listOfShoes.add(shoes);
				
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
		
		return listOfShoes;
			
	}
	
	public List<Shoes> getAllShoesByPriceRange(int price) throws SQLException{
		Shoes shoes = new Shoes();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Shoes> listOfShoes = new ArrayList<Shoes>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLSHOESBYPRICERANGE);
			stmt.setInt(1, price);
			result = stmt.executeQuery();
			
			while(result !=null && result.next()) {
				
				shoes.setShoeName(result.getString(1));
				shoes.setCategoryName(result.getString(2));
				shoes.setShoeSize(result.getInt(3));
				shoes.setPrice(result.getDouble(4));
			
				shoes.setGender(result.getString(5));
				listOfShoes.add(shoes);
				
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
		
		return listOfShoes;
			
	}
	
	public Shoes getShoeByName(String shoeName) throws SQLException {
		Shoes shoes = new Shoes();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETSHOEBYNAME);
			stmt.setString(1, shoeName);
			result = stmt.executeQuery();
			
			if (result.next() && result !=null) {
				shoes.setShoeName(result.getString(1));
				shoes.setCategoryName(result.getString(2));
				shoes.setShoeSize(result.getInt(3));
				shoes.setPrice(result.getDouble(4));
			
				shoes.setGender(result.getString(5));
				
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
		return shoes;
	}
}