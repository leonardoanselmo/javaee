package br.com.plugueinformatica.jdbc.exception;

public class PersistenciaException extends Exception{

	private static final long serialVersionUID = -5322252042721067794L;
	
	public PersistenciaException(String msg, Exception exception) {
		super(msg, exception);
	}
	
	public PersistenciaException(String msg) {
		super(msg);
	}

}
