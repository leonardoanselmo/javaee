package br.com.plugueinformatica;

public class TestaBuscaAlunosNoCurso {

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

        System.out.println("Quem é o aluno que tem a matricula: 4565?");
        Aluno aluno = javaColecoes.buscaMatriculado(1234);
        System.out.println(aluno);

    }
}
