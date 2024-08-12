/*import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph campusMap = new Graph();

        String[] locations = {
                "Main Gate", "JQB", "K.A. Busiah", "Bush Canteen", "FCOS Building",
                "UG School of Law", "Pent Hall", "Evandy Hostel", "Bani Hall",
                "James Top Yankah Nelson", "24 Hour Reading Room",
                "Korean Lab, Balme Library", "Balme Library", "IAC",
                "Communication Studies Lab", "UGBS, Main Campus", "UGCS",
                "Cedi Conference Center", "N Block", "Political Science Department",
                "Forson Building", "Information Studies Lab",
                "Ghana Commercial Bank Building, GCB", "New N'Block",
                "Central Cafeteria (CC)", "Night Market", "Geography department",
                "Institute of African studies", "Akuafo Hall", "Legon Hall",
                "Mensah Sarbah Hall", "Kingdom Bookshop", "Economics department",
                "Volta Hall", "Vikings Hostel", "Computer Science Department",
                "Department of Mathematics", "Department of Physics",
                "Department of Chemistry", "Athletic Oval", "School of Pharmacy",
                "LOT", "Department of Biochemistry",
                "Department of Actuarial Science and Statistics", "School of Nursing",
                "Commonwealth Hall", "Language Centre",
                "University of Ghana Careers and Counselling Center",
                "Alexander Kwapong Hall", "Jubilee Hall", "Limann Hall",
                "Elisabeth Sey Hall", "Great Hall"
        };
        for (String location : locations) {
            campusMap.addLocation(location);
        }


        campusMap.addEdge("Main Gate", "JQB", 400);
        campusMap.addEdge("Main Gate", "Bush Canteen", 500);
        campusMap.addEdge("JQB", "K.A. Busiah", 200);
        campusMap.addEdge("JQB", "Bush Canteen", 600);
        campusMap.addEdge("K.A. Busiah", "Bush Canteen", 100);
        campusMap.addEdge("Bush Canteen", "FCOS Building", 300);
        campusMap.addEdge("Main Gate", "FCOS Building", 500);
        campusMap.addEdge("Main Gate", "UG School of Law", 700);
        campusMap.addEdge("Main Gate", "Pent Hall", 800);
        campusMap.addEdge("Main Gate", "Evandy Hostel", 1300);
        campusMap.addEdge("Main Gate", "Bani Hall", 1400);
        campusMap.addEdge("Main Gate", "James Top Yankah Nelson", 1600);
        campusMap.addEdge("Main Gate", "24 Hour Reading Room", 800);
        campusMap.addEdge("Main Gate", "Korean Lab, Balme Library", 800);
        campusMap.addEdge("Main Gate", "Balme Library", 800);
        campusMap.addEdge("Main Gate", "IAC", 800);
        campusMap.addEdge("Main Gate", "Communication Studies Lab", 1000);
        campusMap.addEdge("Main Gate", "UGBS, Main Campus", 900);
        campusMap.addEdge("Main Gate", "UGCS", 900);
        campusMap.addEdge("Main Gate", "Cedi Conference Center", 900);
        campusMap.addEdge("Main Gate", "N Block", 1100);
        campusMap.addEdge("Main Gate", "Political Science Department", 1100);
        campusMap.addEdge("Main Gate", "Forson Building", 1100);
        campusMap.addEdge("Main Gate", "Information Studies Lab", 1100);
        campusMap.addEdge("Main Gate", "Ghana Commercial Bank Building, GCB", 1200);
        campusMap.addEdge("Main Gate", "New N'Block", 1300);
        campusMap.addEdge("Main Gate", "Central Cafeteria (CC)", 1400);
        campusMap.addEdge("Main Gate", "Night Market", 1500);
        campusMap.addEdge("Main Gate", "Geography department", 400);
        campusMap.addEdge("Main Gate", "Institute of African studies", 100);
        campusMap.addEdge("Main Gate", "Akuafo Hall", 500);
        campusMap.addEdge("Main Gate", "Legon Hall", 900);
        campusMap.addEdge("Main Gate", "Mensah Sarbah Hall", 1100);
        campusMap.addEdge("Main Gate", "Kingdom Bookshop", 800);
        campusMap.addEdge("Main Gate", "Economics department", 800);
        campusMap.addEdge("Main Gate", "Volta Hall", 1000);
        campusMap.addEdge("Main Gate", "Vikings Hostel", 900);
        campusMap.addEdge("Main Gate", "Computer Science Department", 900);
        campusMap.addEdge("Main Gate", "Department of Mathematics", 1000);
        campusMap.addEdge("Main Gate", "Department of Physics", 800);
        campusMap.addEdge("Main Gate", "Department of Chemistry", 900);
        campusMap.addEdge("Main Gate", "Athletic Oval", 1100);
        campusMap.addEdge("Main Gate", "School of Pharmacy", 1100);
        campusMap.addEdge("Main Gate", "LOT", 1100);
        campusMap.addEdge("Main Gate", "Department of Biochemistry", 1100);
        campusMap.addEdge("Main Gate", "Department of Actuarial Science and Statistics", 1100);
        campusMap.addEdge("Main Gate", "School of Nursing", 1000);
        campusMap.addEdge("Main Gate", "Commonwealth Hall", 1200);
        campusMap.addEdge("Main Gate", "Language Centre", 800);
        campusMap.addEdge("Main Gate", "University of Ghana Careers and Counselling Center", 800);
        campusMap.addEdge("Main Gate", "Alexander Kwapong Hall", 1100);
        campusMap.addEdge("Main Gate", "Jubilee Hall", 1100);
        campusMap.addEdge("Main Gate", "Limann Hall", 1100);
        campusMap.addEdge("Main Gate", "Elisabeth Sey Hall", 1100);
        campusMap.addEdge("Main Gate", "Great Hall", 1000);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("--- University of Ghana Campus Route Finder ---");
                System.out.println("1. Find Shortest Path");
                System.out.println("2. Find Shortest Path Through Landmark");
                System.out.println("3. Sort Routes by Distance");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter start location: ");
                        String start = scanner.nextLine().trim();
                        System.out.print("Enter destination: ");
                        String goal = scanner.nextLine().trim();
                        findShortestPath(campusMap, start, goal);
                        break;

                    case 2:
                        System.out.print("Enter start location: ");
                        String landmarkStart = scanner.nextLine().trim();
                        System.out.print("Enter destination: ");
                        String landmarkGoal = scanner.nextLine().trim();
                        System.out.print("Enter landmark: ");
                        String landmark = scanner.nextLine().trim();
                        findShortestPathThroughLandmark(campusMap, landmarkStart, landmarkGoal, landmark);
                        break;

                    case 3:

                        Route[] routes = {
                                new Route("Main Gate", "Bush Canteen", 10),
                                new Route("Main Gate", "K.A. Busiah", 5),
                                new Route("Main Gate", "JQB", 3)
                        };
                        SortingAlgorithms.quickSort(routes, 0, routes.length - 1);
                        System.out.println("Sorted routes by distance:");
                        for (Route route : routes) {
                            System.out.println(route);
                        }





                        /*Route[] routes = {
                                new Route("Main Gate", "Bush Canteen", 10),
                                new Route("Main Gate", "K.A. Busiah", 5),
                                new Route("Main Gate", "JQB", 3)
                        };
                        SortingAlgorithms.quickSort(routes, 0, routes.length - 1);
                        System.out.println("Sorted routes by distance:");
                        for (Route route : routes) {
                            System.out.println(route);
                        }
                        break;

                    case 4:
                        exit = true;
                        System.out.println("Exiting the application. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        scanner.close();
    }

    private static void findShortestPath(Graph graph, String start, String goal) {
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        List<String> path = dijkstra.findShortestPath(start, goal);
        int distance = calculateTotalDistance(graph, path);
        System.out.println("Shortest path using Dijkstra: " + path + " with distance: " + distance + " meters.");
        displayArrivalTime(distance);

        AStarAlgorithm aStar = new AStarAlgorithm(graph);
        List<String> aStarPath = aStar.findShortestPath(start, goal);
        int aStarDistance = calculateTotalDistance(graph, aStarPath);
        System.out.println("Shortest path using A*: " + aStarPath + " with distance: " + aStarDistance + " meters.");
        displayArrivalTime(aStarDistance);
    }

    private static void findShortestPathThroughLandmark(Graph graph, String start, String goal, String landmark) {
        LandmarkSearch landmarkSearch = new LandmarkSearch(graph);
        List<String> path = landmarkSearch.findShortestPathThroughLandmark(start, goal, landmark);
        if (path.isEmpty()) {
            System.out.println("No path found through landmark '" + landmark + "'.");
        } else {
            int distance = calculateTotalDistance(graph, path);
            System.out.println("Shortest path through landmark '" + landmark + "': " + path + " with distance: " + distance + " meters.");
            displayArrivalTime(distance);
        }
    }

    private static int calculateTotalDistance(Graph graph, List<String> path) {
        int totalDistance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String start = path.get(i);
            String end = path.get(i + 1);
            totalDistance += graph.getEdgeWeight(start, end);
        }
        return totalDistance;
    }

    private static void displayArrivalTime(int distance) {
        double walkingSpeed = 1.39; // meters per second
        int arrivalTimeInSeconds = (int) (distance / walkingSpeed);
        int minutes = arrivalTimeInSeconds / 60;
        int seconds = arrivalTimeInSeconds % 60;
        System.out.println("Estimated arrival time: " + minutes + " minutes " + seconds + " seconds.");
    }
}*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph campusMap = new Graph();

        String[] locations = {
                "Main Gate", "JQB", "K.A. Busiah", "Bush Canteen", "FCOS Building",
                "UG School of Law", "Pent Hall", "Evandy Hostel", "Bani Hall",
                "James Top Yankah Nelson", "24 Hour Reading Room",
                "Korean Lab, Balme Library", "Balme Library", "IAC",
                "Communication Studies Lab", "UGBS, Main Campus", "UGCS",
                "Cedi Conference Center", "N Block", "Political Science Department",
                "Forson Building", "Information Studies Lab",
                "Ghana Commercial Bank Building, GCB", "New N'Block",
                "Central Cafeteria (CC)", "Night Market", "Geography department",
                "Institute of African studies", "Akuafo Hall", "Legon Hall",
                "Mensah Sarbah Hall", "Kingdom Bookshop", "Economics department",
                "Volta Hall", "Vikings Hostel", "Computer Science Department",
                "Department of Mathematics", "Department of Physics",
                "Department of Chemistry", "Athletic Oval", "School of Pharmacy",
                "LOT", "Department of Biochemistry",
                "Department of Actuarial Science and Statistics", "School of Nursing",
                "Commonwealth Hall", "Language Centre",
                "University of Ghana Careers and Counselling Center",
                "Alexander Kwapong Hall", "Jubilee Hall", "Limann Hall",
                "Elisabeth Sey Hall", "Great Hall"
        };
        for (String location : locations) {
            campusMap.addLocation(location);
        }


        campusMap.addEdge("Main Gate", "JQB", 400);
        campusMap.addEdge("Main Gate", "Bush Canteen", 500);
        campusMap.addEdge("JQB", "K.A. Busiah", 200);
        campusMap.addEdge("JQB", "Bush Canteen", 600);
        campusMap.addEdge("K.A. Busiah", "Bush Canteen", 100);
        campusMap.addEdge("Bush Canteen", "FCOS Building", 300);
        campusMap.addEdge("Main Gate", "FCOS Building", 500);
        campusMap.addEdge("Main Gate", "UG School of Law", 700);
        campusMap.addEdge("Main Gate", "Pent Hall", 800);
        campusMap.addEdge("Main Gate", "Evandy Hostel", 1300);
        campusMap.addEdge("Main Gate", "Bani Hall", 1400);
        campusMap.addEdge("Main Gate", "James Top Yankah Nelson", 1600);
        campusMap.addEdge("Main Gate", "24 Hour Reading Room", 800);
        campusMap.addEdge("Main Gate", "Korean Lab, Balme Library", 800);
        campusMap.addEdge("Main Gate", "Balme Library", 800);
        campusMap.addEdge("Main Gate", "IAC", 800);
        campusMap.addEdge("Main Gate", "Communication Studies Lab", 1000);
        campusMap.addEdge("Main Gate", "UGBS, Main Campus", 900);
        campusMap.addEdge("Main Gate", "UGCS", 900);
        campusMap.addEdge("Main Gate", "Cedi Conference Center", 900);
        campusMap.addEdge("Main Gate", "N Block", 1100);
        campusMap.addEdge("Main Gate", "Political Science Department", 1100);
        campusMap.addEdge("Main Gate", "Forson Building", 1100);
        campusMap.addEdge("Main Gate", "Information Studies Lab", 1100);
        campusMap.addEdge("Main Gate", "Ghana Commercial Bank Building, GCB", 1200);
        campusMap.addEdge("Main Gate", "New N'Block", 1300);
        campusMap.addEdge("Main Gate", "Central Cafeteria (CC)", 1400);
        campusMap.addEdge("Main Gate", "Night Market", 1500);
        campusMap.addEdge("Main Gate", "Geography department", 400);
        campusMap.addEdge("Main Gate", "Institute of African studies", 100);
        campusMap.addEdge("Main Gate", "Akuafo Hall", 500);
        campusMap.addEdge("Main Gate", "Legon Hall", 900);
        campusMap.addEdge("Main Gate", "Mensah Sarbah Hall", 1100);
        campusMap.addEdge("Main Gate", "Kingdom Bookshop", 800);
        campusMap.addEdge("Main Gate", "Economics department", 800);
        campusMap.addEdge("Main Gate", "Volta Hall", 1000);
        campusMap.addEdge("Main Gate", "Vikings Hostel", 900);
        campusMap.addEdge("Main Gate", "Computer Science Department", 900);
        campusMap.addEdge("Main Gate", "Department of Mathematics", 1000);
        campusMap.addEdge("Main Gate", "Department of Physics", 800);
        campusMap.addEdge("Main Gate", "Department of Chemistry", 900);
        campusMap.addEdge("Main Gate", "Athletic Oval", 1100);
        campusMap.addEdge("Main Gate", "School of Pharmacy", 1100);
        campusMap.addEdge("Main Gate", "LOT", 1100);
        campusMap.addEdge("Main Gate", "Department of Biochemistry", 1100);
        campusMap.addEdge("Main Gate", "Department of Actuarial Science and Statistics", 1100);
        campusMap.addEdge("Main Gate", "School of Nursing", 1000);
        campusMap.addEdge("Main Gate", "Commonwealth Hall", 1200);
        campusMap.addEdge("Main Gate", "Language Centre", 800);
        campusMap.addEdge("Main Gate", "University of Ghana Careers and Counselling Center", 800);
        campusMap.addEdge("Main Gate", "Alexander Kwapong Hall", 1100);
        campusMap.addEdge("Main Gate", "Jubilee Hall", 1100);
        campusMap.addEdge("Main Gate", "Limann Hall", 1100);
        campusMap.addEdge("Main Gate", "Elisabeth Sey Hall", 1100);
        campusMap.addEdge("Main Gate", "Great Hall", 1000);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("--- University of Ghana Campus Route Finder ---");
                System.out.println("Here are the available locations on campus" + Arrays.toString(locations));
                System.out.println("1. Find Shortest Path");
                System.out.println("2. Find Shortest Path Through Landmark");
                System.out.println("3. Sort Routes by Distance");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter start location: ");
                        String start = scanner.nextLine().trim();
                        System.out.print("Enter destination: ");
                        String goal = scanner.nextLine().trim();
                        findShortestPath(campusMap, start, goal);
                        break;

                    case 2:
                        System.out.print("Enter start location: ");
                        String landmarkStart = scanner.nextLine().trim();
                        System.out.print("Enter destination: ");
                        String landmarkGoal = scanner.nextLine().trim();
                        System.out.print("Enter landmark: ");
                        String landmark = scanner.nextLine().trim();
                        findShortestPathThroughLandmark(campusMap, landmarkStart, landmarkGoal, landmark);
                        break;

                    case 3:
                        List<Route> userRoutes = new ArrayList<>();
                        boolean addMoreRoutes = true;
                        while (addMoreRoutes) {
                            System.out.print("Enter start location: ");
                            String userStart = scanner.nextLine().trim();
                            System.out.print("Enter destination: ");
                            String userEnd = scanner.nextLine().trim();
                            System.out.print("Enter distance: ");
                            int userDistance = Integer.parseInt(scanner.nextLine().trim());
                            userRoutes.add(new Route(userStart, userEnd, userDistance));

                            System.out.print("Add another route? (yes/no): ");
                            String addMore = scanner.nextLine().trim().toLowerCase();
                            addMoreRoutes = addMore.equals("yes");
                        }

                        Route[] routesArray = userRoutes.toArray(new Route[0]);
                        SortingAlgorithms.quickSort(routesArray, 0, routesArray.length - 1);
                        System.out.println("Sorted routes by distance:");
                        for (Route route : routesArray) {
                            System.out.println(route);
                        }

                        // Using SortingRoutes (based on Arrays.sort with Comparator)
                        Sortingroute sortingRoutes = new Sortingroute();
                        sortingRoutes.sortRoutes(routesArray);
                        System.out.println("\nRoutes sorted by Arrays.sort:");
                        printRoutes(routesArray);

                        break;


                    case 4:
                        exit = true;
                        System.out.println("Exiting the application. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        scanner.close();
    }

    private static void findShortestPath(Graph graph, String start, String goal) {
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        List<String> path = dijkstra.findShortestPath(start, goal);
        int distance = calculateTotalDistance(graph, path);
        System.out.println("Shortest path using Dijkstra: " + path + " with distance: " + distance + " meters.");
        displayArrivalTime(distance);

        AStarAlgorithm aStar = new AStarAlgorithm(graph);
        List<String> aStarPath = aStar.findShortestPath(start, goal);
        int aStarDistance = calculateTotalDistance(graph, aStarPath);
        System.out.println("Shortest path using A*: " + aStarPath + " with distance: " + aStarDistance + " meters.");
        displayArrivalTime(aStarDistance);
    }

    private static void findShortestPathThroughLandmark(Graph graph, String start, String goal, String landmark) {
        LandmarkSearch landmarkSearch = new LandmarkSearch(graph);
        List<String> path = landmarkSearch.findShortestPathThroughLandmark(start, goal, landmark);
        if (path.isEmpty()) {
            System.out.println("No path found through landmark '" + landmark + "'.");
        } else {
            int distance = calculateTotalDistance(graph, path);
            System.out.println("Shortest path through landmark '" + landmark + "': " + path + " with distance: " + distance + " meters.");
            displayArrivalTime(distance);
        }
    }

    private static int calculateTotalDistance(Graph graph, List<String> path) {
        int totalDistance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String start = path.get(i);
            String end = path.get(i + 1);
            totalDistance += graph.getEdgeWeight(start, end);
        }
        return totalDistance;
    }

    private static void displayArrivalTime(int distance) {
        double walkingSpeed = 1.39; // meters per second
        int arrivalTimeInSeconds = (int) (distance / walkingSpeed);
        int minutes = arrivalTimeInSeconds / 60;
        int seconds = arrivalTimeInSeconds % 60;
        System.out.println("Estimated arrival time: " + minutes + " minutes " + seconds + " seconds.");
    }
    private static void printRoutes(Route[] routes) {
        for (Route route : routes) {
            System.out.println(route);
        }
    }



}
