package carlos_nieto.java_challenge.model;


public class Car {
	
	private Long idCar;
	private String model;
	private Long idType;
	private TypeCar typeCar;

	
	public Car(Long idCar, Long idType, String model) {
		super();
		this.idCar = idCar;
		this.idType = idType;
		this.model = model;
	}
	
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public Long getIdCar() {
		return idCar;
	}

	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}

	public TypeCar getTypeCar() {
		return typeCar;
	}

	public void setTypeCar(TypeCar typeCar) {
		this.typeCar = typeCar;
	}
	
	
	
	
}
