/**
 * Coordinates class.
 *
 * @author ahennessy6
 * @version 1.0
 */
public class Coordinates {

    private final double latitude;
    private final double longitude;

    /**
     * Constructor for Coordinates.
     * @param latitude latitude as double
     * @param longitude longitude as double
     */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Coordinates)) {
            return false;
        }
        return this.getLatitude() == ((Coordinates) other).getLatitude()
                && this.getLongitude() == ((Coordinates) other).getLongitude();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("latitude: %.02f, longitude: %.02f",
                this.getLatitude(), this.getLongitude());
    }

    /**
     * getLatitude getter for Latitude instance var.
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * getLongitude getter for Longitude instance var.
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

}
