package com.jsp.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveData { 
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hapi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		JobPortal j1 = new JobPortal();
		j1.setSkill("java");
		j1.setState("karnataka");
		j1.setCompany("TechA Solution");
		j1.setLocation("bengaluru");
		j1.setRole("developer");
		
		JobPortal j2 = new JobPortal();
		j2.setSkill("Python");
		j2.setState("karnataka");
		j2.setCompany("TechB Solution");
		j2.setLocation("bengaluru");
		j2.setRole("developer");
		
		et.begin();
		em.persist(j1);
		em.persist(j2);
		et.commit();
	}
}
