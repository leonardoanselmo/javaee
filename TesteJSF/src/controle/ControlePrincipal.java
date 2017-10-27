package controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "controlePrincipal")
@RequestScoped
public class ControlePrincipal implements Serializable{
	
	private String nome;
	
	public ControlePrincipal() {
		this.nome = "Leonardo Anselmo";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
