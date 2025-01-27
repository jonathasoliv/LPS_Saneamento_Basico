/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saneamento_basico_r.model.utils;

/**
 *
 * @author JonathasOliveira
 */
import com.mycompany.saneamento_basico_r.model.entities.Usuario;
import org.apache.commons.mail.SimpleEmail;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class NotificarEmail implements INotificador {

    @Override
    public boolean notificar(Usuario usuario, String titulo, String mensagem) {
        CompletableFuture.runAsync(() -> {
            String emailRemetente = "saneamentobasico@gmail.com";
            String senhaEmailRemetente = Secrets.GMAIL_KEY;

            SimpleEmail email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthentication(emailRemetente, senhaEmailRemetente);
            email.setSSLOnConnect(true);

            try {
                email.setFrom(emailRemetente);
                email.setSubject(titulo);
                email.setMsg(mensagem);
                email.addTo(usuario.getEmail());
                email.send();
                System.out.println("Email enviado com sucesso para: " + usuario.getEmail());
            } catch (Exception e) {
                System.err.println("Falha em enviar email para " + usuario.getEmail() + ": " + e.getMessage());
            }
        }).orTimeout(1, TimeUnit.MINUTES);
        return true;
    }

}
