package br.com.digitalRepository.back.repository;

import br.com.digitalRepository.back.entity.LessonPlan;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 8, 2022
 */

public interface LessonPlanRepository extends JpaRepository <LessonPlan, Long>{
	
    List<LessonPlan> findByEnabledTrue();

    List<LessonPlan> findByAuthor(String username);
}

