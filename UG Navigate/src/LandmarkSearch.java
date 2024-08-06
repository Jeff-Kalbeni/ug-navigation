import java.util.*;

class LandmarkSearch {
    private final Graph graph;

    public LandmarkSearch(Graph graph) {
        this.graph = graph;
    }

    public List<String> findShortestPathThroughLandmark(String start, String goal, String landmark) {
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

        // Path from start to landmark
        List<String> startToLandmark = dijkstra.findShortestPath(start, landmark);
        // Path from landmark to goal
        List<String> landmarkToGoal = dijkstra.findShortestPath(landmark, goal);

        if (startToLandmark.isEmpty() || landmarkToGoal.isEmpty()) {
            return Collections.emptyList();
        }

        // Combine the two paths, avoiding duplicate landmark
        startToLandmark.remove(startToLandmark.size() - 1);
        startToLandmark.addAll(landmarkToGoal);
        return startToLandmark;
    }
}
