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
				cadastrarAluno();
			} else if (entrada.equals("E")) {
				exibirAluno();
			} else if (entrada.equals("N")) {
				criaGrupo();
			} else if (entrada.equals("A")) {
				alocaAlunoEGrupo();
			} else if (entrada.equals("R")) {
				alunosQueRespondem();
			} else if (entrada.equals("I")) {
				exibirAlunosQueRespondem();
			} else if (entrada.equals("O")) {
				break;
			} else {
				System.out.println("OPÇÃO INVÁLIDA!");
			}

		} while (true);
	}

	private static void cadastrarAluno() {
		try {
			System.out.print("Matrícula: ");

			int matricula = sc.nextInt();
			sc.nextLine();

			System.out.print("Nome: ");
			String nome = sc.nextLine();

			System.out.print("Curso: ");
			String curso = sc.nextLine();

			controle.cadastrar(matricula, nome, curso);
			
		} catch (InputMismatchException e) {
			System.out.println("Matricula Ivalida!" + ln);
		} catch (IllegalArgumentException i) {
			System.out.println("Argumento invalido." + ln);
		}
		
	}

	private static void exibirAluno() {
		try {
			System.out.print("Matrícula: ");
			int matricula = sc.nextInt();
			sc.nextLine();

			controle.consultarAluno(matricula);
		} catch (InputMismatchException e) {
			System.out.println("Matricula Ivalida!" + ln);
		}

	}

	private static void criaGrupo() {
		System.out.print("Grupo: ");
		String novoGrupo = sc.nextLine();
		if (novoGrupo == null || novoGrupo == "") {
			System.out.println("Entrada Invalida!" + ln);
		} else {
			controle.grupo(novoGrupo.toLowerCase());
		}

	}

	private static void alocaAlunoEGrupo() {
		try {
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

				System.out.println(controle.retornaGrupo(nomeGrupo));
			} else {
				System.out.println("OPÇÃO INVÁLIDA!" + ln);
			}
		} catch (InputMismatchException e) {
			System.out.println("Matricula Ivalida!" + ln);
		} catch (NullPointerException i) {
			System.out.println("Entrada Invalida!" + ln);

		}
	}

	private static void alunosQueRespondem() {
		try {
			System.out.println("Matricula: ");
			int matriculaAluno = sc.nextInt();
			sc.nextLine();
			controle.alunosRespodem(matriculaAluno);
		} catch (InputMismatchException e) {
			System.out.println("Matricula Ivalida!" + ln);
		}
	}

	private static void exibirAlunosQueRespondem() {
		System.out.println("Alunos: " + ln);
		System.out.println(controle.retornoAlunosRespodem());
	}

}
