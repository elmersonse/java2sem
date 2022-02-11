import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static List<Flight> flights = new ArrayList<>();
    public static List<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("flight.csv"));
            String temp;
            while((temp = br.readLine()) != null) {

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
