package br.com.pluginformatica.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemovendoContato {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbAgenda");
		EntityManager em = emf.createEntityManager();
		
		Agenda contato = em.find(Agenda.class, 4L);
		
		if (contato != null) {
			em.getTransaction().begin();
			em.remove(contato);
			em.getTransaction().commit();
			System.out.println("Contato excluído com sucesso!");
		} else {
			System.out.println("Contato não encontrado!");
		}

	}

}
