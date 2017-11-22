package br.com.pluginformatica.main;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pluginformatica.model.Agenda;

public class AtualizandoContatos {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbAgenda");
		EntityManager em = emf.createEntityManager();
		
		Agenda contato = em.find(Agenda.class, 3L);
				
		em.getTransaction().begin();
		contato.setDataRegistro(Date.valueOf("2017-11-21"));		
		em.getTransaction().commit();
		System.out.println("Contato atualizado com suscesso!");

	}

}
