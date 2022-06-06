package br.com.digitalRepository.back.controller;

import java.util.List;
import br.com.digitalRepository.back.entity.Component;
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
@RequestMapping("/components")
public class ComponentController {

	@GetMapping("/load")
	public List<Component> findAll() {
		return null;
	}

	@PostMapping("/save")
	public void save(@RequestBody Component component) {
	}

	@DeleteMapping("/delete")
	public void delete(@PathVariable(value = "id") Long componentId) {

	}

}
