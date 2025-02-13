/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.entities;

/**
 *
 * @author JonathasOliveira
 */

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor

public class Fatura {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  private double valor;

  @ManyToOne
  @JoinColumn(name = "id_pagamento_usuario")
  private Usuario registradoPor;
  @ManyToOne
  @JoinColumn(name = "id_pagamento_cliente")
  private Cliente cliente;
  private String metodoPagamento;
  @OneToOne
  @JoinColumn(name = "manutencao_id")
  private Procedimento manutencao;
  private LocalDateTime deletadoEm;

  public Fatura(double valor, Usuario registradoPor, Cliente cliente, String metodoPagamento, Procedimento manutencao, LocalDateTime deletadoEm) {
    this.id = 0;
    this.valor = valor;
    this.registradoPor = registradoPor;
    this.cliente = cliente;
    this.metodoPagamento = metodoPagamento;
    this.manutencao = manutencao;
    this.deletadoEm = deletadoEm;
  }
}