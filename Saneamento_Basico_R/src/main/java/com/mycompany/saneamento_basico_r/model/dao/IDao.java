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
public interface IDao {
    
    public void save(Object obj);
    
    public boolean delete(Object obj);
            
    public Object find(Object obj);
        
    public List<Object> findAll();
}
