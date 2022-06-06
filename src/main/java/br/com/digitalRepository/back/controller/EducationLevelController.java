package br.com.digitalRepository.back.controller;

import java.util.List;
import br.com.digitalRepository.back.entity.EducationLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franciuíne Almeida (franciuine.almeida@ecomp.ufsm.br)
 * @version Jun 6, 2022
 */

@RestController
@RequestMapping("/levels")
public class EducationLevelController {

	@GetMapping("/load")
	public List<EducationLevel> findAll() {
		return null;
	}

}
