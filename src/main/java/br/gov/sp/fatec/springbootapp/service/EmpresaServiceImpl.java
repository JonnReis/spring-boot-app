package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Empresa;
import br.gov.sp.fatec.springbootapp.entity.Fornecedor;
import br.gov.sp.fatec.springbootapp.repository.EmpresaRepository;
import br.gov.sp.fatec.springbootapp.repository.FornecedorRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    
    @Autowired
	private FornecedorRepository forneRepo;
    
	@Autowired
	private EmpresaRepository empreRepo;
    
    @Transactional
    public Empresa cadastrarEmpresa(String nome, String setor, String fornecedor) {
        
        Fornecedor frn = forneRepo.findByNome(fornecedor);
		if(frn == null) {
			frn = new Fornecedor();
			frn.setNome(fornecedor);
			forneRepo.save(frn);
		}
		Empresa emp = new Empresa();
		emp.setNome(nome);
		emp.setSetor(setor);
		emp.setFornecedores(new HashSet<Fornecedor>());
		emp.getFornecedores().add(frn);
		empreRepo.save(emp);

        return emp;
    }
    
}
