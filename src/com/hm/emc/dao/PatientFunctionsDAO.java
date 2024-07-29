package com.hm.emc.dao;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.hm.emc.bean.DoctorBean;
import com.hm.emc.bean.PatientBean;
import com.hm.emc.inputs.PatientInput;

public class PatientFunctionsDAO {

	public static void PatientFunction() {
		PatientBean pB = new PatientBean();
		PatientDAO ado = new PatientDAO();

		DoctorBean ddo = new DoctorBean();

		String user = JOptionPane.showInputDialog("Enter username");

		String pass = JOptionPane.showInputDialog("Enter Password");

		if ((user.equals("US-001")) && (pass.equals("US-001")))

		{

			pB = PatientInput.addAilmentDetails();

			JOptionPane.showMessageDialog(null, ado.addAilmentDetails(pB));

		}

		else if (user.equals("US-002") && (pass.equals("US-002")))

		{

			pB = PatientInput.modifyAilmentDetails();

			JOptionPane.showMessageDialog(null, ado.modifyAilmentDetails(pB));

		}

		else if (user.equals("US-003") && (pass.equals("US-003")))

		{

			String pid = PatientInput.viewAilmentDetails();

//		 ArrayList<PatientBean> pB1 = ado.viewAilmentDetails(pid);
			JOptionPane.showMessageDialog(null, ado.viewAilmentDetails(pid));

		}

		else if (user.equals("US-004") && (pass.equals("US-004")))

		{

			String s = JOptionPane.showInputDialog("Enter Specilization");

//			String d = JOptionPane.showInputDialog("Enter Date");
//
//			Date doq = new Date();
//
//			doq.parse(d);

//			java.sql.Date d=new java.sql.Date(d.getDate());
			JOptionPane.showMessageDialog(null, ado.viewListOfDoctors(s));

		}

		else if (user.equals("US-005") && (pass.equals("US-005")))

		{

			String pid = JOptionPane.showInputDialog("Enter patient id");
			String did = JOptionPane.showInputDialog("Enter doctor id");
			String d = JOptionPane.showInputDialog("Enter date");
			Date date = new Date();
			date.parse(d);
			java.sql.Date dob = new java.sql.Date(date.getDate());
			JOptionPane.showMessageDialog(null, ado.requestForAppointment(pid, did, dob));

		}

	}

}
