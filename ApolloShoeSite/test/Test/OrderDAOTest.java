package Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import apollo.dao.OrderDAO;
import apollo.model.Order;
public class OrderDAOTest {

	private OrderDAO orderDAO;
	private Order order;

	
	
	@Before
	public void testPrep() {
		
		order= new Order();
		orderDAO = new OrderDAO();
		order.setCustomer_ID(1);
		order.setShoe_ID(1);
		order.setOrderQuantity(12);
		order.setPrice(180.0);
		order.setSubTotal(order.getPrice()* order.getOrderQuantity());
		orderDAO.addOrder(order);
		
		order = new Order();
		order.setCustomer_ID(2);
		order.setShoe_ID(2);
		order.setOrderQuantity(3);
		order.setPrice(139.95);
		order.setSubTotal(order.getPrice()* order.getOrderQuantity());
		
		order = new Order();
		order.setCustomer_ID(21);
		order.setShoe_ID(3);
		order.setOrderQuantity(3);
		order.setPrice(415.00);
		order.setSubTotal(order.getPrice()* order.getOrderQuantity());
	}
	@Test
	public void getOrderTableByIdTest() throws SQLException {
		order = orderDAO.getOrderByOrderID(2);
		assertThat(order.getSubTotal(), equalTo(2160.0));
	}
}
