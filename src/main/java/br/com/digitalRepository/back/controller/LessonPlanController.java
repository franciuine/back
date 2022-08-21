package br.com.digitalRepository.back.controller;

import java.util.List;
import br.com.digitalRepository.back.entity.LessonPlan;
import br.com.digitalRepository.back.repository.LessonPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(value="/lessonplan")
public class LessonPlanController {
	
	@Autowired
	private LessonPlanRepository lessonPlanRepository;

	@GetMapping(value="/all")
	public List<LessonPlan> findAll() {
		return lessonPlanRepository.findAll();
	}
	
	@GetMapping(value="/all/enabled") 
	public List<LessonPlan> finfAllEnabled() {
		return lessonPlanRepository.findByEnabledTrue();
	}

	@GetMapping(value="all/by/user/{username}")
	public List<LessonPlan> findAllByUser(@PathVariable(value = "username") String username) {
		return lessonPlanRepository.findByAuthor(username);
	}

	@GetMapping(value="/get/{id}")
	public LessonPlan findById(@PathVariable(value = "id") Long lessonId) {
		return lessonPlanRepository.findById(lessonId).get();
	}
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<LessonPlan> update(@PathVariable(value = "id") Long lessonId, @RequestBody LessonPlan lesson) { 
		return null;
	}

	@CrossOrigin(value = "http://localhost:4200")
	@PostMapping(value="/add")
	public LessonPlan save(@RequestBody LessonPlan lessonPlan) {
		return lessonPlanRepository.save(lessonPlan);
	}

	@GetMapping(value="/delete/{id}")
	public void delete(@PathVariable(value = "id") Long lessonId) {
		LessonPlan lesson = lessonPlanRepository.findById(lessonId).get();
		lessonPlanRepository.delete(lesson);
	}

}
