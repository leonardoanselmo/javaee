package br.com.plugueinformatica;

import java.util.*;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new ArrayList<>();
    private Set<Aluno> aluno = new HashSet<>();

    public Curso(String nome, String instrutor){
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public void adiciona(Aula aula){
        this.aulas.add(aula);
    }

    public int getTempoTotal(){
        int tempoTotal = 0;
        for (Aula aula: aulas) {
            tempoTotal += aula.getTempo();
        }
        return tempoTotal;
    }

    public int getTempoTotalJava8(){
        return this.aulas.stream().mapToInt(Aula::getTempo).sum();
    }

    @Override
    public String toString() {
        return "Curso: "+nome+", tempo total: "+getTempoTotalJava8()+"\n"+
                "Aulas: "+this.aulas;

    }

    public void matricula(Aluno aluno) {
        this.aluno.add(aluno);
    }

    public Set<Aluno> getAluno() {
        return Collections.unmodifiableSet(aluno);
    }

    public boolean estaMatriculado(Aluno aluno) {
        return this.aluno.contains(aluno);
    }
}
