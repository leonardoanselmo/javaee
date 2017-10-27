package controle;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "controlePrincipal")
@SessionScoped
public class ControlePrincipal implements Serializable {
	
	private String mensagem;
	
	public ControlePrincipal() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:S");		
		this.mensagem = "A Aplicação foi ao ar no momento: "+sdf.format(Calendar.getInstance().getTime());
	}
	
	public String sobre() {
		mensagem = "Você navegou maneira dinamica. método sobre";
		return "sobre";
	}
	
	public String sobreRedirecionado() {
		mensagem = "Você foi redirecionado para a pagina sobre.xhtml";
		return "sobre?faces-redirect=true";
	}
	
	public String geraErro() {
		return "erro";
	}
	
	public String geraLogin() { 
		return "login";
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}	

}
