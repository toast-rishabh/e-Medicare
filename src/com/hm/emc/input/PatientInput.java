package com.hm.emc.inputs;

import java.time.Instant;

import java.util.ArrayList;

import java.util.Date;

//import java.sql.Date;

import java.util.Map;

import javax.swing.JOptionPane;

import com.hm.emc.bean.AppointmentBean;

import com.hm.emc.bean.DoctorBean;

import com.hm.emc.bean.PatientBean;
import com.hm.emc.dao.PatientDAO;

import com.hm.emc.service.Patient;

public class PatientInput {

	public static PatientBean pB = null;

	public static PatientBean addAilmentDetails()

	{

		// String PatientID=JOptionPane.showInputDialog("Enter PatientID ");

		String UserID = JOptionPane.showInputDialog("Enter  UserID ");

		String AppointmentDate = JOptionPane.showInputDialog("Enter  Appointment Date ");

		String AilmentType = JOptionPane.showInputDialog("Enter Ailment Type");

		String AilementDetails = JOptionPane.showInputDialog("Enter Ailment Details");

		String DiagnosisHistory = JOptionPane.showInputDialog("Enter Diagnosis History");

		Date d = new Date();

		d.parse(AppointmentDate);

		pB = new PatientBean();

		// pB.setPatientID(PatientID);

		pB.setUserID(UserID);

		pB.setAppointmentDate(d);

		pB.setAilmentType(AilmentType);

		pB.setAilmentDetails(AilementDetails);

		pB.setDiagnosisHistory(DiagnosisHistory);

		return pB;

	}

	public static PatientBean modifyAilmentDetails()

	{

		PatientBean pB = new PatientBean();

		String patientID = JOptionPane.showInputDialog("Enter patient id");

		String ailmentType = JOptionPane.showInputDialog("Enter ailment type");

		String ailmentDetails = JOptionPane.showInputDialog("Enter ailment details");

		String diagnosisHistory = JOptionPane.showInputDialog("Enter diagnosis history");

		pB.setPatientID(patientID);

		pB.setAilmentType(ailmentType);

		pB.setAilmentDetails(ailmentDetails);

		pB.setDiagnosisHistory(diagnosisHistory);

		return pB;

	}

	public static String viewAilmentDetails()

	{

		String Pid = JOptionPane.showInputDialog("Enter PatientId");

		return Pid;

	}

	public static void viewListOfDoctors()

	{

		PatientDAO p = new PatientDAO();

		String s = JOptionPane.showInputDialog("Enter Specilization");

//		String d = JOptionPane.showInputDialog("Enter Date");
//
//		Date doq = new Date();
//
//	doq.parse(d);

		p.viewListOfDoctors(s);

	}
}
