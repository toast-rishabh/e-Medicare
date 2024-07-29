package com.hm.emc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.hm.emc.bean.DoctorBean;
import com.hm.emc.service.Reporter;
import com.hm.emc.util.DBUtil;

public class ReporterDAO implements Reporter {

	Connection con= DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");
	PreparedStatement ps= null;
	ResultSet rs=null;
	SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-mm-dd");
	@Override
	public ArrayList<DoctorBean> viewAllAvailableDoctors(String date){
		ArrayList<DoctorBean> arr = new ArrayList<DoctorBean>();
		try {
			
		ps = con.prepareStatement("select * from OCS_TBL_DOCTOR where DOCTORID NOT IN ( select DOCTORID from OCS_TBL_LEAVE " + 
				"where LEAVE_FROM <= ? and LEAVE_TO >= ?)"); 
		java.util.Date d = new java.util.Date();
		d.parse(date);
		String forDate = sqlDateFormat.format(d);
		java.sql.Date dob = java.sql.Date.valueOf(forDate);
		ps.setDate(1,dob);
		ps.setDate(2,dob);	
		
		 rs = ps.executeQuery();
		while (rs.next()) {
			DoctorBean doc = new DoctorBean();
			doc.setDoctorID(rs.getString("DOCTORID"));
			doc.setCity(rs.getString("CITY"));
			doc.setContactNumber(rs.getString("CONTACTNUMBER"));
			doc.setDateOfBirth(rs.getDate("DATEOFBIRTH"));
			doc.setDateOfJoining(rs.getDate("DATEOFJOINING"));
			doc.setDoctorName(rs.getString("DOCTORNAME"));
			doc.setEmailID(rs.getString("EMAILID"));
			doc.setGender(rs.getString("GENDER"));
			doc.setLocation(rs.getString("LOCATION"));
			doc.setPincode(rs.getString("DOCTORID"));
			doc.setQualification(rs.getString("QUALIFICATION"));
			doc.setSpecialization(rs.getString("SPECIALIZATION"));
			doc.setState(rs.getString("STATE"));
			doc.setStreet(rs.getString("STREET"));
			doc.setYearsOfExperience(rs.getInt("YEARSOFEXPERIENCE"));
			arr.add(doc);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public ArrayList<DoctorBean> intimateAdmin(String date, String status) {
		ArrayList<DoctorBean> arr = new ArrayList<DoctorBean>();
		
		try {
			ps = con.prepareStatement("select * from OCS_TBL_DOCTOR where DOCTORID NOT IN ( select DOCTORID " + 
		"from OCS_TBL_LEAVE where LEAVE_FROM <= ? and LEAVE_TO>= ? and STATUS=1 )");
			java.util.Date d = new java.util.Date();
			d.parse(date);
			String forDate = sqlDateFormat.format(d);
			java.sql.Date dob = java.sql.Date.valueOf(forDate);
		ps.setDate(1,dob);
		ps.setDate(2,dob);	
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			DoctorBean doc = new DoctorBean();
			doc.setDoctorID(rs.getString("DOCTORID"));
			doc.setCity(rs.getString("CITY"));
			doc.setContactNumber(rs.getString("CONTACTNUMBER"));
			doc.setDateOfBirth(rs.getDate("DATEOFBIRTH"));
			doc.setDateOfJoining(rs.getDate("DATEOFJOINING"));
			doc.setDoctorName(rs.getString("DOCTORNAME"));
			doc.setEmailID(rs.getString("EMAILID"));
			doc.setGender(rs.getString("GENDER"));
			doc.setLocation(rs.getString("LOCATION"));
			doc.setPincode(rs.getString("DOCTORID"));
			doc.setQualification(rs.getString("QUALIFICATION"));
			doc.setSpecialization(rs.getString("SPECIALIZATION"));
			doc.setState(rs.getString("STATE"));
			doc.setStreet(rs.getString("STREET"));
			doc.setYearsOfExperience(rs.getInt("YEARSOFEXPERIENCE"));
			arr.add(doc);
		}
	}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	}
	
