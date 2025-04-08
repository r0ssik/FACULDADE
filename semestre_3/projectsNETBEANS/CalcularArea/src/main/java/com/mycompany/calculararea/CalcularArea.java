/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculararea;


public class CalcularArea {

    public double calcularArea(double lado){
        System.out.println("Usei a do quadrado");
        return lado * lado; 
    }
    
    public double calcularArea(double base, double altura){
        System.out.println("Usei a do retangulo");
        return base * altura; 
    }
    
    public double calcularArea(float raio, double pi){
        System.out.println("Usei a do raio");
        return pi * raio * raio; 
    }
    public static void main(String[] args) {
        CalcularArea calc = new CalcularArea();
        
        System.out.println("Area Quadrado " + calc.calcularArea(2.80));
        System.out.println("Area retangulo " + calc.calcularArea(3.90, 3.43));
        System.out.println("Area circulo: " + calc.calcularArea(2.908f, 3.14));
    }
}
