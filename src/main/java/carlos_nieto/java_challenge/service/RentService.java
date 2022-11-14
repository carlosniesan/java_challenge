package carlos_nieto.java_challenge.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import carlos_nieto.java_challenge.model.Customer;
import carlos_nieto.java_challenge.model.Rent;
import carlos_nieto.java_challenge.model.TypeCar;
import carlos_nieto.java_challenge.repository.RentRepository;

@Service
public class RentService {

	private static final int TYPE_PREMIUM = 1;
	private static final int TYPE_SUV = 2;
	private static final int TYPE_SMALL = 3;

	private static final int DAYS_7 = 7;
	private static final int DAYS_30 = 30;

	private static final double PERCENT_80 = 0.8;
	private static final double PERCENT_60 = 0.6;
	private static final double PERCENT_50 = 0.5;

	private static final double EXTRA_PREMIUM = 1.2;
	private static final double EXTRA_SUV = 1.6;
	private static final double EXTRA_SMALL = 1.3;

	@Autowired
	private RentRepository rentRepository;
	
	@Autowired
	private CarService carService;

	@Autowired
	private CustomerService customerService;

	/**
	 * Method to get a list of Rent
	 * @return
	 */
	public List<Rent> listRents() {
		return rentRepository.getRents();
	}

	/**
	 * Method to get a rental from the idRent
	 * @param idRent
	 * @return
	 */
	public Rent getRent(Long idRent) {
		Rent rent = rentRepository.getRent(idRent);
		rent.setCar(carService.getCar(rent.getIdCar()));
		rent.setCustomer(customerService.getCustomer(rent.getIdCustomer()));
		return rent;
	}

	/**
	 * Method to make a rental
	 * @param rent
	 * @return
	 */
	public Rent rentCar(@RequestBody Rent rent) {
		try {
			rent.setDays(calcDiffDates(rent.getDateRentEnd(), rent.getDateRentIni()));
			rent.setCar(carService.getCar(rent.getIdCar()));
			rent.setPrice(this.calcPrice(rent.getCar().getTypeCar(), rent.getDays()));
			Customer customer = customerService.getCustomer(rent.getIdCustomer());
			customer.setLoyalPoints(customer.getLoyalPoints() + rent.getCar().getTypeCar().getPoints());
			rent.setCustomer(customer);
			customerService.updateCustomer(customer);
			rentRepository.addRent(rent);
		} catch (Exception e) {
			return null;
		}
		return rent;
	}

	/**
	 * Method to make a rent return
	 * @param r
	 * @return
	 */
	public Rent returnCar(@RequestBody Rent r) {
		Rent rent = null;
		try {
			rent = this.getRent(r.getIdRent());
			if (rent.getDateRentReturn() == null) {
				rent.setDateRentReturn(r.getDateRentReturn());
				rent.setDaysExtra(calcDiffDates(rent.getDateRentReturn(), rent.getDateRentEnd()));
				rent.setSurcharges(this.calcSurcharge(rent.getCar().getTypeCar(), rent.getDaysExtra()));
			}
			else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		return rent;
	}

	/**
	 * Calculate the difference in days of two dates
	 * @param dateIni
	 * @param dateEnd
	 * @return
	 */
	private int calcDiffDates(Date dateIni, Date dateEnd) {
		long diffInMillies = Math.abs(dateIni.getTime() - dateEnd.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return (int) diff;
	}

	/**
	 * Calculate the rental price based on vehicle type and number of days
	 * @param type
	 * @param days
	 * @return
	 */
	private Double calcPrice(TypeCar type, Integer days) {

		double price = 0;

		switch (type.getIdType().intValue()) {

		case TYPE_PREMIUM:
			price = type.getPrice() * days;
			break;

		case TYPE_SUV:
			if (days <= DAYS_7) {
				price = type.getPrice() * days;
			} else {
				if (days <= DAYS_30) {
					price = type.getPrice() * DAYS_7;
					price += type.getPrice() * PERCENT_80 * (days - DAYS_7);
				} else {
					price = type.getPrice() * 7;
					price += type.getPrice() * PERCENT_80 * (days - DAYS_7);
					price += type.getPrice() * PERCENT_50 * (days - DAYS_30);
				}
			}
			break;

		case TYPE_SMALL:
			if (days <= DAYS_7) {
				price = type.getPrice() * days;
			} else {
				price = type.getPrice() * DAYS_7;
				price += type.getPrice() * PERCENT_60 * (days - DAYS_7);
			}
			break;

		default:
			break;
		}

		return price;
	}

	/**
	 * Calculate the surcharge based on the type of vehicle and the number of extra days.
	 * @param type
	 * @param daysExtra
	 * @return
	 */
	private Double calcSurcharge(TypeCar type, Integer daysExtra) {

		double surcharge = 0;

		switch (type.getIdType().intValue()) {

		case TYPE_PREMIUM:
			surcharge = type.getPrice() * EXTRA_PREMIUM * daysExtra;
			break;

		case TYPE_SUV:
			surcharge = type.getPrice() * EXTRA_SUV * daysExtra;
			break;

		case TYPE_SMALL:
			surcharge = type.getPrice() * EXTRA_SMALL * daysExtra;
			break;

		default:
			break;	
		}

		return surcharge;
	}

}
