package carlos_nieto.java_challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carlos_nieto.java_challenge.model.Customer;
import carlos_nieto.java_challenge.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * Method to get a list of Customers
	 * @return List<Customer>
	 */
	@GetMapping("/listCustomer")
	public List<Customer> listCustomer(){	
		return customerService.listCustomer();
	}
		
}
