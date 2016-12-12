package by.makarymalinouski.epam.sphere.entity;

public class Point {
    private final double x, y, z;
    
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getZ() {
        return z;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        long xL = Double.doubleToLongBits(x);
        long yL = Double.doubleToLongBits(y);
        long zL = Double.doubleToLongBits(z);

        result = 31 * result + (int) (xL^(xL >>> 32));
        result = 31 * result + (int) (yL^(yL >>> 32));
        result = 31 * result + (int) (zL^(zL >>> 32));
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!obj.getClass().equals(this.getClass())) {
            return false;
        } else if (((Point) obj).x == this.x && ((Point) obj).y == this.y && ((Point) obj).z == this.z) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return String.format("Point (%d, %d, %d)", x, y, z);
    }
}
