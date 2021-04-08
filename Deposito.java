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
public class Deposito extends Transaccion{

    public Deposito(double monto) {
        super(monto);
    }

    @Override
    public double getMonto() {
        return monto;
    }

    @Override
    public void mostrar() {
        System.out.print("Se Deposito en la Cuenta "+getMonto()+"$");
    }
    
}
