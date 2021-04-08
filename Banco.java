/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    static Scanner leer;
    private static String NCuenta = "";
    private static double saldoInicial = 0;
    private static String cuenta ="";
    static ArrayList<Cuenta> cuentas = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static void Menu(){
        int opcion;
        System.out.println("Bienvenido al Banco de sus Sueños");
        do{
            System.out.println("Seleccione la Opcionde la operacion que decea realizar");
            System.out.println("1. Crear Una Cuenta"+
                             "\n2. Consultar Cuenta"+
                             "\n3. Realizar Transaccion"+
                             "\n0. Salir");
            leer = new Scanner(System.in);
            opcion = Integer.parseInt(leer.nextLine());
            switch(opcion){
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    consultarCuenta();
                    break;
                case 3:
                    realizarTransaccio();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Invalida, intente nuevamente");
                    break;
            }
        }while(opcion != 0);
    }

    private static void consultarCuenta(){
        for(Cuenta cuenta: cuentas){
            cuenta.mostrarEstodoCuentas();
        }
    }
    private static void crearCuenta(){
        NCuenta = Integer.toString((int)(Math.random()*10+1));
        Cuenta cuentaNueva = null;
        System.out.println("Ingrese el tipo de cuenta que decea Crear"+
                          "\n1. Cuetnta Corriente"+
                          "\n2. Caja de Ahorro"+
                          "\n0. Salir");
        int seleccionCueta = Integer.parseInt(leer.nextLine().trim());
        System.out.println("Ingrese Nombre y Apellido para crear la cuenta: \n");
        cuenta = leer.nextLine();
        System.out.println("Ingrese el Saldo Inicial de la cuenta: ");
        saldoInicial = Double.parseDouble(leer.nextLine().trim());
        switch (seleccionCueta){
            case 1:
                cuentaNueva = new cuentaCorriente(NCuenta, cuenta, saldoInicial);
                break;
            case 2: 
                cuentaNueva = new cuentaAhorro(NCuenta, cuenta, saldoInicial);
                break;
            case 0:
                   //retorceder al menu
                break;
            default:
                System.out.println("Opcion Invalida, intente Nuevamente");
        }
    }
    
    private static void realizarTransaccio(){
        int NCuenta = 0;
        Transaccion transaccion = null;
        System.out.println("Elija el tipo de Transaccion a Realizar: "+
                         "\n1. Deposito"+
                         "\n2. Extraccion"+
                         "\n0. Salir");
        int seleccion = Integer.parseInt(leer.nextLine().trim());
        System.out.println("Ingrese el numero de Cuenta: ");
        String NroCuenta = leer.nextLine().trim();
        System.out.println("Ingrese el Monto de la Transaccion: ");
        double monto = Double.parseDouble(leer.nextLine().trim());
        switch (seleccion){
            case 1:
                transaccion = new Deposito(monto);
                break;
            case 2:
                transaccion = new Extraccion(monto);
                break;
            case 0:
                //salir un bloque 
                break;
            default:
                System.out.println("Opcion Invalida, Intente Nuevamente");
        }
        for(int i =0; i < cuentas.size(); i++){
            Cuenta Cuentas = cuentas.get(i);
            if(Cuentas.getNCuenta().equals(NroCuenta)){
                Cuentas.agregarTransaccion(transaccion);
                break;
            }else{
                System.out.println("El Bunero de Cuenta que Acabas de Ingresar NO EXISTE");
            }
        }
    }
}
