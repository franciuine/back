package br.com.digitalRepository.back.repository;

import br.com.digitalRepository.back.entity.Pdf;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PdfRepository extends JpaRepository <Pdf, Long>{

    public Pdf findByName(String name);

}
