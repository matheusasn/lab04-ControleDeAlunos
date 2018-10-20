package controle;

import java.util.ArrayList;
import java.util.HashMap;
/*
 * Classe Controle, responsavel por controlar grande parde das informações inseridas 
 * na MAIN, Para que as classes Aluno e Grupo receba essas informaçoes e as armazena.
 */
public class Controle {
	/*
	 * 
	 */
	private HashMap<Integer, Aluno> alunosCadastrados = new HashMap<>();
	private HashMap<String, Grupo> gruposCadastrados = new HashMap<>();
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	/*
	 * Método cadastra, Recebe as informações de um aluno, tás como Matricula(INT), Nome(STR)
	 * e Curso(STR) e armazena essas informações em um HashMap<Integer, Aluno> do tipo int e 
	 * para pegar novamente essas informações é só procurar pela matricula do respectivo aluno.
	 */
	public boolean cadastrar(int matricula, String nome, String curso) {

		if (this.alunosCadastrados.containsKey(matricula)) {
			System.out.println("MATRÍCULA JÁ CADASTRADA!" + Main.ln);
			return false;
		} else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			this.alunosCadastrados.put(matricula, aluno);
			System.out.println("CADASTRO REALIZADO!" + Main.ln);
			return true;
		}
		
		
	}
	/*
	 * Método responsavel por retornar o toString do aluno matriculado, informações como
	 * Matricula(INT), Nome(STR) e Curso(STR). O aluno é localizado atravez de sua Matricula(INT)
	 * caso o aluno n esteja cadastrado uma mensagem "Aluno não cadastrado." retorna para o usuário.   
	 */
	public boolean consultarAluno(int matricula) {
		Aluno aluno = alunosCadastrados.get(matricula);
		if (aluno == null) {
			System.out.println("Aluno não cadastrado." + Main.ln);
			return false;
		} else {
			System.out.println(aluno.toString());
			return true;
		}

	}
	
	/*
	 * Método grupo, Cria um grupo de alunos não repetidos para isso o uso do HashMap.
	 * Caso o grupo já tenha sido cadastrado não terá como ter um novo grupo com o mesmo nome.
	 */
	public boolean grupo(String nome) {
		if (this.gruposCadastrados.containsKey(nome)) {
			System.out.println("GRUPO JÁ CADASTRADO!" + Main.ln);
			return false;
		} else {
			Grupo nomegrupo = new Grupo(nome);
			this.gruposCadastrados.put(nomegrupo.getNome(), nomegrupo);
			System.out.println("CADASTRO REALIZADO!" + Main.ln);
			return true;
		}

	}
	/*
	 * Apóis o grupo ter sido criado, o usuário poderá alocar alunos em qualquer grupo existente.
	 */
	public boolean alocarAluno(int matricula, String nomeGrupo) {
		
		Aluno aluno = alunosCadastrados.get(matricula);
		Grupo grupo = gruposCadastrados.get(nomeGrupo);
		if (aluno == null) {
			System.out.println("Aluno não cadastrado." + Main.ln);
			return false;
		} else if (grupo == null) {
			System.out.println("Grupo não cadastrado." + Main.ln);
			return false;
		} else {
			grupo.addAluno(aluno);
			System.out.println("ALUNO ALOCADO!" + Main.ln);
			return true;
		}
		
	}
	/*
	 * Método parecido com um toString, pois retorna os alunos alocados em seu grupo.
	 */
	public String retornaGrupo(String nomeGrupo) {
		Grupo grupo = gruposCadastrados.get(nomeGrupo);
		return grupo.toString();
	}
	/*
	 * Método que armazena os alunos que respodem perguntas no quadro em um ArrayList de Alunos
	 * fica em um array pois o mesmo aluno pode responder no quadro varias vezes, Pega as informa-
	 * ções do aluno atravez de sua Matricula(INT).
	 */
	public boolean alunosRespodem(int matricula) {
		Aluno aluno = alunosCadastrados.get(matricula);
		this.alunos.add(aluno);
		System.out.println("ALUNO REGISTRADO!" + Main.ln);
		return true;
	}
	/*
	 * Método que pecorre o ArrayList de alunos que respodem perguntas no quadro, e retorna
	 * suas informações em um formato de String na ordem em que os alunos foram responder.
	 */
	public String retornoAlunosRespodem() {
		String retorno = "";
		int cont = 0;
		for (Aluno aluno : alunos) {
			cont += 1;
			retorno += cont + ". " + aluno.getMatricula() + " - " + aluno.getNome() + " - " + aluno.getCurso()
					+ Main.ln;
		}
		return retorno;
	}
	
}