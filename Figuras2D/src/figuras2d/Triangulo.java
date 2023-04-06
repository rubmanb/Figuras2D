package figuras2d;

import static figuras2d.Usuario.*;

/**
 *
 * @author Ruben
 */
public class Triangulo extends Figura implements Dibujable{

    //siempre será un triangulo rectangulo
    protected double base, altura, hipotenusa;

    //constructores
    public Triangulo() {

    }

    public Triangulo(Punto origen, int id, String colorBorde, String colorRelleno) {
        super(origen, id, colorBorde, colorRelleno);
        base = leerDoble("Dime que mide la base del "+this.getClass().getSimpleName());
        altura = leerDoble("Dime que mide la altura del "+this.getClass().getSimpleName());
    }

    //métodos abstractos
    @Override
    public double area() {
        double area = (base * altura) / 2;
        return area;
    }

    @Override
    public double perimetro() {
        hipotenusa = Math.sqrt((base * base) + (altura * altura));
        double perimetro = base + altura + hipotenusa;
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
            System.out.println("La escala del "+this.getClass().getSimpleName()+" ha aumentado un "+porcentaje+"%");
            this.base = base * (porcentaje / 100);
            this.altura = altura * (porcentaje / 100);
            System.out.println("El área ha cambiado a: " + area());
            System.out.println("El perímetro ha cambiado a: " + perimetro());
        } else if (porcentaje < 100) {
            System.out.println("La escala del "+this.getClass().getSimpleName()+" ha disminuido un "+porcentaje+"%");
            this.base = (base * porcentaje) / 100;
            this.altura = (altura * porcentaje) / 100;
            System.out.println("El área ha cambiado a: " + area());
            System.out.println("El perímetro ha cambiado a: " + perimetro());
        } else {
            this.base = base;
            this.altura = altura;
        }
    }
    
    //getters y setters, toStrings, CompareTo
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

    public double getHipotenusa() {
        return hipotenusa;
    }

    public void setHipotenusa(double hipotenusa) {
        this.hipotenusa = hipotenusa;
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
                + "\nPosición de origenX: " + this.origen.getX()+"\nPosición de origenY: " + this.origen.getY()  + "\nBase: " + this.base + "\nAltura: " + this.altura
                + "\nÁrea: " + this.area() + "\nPerímetro: " + this.perimetro() + "\nColor del borde: "
                + this.colorBorde + "\nColor de relleno: " + this.colorRelleno+"\n";
        return propiedades;
    }

    

    @Override
    public void dibujar(){
        System.out.println("He dibujado un: "+this.getClass().getSimpleName());
    }
    
    @Override
    public void rellenar() {
        System.out.println("Se ha rellenado la figura " + this.getClass().getSimpleName() + " de un color");
        /*
        String color = leerString("OPCIONES:(amarillo, azul, blanco, negro, rojo, verde)\nDe que color?");
        color.toUpperCase();
        switch (color) {
            case "AMARILLO":
                //Triangulo.AMARILLO;
                break;
            case "AZUL":
                //Triangulo.AZUL;
                break;
            case "BLANCO":
                //Triangulo.BLANCO;
                break;
            case "NEGRO":
                //Triangulo.NEGRO;
                break;
            case "ROJO":
                //Triangulo.ROJO;
                break;
            case "VERDE":
                //Triangulo.VERDE;
                break;
            default:
                System.out.println("Ese color no está");
        }*/
    }

}
