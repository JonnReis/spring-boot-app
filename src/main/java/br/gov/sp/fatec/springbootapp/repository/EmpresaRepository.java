package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootapp.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    public Empresa findByNome(String nome);
    
    public Empresa findByNomeAndSetor(String nome, String setor);
    
    @Query("select n from Empresa n inner join n.fornecedores c where c.nome = ?1")
    public List<Empresa> findByFornecedoresNome(String fornecedor);
    
}
