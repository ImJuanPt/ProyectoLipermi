/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanpuente.seminario.imc.rmi.net;

import javax.imageio.IIOException;
import juanpuente.seminario.imc.rmi.lib.IRemotaCalculoImc;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

/**
 *
 * @author Juan Miguel
 */
public class Servidor {
    private final int puerto = 9007;
    private final CallHandler invocador;
    private final Server servidor;
    private final CalculoRmiImcImplem calculoImc;
    private IRemotaCalculoImc calculoImcRemoto;
    
    public Servidor(){
        invocador = new CallHandler();
        servidor = new Server();
        calculoImc = new CalculoRmiImcImplem();
    }
    
    public void iniciar() throws Exception{
        try {
            invocador.registerGlobal(IRemotaCalculoImc.class, calculoImc);
            servidor.bind(puerto, invocador);
            System.out.println("Servidor iniciado");
        } catch (LipeRMIException e) {
            throw new Exception("Error: No es posible invocar metodos remotoss");
        }catch (IIOException e){
            throw new Exception("Error I/O");
        }
    }
    public void detener(){
        servidor.close();
    }
}
