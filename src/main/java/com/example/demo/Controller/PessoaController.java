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
    public ModelAndView listar(@RequestParam("visualizacao")Optional<String> visualiazacao){
        ModelAndView view = new ModelAndView("pessoa/listar");
        String valor = visualiazacao.orElse("ativo");
        List<Pessoa> pessoas = pr.findByAtivo(valor == "ativo");
        Long quantidadePessoas = pr.count();

        
        view.addObject("pessoas", pessoas);
        view.addObject("qtd", pessoas.size());
        return view;

    }

    @GetMapping("pessoa/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id){
        ModelAndView view = new ModelAndView("pessoa/alterar");
        Optional<Pessoa> pessoa = pr.findById(id);

        view.addObject("pessoa", pessoa);
        view.addObject("id", id);
        return view;
    }

    @PostMapping("/pessoa/alterar/{id}")
    public String alterar(@PathVariable Long id, Pessoa pessoa){
        this.pr.save(pessoa);
        return "redirect:/pessoa/listar";
    }

    @GetMapping("/pessoa/deletar/{id}")
    public String deletar(@PathVariable Long id){
        Optional<Pessoa> pessoa = this.pr.findById(id);
        Pessoa pessoaModel = pessoa.get();

        pessoaModel.setAtivo(false);

        pr.save(pessoaModel);

        return "redirect:/pessoa/listar";
    }

    @GetMapping("/pessoa/recuperar/{id}")
    public String recuperar(@PathVariable Long id){
        Optional<Pessoa> pessoa = this.pr.findById(id);
        Pessoa pessoaModel = pessoa.get();

        pessoaModel.setAtivo(true);

        pr.save(pessoaModel);

        return "redirect:/pessoa/listar";
    }


   /*  @GetMapping("/pessoa/apresentar")
    public ModelAndView apresentar(){
        String nome = "João";

        ModelAndView view = new ModelAndView("pessoa/apresentar");
        view.addObject("nome", nome);

        return view;
    } */ //não está sendo usado
}