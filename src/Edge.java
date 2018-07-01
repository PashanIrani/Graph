public class Edge<T> {

    private int weigth;
    private Vertex<T> fromVertex;
    private Vertex<T> toVertex;

    public Edge(Vertex<T> v1, Vertex<T> v2, int weigth) {
        this.fromVertex = v1;
        this.toVertex = v2;
        this.weigth = weigth;
    }

    public int getWeigth() {
        return weigth;
    }


    public Vertex<T> fromVertex() {
        return fromVertex;
    }


    public Vertex<T> toVertex() {
        return toVertex;
    }

}
