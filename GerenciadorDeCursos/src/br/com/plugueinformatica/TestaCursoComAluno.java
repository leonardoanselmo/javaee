package br.com.plugueinformatica;

import java.util.Iterator;
import java.util.Set;

public class TestaCursoComAluno {

    public static void main(String[] args) {

        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Leonardo Anselmo");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayLists", 21));
        javaColecoes.adiciona(new Aula("Criando uma classe Aula", 18));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 20));

        Aluno a1 = new Aluno("Leonardo Anselmo", 3245);
        Aluno a2 = new Aluno("Débora Anselmo", 4565);
        Aluno a3 = new Aluno("Paty Anselmo", 1234);

        javaColecoes.matricula(a1);
        javaColecoes.matricula(a2);
        javaColecoes.matricula(a3);

        System.out.println("Todos os alunos matriculados: ");
        /*javaColecoes.getAluno().forEach(a -> {
            System.out.println(a);
        });
*/
        Set<Aluno> alunos = javaColecoes.getAluno();
        Iterator<Aluno> iterador = alunos.iterator();
        while (iterador.hasNext()){
            Aluno proximo = iterador.next();
            System.out.println(proximo);
        }



        System.out.println("O Aluno: "+a1+" está matriculado?");
        System.out.println(javaColecoes.estaMatriculado(a1));


        Aluno anselmo = new Aluno("Leonardo Anselmo", 3245);
        System.out.println(javaColecoes.estaMatriculado(anselmo));



    }
}
