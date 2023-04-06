package figuras2d;

import static figuras2d.Usuario.*;

/**
 *
 * @author Ruben
 */
public class Circulo extends Figura implements Dibujable {

    protected double radio;

    //constructores
    public Circulo() {

    }

    public Circulo(Punto origen, int id, String colorBorde, String colorRelleno) {
        super(origen, id, colorBorde, colorRelleno);
        radio = leerDoble("Dime que mide el radio del " + this.getClass().getSimpleName());
    }
    
    //métodos abstractos
    @Override
    public double area() {
        double area = Math.PI * Math.pow(radio, 2);
        return area;
    }

    @Override
    public double perimetro() {
        double perimetro = (Math.PI * 2) * radio;
        return perimetro;
    }

    @Override
    public double distancia(Figura f) {

        double distancia = this.origen.x - f.origen.x;
        return distancia;
    }

    @Override
    public void escalar(int porcentaje) {

        if (porcentaje > 100) {
            System.out.println("La escala del " + this.getClass().getSimpleName() + " ha aumentado un " + porcentaje + "%");
            this.radio = radio * (porcentaje / 100);
            System.out.println("El área ha cambiado a: " + area());
            System.out.println("El perímetro ha cambiado a: " + perimetro());
        } else if (porcentaje < 100) {
            System.out.println("La escala del " + this.getClass().getSimpleName() + " ha disminuido un " + porcentaje + "%");
            this.radio = (radio * porcentaje) / 100;
            System.out.println("El área ha cambiado a: " + area());
            System.out.println("El perímetro ha cambiado a: " + perimetro());
        } else {
            this.radio = radio;
        }
    }

    //getters y setters, toString, CompareTo
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public Punto getOrigen() {
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
        String propiedades = "Tipo de figura: " + this.getClass().getSimpleName() + "\nID: " + this.getId()
                + "\nPosición de origenX: " + this.origen.getX() + "\nPosición de origenY: " + this.origen.getY() + "\nRadio: : " + this.radio
                + "\nÁrea: " + this.area() + "\nPerímetro: " + this.perimetro() + "\nColor del borde: "
                + this.colorBorde + "\nColor de relleno: " + this.colorRelleno + "\n";
        return propiedades;
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
                //Circulo.AMARILLO;
                break;
            case "AZUL":
                //Circulo.AZUL;
                break;
            case "BLANCO":
                //Circulo.BLANCO;
                break;
            case "NEGRO":
                //Circulo.NEGRO;
                break;
            case "ROJO":
                //Circulo.ROJO;
                break;
            case "VERDE":
                //Circulo.VERDE;
                break;
            default:
                System.out.println("Ese color no está");
        }*/
    }

}
