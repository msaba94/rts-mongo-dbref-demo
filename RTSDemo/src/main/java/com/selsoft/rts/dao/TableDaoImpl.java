package com.selsoft.rts.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.selsoft.rts.model.Company;
import com.selsoft.rts.model.User;

@Repository
@Qualifier("tableDAO")
public class TableDaoImpl implements TableDao {

	@Autowired
	private MongoTemplate template;

	@Override
	public List<User> getAllUser() {
		return template.findAll(User.class);
	}

	@Override
	public List<Company> gettAllCompany() {
		return template.findAll(Company.class);
	}

	@Override
	public void saveUser(User user) {
		template.insert(user);		
	}

	@Override
	public Company findCompanyById(String companyId) {
		Query query = new Query(Criteria.where("_id").is(companyId));
		return template.findOne(query, Company.class);
	}

	@Override
	public void saveCompany(Company company) {
		template.insert(company);	
	}

}
