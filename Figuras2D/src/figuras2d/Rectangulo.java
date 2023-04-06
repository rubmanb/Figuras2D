package figuras2d;

import static figuras2d.Usuario.*;

/**
 *
 * @author Ruben
 */
public class Rectangulo extends Figura implements Dibujable{

    protected double base, altura;

    //constructores
    public Rectangulo() {

    }

    public Rectangulo(Punto origen, int id, String colorBorde, String colorRelleno) {
        super(origen, id, colorBorde, colorRelleno);
        base = leerDoble("Dime que mide la base del " + this.getClass().getSimpleName());
        altura = leerDoble("Dime que mide la altura del " + this.getClass().getSimpleName());
    }

    public Rectangulo(double altura, double base) {
        super();
        this.altura = altura;
        this.base = base;
    }
    
    //métodos abstractos
    @Override
    public double area() {
        double area = base * altura;
        return area;
    }

    @Override
    public double perimetro() {
        double perimetro = (2 * base) + (2 * altura);
        return perimetro;
    }

    @Override
    public double distancia(Figura f) {
        double distancia = this.origen.x - f.origen.x;
        return distancia;
    }

    @Override
    public void escalar(int porcentaje) {
        System.out.println("Se ha cambiado la escala del: " + this.getClass().getSimpleName());
        if (porcentaje > 100) {
            System.out.println("La escala del " + this.getClass().getSimpleName() + " ha aumentado un " + porcentaje + "%");
            this.base = base * (porcentaje / 100);
            this.altura = altura * (porcentaje / 100);
            System.out.println("El área ha cambiado a: " + area());
            System.out.println("El perímetro ha cambiado a: " + perimetro());
        } else if (porcentaje < 100) {
            System.out.println("La escala del " + this.getClass().getSimpleName() + " ha disminuido un " + porcentaje + "%");
            this.base = (base * porcentaje) / 100;
            this.altura = (altura * porcentaje) / 100;
            System.out.println("El área ha cambiado a: " + area());
            System.out.println("El perímetro ha cambiado a: " + perimetro());
        } else {
            this.base = base;
            this.altura = altura;
        }
    }

    //getters y setters, toString, CompareTo
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
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
                + "\nPosición de origenX: " + this.origen.getX() + "\nPosición de origenY: " + this.origen.getY() + "\nBase: " + this.base + "\nAltura: " + this.altura
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
                //Rectangulo.AMARILLO;
                break;
            case "AZUL":
                //Rectangulo.AZUL;
                break;
            case "BLANCO":
                //Rectangulo.BLANCO;
                break;
            case "NEGRO":
                //Rectangulo.NEGRO;
                break;
            case "ROJO":
                //Rectangulo.ROJO;
                break;
            case "VERDE":
                //Rectangulo.VERDE;
                break;
            default:
                System.out.println("Ese color no está");
        }
         */
    }

}
