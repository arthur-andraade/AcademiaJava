package br.atos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.atos.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
