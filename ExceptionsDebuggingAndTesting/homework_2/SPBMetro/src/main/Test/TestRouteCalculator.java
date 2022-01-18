
import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {

    List<Station> route;
    RouteCalculator routeCalculator = new RouteCalculator(new StationIndex());
    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();

        Line line = new Line(1, "Первая");
        Line line1 = new Line(2, "Вторая");


        Station station = new Station("Новочеркасская", line);
        Station station2 = new Station("Зенит", line);
        Station station3 = new Station("Маяковская", line1);
        route.add(station);
        route.add(station2);
        route.add(station3);
    }

    public void testCalculateDuration() {
        double expected = 8.5;
        double actual = RouteCalculator.calculateDuration(route);
        assertEquals(expected, actual);

    }

    public void testGetShortestRoute() {
        List<Station> expected = route.subList(0, route.size());
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(route.size() - 1));
        assertEquals(expected, actual);
    }


}
