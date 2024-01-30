package broker.twotier.test;

import java.sql.SQLException;

import broker.twotier.dao.Database;
import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;

public class DatabaseTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Database db = new Database("127.0.0.1");
		
		try {
			db.addCustomer(new CustomerRec("777-7777", "SEOHEE", "와동동"));
		}catch (DuplicateSSNException e){
			System.out.println(e.getMessage());
		}
		
		try {
			db.deleteCustomer("777-7777");
		}catch (RecordNotFoundException e){
			System.out.println(e.getMessage());
		}


	}

}
