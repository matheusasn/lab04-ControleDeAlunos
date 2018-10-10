package controle;

public class Aluno {

	private int matricula;
	private String nome;
	private String curso;
	
	public Aluno(int matricula, String nome, String curso) {
		
		if (nome == null || curso == null) {
			throw new NullPointerException();
		}else if (nome.equals("") || curso.equals("")) {
			throw new IllegalArgumentException();
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		
	}
	@Override
	public String toString() {
		return Main.ln+"Aluno: " + matricula + " - " + nome + " - " + curso +Main.ln;
	}
}

