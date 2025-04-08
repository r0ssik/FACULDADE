/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notificacao;

/**
 *
 * @author gabri
 */
public class Notificacao {
    
    public void enviarMensagem(){
        System.out.println("Enviando Mensagem");
    }
    
    public static void main(String[] args){
        SMSNotificacao teste_1 = new SMSNotificacao();
        EmailNotificacao teste_2 = new EmailNotificacao();
        
        Notificacao[] lista = {teste_1, teste_2};
        for(int i = 0; i < lista.length; i++){
            lista[i].enviarMensagem();
        }
       
    }
}
