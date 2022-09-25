package database;

import java.sql.*;
/**
 * @author gregoriosaggese
 *
 */

/**Classe che definisce <i>ConnessioneDB</i>
 *  un parametro con(Connection)
 */
public class ConnessioneDB {
	private Connection con;
	/**Costruttore
	 * vuoto
	 */
	public ConnessioneDB() {
	
	}
	/**Metodo che crea la connessione al database
	 * restituisce l'oggetto conn(Connection)
	 * @return return conn;
	 */
	public Connection getConnection() throws SQLException, ClassNotFoundException  {
		String DRIVER = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/EPDatabase";
		Class.forName(DRIVER);
		String user = "root";
		con = DriverManager.getConnection(url,user,null);
		return con;
	}
}
