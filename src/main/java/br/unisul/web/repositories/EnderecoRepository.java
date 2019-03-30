package br.unisul.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.web.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
