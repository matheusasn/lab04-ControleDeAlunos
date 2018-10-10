package controle;

import java.util.HashMap;

public class Controle {
	private HashMap<Integer, Aluno> alunosCadastrados = new HashMap<>();
	private HashMap<String, Grupo> gruposCadastrados = new HashMap<>();
	
	public void cadastra(int matricula, String nome, String curso) {
		
		if (this.alunosCadastrados.containsKey(matricula)) {
			System.out.println("MATRÍCULA JÁ CADASTRADA!"+Main.ln); 

		} else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			this.alunosCadastrados.put(matricula, aluno);
			System.out.println("CADASTRO REALIZADO!"+Main.ln);
		}
	}
	public void consultarAluno(int matricula) {
		Aluno aluno = alunosCadastrados.get(matricula);
		if(aluno == null) {
			System.out.println("Aluno não cadastrado."+Main.ln);
		}else {
			System.out.println(aluno.toString());
		}
		
	}
	public void grupo(String nome) {
		if (this.gruposCadastrados.containsKey(nome)) {
			System.out.println("GRUPO JÁ CADASTRADO!");
		}else {
			Grupo nomegrupo = new Grupo(nome);
			this.gruposCadastrados.put(nomegrupo.getNome(),nomegrupo);
			System.out.println("CADASTRO REALIZADO!");
		}
	
	}
}