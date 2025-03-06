/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package semestre_3.projectsNETBEANS.projeto1.src.main.java.com.mycompany.projeto1;

/**
 *
 * @author rossik
 */
public class Projeto1 {

    public static void main(String[] args){
        System.out.println("Começando a brincar com POO");
        
         Caneta caneta1 = new Caneta();
         caneta1.cor = "preto";
         caneta1.tampada = true;
         caneta1.carga = 100;
         
         caneta1.status();
    }
}
