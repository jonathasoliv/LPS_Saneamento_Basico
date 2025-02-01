/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ifcoder.projetodacc_lps.model.valid;

import com.ifcoder.projetodacc_lps.model.Aluno;
import com.ifcoder.projetodacc_lps.model.exceptions.AlunoException;

/**
 *
 * @author jose
 */
public class ValidateAluno {
    
    public Aluno validaCamposEntrada(String nome, String sexo, String idade, String matricula, String anoIngresso){
        Aluno aluno = new Aluno();
        if (nome.isEmpty())
            throw new AlunoException("Error - Campo vazio: 'nome'.");
        aluno.setNome(nome);
        
        if (sexo.isEmpty()) 
            throw new AlunoException("Error - Campo vazio: 'sexo'.");                
        aluno.setSexo(sexo.charAt(0));        

        int idadeInt = 0;
        if (idade.isEmpty())
            throw new AlunoException("Error - Campo vazio: 'idade'.");
        
        if(!idade.matches("[0-9]*"))
            throw new AlunoException("Error - Valor inválido no campo 'idade'.");
        
        idadeInt = Integer.parseInt(idade);
        aluno.setIdade(idadeInt);        

        if(!ValidaMatricula(matricula))
            throw new AlunoException("Error - Matricula invalida.");
        aluno.setMatricula(matricula);
        
        int anoInt = 0;
        if (!ValidaAno(anoIngresso))
            throw new AlunoException("Error - Ano ingresso invalido.");
        
        if(!anoIngresso.matches("[0-9]*"))
            throw new AlunoException("Error - Valor inválido no campo 'anoIngresso'.");
        
        anoInt = Integer.parseInt(anoIngresso);
        aluno.setAnoIngresso(anoInt);  
                
        return aluno;
    }
    
    public boolean ValidaMatricula(String matricula)
    {
        matricula = matricula.replaceAll("-", "");
        matricula = matricula.replaceAll(" ", "");
        
        if(matricula.length() != 6)
        {
            //System.out.println(matricula);
            return false;
        }
        
        return true;
    }
    
    public boolean ValidaAno(String anoIngresso)
    {
        int anoInserido = Integer.parseInt(anoIngresso.substring(0, 4));
        int posVestibular = Integer.parseInt(anoIngresso.substring(4, 6));
        
        if(anoInserido < 1980 || anoInserido > 2125)
        {
            return false;
        }
        
        // Não acho que tem como inserir um valor menor que 00 (talvez negativo?)
        //     ou maior que 99, mas colocando msm assim
        if(posVestibular < 00 || posVestibular > 99)
        {
            return false;
        }
        
        return true;
    }
}
