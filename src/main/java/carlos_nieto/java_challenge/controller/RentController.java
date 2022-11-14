package carlos_nieto.java_challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carlos_nieto.java_challenge.model.Rent;
import carlos_nieto.java_challenge.service.RentService;

@RestController
@RequestMapping("/rent")
public class RentController {
	
	@Autowired
	private RentService rentService;
	
	/**
	 * Method to get a list of rentals
	 * @return List<Rent>
	 */
	@GetMapping("/listRents")
	public List<Rent> listRents(){	
		return rentService.listRents();
	}
	
	/**
	 * Method of making one or more rentals
	 * @param listRent
	 * @return listRent
	 */
	@PostMapping("/rentCar")
	public List<Rent> rentCar(@RequestBody List<Rent> listRent) {
		for (Rent rent : listRent) {
			rent = rentService.rentCar(rent);
		}
		return listRent;
	}
	
	/**
	 * Method to make a rent return
	 * @param Rent
	 * @return Rent
	 */
	@PostMapping("/returnCar")
	public Rent returnCar(@RequestBody Rent r){
		return rentService.returnCar(r);
	}
	

}
