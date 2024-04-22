package zk.cont;

import zk.ent.Address;

import java.util.LinkedList;
import java.util.List;

public class AddressServiceImpl implements AddressService{

	//data model
	private List<Address> addressList = new LinkedList<Address>();
	private static int id = 1;
	//initialize book data
	public AddressServiceImpl() {
		addressList.add(
				new Address(id++,
						"670000",
						"U-Ude",
						"Zhukocskogo",
						"21",
						"13"));
	}
	
	
	public List<Address> findAll(){
		return addressList;
	}
	
	public List<Address> search(String keyword){
		List<Address> result = new LinkedList<Address>();
		if (keyword==null || "".equals(keyword)){
			result = addressList;
		}else{
			for (Address c: addressList){
				if (c.getStreet().toLowerCase().contains(keyword.toLowerCase())
					||c.getCity().toLowerCase().contains(keyword.toLowerCase())){
					result.add(c);
				}
			}
		}
		return result;
	}
}
