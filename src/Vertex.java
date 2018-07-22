import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Vertex<T> {

    private T data;
    private ArrayList<Edge> edges;
    private HashSet<T> connectedVertices;

    public Vertex(T data) {
        this.data = data;
        this.edges = new ArrayList<>();
        this.connectedVertices = new HashSet<>();
    }

    public boolean addEdge(Vertex<T> toVertex, int weigth) {
        if (toVertex == null) return false;

        if (connectedVertices.contains(toVertex.getData())) return false;

        edges.add(new Edge(this, toVertex, weigth));
        connectedVertices.add(toVertex.getData());
        return true;

    }

    public T getData() {
        return data;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        String s = "";
        ArrayList<Edge> edges = this.getEdges();

        for (Edge e : edges) {
            s += e + ", ";
        }

        if (edges.size() == 0) {
            s = "none";
        }
        return data + ": " + s;
    }
}
