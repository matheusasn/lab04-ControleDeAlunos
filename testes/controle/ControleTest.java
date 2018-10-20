package controle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleTest extends Controle {
	private Controle controle;
	
	@BeforeEach
	void setUp() {
		controle = new Controle();
		//Alunos cadastrados para testes futuros.
		controle.cadastrar(200, "Angela Ziegler", "Medicina");
		controle.cadastrar(201,"Torbjorn Lindholm","Engenharia Mecanica");
		controle.cadastrar(209,"Matheus gaudencio","Sou professor, respeita");
		//Grupos criados para testes futuros.
		controle.grupo("Primeiro grupo");
		controle.grupo("Segundo grupo");
		controle.grupo("Terceiro grupo");
		
	}
	@Test
	void testCadastra() {
		// Teste para saber se o aluno foi cadastrado com sucesso.
		assertEquals(true,controle.cadastrar(250,"Gabriel Reyes","Computação"));
		// Teste para saber se a matricula do aluno já está cadastrada
		assertEquals(false,controle.cadastrar(250,"Gabriel Reyes","Computação"));
	}

	@Test
	void testConsultarAluno() {
		// Teste para saber se o aluno está cadastrado.
		assertEquals(true,controle.consultarAluno(209));
		// Teste para saber se o aluno realmente não está cadastrado.
		assertEquals(false,controle.consultarAluno(500));
		
	}

	@Test
	void testGrupo() {
		//Teste para cadastrar alguns grupos.
		assertEquals(true, controle.grupo("Testgrupo1"));
		assertEquals(true, controle.grupo("Testgrupo2"));
		assertEquals(true, controle.grupo("Testgrupo3"));
		//Teste para ver se realmente n cadastra o mesmo grupo mais de uma vez.
		assertEquals(false, controle.grupo("Testgrupo1"));
		assertEquals(false, controle.grupo("Testgrupo2"));
		assertEquals(false, controle.grupo("Testgrupo3"));
	}

	@Test
	void testAlocarAluno() {
		// Teste para saber se o aluno foi alocado para o grupo designado.
		assertEquals(true, controle.alocarAluno(200, "Primeiro grupo"));
		assertEquals(true, controle.alocarAluno(201, "Primeiro grupo"));
		// Teste para saber se o estão cadastrar em um aluno no grupo que n existe.
		assertEquals(false, controle.alocarAluno(200, "GrupoFalso"));
		assertEquals(false, controle.alocarAluno(201, "GrupoFalso2"));
		// Teste para não cadastrar um aluno que não existe em um grupo.
		assertEquals(false, controle.alocarAluno(300, "Primeiro grupo"));
		assertEquals(false, controle.alocarAluno(500, "Primeiro grupo"));

	}

	@Test
	void testAlunosRespodem() {
		// Teste para cadastrar um aluno que respondeu no quadro.
		assertEquals(true, controle.alunosRespodem(201));
		assertEquals(true, controle.alunosRespodem(200));
	
	}
}
