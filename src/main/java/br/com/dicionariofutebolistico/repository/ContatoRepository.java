package br.com.dicionariofutebolistico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dicionariofutebolistico.model.Contato;


@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
   
}

