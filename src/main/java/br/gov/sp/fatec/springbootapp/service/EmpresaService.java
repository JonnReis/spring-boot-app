package br.gov.sp.fatec.springbootapp.service;

import br.gov.sp.fatec.springbootapp.entity.Empresa;

public interface EmpresaService {

    public Empresa cadastrarEmpresa(String nome, String setor, String fornecedor);
    
}
