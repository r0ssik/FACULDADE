/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semestre_3.projectsNETBEANS.projeto1.src.main.java.com.mycompany.projeto1;

/**
 *
 * @author rossik
 */
public class Caneta {
    public int carga;
    public boolean tampada;
    public String cor;
    
    public void status(){
        System.out.println("A cor da caneta e "+ this.cor);
        System.out.println("As cargas da caneta são "+ this.carga);
        System.out.println("A caneta está "+ this.tampada);
    }
}
