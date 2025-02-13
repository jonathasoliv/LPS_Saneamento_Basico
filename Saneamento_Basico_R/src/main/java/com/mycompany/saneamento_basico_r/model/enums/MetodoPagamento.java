/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.enums;

/**
 *
 * @author JonathasOliveira
 */
public enum MetodoPagamento {
    
    DINHEIRO("Dinheiro"),
    CREDITO("Crédito"),
    DEBITO("Débito"),
    PIX("Pix");

    private final String valor;

    MetodoPagamento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}

