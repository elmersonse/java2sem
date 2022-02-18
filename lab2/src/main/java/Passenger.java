import java.sql.Time;
import java.util.Locale;

public class Passenger {
    private String flightName;
    private String surname;
    private String destination;
    private double flightTime;

    public Passenger() {
        flightName = "";
        surname = "";
        destination = "";
        flightTime = 0;
    }

    public Passenger(String flightName, String surname, String destination, double flightTime) {
        this.flightName = flightName;
        this.surname = surname;
        this.destination = destination;
        this.flightTime = flightTime;
    }

    public Passenger(String[] args) {
        flightName = args[0];
        surname = args[1];
        destination = args[2];
        flightTime = Double.parseDouble(args[3]);
    }

    public String getflightName() {
        return flightName;
    }

    public void setflightName(String flightName) {
        this.flightName = flightName;
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
        return String.format(Locale.US, "%s,%s,%s,%f", flightName, surname, destination, flightTime);
    }

    public static int comparator(Passenger p1, Passenger p2) {
        return p1.surname.compareTo(p2.surname);
    }

    public static int comparator1(Passenger p1, Passenger p2) {
        if(p1.flightTime > p2.flightTime) {
            return 1;
        }
        return -1;
    }
}
