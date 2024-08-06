import java.util.*;

public class AStarAlgorithm {
    private final Graph graph;

    public AStarAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public List<String> findShortestPath(String start, String goal) {
        Map<String, Integer> gScore = new HashMap<>();
        Map<String, Integer> fScore = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(node -> node.fScore));

        for (String location : graph.getLocations()) {
            gScore.put(location, Integer.MAX_VALUE);
            fScore.put(location, Integer.MAX_VALUE);
        }
        gScore.put(start, 0);
        fScore.put(start, heuristic(start, goal));
        openSet.add(new Node(start, fScore.get(start)));

        while (!openSet.isEmpty()) {
            Node currentNode = openSet.poll();
            if (currentNode.location.equals(goal)) {
                break;
            }

            for (Edge edge : graph.getEdges(currentNode.location)) {
                int tentativeGScore = gScore.get(currentNode.location) + edge.weight;
                if (tentativeGScore < gScore.get(edge.end)) {
                    previousNodes.put(edge.end, currentNode.location);
                    gScore.put(edge.end, tentativeGScore);
                    fScore.put(edge.end, tentativeGScore + heuristic(edge.end, goal));
                    openSet.add(new Node(edge.end, fScore.get(edge.end)));
                }
            }
        }

        List<String> path = new ArrayList<>();
        for (String at = goal; at != null; at = previousNodes.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    private int heuristic(String start, String goal) {
        // Simplified heuristic (Manhattan distance)
        return Math.abs(start.charAt(0) - goal.charAt(0));
    }

    private static class Node {
        public final String location;
        public final int fScore;

        public Node(String location, int fScore) {
            this.location = location;
            this.fScore = fScore;
        }
    }
}
