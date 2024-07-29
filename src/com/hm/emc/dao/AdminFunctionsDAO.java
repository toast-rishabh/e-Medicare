package com.hm.emc.dao;

import java.sql.Date;

import javax.swing.JOptionPane;

import com.hm.emc.bean.DoctorBean;
import com.hm.emc.inputs.AdminInput;

public class AdminFunctionsDAO {
	static AdministratorDAO adao = new AdministratorDAO();

	public static void AdminFunction() {
		int a = 0;
		a = Integer.parseInt(JOptionPane.showInputDialog(
				"1) Add doctor 2) Remove doctor 3)View all doctor 4) Modify doctors 5) View Patients By date "));
		switch (a) {
		case 1:
			String user = JOptionPane.showInputDialog("Enter id");
			String pass = JOptionPane.showInputDialog("Enter password");
			if (user.equals("AD-001") && pass.equals("AD-001")) {
				DoctorBean db = AdminInput.addDoctor();
				JOptionPane.showMessageDialog(null, adao.addDoctor(db));
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username/password.");
			}
			break;
		case 2:
			String user1 = JOptionPane.showInputDialog("Enter id");
			String pass1 = JOptionPane.showInputDialog("Enter password");
			if (user1.equals("AD-002") && pass1.equals("AD-002")) {
				String doctorId = AdminInput.removeDoctor();
				JOptionPane.showMessageDialog(null, adao.removeDoctor(doctorId));
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username/password.");
			}
			break;
		case 3:
			String user2 = JOptionPane.showInputDialog("Enter id");
			String pass2 = JOptionPane.showInputDialog("Enter password");
			if (user2.equals("AD-003") && pass2.equals("AD-003")) {
				JOptionPane.showMessageDialog(null, adao.viewAllDoctors());
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username/password.");
			}
			break;
		case 4:
			String user3 = JOptionPane.showInputDialog("Enter id");
			String pass3 = JOptionPane.showInputDialog("Enter password");
			if (user3.equals("AD-004") && pass3.equals("AD-004")) {
				DoctorBean db = AdminInput.modifyDoctor();
				JOptionPane.showMessageDialog(null, adao.modifyDoctor(db));
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username/password.");
			}
			break;
		case 5:
			String user4 = JOptionPane.showInputDialog("Enter id");
			String pass4 = JOptionPane.showInputDialog("Enter password");
			if (user4.equals("AD-005") && pass4.equals("AD-005")) {
				String appointmentDate = JOptionPane.showInputDialog("Enter appointement date");
				Date ad = Date.valueOf(appointmentDate);
				JOptionPane.showMessageDialog(null, adao.viewPatientsByDate(ad));
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username/password.");
			}
			break;
		}
	}
}
