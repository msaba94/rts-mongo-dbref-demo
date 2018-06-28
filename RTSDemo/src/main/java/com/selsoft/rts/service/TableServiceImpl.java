package com.selsoft.rts.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selsoft.rts.dao.TableDao;
import com.selsoft.rts.model.Company;
import com.selsoft.rts.model.User;

@Service("tableService")
public class TableServiceImpl implements TableService {
	
	@Autowired
	TableDao tableDao;

	@Override
	public List<User> getAllUser() throws Throwable {
		return tableDao.getAllUser();
	}

	@Override
	public List<Company> getAllCompany() throws Throwable {
		return tableDao.gettAllCompany();
	}

	@Override
	public void newUser(User user) throws Throwable {
		if (StringUtils.isNotBlank(user.getCompanyId())) {
			Company company = tableDao.findCompanyById(user.getCompanyId());
			if (company == null) {
				throw new Exception("Error!, Company not found");
			}
			user.setCompany(company);
		}
		tableDao.saveUser(user);
	}

	@Override
	public void newCompany(Company company) throws Throwable {
		tableDao.saveCompany(company);
	}	

}
