package br.com.digitalRepository.back.controller;

import java.util.List;
import br.com.digitalRepository.back.entity.LessonPlan;
import br.com.digitalRepository.back.repository.LessonPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@RestController
@RequestMapping("/v1")
public class LessonPlanController {
	
	@Autowired
	private LessonPlanRepository lessonPlanRepository;

	@GetMapping("/lessons")
	public List<LessonPlan> findAll() {
		return lessonPlanRepository.findAll();
	}

	@GetMapping("/lessons/{id}")
	public LessonPlan findById(@PathVariable(value = "id") Long lessonId) {
		return lessonPlanRepository.findById(lessonId).get();
	}
	
	@PutMapping("/lessons/{id}")
	public ResponseEntity<LessonPlan> update(@PathVariable(value = "id") Long lessonId, @RequestBody LessonPlan lesson) { 
		return null;
	}

	@PostMapping("/lessons")
	public LessonPlan save(@RequestBody LessonPlan lessonPlan) {
		return lessonPlanRepository.save(lessonPlan);
	}

	@DeleteMapping("/lessons/{id}")
	public void delete(@PathVariable(value = "id") Long lessonId) {
		LessonPlan lesson = lessonPlanRepository.findById(lessonId).get();
		lessonPlanRepository.delete(lesson);
	}

}
