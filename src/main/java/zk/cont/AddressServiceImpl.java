package zk.cont;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zk.ent.Address;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AddressServiceImpl implements AddressService{

	private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

	private static final String SELECT_ADDRESS = "select id, _index, city, street, home_number, apartment from address";

	private Connection getConnection() {
		try {
			Class.forName(Conn.DRIVER);
			return DriverManager.getConnection(Conn.URL, Conn.USER, Conn.PASS);
		} catch (ClassNotFoundException e) {
			log.error("DriverClassNotFound :" , e);
			throw new RuntimeException(e);
		} catch (SQLException x) {
			log.error("connect with {}, {} and his pass", Conn.URL, Conn.USER);
			log.error("Exception :" , x);
			throw new RuntimeException(x);
		}
	}

	//data model
	private List<Address> addressList = new LinkedList<Address>();
	private static int id = 1;
	//initialize book data
	public AddressServiceImpl() {
	}
	
	
	public List<Address> findAll(){
		List<Address> addresses = new LinkedList<>();
		try (Connection con = getConnection();
			 PreparedStatement stat = con.prepareStatement(SELECT_ADDRESS)) {
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				addresses.add(new Address(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			rs.close();
		} catch (SQLException e) {
			log.error("Select address exception :", e);
		}
		return addresses;
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
