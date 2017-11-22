package br.com.pluginformatica.main;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pluginformatica.model.Agenda;

public class InserindoContatos {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbAgenda");
		EntityManager em = emf.createEntityManager();
		
		Agenda contato = new Agenda("Urso Anselmo", "(87)9.9988-0001", Date.valueOf("2017-11-21"));
		
		em.getTransaction().begin();
		em.persist(contato);
		em.getTransaction().commit();
		
		System.out.println("Contato salvo com sucesso!");		

	}

}
