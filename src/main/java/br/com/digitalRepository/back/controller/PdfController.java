package br.com.digitalRepository.back.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileNotFoundException;

@RestController
@ResponseBody
@RequestMapping("/pdf")
public class PdfController {

    private static final String BASE_DIR = "C:\\Users\\Joedeson Jr\\Documents\\pdf";

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new Exception("Arquivo vazio.");
            }
            File dir = new File(BASE_DIR);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String filename = String.format("pdf-%s.pdf", RandomStringUtils.randomNumeric(8));
            File pdf = new File(dir, filename);
            FileUtils.writeByteArrayToFile(pdf, file.getBytes());
            // TODO: salvar o nome do pdf no banco, sera usado para visualizar o pdf
            return filename;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{filename}")
    public ResponseEntity<StreamingResponseBody> view(@PathVariable String filename) {
        try {
            File pdf = new File(BASE_DIR, filename);
            if (!pdf.exists()) {
                throw new FileNotFoundException("Arquivo não encontrado.");
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header("Content-Disposition", String.format("inline; filename=\"%s.pdf\"", filename))
                    .body(out -> out.write(FileUtils.readFileToByteArray(pdf)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
