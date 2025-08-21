package com.nuvem.computacao.Atividade.service;

import com.nuvem.computacao.Atividade.models.Arquivo;
import com.nuvem.computacao.Atividade.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class ArquivoService {

    private final ArquivoRepository repository;
    private final Path pastaUpload;

    // Recebe o caminho para o diretorio definido no app.properties
    public ArquivoService(ArquivoRepository repository, @Value("${file.upload-dir}") String uploadDir) throws IOException {
        this.repository = repository;
        this.pastaUpload = Paths.get(uploadDir);
    // Caso não exista, já cria automaticamente
        if (!Files.exists(pastaUpload)) {
            Files.createDirectories(pastaUpload);
        }
    }

    public Arquivo salvarArquivo(MultipartFile file) throws IOException {
        String nomeArquivo = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path caminhoArquivo = pastaUpload.resolve(nomeArquivo);

        Files.copy(file.getInputStream(), caminhoArquivo);

        Arquivo arquivo = new Arquivo();
        arquivo.setNome(file.getOriginalFilename());
        arquivo.setCaminho(caminhoArquivo.toString());
        arquivo.setDataUpload(LocalDateTime.now());

        return repository.save(arquivo);
    }

    public java.util.List<Arquivo> listarArquivos() {
        return repository.findAll();
    }
}