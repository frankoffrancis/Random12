package apolloShoes.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import apollo.dao.CustomerDAO;
import apollo.dao.ShoesDAO;
import apollo.model.Customer;
import apollo.model.Order;
import apollo.model.Shoes;



@Controller
@RequestMapping("/")
@SessionAttributes("customerkey")
public class HomeController {

	private CustomerDAO customerDAO  = new CustomerDAO();
	private ShoesDAO shoesDAO = new ShoesDAO();
	private ModelAndView mav = null;
	private HttpSession session;
	private Shoes shoe  = new Shoes();;
	private Order order;
	@ModelAttribute("customerkey")
	public Customer setUpUserForm() {
		return new Customer();
	}
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("Index");
		return mav;
	}
	@RequestMapping("/register")
	public ModelAndView register()  {
		ModelAndView mav = new ModelAndView("Register");
		
		return mav;
	}
 /*@InitBinder
 public void initBinder(WebDataBinder binder) {
	 binder.set
 }*/
	@RequestMapping(value="/process-register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("customerkey")@Valid Customer customer,
			BindingResult errors) throws SQLException {
		ModelAndView mav = null;
		
		if(errors.hasErrors()) {		
			
			mav = new ModelAndView("Register");
			System.out.println("testing");
		return mav;
		}

		else { 
		customerDAO.registerCustomer(customer.getUserName(), customer.getPassword(), customer.getEmail());
		
		
		mav = new ModelAndView("redirect:Customer");
		}

	
		return mav;	
	}
	@RequestMapping("/login")
	public ModelAndView login()  {
	
			mav = new ModelAndView("Login");
			return mav;
		
		
	}
	
	@RequestMapping(value = "/process-login" , method = RequestMethod.POST)
	public ModelAndView login (@ModelAttribute("customerkey")@Valid Customer customer,
			BindingResult errors, HttpServletRequest req) throws SQLException{
		ModelAndView mav = null;

		
		customer = customerDAO.login(customer.getEmail(), customer.getPassword());
		
		if(customer !=null) {
			session = req.getSession();
			session.setAttribute("customerkey", customer);
		 mav = new ModelAndView("redirect:Customer");
		}
		else {
			mav = new ModelAndView("Login");
		}
		
 	return mav;
	}
	
	@RequestMapping("/Customer")
	public ModelAndView customer() {
		mav = new ModelAndView("Customer");
		return mav;
	}
	@RequestMapping("/about")
	public ModelAndView about() {
		mav = new ModelAndView("About");
		return mav;
	}
	@RequestMapping(value ="/modify", method = RequestMethod.GET)
	public ModelAndView user_info_modify() {
		ModelAndView mav = new ModelAndView("CustomerAccountModify");
		
		return mav;
	}
	@RequestMapping(value="/updatePassword", method = RequestMethod.POST)
	public ModelAndView user_info_changes(@ModelAttribute Customer customer,
			@SessionAttribute ("customerkey")Customer ckey,ModelAndView mav) throws SQLException {
		System.out.println("Hello");
		customer.setCustomerID(ckey.getCustomerID());
		
		boolean isUpdated = customerDAO.updatePassword(customer);
		if(isUpdated) {
			System.out.println("Teststdftdfgfdvfsdvv");
		mav.addObject("user_details", customerDAO.getCustomerByID(ckey.getCustomerID()));
		mav.setViewName("CustomerAccountModify");
		}
		return mav;
	}

	@RequestMapping(value= "shoes", method =RequestMethod.POST)
	public ModelAndView shoesPage(@ModelAttribute Shoes shoes,
			@SessionAttribute ("customerkey")Shoes ckey
			) 
	{
		
		
	
	}

}
}
