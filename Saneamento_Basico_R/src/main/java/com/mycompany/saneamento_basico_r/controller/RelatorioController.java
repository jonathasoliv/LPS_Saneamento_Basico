/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller;

/**
 *
 * @author JonathasOliveira
 */
/*
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.io.File;

import javax.swing.JTable;

import com.mycompany.saneamento_basico_r.controller.tableModel.TMRelatorio;
import com.mycompany.saneamento_basico_r.model.dao.RelatorioDAO;
import com.mycompany.saneamento_basico_r.model.entities.Procedimento;
import com.mycompany.saneamento_basico_r.model.entities.Relatorio;
import com.mycompany.saneamento_basico_r.model.utils.GerarPdf;
import com.mycompany.saneamento_basico_r.model.utils.IGerarDocumento;
import com.mycompany.saneamento_basico_r.valid.ValidateRelatorio;

public class RelatorioController {
    private RelatorioDAO repositorio;
    private ValidateRelatorio validador;
    private IGerarDocumento geradorDocumento;

    public RelatorioController() {
        this.repositorio = new RelatorioDAO();
        this.validador = new ValidateRelatorio();
        this.geradorDocumento = new GerarPdf();
    }

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMRelatorio(repositorio.buscarTodos()), null);
    }

    public int salvar(LocalDateTime dataEmissao, String resultado, String observacoes, String caminhoPdf,
            LocalDateTime deletadoEm) {

        Relatorio novoRelatorio = validador.validaCamposEntrada(resultado, observacoes, caminhoPdf, dataEmissao);

        repositorio.salvar(novoRelatorio);
        return novoRelatorio.getId();
    }

    public void editar(int id, LocalDateTime dataEmissao, String resultado, String observacoes, String caminhoPdf,
            LocalDateTime deletadoEm) {

        Relatorio novoRelatorio = validador.validaCamposEntrada(resultado, observacoes, caminhoPdf, dataEmissao);
        novoRelatorio.setId(id);

        repositorio.editar(novoRelatorio);
    }

    public void deletar(int id) {
        Relatorio relatorio = repositorio.buscar(id);
        repositorio.deletar(relatorio);
    }

    public Relatorio buscar(int id) {
        return repositorio.buscar(id);
    }

    public void gerarDocumento(String caminho, int id, Procedimento procedimento) {
        Relatorio relatorio = repositorio.buscar(id);
        String caminhoTemporario = "relatorios/temp";

        new File(caminhoTemporario).mkdirs();

        geradorDocumento.gerarDocumento(caminhoTemporario,
                "PDF gerado em: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "\n",
                "SaneamentoBasico" + "\n",
                "Relatório de Pagamento", "\n",
                "Id do Relatório: " + relatorio.getId(),
                "Data de Emissão: "
                        + relatorio.getDataEmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                "\n",
                "Id do cliente: " + procedimento.getId(),
                "Cliente: " + procedimento.getCliente().getNome(),
                "Descrição: " + procedimento.getDescricao(),
                
                "Status: " + procedimento.getStatus() + "\n\n" + "Resultado: " + relatorio.getResultado(),
                "Observações: " + relatorio.getObeservacoes());
        String caminhoArquivo = caminhoTemporario + "/recibo.pdf";
        List<String> caminhosEntrada = Arrays.asList(caminhoArquivo, relatorio.getCaminhoPdf());
        geradorDocumento.combinarDocumentos(caminho, caminhosEntrada);
    }
}
*/