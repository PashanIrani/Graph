import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private T data;
    private List<Edge> edges;

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
}
