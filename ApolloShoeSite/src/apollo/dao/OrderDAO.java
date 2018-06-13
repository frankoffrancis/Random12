package apollo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import apollo.model.Order;
import apollo.utils.OracleQueries;

public class OrderDAO {

	
	public List<Order> getAllOrderByCustomerID(Integer ID) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		Order order = new Order();
		List<Order> listOfOrder = new ArrayList<Order>();
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLORDERSBYCUSTOMERID);
			stmt.setInt(1, ID);
			result = stmt.executeQuery();
			
			while(result.next()) {
				
				order.setShoe_ID(result.getInt(1));
				
				order.setPrice(result.getDouble(4));
				order.setOrderQuantity(result.getInt(5));
				order.setSubTotal(result.getDouble(6));
				listOfOrder.add(order);
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
		return listOfOrder;
	}
	public Integer addOrder(Order orders) {
		Integer orderID = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String []order_ID = {"order_id"};
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.addOrder,order_ID);
			stmt.setInt(1, orders.getShoe_ID());
			stmt.setInt(2, orders.getCustomer_ID());
			stmt.setInt(3, orders.getOrderQuantity());
			stmt.setDouble(4, orders.getSubTotal());
			stmt.executeUpdate();
			result = stmt.getGeneratedKeys();
			if(result != null && result.next()) {
				orderID = result.getInt(1);
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderID;
	}
	
	public boolean deleteOrder(Integer ID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean isDeleted = false;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.deleteOrder);
			stmt.setInt(1, ID);
			isDeleted = stmt.executeUpdate() >0;
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isDeleted;
		
	}
	
	public Order getOrderByOrderID(Integer ID) throws SQLException {
		Order order = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			order = new Order();
			conn = OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETORDERBYID);
			stmt.setInt(1, ID);
			result = stmt.executeQuery();
			
			if( result != null && result.next()) {
				order.setShoe_ID(result.getInt(1));
				order.setCustomer_ID(result.getInt(2));
				order.setOrderQuantity(3);
				order.setSubTotal(result.getDouble(4));
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			result.close();
			if(stmt!=null ) {
				stmt.close();
				
			}
			if(conn !=null) {
				conn.close();
			}
		}
	return order;

	}	
}
