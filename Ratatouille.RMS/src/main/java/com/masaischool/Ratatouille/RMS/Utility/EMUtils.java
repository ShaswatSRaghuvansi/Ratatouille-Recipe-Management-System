package com.masaischool.Ratatouille.RMS.Utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {
	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("dbconnect"); // connection to persistence.xml file
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
