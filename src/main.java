public class main {
    public static void main(String[] args) {
        Graph<Character> g1 = new Graph<>();
        g1.addEdge('A', 'B');
        g1.addEdge('B', 'C',1);
        g1.addEdge('B', 'E', 2);
        g1.addEdge('B', 'C',0); // this won't be added
        g1.addEdge('C', 'A');
        System.out.println(g1);

        g1.visitAll('A');
    }
}
