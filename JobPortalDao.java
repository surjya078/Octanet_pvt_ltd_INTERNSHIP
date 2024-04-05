package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jsp.entity.JobPortal;

@Component
public class JobPortalDao {
	
	public List<JobPortal> findBySkillAndState(String skill, String state){
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hapi");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select a from JobPortal a where a.skill=?1 and a.state=?2");
		q.setParameter(1, skill);
		q.setParameter(2, state);
		
		List<JobPortal> list = q.getResultList();
		return list;
	
	}
	
	

}
