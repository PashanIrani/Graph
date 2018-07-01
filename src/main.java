public class main {
    public static void main(String[] args) {
        Graph<Character> g1 = new Graph<>();
        g1.addEdge('A', 'B', 4);
        g1.addEdge('A', 'C', 2);
        g1.addEdge('B', 'E', 1);
        System.out.println(g1);
    }
}
