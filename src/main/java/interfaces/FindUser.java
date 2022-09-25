package interfaces;

import java.sql.SQLException;
/**
 * Interfaccia che definisce <i>FindUser</i> 
 */
public interface FindUser {
	String findUser(String username) throws ClassNotFoundException, SQLException;
}
