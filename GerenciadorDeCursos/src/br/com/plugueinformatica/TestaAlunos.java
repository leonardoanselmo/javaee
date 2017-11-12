package br.com.plugueinformatica;

import java.util.*;

public class TestaAlunos {

    public static void main(String[] args) {

        Set<String> alunos = new HashSet<>();

        alunos.add("Leonardo Anselmo");
        alunos.add("Debora Anselmo");
        alunos.add("Paty Anselmo");
        alunos.add("Tuta Anselmo");
        alunos.add("Cezar Anselmo");
        alunos.add("Ló Anselmo");
        alunos.add("Tuta Anselmo");

        System.out.println(alunos.size());

        alunos.remove("Ló Anselmo");

        for (String aluno : alunos) {
            System.out.println(aluno);
        }

        String aluno = "Leonardo Anselmo";
        boolean alunoMatriculado = alunos.contains(aluno);

        if (alunoMatriculado == true){
            System.out.println("Sim! O aluno: "+aluno+" está matriculado.");
        } else {
            System.out.println("Não existe esse aluno: "+aluno+" na nossa base de dados.");
        }

        List<String> alunosNaLista = new ArrayList<>(alunos);
        Collections.sort(alunosNaLista);
        System.out.println(alunosNaLista);

    }

}
