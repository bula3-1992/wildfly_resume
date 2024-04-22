package zk.cont;

import zk.ent.Address;

import java.util.List;

public interface AddressService {

	/**
	 * Retrieve all cars in the catalog.
	 * @return all cars
	 */
	public List<Address> findAll();
	
	/**
	 * search cars according to keyword in model and make.
	 * @param keyword for search
	 * @return list of car that match the keyword
	 */
	public List<Address> search(String keyword);
}
