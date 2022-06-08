package br.com.digitalRepository.back.repository;

import br.com.digitalRepository.back.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 8, 2022
 */

public interface ComponentRepository extends JpaRepository <Component, Long>{
	
	
}
