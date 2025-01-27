/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.utils;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class GerarPdf implements IGerarDocumento {

    @Override
    public void gerarDocumento(String caminho, String... conteudo) {
        Document documento = new Document();
        try {
            String caminhoArquivo = caminho + "/recibo.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(caminhoArquivo));
            documento.open();

            for (String texto : conteudo) {
                documento.add(new Paragraph(texto));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            documento.close();
        }
    }

    @Override
    public void combinarDocumentos(String caminhoSaida, List<String> caminhosEntrada) {
        Document documento = new Document();
        try {
            if (new File(caminhoSaida).isDirectory()) {
                caminhoSaida = caminhoSaida + File.separator + "relatorio.pdf";
            }

            File arquivoSaida = new File(caminhoSaida);
            arquivoSaida.getParentFile().mkdirs();

            PdfCopy copia = new PdfCopy(documento, new FileOutputStream(arquivoSaida));
            documento.open();

            for (String inputPath : caminhosEntrada) {
                PdfReader reader = new PdfReader(inputPath);
                copia.addDocument(reader);
                reader.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            documento.close();
        }
    }

}
