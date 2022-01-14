import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Terminal> terminals = airport.getTerminals();

        return terminals
                .stream()
                .flatMap(terminal -> terminal
                                        .getFlights()
                                        .stream())
                                            .filter(flight -> toLocalDateTime(flight.getDate())
                                                                    .isBefore(toLocalDateTime(flight.getDate()).plusHours(2)) 
                                                                            && toLocalDateTime(flight.getDate())
                                                                                .isAfter(toLocalDateTime(flight.getDate()).plusMinutes(1)));



    }

    public static LocalDateTime toLocalDateTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }



}
