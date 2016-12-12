package by.makarymalinouski.epam.sphere.exception;

public class SphereNotCrossesCoordPlanesException extends Exception {
    public SphereNotCrossesCoordPlanesException() {
    }
    
    public SphereNotCrossesCoordPlanesException(String message) {
        super(message);
    }
    
    public SphereNotCrossesCoordPlanesException(String message, Throwable cause) {
        super(message, cause);
    }

    public SphereNotCrossesCoordPlanesException(Throwable cause) {
        super(cause);
    }
}
