package com.hm.emc.control;

import java.sql.*;
import com.hm.emc.bean.*;
import com.hm.emc.util.*;

public class loginPage implements Authentication {
	public static Connection con = DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");

	public String login(CredentialsBean cb) {
		if (authenticate(cb)) {
			String uid = cb.getUserID();
			return authorize(uid);

		} else {
			return "Invalid";

		}
	}

	@Override
	// authenticates correct user
	public boolean authenticate(CredentialsBean user) {
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from ocs_tbl_user_credentials where userid=? and password=?");
			ps.setString(1, user.getUserID());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (user.getUserID().equals(rs.getString(1)) && (user.getPassword().equals(rs.getString(2)))) {
					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public String authorize(String userID) {
		// authorizes the specific user to perform valid functions
		String res = "";
		try {
			PreparedStatement ps = con.prepareStatement("select * from ocs_tbl_user_credentials where userid=?");
			ps.setString(1, userID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				res = rs.getString("userType");
				PreparedStatement ps1 = con
						.prepareStatement("update ocs_tbl_user_credentials  set loginstatus=? where userid=?");
				ps1.setInt(1, 1); // successfully logged in
				ps1.setString(2, userID);
				ps1.executeUpdate();
			}

		} catch (SQLException sql) {
			System.out.println(sql);
		}

		return res;
	}

	public boolean logout(String userId) {
		boolean i = false;
		try {

			PreparedStatement ps = con
					.prepareStatement("update ocs_tbl_user_credentials  set loginstatus=? where userid=?");
			ps.setInt(1, 0);
			ps.setString(2, userId);

			int i1 = ps.executeUpdate();
			if (i1 > 0) {
				ps.close();
				con.close();
				i = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean user, int loginStatus) {
		try {
			user.setLoginStatus(loginStatus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String changePassword(CredentialsBean cb, String newpassword) {
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("update ocs_tbl_user_profile  set password=? where userid=?");
			ps.setString(1, newpassword);
			ps.setString(2, cb.getUserID());
			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (i == 1) {
			return "Successfully changed password";
		} else {
			return "Fail";
		}

	}

}
