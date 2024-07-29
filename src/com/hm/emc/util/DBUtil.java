package com.hm.emc.util;

import java.sql.*;

public interface DBUtil {

	 static Connection getDBConnection(String driverType) {
		 Connection con=null;
			try
			{
			Class.forName(driverType);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ocs","root","Sysdba_1");
			
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println(cnf);
			}
			catch(SQLException sql)
			{
				System.out.println(sql);
			}
			return con;
	}
	 
}
