/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.utils;

import java.util.List;

/**
 *
 * @author JonathasOliveira
 */
public interface IGerarDocumento {
    
    public void gerarDocumento(String caminho, String... conteudo);

    public void combinarDocumentos(String caminhoSaida, List<String> caminhosEntrada);
}
