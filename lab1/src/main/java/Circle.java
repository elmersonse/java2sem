public class Circle {
    private double x;
    private double y;
    private double r;

    public Circle() {
        x = 0;
        y = 0;
        r = 1;
    }

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public double getArea() {
        return Math.PI*Math.pow(r, 2);
    }

    public double getLength() {
        return 2*Math.PI*r;
    }

    public void add(Circle c) { this.r += c.getR(); }

    public void sub(Circle c) { this.r -= c.getR(); }

    public void mul(Circle c) { this.r *= c.getR(); }

    public void div(Circle c) { this.r /= c.getR(); }
}
