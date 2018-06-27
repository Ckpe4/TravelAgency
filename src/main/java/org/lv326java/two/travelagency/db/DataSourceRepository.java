package org.lv326java.two.travelagency.db;

import java.sql.Driver;
import java.sql.SQLException;

public final class DataSourceRepository {
	private final static String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";

	private DataSourceRepository() {
	}

	public static DataSource getDefault() {
		return getMySqlLocalHost();
	}

	public static DataSource getMySqlLocalHost() {
		Driver sqlDriver;
		try {
			sqlDriver = new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
			// TODO Develop Custom Exceptions
			throw new RuntimeException(FAILED_JDBC_DRIVER);
		}
		return new DataSource(sqlDriver,
				"jdbc:mysql://localhost:3306/TRAVEL_AGENCY", "root", "852456");
	}

//	public static DataSource getSybaseLocalHost() {
//		return new DataSource(new net.sourceforge.jtds.jdbc.Driver(),
//				"jdbc:jtds:sqlserver://CLASS02/lv326;instance=SQLEXPRESS;", "db326", "db326");
//	}

}