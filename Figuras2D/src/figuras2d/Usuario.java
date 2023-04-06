/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras2d;

import java.util.Scanner;

/**
 *
 * @author Ruben
 */
public class Usuario {

    static Scanner usuario = new Scanner(System.in);

    public static double leerDoble(String s) {
        System.out.println(s);
        double n = usuario.nextDouble();
        usuario.nextLine();
        return n;
    }

    public static String leerString(String s) {
        System.out.println(s);
        String cadena = usuario.nextLine();
        return cadena;
    }

    public static char leerChar(String s) {
        System.out.println(s);
        char caracter = usuario.nextLine().charAt(0);
        return caracter;
    }

    public static int leerEntero(String s) {
        System.out.println(s);
        int n = usuario.nextInt();
        usuario.nextLine();
        return n;
    }

    public static boolean devolverBoleano(String s) {
        System.out.println(s);
        char c = usuario.nextLine().charAt(0);
        return c == 's';
    }
}
