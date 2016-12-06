package by.makarymalinouski.epam.project1;

public class Sphere {
    private int radius;
    private Point center;
    
    public Sphere(Point center, int radius) {
        this.radius = radius;
        this.center = center;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public Point getCetner() {
        return center;
    }
    
}
