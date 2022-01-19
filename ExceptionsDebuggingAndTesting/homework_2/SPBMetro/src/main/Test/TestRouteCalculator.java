import core.Line;
import core.Station;
import junit.framework.TestCase;


import java.util.ArrayList;
import java.util.List;

public class TestRouteCalculator extends TestCase {


    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator;

    protected void setUp() {
        stationIndex = new StationIndex();

        Line lineFirst = new Line(1, "First");
        Line lineSecond = new Line(2, "Second");

        stationIndex.addLine(lineFirst);
        stationIndex.addLine(lineSecond);

        Station st1l1 = new Station("L1-ST-1", lineFirst);
        Station st2l1 = new Station("L1-ST-2", lineFirst);
        Station st3l1 = new Station("L1-ST-3", lineFirst);

        lineFirst.addStation(st1l1);
        lineFirst.addStation(st2l1);
        lineFirst.addStation(st3l1);

        Station st1l2 = new Station("L2-ST-1", lineSecond);
        Station st2l2 = new Station("L2-ST-2", lineSecond);
        Station st3l2 = new Station("L2-ST-3", lineSecond);

        lineSecond.addStation(st1l2);
        lineSecond.addStation(st2l2);
        lineSecond.addStation(st3l2);

        stationIndex.addStation(st1l1);
        stationIndex.addStation(st2l1);
        stationIndex.addStation(st3l1);
        stationIndex.addStation(st1l2);
        stationIndex.addStation(st2l2);
        stationIndex.addStation(st3l2);

        List<Station> connection1to2 = new ArrayList<>();
        connection1to2.add(st2l1);
        connection1to2.add(st2l2);
        stationIndex.addConnection(connection1to2);
        routeCalculator = new RouteCalculator(stationIndex);



    }


    public void testCalculateDuration() {

        ArrayList<Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("L1-ST-3"));
        route.add(stationIndex.getStation("L2-ST-1"));
        route.add(stationIndex.getStation("L2-ST-2"));
        double expected = 8.5;
        double actual = RouteCalculator.calculateDuration(route);
        assertEquals(expected, actual);

    }

    public void testGetShortestRoute() {
        ArrayList<Station> route = new ArrayList<>(){{
            add(stationIndex.getStation("L1-ST-3"));
            add(stationIndex.getStation("L2-ST-2"));
            add(stationIndex.getStation("L2-ST-3"));
        }};

        List<Station> expected = route.subList(0, route.size() );
        List<Station> actual = routeCalculator.getShortestRoute(route.get(0),route.get(route.size() - 1) );
        assertEquals(expected,actual);
    }
}

