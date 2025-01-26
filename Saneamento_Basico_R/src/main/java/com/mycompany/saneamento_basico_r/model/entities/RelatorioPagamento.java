/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author JonathasOliveira
 */

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor

public class RelatorioPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private LocalDateTime dataEmissao;
    private String resultado;
    private String obeservacao;
    private String caminhoPdf;
    private LocalDateTime deletadoEm;

    public RelatorioPagamento(LocalDateTime dataEmissao, String resultado, String observacao, String caminhoPdf,
            LocalDateTime deletadoEm) {
        this.id = 0;
        this.dataEmissao = dataEmissao;
        this.resultado = resultado;
        this.obeservacao = observacao;
        this.caminhoPdf = caminhoPdf;
        this.deletadoEm = deletadoEm;
    }
}

