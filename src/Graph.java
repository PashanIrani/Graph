import java.util.HashMap;
import java.util.Map;

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
    }

    private boolean containsVertex(T v){
        return vertexMap.containsKey(v);
    }

    private Vertex getVertex(T v) {
        return vertexMap.get(v);
    }

    @Override
    public String toString() {
        String s = "";

        for (T k : vertexMap.keySet()) {
            s += k + ", ";
        }

        return s;
    }
}
