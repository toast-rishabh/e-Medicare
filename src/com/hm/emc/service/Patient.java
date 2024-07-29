package com.hm.emc.service;
import java.util.Date;
import java.util.ArrayList;
import java.util.Map;

import com.hm.emc.bean.*;

public interface Patient {

	String addAilmentDetails(PatientBean patientBean);
	String modifyAilmentDetails(PatientBean patientBean);
	ArrayList<PatientBean> viewAilmentDetails(String patientID);
	ArrayList<DoctorBean> viewListOfDoctors(String type);
	String requestForAppointment(String patientID,String doctorID, java.sql.Date appointmentDate);
	Map<AppointmentBean, PatientBean> viewAppointmentDetails(String patientID, Date date);
//	Map<AppointmentBean, PatientBean> viewAppointmentDetails(String patientID, java.util.Date date);
	
}
