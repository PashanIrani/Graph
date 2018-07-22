import java.util.Comparator;

/**
 * Used to sort edges from largest weight to least weight.
 */
public class EdgeWeightComparator implements Comparator<Edge>{

    @Override
    public int compare(Edge o1, Edge o2) {
        return o2.getWeigth() - o1.getWeigth();
    }
}
