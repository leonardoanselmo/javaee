package br.com.plugueinformatica.jdbc.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MensagensUtil {
	
	public static void addMsg(Object component, String msg) {
		JOptionPane.showMessageDialog((Component) component, msg);
	}

}
