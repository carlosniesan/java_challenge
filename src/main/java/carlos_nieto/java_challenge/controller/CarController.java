package carlos_nieto.java_challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carlos_nieto.java_challenge.model.Car;
import carlos_nieto.java_challenge.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	/**
	 * Method to get a list of cars
	 * @return List<Car>
	 */
	@GetMapping("/listCars")
	public List<Car> allCars(){	
		return carService.getAllCars();
	}
	
	/**
	 * Method to add a new car to the list of available car
	 * @param Car
	 * @return
	 */
	@PostMapping("/createCar")
	public Car createCar(@RequestBody Car car) {
		return carService.createCar(car);
	}
	
}
