/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller;

import com.mycompany.saneamento_basico_r.controller.tableModel.TMAdministrador;
import com.mycompany.saneamento_basico_r.model.dao.AdministradorDAO;
import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import com.mycompany.saneamento_basico_r.model.exceptions.AdminException;
import com.mycompany.saneamento_basico_r.model.exceptions.ClienteException;
import com.mycompany.saneamento_basico_r.model.utils.INotificador;
import com.mycompany.saneamento_basico_r.model.utils.NotificarEmail;
import com.mycompany.saneamento_basico_r.valid.ValidateAdministrador;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class AdminController {

    private AdministradorDAO repositorio;
    private ValidateAdmin validador;
    private INotificador notificador;
    

    public AdminController() {
        repositorio = new AdministradorDAO();
       // validador = new ValidateAdmin();
       // notificador = new NotificarEmail();
        
    }

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMAdmin(repositorio.buscarTodos()), null);
    }

    public Administrador buscar(int id) {
        return repositorio.buscar(id);
    }

    public void atualizarSenha(Administrador usuario, String senha) {
        String senhaValidada = validador.validaSenha(senha);
        usuario.setSenha(senhaValidada);
        repositorio.editar(usuario);
    }

    public Administrador adicionarCodigoRecuperacao(String cpf, String codigo) {
        Administrador admin = repositorio.buscarPorCpf(cpf);

        if (admin == null) {
            throw new ClienteException("ERRO: Não foi encontrado um(a) administrador(a) com esse cpf.");
        }

        if (admin != null) {
            //admin.setCodigoRecuperacao(codigo);
            //admin.setValidadeCodigoRecuperacao(LocalDateTime.now().plusMinutes(30));
            repositorio.editar(admin);
            //notificador.notificar(admin, "Sanemaneto Basico | Recuperação de Senha", "O seu código de recuperação é: "
            //        + codigo
            //        + ". Pelos próximos 30 minutos, você redefinir sua senha.");
        }
        return admin;
    }

    public void salvar(String cpf, String nome, String email, String senha, String senhaConfirmada,
            String dataNascimento,
            String telefone, String endereco, String deletadoEm) {

        Administrador novoAdm = validador.validaCamposEntrada(cpf, nome, email, senha, senhaConfirmada, dataNascimento,
                telefone, endereco,
                deletadoEm);
        String hashSenha = gerenciadorCriptografia.criptografarSenha(novoAdm.getSenha());
        novoAdm.setSenha(hashSenha);

        Administrador admExistente = repositorio.buscarPorCpf(novoAdm.getCpf());
        if (admExistente != null) {
            throw new ClienteException("ERRO: Já existe um administrador cadastrado com esse cpf.");
        }
        admExistente = repositorio.buscarPorEmail(novoAdm.getEmail());
        if (admExistente != null) {
            throw new ClienteException("ERRO: Já existe um administrador cadastrada com esse email.");
        }

        repositorio.salvar(novoAdm);
    }

    public void editar(int id, String cpf, String nome, String email, String senha, String dataNascimento,
            String telefone, String endereco, String deletadoEm) {
        Administrador novoAdm = validador.validaCamposEntrada(cpf, nome, email, senha, senha, dataNascimento, telefone,
                endereco,
                deletadoEm);
        novoAdm.setId(id);

        Administrador admExistente = repositorio.buscarPorCpf(novoAdm.getCpf());
        if (admExistente != null && admExistente.getId() != id) {
            throw new ClienteException("ERRO: Já existe um administrador cadastrado com esse cpf.");
        }
        admExistente = repositorio.buscarPorEmail(novoAdm.getEmail());
        if (admExistente != null && admExistente.getId() != id) {
            throw new ClienteException("ERRO: Já existe um administrador cadastrada com esse email.");
        }

        repositorio.editar(novoAdm);
    }

    public void deletar(int id, int idAutenticado) {
        Administrador adm = repositorio.buscar(id);
        validador.validaExclusão(adm, idAutenticado);
        repositorio.deletar(adm);
    }

}
