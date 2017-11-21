package br.com.plugueinformatica.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.plugueinformatica.model.Cliente;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo Anselmo");
		cliente.setIdade(38);
		cliente.setProfissao("Programador");
		cliente.setSexo("M");
		
		em.getTransaction().begin();		
		em.persist(cliente);
		em.getTransaction().commit();
		
		
		System.out.println("Cliente salvo com sucesso!");
		
		
		//em.close();
		

	}

}
