/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juanpuente.seminario.imc.rmi;

import juanpuente.seminario.imc.rmi.net.Servidor;

/**
 *
 * @author Juan Miguel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Servidor servicio = new Servidor();
        try {
            servicio.iniciar();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        
    }
    
}
