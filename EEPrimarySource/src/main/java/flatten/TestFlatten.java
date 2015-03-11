package flatten;

/**
 * Created by pankaj on 3/11/15.
 */
public class TestFlatten {
    public static void main(String[] args) {
        Tree.Leaf<Integer> firstNode=new Tree.Leaf(1);
        Tree.Leaf<Integer> secondNode=new Tree.Leaf<>(6);

        Triple<Tree.Leaf<Integer>> triple=new Triple<>(firstNode,secondNode,secondNode);

    }
}
