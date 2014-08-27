package com.dab.docscoring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dab.docscoring.form.LoginForm;
import com.dab.docscoring.hibernate.dao.CompanyDAO;
import com.dab.docscoring.hibernate.dao.UserDAO;
import com.dab.docscoring.hibernate.model.User;

@Controller
@RequestMapping("/login")
@SessionAttributes("companies")
public class LoginController {
 
	@Autowired private CompanyDAO companyDAO;
	@Autowired private UserDAO userDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("companies", companyDAO.findAll());
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@RequestMapping( method = RequestMethod.POST)
	public String logon(@Valid LoginForm loginForm, BindingResult result, ModelMap model, HttpServletRequest request) {
		if(result.hasErrors()){
			return "login";
		} else {
			String userName = loginForm.getUserName();
			Integer company = loginForm.getCompany();
			String pass = loginForm.getUserPassword();

			User user = userDAO.findByName(userName);
			if(user == null){
				result.addError(new ObjectError("loginForm", "Usuario inválido"));
			}
			if(!pass.equals(user.getPassword())){
				result.addError(new ObjectError("loginForm", "Clave inválida"));
			}
			if(user.getCompany().getId().equals(company) && pass.equals(user.getPassword())){
				request.getSession().setAttribute("user", user);
				return "redirect:/scoring";
			}
			return "login";
		}
	}
}