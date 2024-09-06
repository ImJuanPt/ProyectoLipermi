/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanpuente.seminario.imc.rmi.net;

import juanpuente.seminario.imc.rmi.lib.IRemotaCalculoImc;
import juanpuente.seminario.imc.rmi.lib.DatosImc;

/**
 *
 * @author Juan Miguel
 */
public class CalculoRmiImcImplem implements IRemotaCalculoImc {

    private DatosImc datos;

    public CalculoRmiImcImplem() {
    }

    @Override
    public DatosImc calcularImc(DatosImc datos) {
        float resultado = 0;
        if (datos.getPeso() <= 0 || datos.getAltura() <= 0) {
            datos.setInterpretacion("ERROR: El peso y la altura deben ser mayores que 0");
            return datos;
        } else {
            resultado = datos.getPeso() / (datos.getAltura() * datos.getAltura());
            datos.setResultado(resultado);
            if (resultado < 18.5) {
                datos.setInterpretacion("Debes consultar un medico, tu peso debe ser mayor que 0");
            } else if (resultado <= 24.9) {
                datos.setInterpretacion("Estas bien de peso");
            } else if (resultado <= 29.9) {
                datos.setInterpretacion("Debes bajar un poco de peso");
            } else {
                datos.setInterpretacion("Debes consultar un Medico, tu peso es muy alto");
            }
        }
        return datos;
    }
}
