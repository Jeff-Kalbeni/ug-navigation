import java.util.*;

class Node implements Comparable<Node> {
    String name;
    int x, y;
    List<Edge> adjacents;

    Node(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.adjacents = new ArrayList<>();
    }

    void addAdjacent(Node node, int weight) {
        adjacents.add(new Edge(node, weight));
    }

    @Override
    public int compareTo(Node other) {
        return 0; // Just to satisfy Comparable interface
    }
}

class Edge {
    Node node;
    int weight;

    Edge(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class AStarAlgorithm {

    private static double heuristic(Node node1, Node node2) {
        return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y); // Manhattan distance
    }

    public static List<Node> aStar(Node start, Node goal, Set<Node> allNodes) {
        Map<Node, Double> gScore = new HashMap<>();
        Map<Node, Double> fScore = new HashMap<>();

        for (Node node : allNodes) {
            gScore.put(node, Double.POSITIVE_INFINITY);
            fScore.put(node, Double.POSITIVE_INFINITY);
        }

        gScore.put(start, 0.0);
        fScore.put(start, heuristic(start, goal));

        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(fScore::get));
        openSet.add(start);

        Map<Node, Node> cameFrom = new HashMap<>();

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.equals(goal)) {
                List<Node> path = new ArrayList<>();
                while (current != null) {
                    path.add(current);
                    current = cameFrom.get(current);
                }
                Collections.reverse(path);
                return path;
            }

            for (Edge edge : current.adjacents) {
                Node neighbor = edge.node;
                double tentativeGScore = gScore.get(current) + edge.weight;

                if (tentativeGScore < gScore.get(neighbor)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, tentativeGScore + heuristic(neighbor, goal));
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many locations are there? ");
        int numberOfLocations = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Map<String, Node> nodes = new HashMap<>();

        for (int i = 0; i < numberOfLocations; i++) {
            System.out.println("Enter details for location " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the horizontal distance from the origin: ");
            int x = scanner.nextInt();
            System.out.print("Enter the vertical distance from the origin: ");
            int y = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            nodes.put(name, new Node(name, x, y));
        }

        System.out.println("\nNow, let's enter the paths between these locations.");

        System.out.print("How many paths are there? ");
        int numberOfEdges = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfEdges; i++) {
            System.out.println("Enter details for path " + (i + 1) + ":");
            System.out.print("Start location: ");
            String startName = scanner.nextLine();
            System.out.print("End location: ");
            String endName = scanner.nextLine();
            System.out.print("Distance: ");
            int weight = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Node startNode = nodes.get(startName);
            Node endNode = nodes.get(endName);

            if (startNode != null && endNode != null) {
                startNode.addAdjacent(endNode, weight);
            } else {
                System.out.println("Invalid start or end location. Please ensure the locations exist.");
                i--; // Retry this path entry
            }
        }

        System.out.println("\nAlmost done! Now, let's find the best route.");

        System.out.print("Enter the start location: ");
        String startName = scanner.nextLine();
        System.out.print("Enter the goal location: ");
        String goalName = scanner.nextLine();

        Node start = nodes.get(startName);
        Node goal = nodes.get(goalName);

        if (start != null && goal != null) {
            Set<Node> allNodes = new HashSet<>(nodes.values());
            List<Node> path = aStar(start, goal, allNodes);

            if (path != null) {
                System.out.println("\nBest route found:");
                for (Node node : path) {
                    System.out.print(node.name + " ");
                }
            } else {
                System.out.println("\nNo route found between the specified locations.");
            }
        } else {
            System.out.println("Invalid start or goal location.");
        }

        scanner.close();
    }
}
