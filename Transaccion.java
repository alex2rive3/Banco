/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Alex
 */
public abstract class Transaccion {
    protected double monto;

    public Transaccion(double monto) {
        super();
        this.monto = monto;
    }
    
    public abstract double getMonto();
    public abstract void mostrar();
}
