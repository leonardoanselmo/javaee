package br.com.plugueinformatica.jdbc.exception;

public class NegocioException extends Exception {
	
	private static final long serialVersionUID = -5322252042721067794L;
	
	public NegocioException(String msg, Exception exception) {
		super(msg, exception);
	}
	
	public NegocioException(String msg) {
		super(msg);
	}
	
	public double somar(double num1, double num2) {
		return num1 + num2;
	}


}
