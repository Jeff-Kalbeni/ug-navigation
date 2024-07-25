
# Floyd-Warshall Algorithm in Java

## Overview

This project implements the Floyd-Warshall algorithm in Java to find the shortest paths between all pairs of nodes in a weighted graph. The Floyd-Warshall algorithm is a dynamic programming technique that efficiently calculates the shortest paths in a graph with positive or negative edge weights, but without negative cycles.

## Features

- Computes shortest paths between all pairs of nodes.
- Handles graphs with positive and negative weights (no negative cycles).
- Displays the shortest distance matrix for the input graph.

## Graph Representation

The graph is represented using a 2D array (adjacency matrix), where each element `graph[i][j]` represents the weight of the edge from node `i` to node `j`. If there is no direct edge between two nodes, a large constant (e.g., `INF`) is used to denote no connection.

### Example Graph

Consider a graph with the following nodes and edges:

- **Nodes (Vertices):** Library, Science Building, Administration Office, Dormitory, Cafeteria
- **Edges:**
  - Library to Science Building with weight 5
  - Library to Dormitory with weight 2
  - Science Building to Administration Office with weight 3
  - Administration Office to Dormitory with weight 1
  - Dormitory to Cafeteria with weight 6


### Prerequisites

- Java Development Kit (JDK) 8 or higher installed on your system.

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/doreen09/ug-navigation.git
   cd floyd-warshall-java
   ```

2. **Compile the Java Program:**

   Ensure that your Java file is named `FloydWarshall.java`.

   ```bash
   javac FloydWarshall.java
   ```

3. **Run the Program:**

   ```bash
   java FloydWarshall
   ```

## How It Works

1. **Initialization:**
   - The distance matrix is initialized with the same values as the graph matrix. If there's no edge between two nodes, the distance is set to a large number (`INF`).

2. **Algorithm Execution:**
   - The algorithm iteratively updates the shortest paths between nodes by considering each node as an intermediate vertex.

3. **Result:**
   - The shortest distance matrix is printed, showing the minimum distances between all pairs of nodes.

### Code Explanation

Here's a brief overview of the key parts of the code:

```java
// Number of vertices in the graph
final static int INF = 99999; // A large number to denote no connection

// Floyd-Warshall algorithm implementation
void floydWarshall(int graph[][]) {
    int numVertices = graph.length;
    int[][] dist = new int[numVertices][numVertices];

    // Initialize the distance array
    for (int i = 0; i < numVertices; i++) {
        for (int j = 0; j < numVertices; j++) {
            dist[i][j] = graph[i][j];
        }
    }

    // Update distances
    for (int k = 0; k < numVertices; k++) {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    // Print the shortest distance matrix
    printSolution(dist);
}
```

### Output

The program outputs the shortest distances between every pair of nodes. If there is no path between two nodes, it prints `INF`.

```plaintext
Shortest distances between every pair of vertices:
0   3   7   5   
2   0   6   4   
3   1   0   5   
5   3   2   0   
```




