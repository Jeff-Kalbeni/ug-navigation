import java.util.*;

class Graph {
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addLocation(String location) {
        adjacencyList.putIfAbsent(location, new ArrayList<>());
        System.out.println("Location added: " + location);
    }

    public void addEdge(String start, String end, int weight) {
        addLocation(start); // Ensure the location exists
        addLocation(end); // Ensure the location exists

        adjacencyList.get(start).add(new Edge(start, end, weight));
        adjacencyList.get(end).add(new Edge(end, start, weight)); // Assuming it's an undirected graph
        System.out.println("Edge added: " + start + " <-> " + end + " with weight " + weight);
    }

    public List<Edge> getEdges(String location) {
        return adjacencyList.get(location);
    }

    public int getEdgeWeight(String start, String end) {
        List<Edge> edges = adjacencyList.get(start);
        if (edges != null) {
            for (Edge edge : edges) {
                if (edge.end.equals(end)) {
                    return edge.weight;
                }
            }
        }
        throw new IllegalArgumentException("Edge not found between " + start + " and " + end);
    }

    public Set<String> getLocations() {
        return adjacencyList.keySet();
    }
}

class Edge {
    public final String start;
    public final String end;
    public final int weight;

    public Edge(String start, String end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
