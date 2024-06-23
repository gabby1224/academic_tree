package database;
import java.sql.*;
public class DB_connect {
	public static Connection connect() {
		Connection connect = null;//ָ��
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动程序
			connect = DriverManager.getConnection(//在本地运行
					"jdbc:mysql://8.146.250.253:3306/tree", "root","Xhhgxy654321");
					//"jdbc:mysql://vtimpihxxesr.mysql.sae.sina.com.cn:10499/student354", "student354","LIXIANGamy773316");
					//"jdbc:mysql://localhost:3306/tree", "root","12345678");//嗯
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error!");//未连接到数据库
		}
		catch (Exception e) {
			System.out.println("Error!");//未连接到数据库
		}
		return connect;
	}
}