
import core.Line;
import core.Station;
import junit.framework.TestCase;


import java.util.List;

public class TestRouteCalculator extends TestCase {

    List<Station> route;
    StationIndex stationIndex = new StationIndex();

    @Override
    protected void setUp() throws Exception {
        StationIndex stationIndex = new StationIndex();
        Line line = new Line(1,"Первая");
        Station station = new Station("Новочеркасская",line);
        Station station2 = new Station("Маяковская",line);
        Station station3 = new Station("Зенит",line);
        Line line1 = new Line(1,"вторая");
        stationIndex.addLine(line1);
        stationIndex.addLine(line);
        stationIndex.addStation(station);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        

    }
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

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
