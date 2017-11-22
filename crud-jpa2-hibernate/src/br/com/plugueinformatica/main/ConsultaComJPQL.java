package br.com.plugueinformatica.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.plugueinformatica.model.Cliente;

public class ConsultaComJPQL {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();

		List<Cliente> clientes = em.createQuery("from Cliente where sexo = 'M'", Cliente.class).getResultList();
		
		for (Cliente cliente : clientes) {
			System.out.println("Código: "+cliente.getCodigo());
			System.out.println("Nome: "+cliente.getNome());
			System.out.println("Sexo: "+cliente.getSexo());
			System.out.println("Profissão: "+cliente.getProfissao());
			System.out.println("----------------------------------");
		}

	}

}
