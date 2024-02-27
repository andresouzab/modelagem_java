package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "sondagem", nullable = false, length = 250)
    private String sondagem;

    @Column(name = "entrega_amigavel", nullable = false, length = 15)
    private String entregaAmigavel;

    @Column(name = "quitacao", nullable = true, length = 250)
    private String quitacao;

    @Column(name = "atualizacao", nullable = true, length = 250)
    private String atualizacao;

    @Column(name = "parcial", nullable = true, length = 250)
    private String parcial;
    
    @Column(name = "renegociacao", nullable = true, length = 250)
    private String renegociacao;

    public String getSondagem(){
        return this.sondagem;
    }

    public void setSondagem(String sondagem){
        this.sondagem = sondagem;
    }

    public String getEntregaAmigavel(){
        return this.entregaAmigavel;
    }

    public void setEntregaAmigavel(String entregaAmigavel){
        this.entregaAmigavel = entregaAmigavel;
    }

    public String getQuitacao(){
        return this.quitacao;
    }

    public void setQuitacao(String quitacao){
        this.quitacao = quitacao;
    }

    public String getAtualizacao(){
        return this.atualizacao;
    }

    public void setAtualizacao(String atualizacao){
        this.atualizacao = atualizacao;
    }

    public String getParcial(){
        return this.parcial;
    }

    public void setParcial(String parcial){
        this.parcial = parcial;
    }

    public String getRenegociacao(){
        return this.renegociacao;
    }

    public void setRenegociacao(String renegociacao){
        this.renegociacao = renegociacao;
    }

}