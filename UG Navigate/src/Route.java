import java.util.*;

class Route {
    public final String start;
    public final String end;
    public final int distance;

    public Route(String start, String end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", distance=" + distance +
                '}';
    }
}