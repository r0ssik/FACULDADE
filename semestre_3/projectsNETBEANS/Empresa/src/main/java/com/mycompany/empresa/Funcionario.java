/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empresa;

/**
 *
 * @author gabri
 */
public class Funcionario {
    protected String nome;
    protected  int idade;
    protected double salario;
    
    public Funcionario(String nome, int idade, double salario){
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }
    
    public void exibirInformacoes(){
        System.out.println("Funcionario : " + nome + " Idade: " + idade +  " Salario: " + String.format("%.3f", salario));
    }
}
