package crud_veiculo_carapicuiba_poo_manha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//bloco inicializador estático
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection () throws SQLException {
		Connection conn;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/veiculo_poo_ads_manha?useTimezone=true&serverTimezone=UTC", "root", "");
		return conn;
	}
	
}
