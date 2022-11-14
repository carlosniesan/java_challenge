package carlos_nieto.java_challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carlos_nieto.java_challenge.model.Customer;
import carlos_nieto.java_challenge.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * Method to get a list of customers
	 * @return List<Customer>
	 */
	public List<Customer> listCustomer(){	
		return customerRepository.getCustomers();
	}
	
	/**
	 * Method to get a customers from the idCustomer
	 * @param idCustomer
	 * @return Car
	 */
	public Customer getCustomer(Long idCustomer) {
		return customerRepository.getCustomer(idCustomer);
	}
	
	/**
	 * Method to update a customer
	 * @param Customer
	 * @return Customer
	 */
	public Customer updateCustomer(Customer customer) {
		return customerRepository.updateCustomer(customer);
	}
}
