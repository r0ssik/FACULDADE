/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empresa;

/**
 *
 * @author gabri
 */
public class Desenvolvedor extends Funcionario{
    private String linguagem;
    
    public Desenvolvedor(String nome, int idade, double salario, String linguagem){
        super(nome, idade, salario);
        this.linguagem = linguagem;
    }
    
    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("Linguagem: " + linguagem);
    }
}
