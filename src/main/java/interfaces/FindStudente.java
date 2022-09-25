package interfaces;

import java.sql.SQLException;
/**
 * Interfaccia che definisce <i>FindStudente</i> 
 */
public interface FindStudente {
	int findUserId(String username) throws SQLException, ClassNotFoundException;
}
