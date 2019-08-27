package br.gov.fazenda.mg.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.fazenda.mg.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}