package figuras2d;

/**
 *
 * @author Ruben
 */
public abstract class Figura implements Comparable<Figura> {

    protected Punto origen;
    protected int id; 
    protected String colorBorde, colorRelleno;

    //constructores
    public Figura() {

    }

    public Figura(Punto origen, int id, String colorBorde, String colorRelleno) {
        this.origen = origen;
        this.id = id;
        this.colorBorde = colorBorde;
        this.colorRelleno = colorRelleno;
    }

    //métodos
    public abstract double area();

    public abstract double perimetro();

    public abstract double distancia(Figura f);

    public abstract void escalar(int porcentaje);

    public void mover(Punto p) {
        origen.x = p.x;
        origen.y = p.y;
    }

    public void desplazarH(double x) {
        //desplaza la figura horizontalmente(+derecha, -izquierda)
        origen.setX(x);
        System.out.println("La figura se ha desplazado al eje x: ");//no se pot mostrar amb la nova assignació
    }

    public void desplazarV(double y) {
        //desplaza la figura verticalmente(+arriba, -abajo)
        origen.setY(y);
    }

    //getters y setters
    public Punto getOrigen() {
        return origen;
    }

    public void setOrigen(Punto origen) {
        this.origen = origen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(String colorBorde) {
        this.colorBorde = colorBorde;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    @Override
    public int compareTo(Figura f) {
        Double a;
        a = area();
        return a.compareTo(f.area());
    }

    public Double distancia(Punto p) {
        double x1 = origen.x - p.getX();
        double y1 = origen.y - p.getY();
        return Math.sqrt(x1 * x1 + y1 * y1);
    }

}
