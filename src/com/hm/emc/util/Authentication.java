package com.hm.emc.util;

import com.hm.emc.bean.*;

public interface Authentication {

	boolean authenticate(CredentialsBean user);
	String authorize(String userID);
	boolean changeLoginStatus(CredentialsBean user, int loginStatus);
	
}
