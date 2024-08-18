// public class SortingRoutes {
//     public void sortRoutes(Route[] routes) {
//         Arrays.sort(routes, new Comparator<Route>() {
//             @Override
//             public int compare(Route r1, Route r2) {
//                 return Integer.compare(r1.distance, r2.distance);
//             }
//         });
//     }
// }

public class Sortingroute {

    public void sortRoutes(Route[] routes) {
        quickSort(routes, 0, routes.length - 1);
    }

    private void quickSort(Route[] routes, int low, int high) {
        if (low < high) {
            int pi = partition(routes, low, high);
            quickSort(routes, low, pi - 1);
            quickSort(routes, pi + 1, high);
        }
    }

    private int partition(Route[] routes, int low, int high) {
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