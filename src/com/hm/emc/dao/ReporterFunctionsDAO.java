package com.hm.emc.dao;
import javax.swing.JOptionPane;


public class ReporterFuctionsDAO {
	public static void ReporterFuction()
	{
		 String user=JOptionPane.showInputDialog("Enter id");
		 ReporterDAO rdao=new ReporterDAO();
		 if(user.equals("RE-001"))
		 {
			 String d=JOptionPane.showInputDialog("Enter Date");
			 JOptionPane.showMessageDialog(null, rdao.viewAllAvailableDoctors(d));
		 }
		 else if(user.equals("RE-002"))
		 {
			 String d=JOptionPane.showInputDialog("Enter Date");
			 String s=JOptionPane.showInputDialog("Enter Status");
			 JOptionPane.showMessageDialog(null, rdao.intimateAdmin(d,s));
		 }
		 else
		 {
			 
		 }
	}
}
