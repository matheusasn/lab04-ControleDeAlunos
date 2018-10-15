package controle;

import java.util.HashSet;

public class Grupo {
	private String nome;
	private HashSet<Aluno> alunos;

	public Grupo(String grupo) {
		this.nome= grupo;
		this.alunos= new HashSet<>();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public HashSet<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(HashSet<Aluno> alunos) {
		this.alunos = alunos;
	}
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	@Override
	public String toString() {
		String retorno = "";
		retorno += Main.ln+"Alunos do grupo " + this.nome; 
		for(Aluno aluno: alunos) {
			retorno += Main.ln+"Aluno: " + aluno.getMatricula() + " - " + aluno.getNome() + " - " + aluno.getCurso() +Main.ln;
		}
		return retorno; 
	}

}
