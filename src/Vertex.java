import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private T data;
    private ArrayList<Edge> edges;

    public Vertex(T data) {
        this.data = data;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Vertex<T> toVertex, int weigth) {
        edges.add(new Edge(this, toVertex, weigth));
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
