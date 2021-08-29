package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootapp.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    
}
