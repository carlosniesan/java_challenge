package carlos_nieto.java_challenge.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import carlos_nieto.java_challenge.model.Rent;

@Repository
public class RentRepository {
	
	private List<Rent> rents = new ArrayList<Rent>();
	
	/**
	 * 
	 * @return
	 */
	public List<Rent> getRents() {
		return rents;
	}
	
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Boolean addRent(Rent r) {
		r.setIdRent(rents.size()+1L);
		return rents.add(r);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Rent getRent(Long id) {
		for (Rent rent : rents) {
			if(rent.getIdRent().equals(id)) {
				return rent;
			}
		}
		return null;
	}

}
