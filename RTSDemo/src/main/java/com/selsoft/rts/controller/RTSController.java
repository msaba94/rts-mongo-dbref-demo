package com.selsoft.rts.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.selsoft.rts.model.Company;
import com.selsoft.rts.model.User;
import com.selsoft.rts.service.TableService;

@RestController
@RequestMapping(value = "/demo")
public class RTSController {

	@Autowired
	TableService tableService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String addNewProperty() {
		return "demo test post";
	}

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllUser() {
		JSONObject jsonObject = new JSONObject();

		try {
			List<User> users = tableService.getAllUser();
			jsonObject.put("success", true);
			jsonObject.put("user", users);
		} catch (Exception e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		} catch (Throwable e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		}

		return jsonObject.toString();
	}

	@RequestMapping(value = "/getAllCompany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllCompany() {
		JSONObject jsonObject = new JSONObject();

		try {
			List<Company> companies = tableService.getAllCompany();
			jsonObject.put("success", true);
			jsonObject.put("company", companies);
		} catch (Exception e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		} catch (Throwable e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		}

		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/insertNewUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertNewUser(@RequestBody User user) {
		JSONObject jsonObject = new JSONObject();
		try {
			tableService.newUser(user);
			jsonObject.put("success", true);
			jsonObject.put("user", user.toJSON());
		} catch (Exception e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		} catch (Throwable e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		}
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/insertNewCompany", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertNewCompany(@RequestBody Company company) {
		JSONObject jsonObject = new JSONObject();
		try {
			tableService.newCompany(company);
			jsonObject.put("success", true);
			jsonObject.put("user", company.toJSON());
		} catch (Exception e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		} catch (Throwable e) {
			jsonObject.put("success", false);
			jsonObject.put("message", e.getMessage());
		}
		return jsonObject.toString();
	}
}
