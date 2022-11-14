package carlos_nieto.java_challenge.model;


public class Customer {
	
	private Long idCustomer;
	private String name;
	private Integer loyalPoints;
	
	public Customer(Long idCustomer, String name, Integer points) {
		super();
		this.idCustomer = idCustomer;
		this.name = name;
		this.loyalPoints = points;
	}

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLoyalPoints() {
		return loyalPoints;
	}

	public void setLoyalPoints(Integer loyalPoints) {
		this.loyalPoints = loyalPoints;
	}
	
	
	
	
}
