import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        List<Terminal> terminals = airport.getTerminals();
        LocalDateTime now = LocalDateTime.now();
        return terminals
                .stream()
                .flatMap(terminal -> terminal
                        .getFlights()
                        .stream())
                .filter(flight -> toLocalDateTime(flight.getDate()).isAfter(now))
                .filter(flight -> toLocalDateTime(flight.getDate()).isBefore(now.plusHours(2)))
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());


    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


}
