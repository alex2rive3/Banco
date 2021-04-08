/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alex
 */
public class cuentaCorriente extends Cuenta{
    private ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    public cuentaCorriente(String Ncuenta, String cliente, double monto) {
        super(Ncuenta, cliente, monto);
    }

    @Override
    public void agregarTransaccion(Transaccion transaccion) {
        if(transaccion.getClass() == Deposito.class){
            this.setMonto(getMonto()+transaccion.getMonto());
        }else if(transaccion.getClass() == Extraccion.class){
            this.setMonto(getMonto()-transaccion.getMonto());
            transacciones.add(transaccion);
        }
    }

    @Override
    public void mostrarEstodoCuentas() {
        System.out.println("Nro. de Cuenta: " + this.getNCuenta()+
                            "Cliente: " + this.getCliente() +
                            "Monto: " + getMonto()+"\n");
        if(transacciones.size()>0){
            System.out.println("Las transacciones de las cuentas fueron las siguientes: ");
            //se iteran todas las transacciones que se encuentran en el array se van mostrando 
            for (Iterator<Transaccion> it = transacciones.iterator(); it.hasNext();) {
                Transaccion transaccion = it.next();
                transaccion.mostrar();
            }
            System.out.println("");
        }
    }
    
}
