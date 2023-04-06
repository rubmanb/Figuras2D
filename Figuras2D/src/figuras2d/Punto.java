package figuras2d;


/**
 *
 * @author Ruben
 */
public class Punto {

    protected double x, y;

    //constructores
    public Punto() {

    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    //getters y setters

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
