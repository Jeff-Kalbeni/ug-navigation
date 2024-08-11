public class FloydWarshall {

    // Number of vertices in the graph
    final static int INF = 99999; // A large number to denote no connection

    // Implementing the Floyd-Warshall algorithm
    void floydWarshall(int graph[][]) {
        int numVertices = graph.length;
        int[][] dist = new int[numVertices][numVertices];

        // Initialize the distance array same as input graph matrix
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Update the distance array
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    // Update dist[i][j] only if vertex k is on the shortest path
                    // from i to j
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    // Utility function to print the solution
    void printSolution(int dist[][]) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a graph as a 2D array
        int graph[][] = {
                { 0, 3, INF, 5 },
                { 2, 0, INF, 4 },
                { INF, 1, 0, INF },
                { INF, INF, 2, 0 }
        };

        FloydWarshall a = new FloydWarshall();
        a.floydWarshall(graph);
    }
}
