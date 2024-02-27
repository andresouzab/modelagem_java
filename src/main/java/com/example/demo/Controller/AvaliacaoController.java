package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Model.Avaliacao;
import com.example.demo.Repository.AvaliacaoRepository;

@Controller
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository pr;

    @GetMapping("/avaliacao/criar")
    public String criar(){
        return "avaliacao/criar";
    }

    @PostMapping("/avaliacao/criar")
    public String criar(Avaliacao avaliacao){
        pr.save(avaliacao);
        return "avaliacao/criar";
    }
}