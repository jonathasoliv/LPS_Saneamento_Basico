/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.dao;

import java.util.List;

/**
 *
 * @author JonathasOliveira
 */
public interface IDao<T> {

    public void salvar(T obj);

    public void editar(T obj);

    public boolean deletar(T obj);

    public T buscar(int id);

    public List<T> buscarTodos();

}