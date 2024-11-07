package br.com.dicionariofutebolistico.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dicionariofutebolistico.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
    
}

