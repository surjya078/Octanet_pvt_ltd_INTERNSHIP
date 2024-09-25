package com.jsp.driver;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.JobPortalDao;
import com.jsp.entity.JobPortal;

@Controller
public class JobDriver {
	
	@Autowired
	JobPortalDao jdao;

	@RequestMapping("/searchengine")
	public ModelAndView getResult(ServletRequest req) {
		// TODO Auto-generated method stub
	 String skill =	req.getParameter("skill");
	 String state = req.getParameter("state");
	 
	 List<JobPortal> list = jdao.findBySkillAndState(skill, state);
	 
	 ModelAndView mv = new ModelAndView();
	 mv.addObject("jobobj", list);
	 mv.setViewName("index.jsp");
	 
	 return mv;
	}
	
}
