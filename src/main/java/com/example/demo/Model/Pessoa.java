package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "carteira", nullable = false, length = 250)
    private String carteira;

    @Column(name = "negociador", nullable = false, length = 15)
    private String negociador;

    @Column(name = "email", nullable = true, length = 250)
    private String email;

    public String getCarteira(){
        return this.carteira;
    }

    public void setCarteira(String carteira){
        this.carteira = carteira;
    }

    public String getNegociador(){
        return this.negociador;
    }

    public void setNegociador(String negociador){
        this.negociador = negociador;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

}