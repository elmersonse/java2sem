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
            br = new BufferedReader(new FileReader("src/main/java/flight.csv"));
            String temp;
            String[] mas;
            while((temp = br.readLine()) != null) {
                mas = temp.split(",");
                flights.add(new Flight(mas));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for (Flight f: flights) {
            System.out.println(f.toString());
        }

    }

    //Определение среднего количество проданных билетов для каждой даты вылета. Выводить дату вылета и среднее
    //количество проданных билетов.
    public void task3() {

    }
}
