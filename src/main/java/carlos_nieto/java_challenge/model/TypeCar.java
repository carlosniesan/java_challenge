package carlos_nieto.java_challenge.model;


public class TypeCar {
	
	private Long idType;
	private String type;
	private Double price;
	private Integer points;
	
	public TypeCar(Long idType, String type, Double price, Integer points) {
		super();
		this.idType = idType;
		this.type = type;
		this.price = price;
		this.points = points;
	}
	
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}

}
