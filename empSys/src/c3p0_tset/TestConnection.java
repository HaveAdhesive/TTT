package c3p0_tset;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import org.junit.Test;

import com.ttt.empSys.util.C3p0DBUtils;

public class TestConnection {

	@Test
	public void testConnection() throws SQLException {
		Connection connection = C3p0DBUtils.getConnention();
		System.out.println(connection);
		connection.close();
	}
	
	@Test
	public void tettt() {
		Random A = new Random();
		Random B = new Random();
		Random C = new Random();
		Random D = new Random();
		
		
		String S = String.valueOf(A.nextInt(10)) + String.valueOf(B.nextInt(10)) + String.valueOf(C.nextInt(10)) + String.valueOf(D.nextInt(10));
		
		System.out.println(S);
		
	}
	
}
