package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/pessoa/listar")
    public ModelAndView listar(){
        ModelAndView view = new ModelAndView("pessoa/listar");
        List<Pessoa> pessoas = pr.findAll();
        Long quantidadePessoas = pr.count();

        
        view.addObject("pessoas", pessoas);
        view.addObject("qtd", quantidadePessoas);
        return view;

    }

    @GetMapping("pessoa/alterar")
    public ModelAndView alterar(@RequestParam("id") Optional<Long> id){
        ModelAndView view = new ModelAndView("pessoa/alterar");
        Optional<Pessoa> pessoa = pr.findById(Long.valueOf(2));

        view.addObject("pessoa", pessoa);
        view.addObject("id", (Long.valueOf(2)));
        return view;
    }


    @GetMapping("/pessoa/apresentar")
    public ModelAndView apresentar(){
        String nome = "João";

        ModelAndView view = new ModelAndView("pessoa/apresentar");
        view.addObject("nome", nome);

        return view;
    }
}