package br.com.digitalRepository.back.repository;

import br.com.digitalRepository.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 8, 2022
 */

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

	User findByUsername(String username);
	
}
