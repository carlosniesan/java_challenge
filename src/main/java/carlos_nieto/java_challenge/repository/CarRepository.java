package carlos_nieto.java_challenge.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import carlos_nieto.java_challenge.model.Car;

@Repository
public class CarRepository {
	
	private List<Car> cars = new ArrayList<Car>();

	/**
	 * 
	 */
	public CarRepository() {
		cars.add(new Car(1L,1L,"BMW 7"));
		cars.add(new Car(2L,2L,"Kia Sorento"));
		cars.add(new Car(3L,2L,"Nissan Juke"));
		cars.add(new Car(4L,3L,"Seat Ibiza"));
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Car> getCars() {
		return cars;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public Car addCar(Car c) {
		c.setIdCar(cars.size()+1L);
		cars.add(c);
		return c;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Car getCar(Long id) {
		for (Car car : cars) {
			if(car.getIdCar().equals(id)) {
				return car;
			}
		}
		return null;
	}

}
