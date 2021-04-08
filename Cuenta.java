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
public abstract class Cuenta {

    private String Ncuenta;
    private String cliente;
    private double monto;

    public Cuenta(String cuenta, String cliente, double monto) {
        super();
        this.Ncuenta = cuenta;
        this.cliente = cliente;
        this.monto = monto;
    }

    public String getNCuenta() {
        return Ncuenta;
    }

    public void setNCuenta(String Ncuenta) {
        this.Ncuenta = Ncuenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public abstract void agregarTransaccion(Transaccion transaccion);

    public abstract void mostrarEstodoCuentas();
}
