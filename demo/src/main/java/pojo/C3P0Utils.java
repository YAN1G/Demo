package pojo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Utils {
	// Ĭ������
	private static DataSource dataSource = new ComboPooledDataSource();
	// ��������
	// private static DataSource dataSource = new ComboPooledDataSource("test");

	public static DataSource getDataSource() {
		return dataSource;
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
