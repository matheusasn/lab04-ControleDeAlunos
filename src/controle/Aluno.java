package controle;
/*
 * Classe aluno, Responsavel por todas as informações do aluno como Matricula(INT), Nome(STR)
 * e Curso(STR) retorna o ToString do aluno no formato descrito no final e fica responsavel por
 * todos os get e set.
 */
public class Aluno {

	private int matricula;
	private String nome;
	private String curso;
	/*
	 * Metodo Construtor Aluno, pega as informações e impede que um valor null ou vazio entre
	 * no código causando algum problema.
	 */
	public Aluno(int matricula, String nome, String curso) {

		if (nome == null || curso == null || nome == "" || curso == "") {
			throw new NullPointerException();
		} else if (nome.equals("") || curso.equals("")) {
			throw new IllegalArgumentException();
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;

	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return Main.ln + "Aluno: " + matricula + " - " + nome + " - " + curso + Main.ln;
	}
}
