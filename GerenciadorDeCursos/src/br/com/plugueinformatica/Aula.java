package br.com.plugueinformatica;

public class Aula {
	
	private String titulo;
	private int tempo;
	
	public Aula(String titulo, Integer tempo) {
		this.titulo = titulo;
		this.tempo = tempo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public int getTempo() {
		return tempo;
	}

	@Override
	public String toString() {
		return "Aula: "+getTitulo()+", "+getTempo()+" minutos";
	}
}
