package com.dao;

import com.dto.Admin;

public interface AdimDao {
	public boolean validateAdmin(Admin admin);
	public Integer addAdmin(Admin admin);
	public void updateAdminPassword(String email, String password);
	public void deleteAdmin(Integer adminId);
	public Admin searchAdminByEmail(String email);
}

