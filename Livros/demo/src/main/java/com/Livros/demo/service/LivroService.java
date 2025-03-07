package com.Livros.demo.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Livros.demo.domain.Livro;

@Service
public class LivroService {
    @Autowired
    private com.Livros.demo.repository.LivroRepository LivroRepository;

    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(5000);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }


    public List<Livro> getLivros() throws InterruptedException, ExecutionException {
        
        Future<String> completableFuture = calculateAsync();
        LivroRepository.findAll().parallelStream().filter(livro -> livro != null).toList();
        LivroRepository.findAll().parallelStream().filter(livro -> livro != null).toList();
        String result = completableFuture.get();    
        return LivroRepository.findAll().parallelStream().filter(livro -> livro != null).toList();
    }

    public Livro getLivroById(int id) {
        return LivroRepository.findById(id).orElse(null);
    }

    public Livro createLivro(Livro livro) {
        return LivroRepository.save(livro);
    }

    public Livro updateLivro(int id, Livro livro) {
        Livro livroToUpdate = LivroRepository.findById(id).orElse(null);
        if (livroToUpdate == null) {
            return null;
        }
        livroToUpdate.setNome(livro.getNome());
        livroToUpdate.setAutor(livro.getAutor());

        return LivroRepository.save(livroToUpdate);
    }

    public void deleteLivro(int id) {
        LivroRepository.deleteById(id);
    }
}
