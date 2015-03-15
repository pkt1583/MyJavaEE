package flatten;

import java.util.List;

/**
 * Created by pankaj on 3/11/15.
 */
public class TestFlatten {
    public static void main(String[] args) {
        Tree tree = Tree.Node.tree(Tree.Node.tree(Tree.Node.tree(Tree.Leaf.leaf(1), Tree.Leaf.leaf(8),Tree.Leaf.leaf(9)), Tree.Leaf.leaf(7), Tree.Leaf.leaf(2)), Tree.Node.tree(Tree.Leaf.leaf(3), Tree.Leaf.leaf(6), Tree.Leaf.leaf(4)), Tree.Node.tree(Tree.Leaf.leaf(12),Tree.Leaf.leaf(11),Tree.Leaf.leaf(10)));

        TestFlatten testFlatten=new TestFlatten();
        System.out.println(testFlatten.flattenInOrder(tree));

        /*Triple root = (Triple) tree.get().ifRight(new Function<Triple, Triple>() {
            @Override
            public Triple apply(Triple o) {
                return o;
            }
        });

        System.out.println(root.get().isLeft());*/

    }

    public List flattenInOrder(Tree tree) {
        Either eitherLeftOrRight=tree.get();
        Triple triple=eitherLeftOrRight.ifRight(new Function<Triple,Triple>() {
            @Override
            public Triple apply(Triple o) {
                return o;
            }
        });
    Either either =triple.left().;


        if(eitherLeftOrRight.isLeft()){
            System.out.println(eitherLeftOrRight.ifLeft(new Function() {
                @Override
                public Object apply(Object o) {
                    return o;
                }
            }));
        }
        return null;
    }
}
