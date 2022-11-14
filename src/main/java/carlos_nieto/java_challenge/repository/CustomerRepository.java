package carlos_nieto.java_challenge.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import carlos_nieto.java_challenge.model.Customer;

@Repository
public class CustomerRepository {
	
	private List<Customer> customers = new ArrayList<Customer>();

	/**
	 * 
	 */
	public CustomerRepository() {
		customers.add(new Customer(1L,"Alice",0));
		customers.add(new Customer(2L,"Bob",0));
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Customer> getCustomers() {
		return customers;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomer(Long id) {
		for (Customer cus : customers) {
			if(cus.getIdCustomer().equals(id)) {
				return cus;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	public Customer updateCustomer(Customer customer) {
		for (Customer cus : customers) {
			if(cus.getIdCustomer().equals(customer.getIdCustomer())) {
				cus = customer;
				return cus;
			}
		}
		return null;
	}

}
