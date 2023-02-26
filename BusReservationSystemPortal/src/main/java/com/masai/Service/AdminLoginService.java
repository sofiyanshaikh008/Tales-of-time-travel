package com.masai.Service;

import com.masai.Entity.AdminDto;
import com.masai.Exception.LoginException;



public interface AdminLoginService {
	public String logIntoAccount(AdminDto dto) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
