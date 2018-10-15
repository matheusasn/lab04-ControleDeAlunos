package controle;

import java.util.ArrayList;
import java.util.HashMap;

public class Controle {
	
	private HashMap<Integer, Aluno> alunosCadastrados = new HashMap<>();
	private HashMap<String, Grupo> gruposCadastrados = new HashMap<>();
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
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
	public void alocarAluno(int matricula, String nomeGrupo) {
		Aluno aluno = alunosCadastrados.get(matricula);
		Grupo grupo = gruposCadastrados.get(nomeGrupo);
		if (aluno == null){
			System.out.println("Aluno não cadastrado.");
		
		}else if (grupo == null){
			System.out.println("Grupo não cadastrado.");
		
		}else {
			grupo.addAluno(aluno);	
			System.out.println("ALUNO ALOCADO!");
		}
	}
	public String retornaGrupo(String nomeGrupo) {
		Grupo grupo = gruposCadastrados.get(nomeGrupo);
		return grupo.toString();
	}
	public void alunosRespodem(int matricula) {
		Aluno aluno = alunosCadastrados.get(matricula);
		this.alunos.add(aluno);
		System.out.println("ALUNO REGISTRADO!");
	}
	public String RetornoAlunosRespodem() {
		String retorno = "";
		int cont = 0;
		for (Aluno aluno: alunos){
			cont +=1;
			retorno += aluno.getMatricula() + " - " + aluno.getNome() + " - " + aluno.getCurso() +Main.ln;
		}
	return cont + retorno;
	}
}