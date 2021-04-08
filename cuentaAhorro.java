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
public class cuentaAhorro extends Cuenta {
    private ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();

    public cuentaAhorro(String Ncuenta, String cliente, double monto) {
        super(Ncuenta, cliente, monto);
    }
    
    @Override
    public void agregarTransaccion(Transaccion transaccion) {
        boolean transaccionHecha = false;
        if(transaccion.getClass() == Deposito.class){
            this.setMonto(getMonto()+transaccion.getMonto());
        }else if(transaccion.getClass() == Extraccion.class){
            if(getMonto()-transaccion.getMonto()>0){
                this.setMonto(getMonto()-transaccion.getMonto());
                transaccionHecha=true;
            }else{
                System.out.print("El saldo es Insuficiente");
            }
        }
        if(transaccionHecha){
            transacciones.add(transaccion);
        }else{
            System.out.println("No es posible relizar esta Transaccion");
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
           for (Transaccion transaccion: transacciones){
                transaccion.mostrar();
            }
           System.out.println("");
        }
    }
}
