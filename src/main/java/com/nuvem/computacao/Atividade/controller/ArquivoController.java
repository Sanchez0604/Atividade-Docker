package com.nuvem.computacao.Atividade.controller;

import com.nuvem.computacao.Atividade.AtividadeApplication;
import com.nuvem.computacao.Atividade.models.Arquivo;
import com.nuvem.computacao.Atividade.service.ArquivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class ArquivoController {

    private final ArquivoService arquivoService;

    public ArquivoController(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Arquivo> upload(@RequestParam("arquivo") MultipartFile file) throws IOException {
        Arquivo arquivo = arquivoService.salvarArquivo(file);
        return ResponseEntity.ok(arquivo);
    }

    @GetMapping
    public ResponseEntity<List<Arquivo>> listar() {
        return ResponseEntity.ok(arquivoService.listarArquivos());
    }
}
