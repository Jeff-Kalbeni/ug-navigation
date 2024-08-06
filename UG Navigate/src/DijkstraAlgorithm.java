import java.util.*;

class DijkstraAlgorithm {
    private final Graph graph;

    public DijkstraAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public List<String> findShortestPath(String start, String goal) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        PriorityQueue<String> nodes = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String location : graph.getLocations()) {
            if (location.equals(start)) {
                distances.put(location, 0);
            } else {
                distances.put(location, Integer.MAX_VALUE);
            }
            nodes.add(location);
        }

        while (!nodes.isEmpty()) {
            String closestNode = nodes.poll();

            if (closestNode.equals(goal)) {
                List<String> path = new ArrayList<>();
                while (previousNodes.containsKey(closestNode)) {
                    path.add(closestNode);
                    closestNode = previousNodes.get(closestNode);
                }
                path.add(start);
                Collections.reverse(path);
                return path;
            }

            if (distances.get(closestNode) == Integer.MAX_VALUE) {
                break;
            }

            List<Edge> edges = graph.getEdges(closestNode);
            if (edges != null) {
                for (Edge edge : edges) {
                    int alt = distances.get(closestNode) + edge.weight;
                    if (alt < distances.get(edge.end)) {
                        distances.put(edge.end, alt);
                        previousNodes.put(edge.end, closestNode);
                        nodes.add(edge.end);
                    }
                }
            }
        }
        return Collections.emptyList();
    }
}
