package br.com.digitalRepository.back.controller;

import org.apache.commons.io.FileUtils;
import org.hibernate.dialect.identity.GetGeneratedKeysDelegate;
import org.hibernate.resource.transaction.spi.DdlTransactionIsolator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import br.com.digitalRepository.back.dtos.PdfDTO;
import br.com.digitalRepository.back.entity.Pdf;
import br.com.digitalRepository.back.repository.PdfRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Base64;

@RestController
@ResponseBody
@RequestMapping(value="/pdf")
@CrossOrigin(origins = "*")
public class PdfController {

    private static final String BASE_DIR = "C:\\PDF\\";

    @Autowired
    PdfRepository pdfRepository;

    @PostMapping(value="/add/{filename}")
    public String UploadFile(@PathVariable("filename")  String filename, @RequestParam("file") MultipartFile file) {
        try 
        {
            if (file.isEmpty())
            {
                return("Arquivo vazio.");
            }

            Pdf pdf = new Pdf();
            pdf.setFile(Base64.getEncoder().encodeToString(file.getBytes()));
            pdf.setName(filename);
            pdfRepository.save(pdf); 

        } catch (Exception e) 
        {
            return "Erro salvando o arquivo: " + e.getMessage();
        }
        return "PDF salvo com sucesso"; 
    }

    @GetMapping(value="/get/{filename}")
    public @ResponseBody PdfDTO GetFile(@PathVariable String filename) throws Exception {
        try {
            Pdf pdf = pdfRepository.findByName(filename);
            PdfDTO pdfToReturn = new PdfDTO();
            pdfToReturn.setPdf(pdf.getFile());
            return pdfToReturn;
        } catch (Exception e) {
            throw new Exception (e);
        }
    }

}
