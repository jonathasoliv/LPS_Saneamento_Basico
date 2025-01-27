/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.controller;

import com.mycompany.saneamento_basico_r.controller.tableModel.TMClientes;
import com.mycompany.saneamento_basico_r.model.entities.Cliente;
import com.mycompany.saneamento_basico_r.model.dao.ClienteDao;
import com.mycompany.saneamento_basico_r.model.exceptions.ClienteException;
import com.mycompany.saneamento_basico_r.model.utils.INotificador;
import com.mycompany.saneamento_basico_r.model.utils.NotificarEmail;
import com.mycompany.saneamento_basico_r.valid.ValidateCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author JonathasOliveira
 */
public class ClienteController {

    private ClienteDao repositorio;
    private ValidateCliente validador;
    private INotificador notificador;
    //private GerenciadorCriptografia gerenciadorCriptografia;

    public ClienteController() {
        repositorio = new ClienteDao();
        validador = new ValidateCliente();
        notificador = new NotificarEmail();
        //gerenciadorCriptografia = new GerenciadorCriptografia();
    }

    public void atualizarTabela(JTable grd) {
        Util.jTableShow(grd, new TMClientes(repositorio.buscarTodos()), null);
    }

    public void salvar(String cpf, String nome, String email, String senha, String senhaConfirmada,
            String dataNascimento,
            String telefone, String endereco, String deletadoEm,
            String historicoConsumo) {

        Cliente novoCliente = validador.validaCamposEntrada(cpf, nome, email, senha, senhaConfirmada, dataNascimento,
                telefone,
                endereco, deletadoEm, historicoConsumo);

        //String hashSenha = gerenciadorCriptografia.criptografarSenha(novoCliente.getSenha());
        //novoCliente.setSenha(hashSenha);

        Cliente clienteExistente = repositorio.buscarPorCpf(novoCliente.getCpf());
        if (clienteExistente != null) {
            throw new ClienteException("ERRO: Já existe um cliente cadastrada com esse cpf.");
        }
       clienteExistente = repositorio.buscarPorEmail(novoCliente.getEmail());
        if (clienteExistente != null) {
            throw new ClienteException("ERRO: Já existe um cliente cadastrada com esse email.");
        }

        repositorio.salvar(novoCliente);

    }

    public Cliente buscar(int id) {
        return repositorio.buscar(id);
    }

    public List<Cliente> buscarTodos() {
        return repositorio.buscarTodos();
    }

    public void editar(int id, String cpf, String nome, String email, String senha, String dataNascimento,
            String telefone, String endereco, String deletadoEm, String historicoConsumo) {

        Cliente novoCliente = validador.validaCamposEntrada(cpf, nome, email, senha, senha, dataNascimento, telefone,
                endereco, deletadoEm, historicoConsumo);

        novoCliente.setId(id);

        Cliente clienteExistente = repositorio.buscarPorCpf(novoCliente.getCpf());
        if (clienteExistente != null && clienteExistente.getId() != id) {
            throw new ClienteException("ERRO: Já existe um cliente cadastrada com esse cpf.");
        }
        clienteExistente = repositorio.buscarPorEmail(novoCliente.getEmail());
        if (clienteExistente != null && clienteExistente.getId() != id) {
            throw new ClienteException("ERRO: Já existe um cliente cadastrada com esse email.");
        }

        repositorio.editar(novoCliente);

    }

    public void deletar(int id) {
        Cliente cliente = repositorio.buscar(id);
        repositorio.deletar(cliente);
    }

    public void atualizarSenha(Cliente usuario, String senha) {
        String senhaValidada = validador.validaSenha(senha);
        //String hashSenha = gerenciadorCriptografia.criptografarSenha(senhaValidada);
        //usuario.setSenha(hashSenha);
        repositorio.editar(usuario);
    }

    public Cliente adicionarCodigoRecuperacao(String cpf, String codigo) {
        Cliente cliente = repositorio.buscarPorCpf(cpf);

        if (cliente == null) {
            throw new ClienteException("ERRO: Não foi encontrada um cliente com esse cpf.");
        }

        //cliente.setCodigoRecuperacao(codigo);
        //cliente.setValidadeCodigoRecuperacao(LocalDateTime.now().plusMinutes(30));
        repositorio.editar(cliente);
        notificador.notificar(cliente, "SaneamentoBasico | Recuperação de Senha", "Seu código de recuperação é: " + codigo
                + ". Pelos próximos 30 minutos, você vai conseguir logar na sua conta utilizando este código no lugar da senha.");
        return cliente;
    }

}
