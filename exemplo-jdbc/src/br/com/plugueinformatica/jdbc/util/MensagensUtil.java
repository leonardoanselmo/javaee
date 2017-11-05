package br.com.plugueinformatica.jdbc.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MensagensUtil {
			
	public void addMsg(Object component, String msg) {
		JOptionPane.showMessageDialog((Component) component, msg);
	}
	
	public void exibirMensagem(String mensagem) {
		System.out.println(mensagem);
	}
	
	
}
