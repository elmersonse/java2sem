import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

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
            br = new BufferedReader(new FileReader("src/main/java/passenger.csv"));
            while((temp = br.readLine()) != null) {
                mas = temp.split(",");
                passengers.add(new Passenger(mas));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Список рейсов:");
        for (Flight f: flights) {
            System.out.println(f.toString());
        }
        System.out.println("Список пассажиров");
        for (Passenger p: passengers) {
            System.out.println(p.toString());
        }
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    public static void task1() {
        System.out.println("\nВывод списка фамилий пассажиров, которые покупают билеты дороже 200 рублей в алфавитном " +
                "порядке с указанием рейса");
        List<Passenger> pass = new ArrayList<>();
        for(Flight f: flights) {
            pass.addAll(passengers.stream()
                    .filter(p -> p.getflightName()
                            .equals(f.getName()) && f.getTicketPrice() > 200)
                    .toList());
        }
        for (Passenger p: pass.stream().sorted(Passenger::comparator).toList()) {
            System.out.println(p.toString());
        }
    }

    public static void task2() {
        System.out.println("\nВывод списка пунктов назначения (без повторений).");
        System.out.println(passengers.stream().collect(Collectors.groupingBy(Passenger::getDestination)).keySet());
    }


    //Определение среднего количество проданных билетов для каждой даты вылета. Выводить дату вылета и среднее
//    количество проданных билетов.
    public static void task3() {
        System.out.println("\nОпределение среднего количество проданных билетов для каждой даты вылета. Выводить дату вылета и среднее"+
                " количество проданных билетов.");
        Map<Date, List<Flight>> dmap = flights.stream().collect(Collectors.groupingBy(Flight::getFlightDate));
        for(Map.Entry<Date, List<Flight>> e : dmap.entrySet()) {
            double count = 0;
            for (Flight f : e.getValue()) {
                count += f.getSoldTicketCount();
            }
            count /= e.getValue().size();
            System.out.println(e.getKey() + ": " + count);
        }
    }

    public static void task4() {
        System.out.println("\nВывод списка рейсов с заданным пунктом назначения, у которых количество проданных билетов меньше 30.");
        List<Flight> fl = new ArrayList<>();
        Map<Flight, String> fmap = new HashMap<>();
        fl.addAll(flights.stream().filter(f -> f.getSoldTicketCount() < 30).toList());
        for (Flight f: fl) {
            fmap.put(f, passengers.stream().filter(p -> p.getflightName().equals(f.getName())).toList().get(0).getDestination());
        }
        for(Map.Entry<Flight, String> e: fmap.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public static void task5() {
        System.out.println("\nОпределение рейса с максимальным количеством мест на борту.");
        System.out.println(flights.stream().max(Flight::compare1).get());
    }

    public static void task6() {
        System.out.println("\nОпределение максимального время полета в заданную дату.");
        System.out.println("Введите дату:");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        Date dateCheck = Date.valueOf(date);
        List<Flight> fl = new ArrayList<>(flights.stream().filter(f -> f.getFlightDate().equals(dateCheck)).toList());
        List<Passenger> ps = new ArrayList<>();
        for(Flight f: fl) {
            ps.addAll(passengers.stream().filter(p -> p.getflightName().equals(f.getName())).toList());
        }
        System.out.println(ps.stream().max(Passenger::comparator1).get().getFlightTime());
    }

    public static void task7() {
        System.out.println("\nВывод списка фамилий пассажиров, которые суммарно налетали более 20 часов.");
        Map<String, List<Passenger>> pmap = passengers.stream().collect(Collectors.groupingBy(Passenger::getSurname));
        for(Map.Entry<String, List<Passenger>> e: pmap.entrySet()) {
            double count = 0;
            for(Passenger p: e.getValue()) {
                count+=p.getFlightTime();
            }
            if(count > 20) {
                System.out.println(e.getKey() + ": " + count);
            }
        }





//        Map<Date, List<Flight>> dmap = flights.stream().collect(Collectors.groupingBy(Flight::getFlightDate));
//        for(Map.Entry<Date, List<Flight>> e : dmap.entrySet()) {
//            double count = 0;
//            for (Flight f : e.getValue()) {
//                count += f.getSoldTicketCount();
//            }
//            count /= e.getValue().size();
//            System.out.println(e.getKey() + ": " + count);
//        }
    }
}
