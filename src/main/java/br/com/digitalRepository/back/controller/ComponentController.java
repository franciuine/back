package br.com.digitalRepository.back.controller;

import java.util.List;
import br.com.digitalRepository.back.entity.Component;
import br.com.digitalRepository.back.repository.ComponentRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/v1")
public class ComponentController {
	
	@Autowired
	private ComponentRepository componentRepository;

	@GetMapping("/components")
	public List<Component> findAll() {
		return componentRepository.findAll();
	}

	@PostMapping("/components")
	public Component save(@RequestBody Component component) {
		return componentRepository.save(component);
	}

	@DeleteMapping("/components")
	public void delete(@PathVariable(value = "id") Long componentId) {
		Component component = componentRepository.findById(componentId).get();
		componentRepository.delete(component);
	}

}
