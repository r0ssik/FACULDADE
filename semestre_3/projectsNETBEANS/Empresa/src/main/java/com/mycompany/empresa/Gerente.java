/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.empresa;

/**
 *
 * @author gabri
 */
public class Gerente extends Funcionario{
    private String departamento;
    
    public Gerente(String nome, int idade, double salario, String dapartamento){
        super(nome, idade, salario);
        this.departamento = departamento;
    }
    
    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("Departamento: " + departamento);
    }
}
