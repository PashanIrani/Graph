import java.util.*;

/**
 * A graph data structure
 *
 * @param <T> Data type of object being sorted in this graph
 */
public class Graph<T> {
    static final int DEFAULT_EDGE_WEIGHT = 0;

    // keeps track of vertexes added to the to the graph
    private Map<T, Vertex<T>> vertexMap;

    public Graph() {
        vertexMap = new HashMap<>();
    }

    /**
     * Adds vertex to the graph
     *
     * @param vertex
     * @return succes or failure of adding vertex
     */
    public boolean addVertex(T vertex) {
        if (containsVertex(vertex)) {
            return false;
        }

        vertexMap.put(vertex, new Vertex<>(vertex));
        return true;
    }

    /* adds edge */

    /**
     * Adds edge
     * @param fromVertex from vertex
     * @param toVertex to vertex
     */
    public void addEdge(T fromVertex, T toVertex) {
        addEdge(fromVertex, toVertex, DEFAULT_EDGE_WEIGHT);
    }

    /**
     * Adds edge between two nodes, and also sets weight
     * @param fromVertex from vertex
     * @param toVertex to vertex
     * @param weight weight of the edge
     */
    public void addEdge(T fromVertex, T toVertex, int weight) {
        Vertex<T> from;
        Vertex<T> to;

        //checks if vertex is already existing
        if (containsVertex(fromVertex)) {
            from = getVertex(fromVertex);
        } else {
            from = new Vertex<>(fromVertex);
            addVertex(from.getData());
        }

        //checks if vertex is already existing
        if (containsVertex(toVertex)) {
            to = getVertex(toVertex);
        } else {
            to = new Vertex<>(toVertex);
            addVertex(to.getData());
        }

        from.addEdge(to, weight);
        vertexMap.put(from.getData(), from); //update stored record
    }

    /**
     * Checks if vertex exists in graph
     * @param vertex
     * @return result of if vertex is in the graph
     */
    public boolean containsVertex(T vertex) {
        return vertexMap.containsKey(vertex);
    }

    /**
     * Gets the vertex object from this graph
     * @param vertex
     * @return the vertex object
     */
    public Vertex getVertex(T vertex) {
        return vertexMap.get(vertex);
    }

    private boolean runDFS(T start, Comparator<? super Edge> comp, T searchForNode) {
        HashSet<T> visited = new HashSet<>();

        return runDFS(start, comp, searchForNode, visited);
    }

    private boolean runDFS(T currentNode, Comparator<? super Edge> comp, T searchForNode, HashSet visited) {

        visited.add(currentNode);

        List<Edge> edges = getVertex(currentNode).getEdges();

        if (comp != null) {
            Collections.sort(edges, comp);
        }

        //loop through and visit unvisited neighbours
        for (Edge e : edges) {
            T data = (T) e.toVertex().getData();

            if (searchForNode != null && data.equals(searchForNode)) return true;

            if (!visited.contains(data)) {
                if (runDFS(data, comp, searchForNode, visited)) return true;
            }
        }

        return false;
    }

    public boolean routeBetween(T a, T b) {
        return runDFS(a, null, b);
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
