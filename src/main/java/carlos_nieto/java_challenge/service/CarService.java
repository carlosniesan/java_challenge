package carlos_nieto.java_challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import carlos_nieto.java_challenge.model.Car;
import carlos_nieto.java_challenge.repository.CarRepository;
import carlos_nieto.java_challenge.repository.TypeCarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private TypeCarRepository typeCarRepository;
	
	/**
	 * Method to get a list of cars
	 * @return List<Car>
	 */
	public List<Car> getAllCars(){	
		List<Car> cars = carRepository.getCars();
		for (Car car : cars) {
			car.setTypeCar(typeCarRepository.getType(car.getIdType()));
		}		
		return cars;
	}
	
	/**
	 * Method to get a car from the idCar
	 * @param idCar
	 * @return Car
	 */
	public Car getCar(Long idCar) {
		Car car = carRepository.getCar(idCar);
		car.setTypeCar(typeCarRepository.getType(car.getIdType()));
		return car;
	}
	
	/**
	 * Method to add a new car to the list of available car
	 * @param Car
	 * @return Car
	 */
	public Car createCar(@RequestBody Car car) {
		car = carRepository.addCar(car);
		car.setTypeCar(typeCarRepository.getType(car.getIdType()));
		return car;
	}
	

}
