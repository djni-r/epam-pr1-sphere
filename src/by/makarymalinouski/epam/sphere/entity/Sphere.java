package by.makarymalinouski.epam.sphere.entity;

public class Sphere {
    private double radius;
    private Point center;
    
    public Sphere(Point center, double radius) {
        this.radius = radius;
        this.center = center;
    }
    
    public Sphere(double centerX, double centerY, double centerZ, double radius) {
        center = new Point(centerX, centerY, centerZ);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    
    public Point getCenter() {
        return center;
    }
    
    @Override
    public int hashCode() {
        int result = 37;
        long r = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (r^(r >>> 32));
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
    
    @Override
    public String toString() {
        return String.format("Sphere with center %s, radius %d", center, radius);
    }
    
    
}
