package apollo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apollo.model.Category;
import apollo.utils.OracleQueries;

public class CategoryDAO {

	public List<Category> getallCategory() throws SQLException{
		Category category = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Category> listOfCategory = new ArrayList<Category>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLCATEGORY);
			result = stmt.executeQuery();
			
			while(result!=null && result.next()) {
				category = new Category();
				category.setCategoryID(result.getInt(1));
				category.setCategoryName(result.getString(2));
				listOfCategory.add(category);
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
		return listOfCategory;
	}

	public Category getCategoryByName(String categoryName) throws SQLException {
		Category category = new Category();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETCATEGORYBYNAME);
			stmt.setString(1, categoryName);
			result = stmt.executeQuery();
			if(result!=null && result.next()) {
				category.setCategoryID(result.getInt(1));
				category.setCategoryName(result.getString(2));
				
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
		
		return category;
	}
	
	
}
