package com.hm.emc.service;
import java.sql.Date;
import java.util.ArrayList;

import com.hm.emc.bean.DoctorBean;

public interface Reporter {

//	ArrayList<DoctorBean> viewAllAvailableDoctors(Date date);
	ArrayList<DoctorBean> intimateAdmin(String date, String status);
	ArrayList<DoctorBean> viewAllAvailableDoctors(String date);
	
}
