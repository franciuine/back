package br.com.digitalRepository.back.controller;

import java.util.List;
import br.com.digitalRepository.back.entity.LessonPlan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@RestController
@RequestMapping("/lessons")
public class LessonPlanController {

	@GetMapping("/load")
	public List<LessonPlan> findAll() {
		return null;
	}

	@GetMapping("/load/by/id/{id}")
	public LessonPlan findById(@PathVariable(value = "id") Long lessonId) {
		return null;
	}

	@PostMapping("/save")
	public void save(@RequestBody LessonPlan lessonPlan) {
	}

	@DeleteMapping("/delete")
	public void delete(@PathVariable(value = "id") Long lessonId) {

	}

}
