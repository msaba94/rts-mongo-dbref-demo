package com.selsoft.rts.service;

import java.util.List;

import com.selsoft.rts.model.Company;
import com.selsoft.rts.model.User;

public interface TableService {

	public List<User> getAllUser() throws Throwable;

	public List<Company> getAllCompany() throws Throwable;

	public void newUser(User user) throws Throwable;

	public void newCompany(Company company) throws Throwable;

}
