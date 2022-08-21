package br.com.digitalRepository.back.controller;

import java.util.List;
import br.com.digitalRepository.back.entity.EducationLevel;
import br.com.digitalRepository.back.repository.EducationLevelRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value="/educationlevel")
public class EducationLevelController {
	
	@Autowired
	private EducationLevelRepository educationLevelRepository;
    
	@GetMapping(value="/all")
	public List<EducationLevel> findAll() {
		return educationLevelRepository.findAll();
	}
	
	@PostMapping(value="/save")
	public EducationLevel save(@RequestBody EducationLevel level) {
		return educationLevelRepository.save(level);
	}
	
	@GetMapping(value="/get/{id}")
	public EducationLevel findById(@PathVariable(value = "id") Long levelId) {
		return educationLevelRepository.findById(levelId).get();
	}

}
