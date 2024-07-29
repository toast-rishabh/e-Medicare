package com.hm.emc.util;

import com.hm.emc.bean.*;

public interface User {
	String login(CredentialsBean credentialsBean);
	boolean logout(String userID);
	String changePassword(CredentialsBean credentialBean, String password);
	String register(ProfileBean profileBean);

}
