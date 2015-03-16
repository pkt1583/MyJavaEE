package flatten;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestFlatten<T> implements FlattenTree<T>
{
    public static void main(String[] args) {
        Tree tree = Tree.Node.tree(Tree.Node.tree(Tree.Node.tree(Tree.Leaf.leaf(1), Tree.Leaf.leaf(8),Tree.Leaf.leaf(9)), Tree.Leaf.leaf(7), Tree.Leaf.leaf(2)), Tree.Node.tree(Tree.Leaf.leaf(3), Tree.Leaf.leaf(6), Tree.Leaf.leaf(4)), Tree.Node.tree(Tree.Leaf.leaf(12),Tree.Leaf.leaf(11),Tree.Leaf.leaf(10)));

        MyFlattenTree testFlatten=new MyFlattenTree();
        List flatList=testFlatten.flattenInOrder(tree);
        System.out.println(flatList);
        /*for(Object oneElement:flatList){
            System.out.println(oneElement);
        }*/


    }

    List lst=new LinkedList();
    public List<T> flattenInOrder(Tree<T> tree)
    {
        if (tree == null)
            throw new IllegalArgumentException("Tree cannot be null.");
        if (tree.get().isLeft()) {
            T branches=tree.get().ifLeft(new Function<T, T>() {
                @Override
                public T apply(T t) {
                    System.out.println(t);
                    return t;
                }
            });

            return null;
        }
        else {
             tree.get().ifRight(new Function<Triple<Tree<T>>, Triple<Tree<T>>>() {
                @Override
                public Triple<Tree<T>> apply(Triple<Tree<T>> treeTriple) {
                   flattenInOrder(treeTriple.left());
                   flattenInOrder(treeTriple.middle());
                   flattenInOrder(treeTriple.right());
                   return treeTriple;
                }
            });
        }
        return null;
        }
    }
