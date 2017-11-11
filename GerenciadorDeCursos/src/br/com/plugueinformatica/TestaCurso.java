package br.com.plugueinformatica;

import java.util.List;

public class TestaCurso {

    public static void main(String[] args) {

        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Leonardo Anselmo");
        //List<Aula> aulas = javaColecoes.getAulas();
        //System.out.println(aulas);

        //Aula aula1 = new Aula("Trabalhando com ArrayLists", 21);
        //Aula aula2 = new Aula("Aprendendo JavaFX8", 21);

        //aulas.add(aula1);
        //aulas.add(aula2);
        //aulas.add(new Aula("Coleções em Java", 21));



        //javaColecoes.getAulas().add(new Aula("Generations", 21));
        javaColecoes.adiciona(new Aula("Strings", 18));
        javaColecoes.adiciona(new Aula("Coleções em Java", 21));
        javaColecoes.adiciona(new Aula("Aprendendo JavaFX8", 21));

      //  System.out.println(aulas+" - objeto aula");

        System.out.println(javaColecoes.getAulas()+" - javaColeções");

       // System.out.println(aulas == javaColecoes.getAulas());

    }

}
