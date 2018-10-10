package controle;
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

		System.out.print(ln+ "Opção> ");
	}		
			
	public static void main(String[] args) {
		do {
			Menu();
			
			String entrada = sc.nextLine();
			
			if(entrada.equals("C")) {
				
				System.out.print("Matrícula: ");
				int matricula = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Nome: ");
				String nome = sc.nextLine();
	
				System.out.print("Curso: ");
				String curso =  sc.nextLine();
				
				controle.cadastra(matricula,nome,curso);
			
			}else if(entrada.equals("E")) {
				
				System.out.print("Matrícula: ");
				int matricula = sc.nextInt();
				sc.nextLine();
				
				controle.consultarAluno(matricula);
			
			}else if(entrada.equals("N")) {
			
				System.out.print("Grupo: ");
				String novogrupo = sc.nextLine();
				
				controle.grupo(novogrupo.toLowerCase());
				
			}else if(entrada.equals("A")) {
				
				System.out.println("(A)locar Aluno ou (I)mprimir Grupo? ");
				// String entrada = sc.nextLine();
				
				if (entrada.equals("A")) {
					System.out.println("Matricula: ");
					String matricula = sc.nextLine();
					sc.nextLine();
					
					System.out.println("Grupo: ");
					String grupo = sc.nextLine();
				}else if (entrada.equals("I")) {
					
				}else {
					System.out.println("OPÇÃO INVÁLIDA!");
				}
				
			}else if(entrada.equals("R")) {
				
			}else if(entrada.equals("I")) {
				
			}else if(entrada.equals("O")) {
				break;
				
			}else {
				System.out.println("OPÇÃO INVÁLIDA!");
			}
			
		}while (true);
	}
}	
