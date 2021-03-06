package br.gov.sp.fatec.springbootapp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Empresa;
import br.gov.sp.fatec.springbootapp.entity.Fornecedor;
import br.gov.sp.fatec.springbootapp.repository.EmpresaRepository;
import br.gov.sp.fatec.springbootapp.repository.FornecedorRepository;
import br.gov.sp.fatec.springbootapp.service.EmpresaService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

	@Autowired
	private FornecedorRepository forneRepo;

	@Autowired
	private EmpresaRepository empreRepo;

	@Autowired
	private EmpresaService empresaService;

	@Test
	void contextLoads() {
	}

	@Test
	void fornecedorRepositorySaveTest() {
		Fornecedor frn = new Fornecedor();
		frn.setNome("testeFornecedor");
		forneRepo.save(frn);
		assertNotNull(frn.getId());
	}

	@Test
	void empresaRepositorySaveTest() {
		Fornecedor frn = new Fornecedor();
		frn.setNome("testeFornecedor1");
		forneRepo.save(frn);

		Empresa emp = new Empresa();
		emp.setNome("testeEmpresa");
		emp.setSetor("testeSetor");
		emp.setFornecedores(new HashSet<Fornecedor>());
		emp.getFornecedores().add(frn);
		empreRepo.save(emp);

		assertNotNull(emp.getId());
	}

	@Test
	void fornecedorRepositoryFindByNomeTest() {
		Fornecedor frn = new Fornecedor();
		frn.setNome("testeFornecedor2");
		forneRepo.save(frn);
		assertNotNull(forneRepo.findByNome("testeFornecedor2"));
	}

	@Test
	void empresaServiceCadastrarEmpresaTest() {
		empresaService.cadastrarEmpresa("testeNome", "testeSetor", "testeFornecedor");
		
		assertNotNull(empreRepo.findByNome("testeNome").getId());
	}
	
	@Test
	void empresaServiceFindByNomeAndSetorTest() {
		empresaService.cadastrarEmpresa("testeNome", "testeSetor", "testeFornecedor");
		
		assertNotNull(empreRepo.findByNomeAndSetor("testeNome", "testeSetor").getId());
	}
	
	@Test
	void empresaRepositoryFindByFornecedoresNomeTest() {
		empresaService.cadastrarEmpresa("testeNome", "testeSetor", "testeFornecedor");
		
		assertFalse(empreRepo.findByFornecedoresNome("testeFornecedor").isEmpty());
	
	}

}

