package com.dab.docscoring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dab.docscoring.form.ScoringForm;
import com.dab.docscoring.hibernate.dao.DocumentTypeDAO;
import com.dab.docscoring.hibernate.dao.ScoringDAO;
import com.dab.docscoring.hibernate.model.DocumentValidation;
import com.dab.docscoring.hibernate.model.User;

@Controller
@RequestMapping("/scoring")
@SessionAttributes(value={"documentTypes"})
public class ScoringController {

	@Autowired 
	private DocumentTypeDAO docTypeDAO;
	
	@Autowired 
	private ScoringDAO scoringDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String scoringPage(ModelMap model) {
		model.addAttribute("documentTypes", docTypeDAO.findAll());
		model.addAttribute("scoringForm", new ScoringForm());
		return "scoring/scoring";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String changeScoring(@Valid ScoringForm scoringForm, BindingResult result, ModelMap model, HttpServletRequest request){
		String page = "scoring/scoring";
		if(!result.hasErrors()){
			User user = (User) request.getSession().getAttribute("user");
			System.out.println("USER: "+user);
			Integer minimum = scoringDAO.getMinimumAcceptable(user.getCompany().getId(), scoringForm.getSelectedDocument());
			model.addAttribute("minimum", minimum);
	
			List<DocumentValidation> validations = scoringDAO.getValidations(user.getCompany().getId(), scoringForm.getSelectedDocument());
			
			for (DocumentValidation documentValidation : validations) {
				System.out.println("ADDING VALIDATION: "+validations);
			}
			
			model.addAttribute("validations", validations);
		}
		return page;
	}

	@RequestMapping(value = "processScoring", method = RequestMethod.POST)
	public String processScoring(@Valid ScoringForm scoringForm, BindingResult result, ModelMap model){
		return "scoring/results";
	}
}