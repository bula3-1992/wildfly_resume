package zk.cont;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zk.ent.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;

public class AddressServiceImpl implements AddressService{

	private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

	private static final String SELECT_ADDRESS = "select id, _index, city, street, home_number, apartment from address";

	//data model
	private List<Address> addressList = new LinkedList<Address>();
	private static int id = 1;
	//initialize book data
	public AddressServiceImpl() {
	}

	public List<Address> findAll(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Resume");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Address> addresses = entityManager.createNativeQuery("select id, _index, city, street, home_number, apartment from address", Address.class).getResultList();
		entityManagerFactory.close();
		return addresses;
	}

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Resume");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Address> addresses = entityManager.createNativeQuery("select id, _index, city, street, home_number, apartment from address", Address.class).getResultList();
		for(Address a: addresses) {
			System.out.println(a.getCity());
		}
		entityManagerFactory.close();
	}
	
	public List<Address> search(String keyword){
		addressList = findAll();
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
