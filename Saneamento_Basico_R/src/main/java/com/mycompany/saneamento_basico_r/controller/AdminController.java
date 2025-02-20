/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller;

import com.mycompany.saneamento_basico_r.controller.tableModel.TMAdministrador;
import com.mycompany.saneamento_basico_r.model.dao.AdministradorDAO;
import com.mycompany.saneamento_basico_r.model.entities.Administrador;
import com.mycompany.saneamento_basico_r.model.exceptions.ClienteException;
import com.mycompany.saneamento_basico_r.model.utils.INotificador;
import com.mycompany.saneamento_basico_r.valid.ValidateAdmin;
import javax.swing.JTable;

public class AdminController {

    private AdministradorDAO repositorio;
    private ValidateAdmin validador;
    private INotificador notificador;
    

    public AdminController() {
        repositorio = new AdministradorDAO();
        validador = new ValidateAdmin();
       // notificador = new NotificarEmail();
        
    }

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMAdministrador(repositorio.buscarTodos()), null);
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

    public void salvar(String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro) {

        Administrador novoAdm = validador.validaCamposEntrada(nome, sexo, idade,
                cpf, endereco, email, senha, telefone, cidade, bairro);

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

    public void editar(int id, String nome, String sexo, String idade,
            String cpf, String endereco, String email,
            String senha, String telefone, String cidade, String bairro)
    {
        Administrador novoAdm = validador.validaCamposEntrada(nome, sexo, idade,
                cpf, endereco, email, senha, telefone, cidade, bairro);
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
