package apollo.utils;

public class OracleQueries {

	public static final String REGISTERCUSTOMERS = "insert into customer "
			+ "(user_name, passwords, email) "
			+ "values (?,?,?)";
	
	public final static String DELTECUSTOMER= "delete from customer "
			+ "where customer_id = ?";
	public final static String GETCUSTOMERBYEMAIL = " select  * from customer "
			+ " where email = ?";
	public final static String UPDATECUSTOMER = "update customer "
			+ "set user_name = ?, "
			+ " password = ?, "
			+ " email = ? "
			+ "where customer_id=?";
	public final static String GETCUSTOMERBYID = "select customer.user_name, customer.passwords, customer.email from customer "
			+ " where customer_id = ? ";
	
	public final static String GETALLSHOES = "select shoes.shoe_name,  category_table.category_name, shoes.shoe_size, shoes.price, shoes.gender "
			+ "from shoes shoes"
			+ " join category_table on shoes.CATEGORY_ID= category_table.CATEGORY_ID ";
	
	
	public final static String GETALLSHOESBYCATEGORYID = "select shoe_name,  category_name, shoe_size, price, gender "
			+ "from shoes "
			+ " join category_table on shoes.CATEGORY_ID= category_table.CATEGORY_ID "
			+ " where category_table.category_id = ?";
	
	public final static String GETALLSHOESBYGENDER = "select shoe_name,  category_name, shoe_size, price, gender "
			+ "from shoes "
			+ " join category_table on shoes.CATEGORY_ID= category_table.CATEGORY_ID "
			+ " where shoes.GENDER  = ?";
	public final static String GETALLSHOESBYSIZE = "select shoe_name,  category_name, shoe_size, price, gender "
			+ "from shoes "
			+ " join category_table on shoes.CATEGORY_ID= category_table.CATEGORY_ID "
			+ " where shoes.Shoe_size  = ?";
	
	public final static String GETALLSHOESBYPRICE = "select shoe_name,  category_name, shoe_size, price, gender "
			+ "from shoes "
			+ "join  category_table on shoes.CATEGORY_ID= category_table.CATEGORY_ID "
			+ " where shoes.price  = ?";
	public final static String GETALLSHOESBYPRICERANGE = "select shoe_name,  category_name, shoe_size, price, gender "
			+ "from shoes "
			+ " join category_table on shoes.CATEGORY_ID= category_table.CATEGORY_ID "
			+ " where shoes.price  > ?";
	
	public final static String GETSHOEBYNAME = "select category_name, shoe_name, shoe_size, price, gender " + 
			"from shoes join category_table on shoes.CATEGORY_ID= category_table.CATEGORY_ID " + 
			"where lower (shoes.shoe_name) like lower ('?%') ";
	
	public final  static String GETALLCATEGORY = "select category_id, category_name from category_table ";
	
	public final static String GETCATEGORYBYNAME = "select category_id, category_name from category_table "
			+ "where category_name = ? ";
	
	public final static String GETALLORDERSBYCUSTOMERID = "select sh.shoe_id,ca.category_name,sh.price,ord.order_quantity,ord.subtotal " + 
			"from order_table ord " + 
			"join shoes sh on sh.SHOE_ID= ord.SHOE_ID " + 
			"join category_table ca on ca.category_id = ord.CATEGORY_ID " + 
			"where ord.CUSTOMER_ID = ?";
	
	public static final String addOrder = "insert into " + 
			"  order_table " + 
			"set " + 
			"  shoe_id = ?, " + 
			"  customer_id = ?, " + 
			"  order_quantity = ?, " + 
			"  subtotal = ? " ;
	
	public static final String deleteOrder = " delete from order_table "
			+ " where order_id = ?";
	
	public final static String GETORDERBYID = "SELECT * FROM order_table "
			+ "WHERE order_id = ?";
	public static final String UPDATEPASSWORD = "update customer"
			+ "set passwords = ? "
			+ "where customer_id = ?";
}
