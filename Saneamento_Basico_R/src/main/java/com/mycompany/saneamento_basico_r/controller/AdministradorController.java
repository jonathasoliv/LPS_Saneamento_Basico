/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller;

import com.mycompany.saneamento_basico_r.controller.tableModel.TMAdministrador;
import com.mycompany.saneamento_basico_r.model.dao.AdministradorDao;
import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import com.mycompany.saneamento_basico_r.model.exceptions.AdministradorException;
import com.mycompany.saneamento_basico_r.model.exceptions.ClienteException;
import com.mycompany.saneamento_basico_r.valid.ValidateAdministrador;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
public class AdministradorController {

    private AdministradorDao repositorio;
    private ValidateAdministrador validador;
   

    public AdministradorController() {
        repositorio = new AdministradorDao();
        validador = new ValidateAdministrador();
       
    }

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMAdministrador(repositorio.buscarTodos()), null);
    }

    public Administrador buscar(int id) {
        return repositorio.buscar(id);
    }

    public void atualizarSenha(Administrador usuario, String senha) {
        //String senhaValidada = validador.validaSenha(senha);
        //String hashSenha = gerenciadorCriptografia.criptografarSenha(senhaValidada);
        //usuario.setSenha(hashSenha);
        repositorio.editar(usuario);
    }

    public Administrador adicionarCodigoRecuperacao(String cpf, String codigo) {
        Administrador administrador = repositorio.buscarPorCpf(cpf);

        if (administrador == null) {
            throw new ClienteException("ERRO: Não foi encontrado um(a) administrador(a) com esse cpf.");
        }

        if (administrador != null) {
            //administrador.setCodigoRecuperacao(codigo);
           // administrador.setValidadeCodigoRecuperacao(LocalDateTime.now().plusMinutes(30));
            repositorio.editar(administrador);
            //notificador.notificar(admin, "SaneamentoBasico | Recuperação de Senha", "Seu código de recuperação é: "
            //        + codigo
            //        + ". Pelos próximos 30 minutos, você vai conseguir logar na sua conta utilizando este código no lugar da senha.");
        }
        return administrador;
    }

    public void salvar(String nome, String sexo, int idade, String cpf, String endereco,
            String email, String senha, String telefone, String cidade, String bairro, 
            String unidadeConsumidora, LocalDateTime deletadoEm) {

        Administrador novoAdministrador = validador.validaCamposEntrada(nome, sexo, idade, cpf, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora, deletadoEm);
        //String hashSenha = gerenciadorCriptografia.criptografarSenha(novoAdm.getSenha());
        //novoAdministrador.setSenha(hashSenha);

        Administrador administradorExistente = repositorio.buscarPorCpf(novoAdministrador.getCpf());
        if (administradorExistente != null) {
            throw new ClienteException("ERRO: Já existe um administrador cadastrado com esse cpf.");
        }
        administradorExistente = repositorio.buscarPorEmail(novoAdministrador.getEmail());
        if (administradorExistente != null) {
            throw new ClienteException("ERRO: Já existe um administrador cadastrada com esse email.");
        }

        repositorio.salvar(novoAdministrador);
    }

    public void editar(int id, String nome, String sexo, int idade, String cpf, String endereco,
            String email, String senha, String telefone, String cidade, String bairro, 
            String unidadeConsumidora, LocalDateTime deletadoEm) {
        Administrador novoAdministrador = validador.validaCamposEntrada(nome, sexo, idade, cpf, endereco, email, senha, telefone, cidade, bairro, unidadeConsumidora, deletadoEm);
        novoAdministrador.setId(id);

        Administrador administradorExistente = repositorio.buscarPorCpf(novoAdministrador.getCpf());
        if (administradorExistente != null && administradorExistente.getId() != id) {
            throw new ClienteException("ERRO: Já existe um administrador cadastrado com esse cpf.");
        }
        administradorExistente = repositorio.buscarPorEmail(novoAdministrador.getEmail());
        if (administradorExistente != null && administradorExistente.getId() != id) {
            throw new ClienteException("ERRO: Já existe um administrador cadastrada com esse email.");
        }

        repositorio.editar(novoAdministrador);
    }

    public void deletar(int id, int idAutenticado) {
        Administrador administrador = repositorio.buscar(id);
        validador.validaExclusao(administrador, idAutenticado);
        repositorio.deletar(administrador);
    }

}
