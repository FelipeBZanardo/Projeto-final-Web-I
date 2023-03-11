package com.ada.projetowebi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String pais;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fundacao;
    private Integer quantidadeTitulos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFundacao() {
        return fundacao;
    }

    public void setFundacao(LocalDate fundacao) {
        this.fundacao = fundacao;
    }

    public Integer getQuantidadeTitulos() {
        return quantidadeTitulos;
    }

    public void setQuantidadeTitulos(Integer quantidadeTitulos) {
        this.quantidadeTitulos = quantidadeTitulos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(nome, time.nome) && Objects.equals(pais, time.pais) && Objects.equals(fundacao, time.fundacao) && Objects.equals(quantidadeTitulos, time.quantidadeTitulos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pais, fundacao, quantidadeTitulos);
    }
}
