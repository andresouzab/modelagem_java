package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Pessoa;
import com.example.demo.Repository.PessoaRepository;

@Controller
public class PessoaController {

    @Autowired
    private PessoaRepository pr;

    @GetMapping("/pessoa/criar")
    public String criar(){
        return "pessoa/criar";
    }

    @PostMapping("/pessoa/criar")
    public String criar(Pessoa pessoa){
        pr.save(pessoa);
        return "redirect:/avaliacao/criar";

    }

    @GetMapping("/pessoa/apresentar")
    public ModelAndView apresentar(){
        String nome = "João";

        ModelAndView view = new ModelAndView("pessoa/apresentar");
        view.addObject("nome", nome);

        return view;
    }
}