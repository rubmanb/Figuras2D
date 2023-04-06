/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras2d;

import static figuras2d.Usuario.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Ruben
 */
public class Lienzo {

    static ArrayList<Figura> figuras = new ArrayList();

    //métodos arraylist
    public void add(Figura f) {
        figuras.add(f);
    }

    public static Comparator<Figura> compararPerimetro = (Figura a, Figura b) -> {
        Double a1 = a.perimetro();
        return a1.compareTo(b.perimetro());
    };

    public static Comparator<Figura> compararDistancia = (Figura a, Figura b) -> {
        Punto xy = new Punto(0, 0);
        Double a1 = a.distancia(xy);
        return a1.compareTo(b.distancia(xy));
    };

    //titulo
    public static void titulo(String s, char c) {
        for (int i = 0; i <= s.length(); i++) {
            System.out.print(c);
        }
        System.out.println("\n" + s);
        for (int i = 0; i <= s.length(); i++) {
            System.out.print(c);
        }
    }

    //métodos para las figuras
    public static double ubicacionX() {
        double ubicacionX = Math.round(Math.random() * (100 - 0) + 1);
        return ubicacionX;
    }

    public static double ubicacionY() {
        double ubicacionY = Math.round(Math.random() * (100 - 0) + 1);
        return ubicacionY;
    }

    public static int insertarIdentificador() {
        int id = leerEntero("Identificador: ");
        return id;
    }

    public static String colorRandom() {
        String color = null;
        int colorRandom = (int) (Math.random() * (6 - 0) + 1);
        switch (colorRandom) {
            case 1:
                color = Dibujable.ROJO;
                break;
            case 2:
                color = Dibujable.VERDE;
                break;
            case 3:
                color = Dibujable.AZUL;
                break;
            case 4:
                color = Dibujable.AMARILLO;
                break;
            case 5:
                color = Dibujable.NEGRO;
                break;
            case 6:
                color = Dibujable.BLANCO;
                break;
            default:
        }
        return color;
    }

    public static String colorBorde() {
        String colorBorde = colorRandom();
        return colorBorde;
    }

    public static String colorRelleno() {
        String colorRelleno = colorRandom();
        return colorRelleno;
    }

    //construccion de figuras
    public static void dibujar() {
        Figura fig = null;
        Punto p = null;
        int numFiguras = 1;
        int figuraRandom = 0;
        do {
            figuraRandom = (int) Math.floor(Math.random() * (5 - 1) + 1);
            System.out.println("Creando una Figura");
            int id = insertarIdentificador();
            double x = ubicacionX();
            double y = ubicacionY();
            String cBorde = colorBorde();
            String cRelleno = colorRelleno();
            switch (figuraRandom) {
                case 1:
                    p = new Punto(x, y);
                    fig = new Cuadrado(p, id, cBorde, cRelleno);
                    break;
                case 2:
                    p = new Punto(x, y);
                    fig = new Rectangulo(p, id, cBorde, cRelleno);
                    break;
                case 3:
                    p = new Punto(x, y);
                    fig = new Circulo(p, id, cBorde, cRelleno);
                    break;
                case 4:
                    p = new Punto(x, y);
                    fig = new Triangulo(p, id, cBorde, cRelleno);
                    break;
                default:
                    System.out.println("Elige entre el 1 y el 4");
            }
            figuras.add(fig);
            numFiguras++;
        } while (numFiguras <= 10);
        menu();
    }

    public static void area() {
        //mostrar las areas de todas las figuras
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println("Figura: " + (i + 1) + " " + figuras.get(i).area());
        }
    }

    public static void perimetro() {
        //mostrar los perimetros de todas las figuras
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println("Figura: " + (i + 1) + " " + figuras.get(i).perimetro());
        }
    }

    public static void distancia(int id) {
        //mostrar la distancia entre figuras
        int posIdFigura = 0;
        for (int i = 0; i < figuras.size(); i++) {
            if (figuras.get(i).getId() == id) {
                posIdFigura = i;
            }
        }
        for (int i = 0; i < figuras.size(); i++) {
            if (posIdFigura != i) {
                System.out.println("La distancia es: " + figuras.get(posIdFigura).distancia(figuras.get(i)));
            }
        }
    }

    public static void listar() {
        //mostrar la lista
        if (figuras.isEmpty()) {
            System.out.println("La lista está vacia");
        } else {
            for (int i = 0; i < figuras.size(); i++) {
                System.out.println("Figura: " + (i + 1) + " " + figuras.get(i));
            }
        }
    }

    public static void escalar(int id, int porcentaje) {
        //cambiar el tamaño de la figura
        for (int i = 0; i < figuras.size(); i++) {
            if (figuras.get(i).getId() == id) {
                figuras.get(i).escalar(porcentaje);
            }
        }
    }

    public static void mover(int id, Punto p) {
        //mover una figura 
        for (int i = 0; i < figuras.size(); i++) {
            if (figuras.get(i).getId() == id) {
                figuras.get(i).mover(p);
            }
        }

    }

    public static void desplazarh(int id, double x) {
        //desplazar en horizontal una figura
        for (int i = 0; i < figuras.size(); i++) {
            if (figuras.get(i).getId() == id) {
                figuras.get(i).desplazarH(x);
            }
        }

    }

    public static void desplazarv(int id, double y) {
        //desplazar en vertical una figura
        for (int i = 0; i < figuras.size(); i++) {
            if (figuras.get(i).getId() == id) {
                figuras.get(i).desplazarV(y);
            }
        }
    }

    public static void desplazar(int id, double x, double y) {
        desplazarh(id, x);
        desplazarv(id, y);
    }

    public static void ordenar() {
        System.out.println("ORDENAR FIGURAS");
        int ordenarPor = leerEntero("Ordenar por: 1 - Área, 2 - Perímetro, 3 - Distancia");
        switch (ordenarPor) {
            case 1:
                Collections.sort(figuras);
                break;
            case 2:
                Collections.sort(figuras, compararPerimetro);
                break;
            case 3:
                Collections.sort(figuras, compararDistancia);
                break;
            default:
                System.out.println("Elige entre 1, 2, 3");
        }
        menu();
    }

    //menu
    public static void menu() {
        int id = 0;
        int porcentaje = 0;
        Punto p = null;
        double x = 0;
        double y = 0;
        System.out.println("MENU");
        System.out.println("1 - Listar Figuras");
        System.out.println("2 - Dibujar Figuras");
        System.out.println("3 - Ver el perímetro de las Figuras");
        System.out.println("4 - Ver el área de las Figuras");
        System.out.println("5 - Cambiar el tamaño de las Figuras");
        System.out.println("6 - Mover Figuras");
        System.out.println("7 - Desplazar una Figura");
        System.out.println("8 - Ordenar las Figuras\n");
        int opcion = leerEntero("Elige una opción");
        switch (opcion) {
            case 1:
                listar();
                break;
            case 2:
                dibujar();
                break;
            case 3:
                perimetro();
                break;
            case 4:
                area();
                break;
            case 5:
                id = leerEntero("Que figura deseas? Marca el ID de la figura.");
                porcentaje = leerEntero("Que porcentaje quieres aumentar o disminuir la figura?");
                escalar(id, porcentaje);
                break;
            case 6:
                id = leerEntero("Que figura deseas? Marca el ID de la figura.");
                p.x = leerDoble("Dime un punto de referencia");
                mover(id, p);
                break;
            case 7:
                id = leerEntero("Que figura deseas? Marca el ID de la figura.");
                x = leerDoble("Dime la coordenada 'x' de una figura");
                y = leerDoble("Dime la coordenada 'y' de una figura");
                desplazar(id, x, y);
                break;
            case 8:
                ordenar();
                break;
            default:
                System.out.println("Esa opción no está");
        }
        System.out.println();
        boolean volverMenu = devolverBoleano("Quieres volver al Menu? (Escribe -> ('s' o 'n'))");
        if (volverMenu == true) {
            menu();
        } else {
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        titulo("FIGURAS GEOMETRICAS", '#');
        menu();

        /*PRUEBAS
        Punto c1Punto = new Punto(1.3, 5.5);
        Punto r1Punto = new Punto(2.5, 5.5);
        Punto circ1Punto = new Punto(5.3, 5.5);
        Punto t1Punto = new Punto(7.3, 5.5);
        Figura c1;
        c1 = new Cuadrado(c1Punto, 1234, "Azul", "Verde");
        c1.mover(c1Punto);
        Figura r1;
        r1 = new Rectangulo(r1Punto, 5678, "Verde", "Azul");
        Figura cercle;
        cercle = new Circulo(circ1Punto, 4321, "Rojo", "Negro");
        Figura t1;
        t1 = new Triangulo(t1Punto, 9876, "Rojo", "Amarillo");

        //listado de figuras
        System.out.println(c1.toString());
        System.out.println(r1.toString());
        System.out.println(cercle.toString());
        System.out.println(t1.toString());

        //nuevo escalado
        c1.escalar(200);
        c1.escalar(50);
        r1.escalar(200);
        r1.escalar(50);
        cercle.escalar(200);
        cercle.escalar(50);
        t1.escalar(200);
        t1.escalar(50);
         */
    }
}
