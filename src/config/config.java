package config;

public class config {
	// user name
	public final static String USERNAME = "root";
	// password
	public final static String PASSWORD = "Xhhgxy654321";
	// your database name
	public final static String DBNAME = "tree";
	// mysql driver
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	// mysql url
	//public final static String URL = "jdbc:mysql://localhost:3306/" + DBNAME
	//		+ "?useUnicode=true&characterEncoding=UTF-8";
	public final static String URL = "jdbc:mysql://8.146.250.253:3306/" + DBNAME
			+ "?useUnicode=true&characterEncoding=UTF-8";
	// must bigger than the number of the keyword in your database table
	public final static int TABLELEN = 10;

}