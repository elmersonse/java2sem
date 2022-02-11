import java.sql.Time;
import java.util.Locale;

public class Passenger {
    private int flightId;
    private String surname;
    private String destination;
    private double flightTime;

    public Passenger() {
        flightId = 0;
        surname = "";
        destination = "";
        flightTime = 0;
    }

    public Passenger(int flightId, String surname, String destination, double flightTime) {
        this.flightId = flightId;
        this.surname = surname;
        this.destination = destination;
        this.flightTime = flightTime;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(double flightTime) {
        this.flightTime = flightTime;
    }

    public String toString() {
        return String.format(Locale.US, "%d,%s,%s,%f", flightId, surname, destination, flightTime);
    }
}
