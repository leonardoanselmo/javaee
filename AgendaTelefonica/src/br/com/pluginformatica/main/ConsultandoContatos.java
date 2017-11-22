package br.com.pluginformatica.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.pluginformatica.model.Agenda;

public class ConsultandoContatos {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbAgenda");
		EntityManager em = emf.createEntityManager();
				
		Agenda contato = em.find(Agenda.class, 2L);
		
		if (contato != null) {
			System.out.println("Nome: "+contato.getNome());
			System.out.println("Telefone: "+contato.getTelefone());
			System.out.println("Data de registro: "+contato.getDataRegistro());
		} else {
			System.out.println("Contato não existe!");
		}

	}

}
