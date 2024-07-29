package com.hm.emc.inputs;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.hm.emc.bean.DoctorBean;

public class AdminInput {
	public static DoctorBean addDoctor()
	{
		
		DoctorBean db = new DoctorBean();
		//getting user input

	        String doctorName=JOptionPane.showInputDialog("Enter doctor Name");
	       String dob = JOptionPane.showInputDialog("Enter date of birth");
	     String dateOfJoining = JOptionPane.showInputDialog("Enter date of joining");
	       String gender = JOptionPane.showInputDialog("Enter gender of doctor");
	       String qualification = JOptionPane.showInputDialog("Enter qualification");
	       String specialization = JOptionPane.showInputDialog("Enter specialization");
	       int yearsOfExperience = Integer.parseInt(JOptionPane.showInputDialog("Enter years of experience"));
	       String street = JOptionPane.showInputDialog("Enter street address");
	       String location = JOptionPane.showInputDialog("Enter location address");
	       String city = JOptionPane.showInputDialog("Enter city name");
	       String state = JOptionPane.showInputDialog("Enter state name");
	       String pincode = JOptionPane.showInputDialog("Enter pincode value");
	       String contactNum = JOptionPane.showInputDialog("Enter contact number");
	       String emailid = JOptionPane.showInputDialog("Enter email id");
	       
	       //setting values in doctor bean
//	       db.setDoctorID(doctorID);
	       db.setDoctorName(doctorName);
	       Date dateOfBirth = new Date();
	       dateOfBirth.parse(dob);
	       db.setDateOfBirth(dateOfBirth);
	       Date doj = new Date();
	       doj.parse(dateOfJoining);
	       db.setDateOfJoining(doj);
	       db.setGender(gender);
	       db.setQualification(qualification);
	       db.setSpecialization(specialization);
	       db.setYearsOfExperience(yearsOfExperience);
	       db.setStreet(street);
	       db.setLocation(location);
	       db.setCity(city);
	       db.setState(state);
	       db.setContactNumber(contactNum);
	       db.setPincode(pincode);
	       db.setEmailID(emailid);
	       
	       return db;
	}
	
	 public static String removeDoctor()
	 {
		 String doctorId = JOptionPane.showInputDialog("Enter Doctor Id");
		 return doctorId;
	 }
	 
	 public static DoctorBean modifyDoctor()
	 {
		 DoctorBean db= new DoctorBean();
		 String doctorId = JOptionPane.showInputDialog("Enter Doctor Id");
		 String doctorName=JOptionPane.showInputDialog("Enter doctor Name");
	       String dob = JOptionPane.showInputDialog("Enter date of birth");
	     String dateOfJoining = JOptionPane.showInputDialog("Enter date of joining");
	       String gender = JOptionPane.showInputDialog("Enter gender of doctor");
	       String qualification = JOptionPane.showInputDialog("Enter qualification");
	       String specialization = JOptionPane.showInputDialog("Enter specialization");
	       int yearsOfExperience = Integer.parseInt(JOptionPane.showInputDialog("Enter years of experience"));
	       
	       db.setDoctorID(doctorId);
	       db.setDoctorName(doctorName);
	       Date dateOfBirth = new Date();
	       dateOfBirth.parse(dob);
	       db.setDateOfBirth(dateOfBirth);
	       Date doj = new Date();
	       doj.parse(dateOfJoining);
	       db.setDateOfJoining(doj);
	       db.setGender(gender);
	       db.setQualification(qualification);
	       db.setSpecialization(specialization);
	       db.setYearsOfExperience(yearsOfExperience);
	       
	       return db;
	 }
	 

}
