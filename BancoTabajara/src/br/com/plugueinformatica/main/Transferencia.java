package br.com.plugueinformatica.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Transferencia {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbTabajara");
		EntityManager em = emf.createEntityManager();

	}

}
