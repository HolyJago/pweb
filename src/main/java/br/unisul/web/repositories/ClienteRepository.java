package br.unisul.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.web.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
