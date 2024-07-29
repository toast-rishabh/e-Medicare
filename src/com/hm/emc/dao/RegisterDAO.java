package com.hm.emc.dao;

import java.sql.*;

import com.hm.emc.bean.ProfileBean;
import com.hm.emc.util.DBUtil;

public class RegisterDAO {
	public static Connection con=DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");
    public static PreparedStatement ps=null;
    public static ResultSet rs=null;
    
    public String register(ProfileBean pfb)
    {
    	int i=0;
    	int data=0;
    	try
    	{
    	ps=con.prepareStatement("insert into demo2 values()");
    	i=ps.executeUpdate();
    	}
    	catch(SQLException sql)
    	{
    	}
    	try
    	{
    		ps=con.prepareStatement("select id from demo2");
    		rs=ps.executeQuery();
    	while(rs.next())
    	{
    		data=rs.getInt(1);
    	}
    	}
    	catch(SQLException sql)
    	{
    		System.out.println(sql);
    	}
    	try
    	{
    		ps = con.prepareStatement("insert into ocs_tbl_user_profile values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
    		ps.setString(1, (pfb.getFirstName().substring(0,2))+data);
    		ps.setString(2,  pfb.getFirstName());
    		ps.setString(3, pfb.getLastName());
    		java.sql.Date dob = new java.sql.Date(pfb.getDateOfBirth().getDate());
    		ps.setDate(4, dob);
    		ps.setString(5, pfb.getGender());
    		ps.setString(6, pfb.getStreet());
    		ps.setString(7, pfb.getLocation());
    		ps.setString(8, pfb.getCity());
    		ps.setString(9, pfb.getState());
    		ps.setString(10, pfb.getPincode());
    		ps.setString(11, pfb.getMobileNo());
    		ps.setString(12, pfb.getEmailID());
    		ps.setString(13, pfb.getPassword());
    		i=ps.executeUpdate();
    	}
    		catch(SQLException sql)
            {
                System.out.println(sql);
            }
    	        if(i==1)
    	        {
    	        	return "SUCCESSFULLY REGISTERED";
    	        }
    	        if(i==0)
    	        {
    	        	return "FAIL";
    	        }
    	        else
    	        {
    	        	return "ERROR";
    	        }
    }
}
