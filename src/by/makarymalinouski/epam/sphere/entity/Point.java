package by.makarymalinouski.epam.sphere.entity;

public class Point {
    private final int x, y, z;
    
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getZ() {
        return z;
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
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
}
