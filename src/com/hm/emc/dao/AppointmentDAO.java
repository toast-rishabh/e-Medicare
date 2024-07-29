package com.hm.emc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.hm.emc.bean.AppointmentBean;
import com.hm.emc.util.DBUtil;

public class AppointmentDAO {
	public static void justThrowException() throws SQLException {
		throw new SQLException("Error occured while running query");
	}
	public static Connection con = DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	@SuppressWarnings("unused")
	public void addAppointment(AppointmentBean ap) {
		int i = 0;
		int data = 0;
		try {
			ps = con.prepareStatement("insert into demo4 values()");
			i = ps.executeUpdate();
			justThrowException();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps = con.prepareStatement("select id from demo4");
			rs = ps.executeQuery();
			while (rs.next()) {
				data = rs.getInt(1);
			}
		} catch (SQLException sql) {
			System.out.println(sql);
		}
		try {
			ps = con.prepareStatement("insert into ocs_tbl_appointments values(?,?,?,?)");
			ps.setString(1, "AP" + data);
			ps.setString(2, ap.getDoctorID());
			ps.setString(3, ap.getPatientID());
			SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			String forDate = sqlDateFormat.format(ap.getAppointmentDate());
			java.sql.Date dob = java.sql.Date.valueOf(forDate);
			ps.setDate(4, dob);
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
