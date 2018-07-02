import java.util.*;

public class Graph<T> {

    private Map<T, Vertex<T>> vertexMap;

    public Graph() {
        vertexMap = new HashMap<>();
    }

    public boolean addVertex(T vertex) {
        if (containsVertex(vertex)) {
            return false;
        }

        vertexMap.put(vertex, new Vertex<>(vertex));
        return true;
    }

    public void addEdge(T v1, T v2) {
        addEdge(v1, v2, 0);
    }

    public void addEdge(T v1, T v2, int w) {
        Vertex<T> from;
        Vertex<T> to;

        //checks if vertex is already existing
        if (containsVertex(v1)) {
            from = getVertex(v1);
        } else {
            from = new Vertex<>(v1);
            addVertex(from.getData());
        }

        //checks if vertex is already existing
        if (containsVertex(v2)) {
            to = getVertex(v1);
        } else {
            to = new Vertex<>(v2);
            addVertex(to.getData());
        }

        from.addEdge(to, w);
        vertexMap.put(from.getData(), from);
    }

    private boolean containsVertex(T v) {
        return vertexMap.containsKey(v);
    }

    private Vertex getVertex(T v) {
        return vertexMap.get(v);
    }

    public void runDFS(T start) {
        HashSet<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        runDFS(start, visited);

    }

    private void runDFS(T currentNode, HashSet visited) {

        visited.add(currentNode);

        List<Edge> edges = getVertex(currentNode).getEdges();
        
        //loop through and visit unvisited neighbours
        for (Edge e : edges) {
            T data = (T) e.toVertex().getData();

            if (!visited.contains(data)) {
                runDFS(data, visited);
            }
        }
    }

    @Override
    public String toString() {
        String s = "";

        for (T k : vertexMap.keySet()) {
            s += getVertex(k) + "\n";

        }

        return s;
    }
}
