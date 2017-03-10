package db_connect;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	/* ユーザ名 */
	private static  String user = "hew2";
	  /* パスワード */
	private static  String pass = "angel8771";
	  /* サーバ名 */
	private static  String servername = "localhost";
	  /* SID */
	private static  String sid = "xe";
	private static String drivername ="oracle.jdbc.driver.OracleDriver";

	public static Connection getConnection() throws Exception{

		  Connection conn = null;
		  try {
				/* ドライバクラスのロード */
				Class.forName (drivername);

				/* Connectionの作成 */
				conn = DriverManager.getConnection("jdbc:oracle:thin:@" + servername + ":1521:" + sid,user,pass);
		  }catch(ClassNotFoundException e){
				throw e;
		  }
		return conn;
		}
}
