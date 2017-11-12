package br.com.plugueinformatica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {

    public static void main(String[] args) {

        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Leonardo Anselmo");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayLists", 21));
        javaColecoes.adiciona(new Aula("Criando uma classe Aula", 18));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 20));

        System.out.println(javaColecoes.getAulas());

        List<Aula> aulasImutaveis = javaColecoes.getAulas();
        System.out.println(aulasImutaveis);

        List<Aula> aulas = new ArrayList<>(aulasImutaveis);

        Collections.sort(aulas);
        System.out.println(aulas);
        System.out.println(javaColecoes.getTempoTotal());
        System.out.println(javaColecoes.getTempoTotalJava8());

   }

}
