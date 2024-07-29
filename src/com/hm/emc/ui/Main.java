package com.hm.emc.ui;

import javax.swing.JOptionPane;

import com.hm.emc.bean.*;
import com.hm.emc.control.loginPage;
import com.hm.emc.dao.*;
import com.hm.emc.inputs.UserInput;

public class Main {
	public static void functions(String res) {
		if (res.equals("A")) {
			AdminFunctionsDAO.AdminFunction();
		} else if (res.equals("R")) {
			ReporterFuctionsDAO.ReporterFuction();
		} else if (res.equals("P")) {
			PatientFunctionsDAO.PatientFunction();
		} else {
			JOptionPane.showMessageDialog(null, "Error.");
		}

	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "*****Welcome To eMedicareConnect*****");
		loginPage u = new loginPage();
		RegisterDAO rdao = new RegisterDAO();
		int i = Integer.parseInt(JOptionPane.showInputDialog("1) login 2 ) logout 3) change password 4) register"));
		switch (i) {
		case 1:
			CredentialsBean cb = new CredentialsBean();
			String userID = JOptionPane.showInputDialog("Enter user ID");
			String password = JOptionPane.showInputDialog("Enter password");
			cb.setUserID(userID);
			cb.setPassword(password);
			String res = u.login(cb);
			functions(res);
			break;
		case 2:
			String uid = JOptionPane.showInputDialog("Enter user ID to logout");
			boolean ans = u.logout(uid);
			if (ans) {
				JOptionPane.showMessageDialog(null, "logout sucessfull");
			} else {
				JOptionPane.showMessageDialog(null, "logout not sucessfull");
			}
			break;
		case 3:
			String usrID = JOptionPane.showInputDialog("Enter user ID");
			String Oldpass = JOptionPane.showInputDialog("Enter old password");
			String newPass = JOptionPane.showInputDialog("Enter new password");
			CredentialsBean cb1 = new CredentialsBean();
			cb1.setUserID(usrID);
			cb1.setPassword(Oldpass);
			JOptionPane.showMessageDialog(null, u.changePassword(cb1, newPass));
			break;
		case 4:
			ProfileBean pfb = UserInput.register();
			JOptionPane.showMessageDialog(null, rdao.register(pfb));
			break;
		}

	}

}
