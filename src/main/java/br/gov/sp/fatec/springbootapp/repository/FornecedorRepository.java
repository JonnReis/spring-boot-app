package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    public Fornecedor findByNome(String nome);
    
}
