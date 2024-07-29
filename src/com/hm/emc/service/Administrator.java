package com.hm.emc.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import com.hm.emc.bean.AppointmentBean;
import com.hm.emc.bean.DoctorBean;
import com.hm.emc.bean.PatientBean;

public interface Administrator {
	String addDoctor(DoctorBean doctorBean);
	Boolean modifyDoctor(DoctorBean doctorBean);
	ArrayList<DoctorBean> viewAllDoctors();
	int removeDoctor(String doctorID);
	ArrayList<DoctorBean> suggestDoctors(String patientID, Date date);
	ArrayList<PatientBean> viewPatientsByDate(Date appointmetnDate);
	
}
