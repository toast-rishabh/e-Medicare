package com.hm.emc.inputs;

import java.util.Date;

import javax.swing.JOptionPane;

import com.hm.emc.bean.ProfileBean;

public class UserInput {
	public static ProfileBean register()
	{
		ProfileBean pfb = new ProfileBean();
		String firstName = JOptionPane.showInputDialog("Enter first name");
		String lastName = JOptionPane.showInputDialog("Enter last name");
		String dob = JOptionPane.showInputDialog("Enter date of birth");
		String gender = JOptionPane.showInputDialog("Enter gender");
		  String street = JOptionPane.showInputDialog("Enter street address");
	       String location = JOptionPane.showInputDialog("Enter location address");
	       String city = JOptionPane.showInputDialog("Enter city name");
	       String state = JOptionPane.showInputDialog("Enter state name");
	       String pincode = JOptionPane.showInputDialog("Enter pincode value");
	       String contactNum = JOptionPane.showInputDialog("Enter contact number");
	       String emailid = JOptionPane.showInputDialog("Enter email id");
	       String password = JOptionPane.showInputDialog("Enter password");
	       
	       pfb.setFirstName(firstName);
	       pfb.setLastName(lastName);
	       Date dob1 = new Date();
	       dob1.parse(dob);
	       pfb.setDateOfBirth(dob1);
	       pfb.setGender(gender);
	       pfb.setStreet(street);
	       pfb.setLocation(location);
	       pfb.setCity(city);
	       pfb.setState(state);
	       pfb.setMobileNo(contactNum);
	       pfb.setPincode(pincode);
	       pfb.setEmailID(emailid);
	       pfb.setPassword(password);
	       
	       return pfb;
	}
}
