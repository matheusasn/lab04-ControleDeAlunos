package controle;

import java.util.HashSet;
/*
 * Classe grupo, Fica responsavel por controlar o get e set dos grupos de alunos, possue o 
 * toString do HashSet de alunos que pecorre com um for e ver todos os alunos ali presentes,
 * se utiliza um HashSet para que os alunos não possam ser repetidos dentro de de grupo. 
 */
public class Grupo {
	private String nome;
	private HashSet<Aluno> alunos;

	public Grupo(String grupo) {
		this.nome = grupo;
		this.alunos = new HashSet<>();
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
		retorno += Main.ln + "Alunos do grupo " + this.nome + Main.ln;
		for (Aluno aluno : alunos) {
			retorno += "Aluno: " + aluno.getMatricula() + " - " + aluno.getNome() + " - " + aluno.getCurso();
		}
		return retorno;
	}

}
