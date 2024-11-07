package br.com.dicionariofutebolistico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dicionariofutebolistico.model.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

}
