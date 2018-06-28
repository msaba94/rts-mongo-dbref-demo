package com.selsoft.rts.dao;

import java.util.List;

import com.selsoft.rts.model.Company;
import com.selsoft.rts.model.User;

public interface TableDao {

	public List<User> getAllUser();
	
	public List<Company> gettAllCompany();

	public void saveUser(User user);

	public Company findCompanyById(String companyId);

	public void saveCompany(Company company);
	
}
