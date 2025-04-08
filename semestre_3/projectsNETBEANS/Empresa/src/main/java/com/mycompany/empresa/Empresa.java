/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.empresa;

/**
 *
 * @author gabri
 */
public class Empresa {

    public static void main(String[] args) {
        Gerente gerente_1 = new Gerente("Pedro", 40, 1.230, "Desenvolvimento");
        Desenvolvedor desenvolvedor_1 = new Desenvolvedor("Luan", 20, 1.700, "PHP");
        
        System.out.println("Info GERENTE");
        gerente_1.exibirInformacoes();
        
        System.out.println("Info DEV");
        desenvolvedor_1.exibirInformacoes();
    }
}
