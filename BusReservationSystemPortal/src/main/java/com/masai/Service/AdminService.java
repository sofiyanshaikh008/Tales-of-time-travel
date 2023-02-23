package com.masai.Service;

import com.masai.Entity.Admin;
import com.masai.Exception.UserException;

public interface AdminService {
	public Admin registerAdmin(Admin admin);
	public Admin getAdminByemail(Admin admin) throws UserException ;
}
