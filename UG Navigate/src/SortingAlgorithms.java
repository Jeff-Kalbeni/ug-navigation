public class SortingAlgorithms {
    public static void quickSort(Route[] routes, int low, int high) {
        if (low < high) {
            int pi = partition(routes, low, high);
            quickSort(routes, low, pi - 1);
            quickSort(routes, pi + 1, high);
        }
    }

    private static int partition(Route[] routes, int low, int high) {
        Route pivot = routes[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (routes[j].distance < pivot.distance) {
                i++;
                Route temp = routes[i];
                routes[i] = routes[j];
                routes[j] = temp;
            }
        }
        Route temp = routes[i + 1];
        routes[i + 1] = routes[high];
        routes[high] = temp;
        return i + 1;
    }
}
