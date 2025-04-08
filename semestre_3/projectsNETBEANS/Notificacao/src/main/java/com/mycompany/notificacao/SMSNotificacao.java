/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notificacao;

/**
 *
 * @author gabri
 */
public class SMSNotificacao extends Notificacao {

    @Override
    public void enviarMensagem(){
        System.out.println("Enviando Mensagem por SMS");
    }
}
