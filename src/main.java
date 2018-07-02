public class main {
    public static void main(String[] args) {
        Graph<Character> g1 = new Graph<>();
        g1.addEdge('A', 'B');
        g1.addEdge('B', 'E');
        g1.addEdge('B', 'Y');
        g1.addEdge('A', 'C');
        g1.addEdge('C', 'Y');
        g1.addEdge('Y', 'Z');
        g1.addEdge('Y', 'X');
        g1.addEdge('X', 'H');
        g1.addEdge('C', 'D');
        System.out.println(g1);

        g1.runDFS('A');
    }
}
