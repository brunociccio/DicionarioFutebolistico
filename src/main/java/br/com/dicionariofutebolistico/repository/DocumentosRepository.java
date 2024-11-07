package br.com.dicionariofutebolistico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dicionariofutebolistico.model.Documentos;

@Repository
public interface DocumentosRepository extends JpaRepository<Documentos, Long> {

}
