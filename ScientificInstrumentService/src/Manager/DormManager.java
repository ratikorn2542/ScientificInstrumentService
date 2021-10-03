package Manager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import projectutil.ConnectionDB;

public class DormManager {

	public int addLineTokenSP(String id ,String token) {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConection();
		try {

			CallableStatement stmt = con.prepareCall("{call addLineTokenSP(?,?)}");
			stmt.setString(1, id);
			stmt.setString(2, token);
			stmt.execute();
			con.close();
			stmt.close();
			
			return 1 ;
		} catch (SQLException er) {
			er.printStackTrace();
		}
		
		return 0;
	}
	
}
