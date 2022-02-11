import java.sql.Date;

public class Flight {
    private String name;
    private int seatCount;
    private Date flightDate;
    private int soldTicketCount;
    private double ticketPrice;

    public Flight() {
        name = "";
        seatCount = 0;
        flightDate = Date.valueOf("1970-01-01");
        soldTicketCount = 0;
        ticketPrice = 0;
    }

    public Flight(String name, int seatCount, String flightDate, int soldTicketCount, double ticketPrice) {
        this.name = name;
        this.seatCount = seatCount;
        this.flightDate = Date.valueOf(flightDate);
        this.soldTicketCount = soldTicketCount;
        this.ticketPrice = ticketPrice;
    }

    public Flight(String[] args) {
        this.name = args[0];

    }

    public String getName() {
        return name;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public String getFlightDate() {
        return flightDate.toString();
    }

    public int getSoldTicketCount() {
        return soldTicketCount;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = Date.valueOf(flightDate);
    }

    public void setSoldTicketCount(int soldTicketCount) {
        this.soldTicketCount = soldTicketCount;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %d, %.2f", name, seatCount, flightDate.toString(), soldTicketCount, ticketPrice);
    }
}
