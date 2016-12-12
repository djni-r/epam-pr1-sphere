package by.makarymalinouski.epam.sphere.entity;

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
    
    public Point getCenter() {
        return center;
    }
    
    @Override
    public int hashCode() {
        int result = 37;
        result = 31 * result + radius;
        result = 31 * result + center.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!obj.getClass().equals(this.getClass())) {
            return false;
        } else if (((Sphere) obj).center.equals(this.center) && ((Sphere) obj).radius == this.radius) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
