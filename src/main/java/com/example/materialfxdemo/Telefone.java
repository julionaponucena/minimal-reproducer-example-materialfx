package com.example.materialfxdemo;

public class Telefone {

    private Long id;


    private int DDD;


    private Long numero;

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public int getDDD() {
        return DDD;
    }

    public Long getNumero() {
        return numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}