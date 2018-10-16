package controle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static final String ln = System.lineSeparator();
	public static Scanner sc = new Scanner(System.in);
	public static Controle controle = new Controle();

	public static void Menu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");

		System.out.print(ln + "Opção> ");
	}
	
	public static void main(String[] args) {
		do {
			Menu();

			String entrada = sc.nextLine();

			if (entrada.equals("C")) {
				try {
					System.out.print("Matrícula: ");

					int matricula = sc.nextInt();
					sc.nextLine();

					System.out.print("Nome: ");
					String nome = sc.nextLine();

					System.out.print("Curso: ");
					String curso = sc.nextLine();

					controle.cadastra(matricula, nome, curso);

				} catch (InputMismatchException e) {
					System.out.println("Valor diferente de um inteiro.");
				} catch (IllegalArgumentException i) {
					System.out.println("Argumento invalido.");
				}

			} else if (entrada.equals("E")) {
				
				System.out.print("Matrícula: ");
				int matricula = sc.nextInt();
				sc.nextLine();

				controle.consultarAluno(matricula);

			} else if (entrada.equals("N")) {

				System.out.print("Grupo: ");
				String novogrupo = sc.nextLine();

				controle.grupo(novogrupo.toLowerCase());

			} else if (entrada.equals("A")) {

				System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
				String opcao = sc.nextLine();

				if (opcao.equals("A")) {
					System.out.println("Matricula: ");
					int matricula = sc.nextInt();
					sc.nextLine();

					System.out.println("Grupo: ");
					String grupo = sc.nextLine();

					controle.alocarAluno(matricula, grupo);

				} else if (opcao.equals("I")) {
					System.out.println("Grupo: ");
					String nomeGrupo = sc.nextLine();
					
					controle.retornaGrupo(nomeGrupo);
				} else {
					System.out.println("OPÇÃO INVÁLIDA!");
				}

			} else if (entrada.equals("R")) {
				System.out.println("Matricula: ");
				int matriculaAluno = sc.nextInt();
				sc.nextLine();
				controle.alunosRespodem(matriculaAluno);
				
			} else if (entrada.equals("I")) {
				System.out.println("Alunos: "+ln);
				System.out.println(controle.retornoAlunosRespodem()); 

			} else if (entrada.equals("O")) {
				break;

			} else {
				System.out.println("OPÇÃO INVÁLIDA!");
			}

		} while (true);
	}
}
