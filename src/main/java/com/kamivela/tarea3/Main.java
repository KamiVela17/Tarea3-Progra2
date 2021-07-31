/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamivela.tarea3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner t = new Scanner(System.in);

    public static String[][] comisiones = new String[3][6];

    public static void updateNombre() {
        String actual = "";
        String nuevo = "";

        System.out.println("Ingrese nombre actual: ");
        actual = t.nextLine();
        System.out.println("Ingrese nombre nuevo: ");
        nuevo = t.nextLine();

        for (int x = 0; x < comisiones.length; x++) {
            if (comisiones[x][0].equals(actual)) {
                comisiones[x][0] = new String(nuevo);
                break;

            }

        }

        System.out.println("Se ha cambiado el nombre de: " + actual + " por: " + nuevo);

    }

    public static void updateInfo() {
        String nombre = "";
        int mes = 0;
        String valor = "";

        System.out.println("Ingrese nombre: ");
        nombre = t.nextLine();
        System.out.println("Ingrese numero de mes: ");
        mes = Integer.parseInt(t.nextLine());
        System.out.println("Ingrese nuevo valor: ");
        valor = t.nextLine();

        for (int x = 0; x < comisiones.length; x++) {
            if (comisiones[x][0].equals(nombre)) {
                comisiones[x][mes] = valor;
                break;

            }

        }

        System.out.println("Se ha cambiado el valor del mes de: " + mes + " de la persona: " + nombre + " por el valor de: " + valor);
        calcTotalMeses();
        imprimirDecorado(comisiones);
        calcTotalMes();
    }

    public static void cargaInfo() {
        System.out.println("Ingrese nombre 1: ");
        comisiones[0][0] = t.nextLine();
        System.out.println("Ingrese informacion de enero");
        comisiones[0][1] = t.nextLine();
        System.out.println("Ingrese informacion de febrero");
        comisiones[0][2] = t.nextLine();
        System.out.println("Ingrese informacion de marzo");
        comisiones[0][3] = t.nextLine();
        System.out.println("Ingrese nombre 2: ");
        comisiones[1][0] = t.nextLine();
        System.out.println("Ingrese informacion de enero");
        comisiones[1][1] = t.nextLine();
        System.out.println("Ingrese informacion de febrero");
        comisiones[1][2] = t.nextLine();
        System.out.println("Ingrese informacion de marzo");
        comisiones[1][3] = t.nextLine();
        System.out.println("Ingrese nombre 3: ");
        comisiones[2][0] = t.nextLine();
        System.out.println("Ingrese informacion de enero");
        comisiones[2][1] = t.nextLine();
        System.out.println("Ingrese informacion de febrero");
        comisiones[2][2] = t.nextLine();
        System.out.println("Ingrese informacion de marzo");
        comisiones[2][3] = t.nextLine();
    }

    public static void imprimirDecorado(String[][] array) {
        System.out.println("Nombre \t|| Enero \t|| Febrero \t|| Marzo \t|| Total \t|| Promedio");

        for (int x = 0; x < comisiones.length; x++) {

            System.out.print(comisiones[x][0]);
            System.out.print(" \t||");

            for (int y = 1; y < comisiones[x].length; y++) {
                System.out.print(" Q." + comisiones[x][y]);
                System.out.print(" \t\t||");

            }

            System.out.print(" \n");

        }

    }

    public static void calcTotalMes() {
        Double acumuladorMes;
        int acumuladorFila;
        int[] totalMes = new int[comisiones.length];

        for (int columna = 1; columna < comisiones[0].length - 1; columna++) {
            /*
            Se empieza desde la columna 1 para evitar el nombre.
            Se resta 1 a comisiones.length para evitar total.
             */
            acumuladorMes = 0.0;
            acumuladorFila = 0;

            for (int fila = 0; fila < comisiones.length; fila++) {

                acumuladorMes += Double.parseDouble(comisiones[fila][columna]);
            }

            System.out.println("Totales de la columna " + columna + " son " + acumuladorMes);
        }
    }

    public static void mayormenor() {

        Double numeroMayor = 0.0;
        Double numeroMenor = 0.0;
        String mayorPosicion = "0,0";
        String menorPosicion = "0,0";
        String nombreMayor = "";
        String nombreMenor = "";
        for (int x = 0; x < comisiones.length; x++) {
            for (int y = 1; y < comisiones[x].length - 2; y++) {
                if (Double.parseDouble(comisiones[x][y]) > numeroMayor) {
                    numeroMayor = Double.parseDouble(comisiones[x][y]);
                    mayorPosicion = String.valueOf(x) + "," + String.valueOf(y);
                    nombreMayor = comisiones[x][0];
                }
                if (x == 0 && y == 1) {
                    numeroMenor = Double.parseDouble(comisiones[x][y]);
                    nombreMenor = comisiones[x][0];

                }

                if (Double.parseDouble(comisiones[x][y]) < numeroMenor) {
                    numeroMenor = Double.parseDouble(comisiones[x][y]);
                    menorPosicion = String.valueOf(x) + "," + String.valueOf(y);
                    nombreMenor = comisiones[x][0];

                }
            }
        }

        System.out.println("El la venta por mes mayor es: " + numeroMayor + " de: " + nombreMayor);
        System.out.println("El la venta por mes menor es: " + numeroMenor + " de: " + nombreMenor);
    }

    public static void busqueda() {

        String valor = "";
        String nombre = "";
        int mes = 0;
        System.out.println("Ingrese el valor de busqueda: ");
        valor = t.nextLine();
        for (int x = 0; x < comisiones.length; x++) {
            for (int y = 1; y < comisiones[x].length - 2; y++) {
                if (comisiones[x][y].equals(valor)) {
                    nombre = (comisiones[x][0]);
                    mes = y;
                }

            }
        }
        if (nombre.equals("")) {
            System.out.println("No se encontro el valor");

        } else {
            System.out.println("El la venta pertenece a: " + nombre + " en el mes numero: " + mes);

        }
    }

    public static void quienvendio() {
        int y = 4;
        Double numeroMayor = 0.0;
        Double numeroMenor = 0.0;
        String mayorPosicion = "0,0";
        String menorPosicion = "0,0";
        String nombreMayor = "";
        String nombreMenor = "";
        for (int x = 0; x < comisiones.length; x++) {
            if (Double.parseDouble(comisiones[x][y]) > numeroMayor) {
                numeroMayor = Double.parseDouble(comisiones[x][y]);
                mayorPosicion = String.valueOf(x) + "," + String.valueOf(y);
                nombreMayor = comisiones[x][0];
            }
            if (x == 0 && y == 1) {
                numeroMenor = Double.parseDouble(comisiones[x][y]);
                nombreMenor = comisiones[x][0];

            }

            if (Double.parseDouble(comisiones[x][y]) < numeroMenor) {
                numeroMenor = Double.parseDouble(comisiones[x][y]);
                menorPosicion = String.valueOf(x) + "," + String.valueOf(y);
                nombreMenor = comisiones[x][0];

            }
        }

        System.out.println("El la venta mayor es: " + numeroMayor + " de : " + nombreMayor);
    }

    public static void calcTotalMeses() {

        String nombrePersona = "";
        Double acumuladorMes;
        int cantMeses;
        double promedio;

        for (int fila = 0; fila < comisiones.length; fila++) {
            cantMeses = 0;
            acumuladorMes = 0.0;
            promedio = 0;

            for (int columna = 1; columna < comisiones[fila].length - 2; columna++) {
                /*
                Se empieza desde la columna 1 para evitar el nombre.
                Se resta 2 a comisiones.length para evitar total y promedio.
                 */

                acumuladorMes += Double.parseDouble(comisiones[fila][columna]);
                cantMeses++;

                promedio = acumuladorMes / cantMeses;

            }

            comisiones[fila][comisiones[fila].length - 2] = String.valueOf(acumuladorMes);
            comisiones[fila][comisiones[fila].length - 1] = String.valueOf(promedio);

            nombrePersona = comisiones[fila][0];
            System.out.println("Total de " + nombrePersona + " es de : " + acumuladorMes);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //calcTotalMeses();
        //   imprimirDecorado(comisiones);
        //  calcTotalMes();
        boolean salir = false;
        String opcion = ""; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Cargar informacion de vendedores");
            System.out.println("2. Quien vendio mas y quien vendio menos?");
            System.out.println("3. Quien vendio mas en los 3 meses?");
            System.out.println("4. Editar nombre");
            System.out.println("5. Editar valor");
            System.out.println("6. Busqueda por cantidad");
            System.out.println("7. Desplegar matriz");
            System.out.println("8. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = t.nextLine();

                switch (opcion) {
                    case "1":

                        cargaInfo();
                        break;
                    case "2":
                        mayormenor();
                        break;
                    case "3":
                        quienvendio();

                        break;
                    case "4":
                        updateNombre();
                        break;
                    case "5":
                        updateInfo();
                        break;
                    case "6":
                        busqueda();
                        break;
                    case "7":
                        calcTotalMeses();
                        imprimirDecorado(comisiones);
                        calcTotalMes();
                        break;
                    case "8":
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                t.next();
            }

        }

    }
}
