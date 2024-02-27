package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Avaliacao;



@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    
    
}