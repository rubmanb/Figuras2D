package figuras2d;

import static figuras2d.Usuario.*;

/**
 *
 * @author Ruben
 */
public class Cuadrado extends Figura implements Dibujable {

    protected double lado;

    //constructores
    public Cuadrado() {

    }

    public Cuadrado(Punto origen, int id, String colorBorde, String colorRelleno) {
        super(origen, id, colorBorde, colorRelleno);
        lado = leerDoble("Dime que mide un lado del " + this.getClass().getSimpleName());
        
    }

    //métodos abstractos
    @Override
    public double area() {
        double area = lado * 2;
        return area;
    }

    @Override
    public double perimetro() {
        double perimetro = lado * 4;
        return perimetro;
    }

    @Override
    public double distancia(Figura f) {
        double distancia = 0;
        if (this.origen.x > f.origen.x) {
            distancia = this.origen.x - f.origen.x;
        } else if (this.origen.x < f.origen.x) {
            distancia = f.origen.x - this.origen.x;
        } else {
            distancia = 0;
        }
        return distancia;
    }

    @Override
    public void escalar(int porcentaje) {

        if (porcentaje > 100) {
            System.out.println("La escala del " + this.getClass().getSimpleName() + " ha aumentado un " + porcentaje + "%");
            this.lado = lado * (porcentaje / 100);
            System.out.println("El área ha cambiado a: " + area());
            System.out.println("El perímetro ha cambiado a: " + perimetro());
        }
        if (porcentaje < 100) {
            System.out.println("La escala del " + this.getClass().getSimpleName() + " ha disminuido un " + porcentaje + "%");
            this.lado = (lado * porcentaje) / 100;
            System.out.println("El área ha cambiado a: " + area());
            System.out.println("El perímetro ha cambiado a: " + perimetro());
        } else {
            this.lado = lado;
        }
    }
    
    //getters y setters, toString, CompareTo
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public Punto getOrigen() {
        origen.x = origen.getX();
        return origen;
    }

    @Override
    public void setOrigen(Punto origen) {
        this.origen = origen;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getColorBorde() {
        return colorBorde;
    }

    @Override
    public void setColorBorde(String colorBorde) {
        this.colorBorde = colorBorde;
    }

    @Override
    public String getColorRelleno() {
        return colorRelleno;
    }

    @Override
    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    @Override
    public String toString() {
        String atributos = "Tipo de figura: " + this.getClass().getSimpleName() + "\nID: " + this.getId()
                + "\nPosición de origenX: " + this.origen.getX() + "\nPosición de origenY: " + this.origen.getY() + "\nLado: " + this.lado
                + "\nÁrea: " + this.area() + "\nPerímetro: " + this.perimetro() + "\nColor del borde: "
                + this.colorBorde + "\nColor de relleno: " + this.colorRelleno + "\n";
        return atributos;
    }

    

    @Override
    public void dibujar() {
        System.out.println("He dibujado un: " + this.getClass().getSimpleName());
    }

    @Override
    public void rellenar() {
        System.out.println("Se ha rellenado la figura " + this.getClass().getSimpleName() + " de un color");
        /*
        String color = leerString("OPCIONES:(amarillo, azul, blanco, negro, rojo, verde)\nDe que color?");
        color.toUpperCase();
        switch (color) {
            case "AMARILLO":
                //Cuadrado.AMARILLO;
                break;
            case "AZUL":
                //Cuadrado.AZUL;
                break;
            case "BLANCO":
                //Cuadrado.BLANCO;
                break;
            case "NEGRO":
                //Cuadrado.NEGRO;
                break;
            case "ROJO":
                //Cuadrado.ROJO;
                break;
            case "VERDE":
                //Cuadrado.VERDE;
                break;
            default:
                System.out.println("Ese color no está");
        }*/
    }
}
