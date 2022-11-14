package carlos_nieto.java_challenge.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import carlos_nieto.java_challenge.model.TypeCar;

@Repository
public class TypeCarRepository {
	
	private List<TypeCar> types = new ArrayList<TypeCar>();

	/**
	 * 
	 */
	public TypeCarRepository() {
		types.add(new TypeCar(1L,"premium",300.0,5));
		types.add(new TypeCar(2L,"suv",150.0,3));
		types.add(new TypeCar(3L,"small",50.0,1));
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public TypeCar getType(Long id) {
		for (TypeCar type : types) {
			if(type.getIdType().equals(id)) {
				return type;
			}
		}
		return null;
	}

}
