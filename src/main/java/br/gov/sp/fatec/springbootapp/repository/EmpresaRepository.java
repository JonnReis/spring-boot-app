package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    public List<Empresa> findByFornecedoresNome(String fornecedor);
    
}
