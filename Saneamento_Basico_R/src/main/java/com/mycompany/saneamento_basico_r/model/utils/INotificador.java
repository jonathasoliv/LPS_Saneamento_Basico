/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.utils;

import com.mycompany.saneamento_basico_r.model.entities.Usuario;

/**
 *
 * @author JonathasOliveira
 */
public interface INotificador {
    boolean notificar(Usuario usuario, String titulo, String mensagem);
}