package carlos_nieto.java_challenge.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Rent {

	private Long idRent;

	private Long idCar;
	private Car car;
	private Long idCustomer;
	private Customer customer;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateRentIni;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateRentEnd;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateRentReturn;

	private Integer days;
	private Double price;
	private Integer daysExtra;
	private Double surcharges;

	

	public Long getIdRent() {
		return idRent;
	}

	public void setIdRent(Long id) {
		this.idRent = id;
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Integer getDaysExtra() {
		return daysExtra;
	}

	public void setDaysExtra(Integer daysExtra) {
		this.daysExtra = daysExtra;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSurcharges() {
		return surcharges;
	}

	public void setSurcharges(Double surcharges) {
		this.surcharges = surcharges;
	}

	public Date getDateRentIni() {
		return dateRentIni;
	}

	public void setDateRentIni(Date dateRentIni) {
		this.dateRentIni = dateRentIni;
	}

	public Date getDateRentEnd() {
		return dateRentEnd;
	}

	public void setDateRentEnd(Date dateRentEnd) {
		this.dateRentEnd = dateRentEnd;
	}

	public Date getDateRentReturn() {
		return dateRentReturn;
	}

	public void setDateRentReturn(Date dateRentReturn) {
		this.dateRentReturn = dateRentReturn;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
