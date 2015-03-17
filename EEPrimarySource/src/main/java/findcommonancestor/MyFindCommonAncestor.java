package findcommonancestor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by pankaj on 17-03-2015.
 */
public class MyFindCommonAncestor {

    public static void main(String[] args) {
        MyFindCommonAncestor myFindCommonAncestor = new MyFindCommonAncestor();
        //String[] commits = {"G", "F", "E", "D", "C", "B", "A"};
        String[] commits = {"P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};
        String[][] parents = {{"G", "O"}, {"N"}, {"D"}, {"L"}, {"K"}, {"C"}, {"I"}, {"H"}, {"B"}, {"P", "F"}, {"M", "E"}, {"D", "J"}, {"C"}, {"B"}, {"A"}, null};
        String commit1 = "D";
        String commit2 = "F";

        System.out.println(myFindCommonAncestor.findCommmonAncestor(commits, parents, commit1, commit2));
    }


    public String findCommmonAncestor(String[] commitHashes,
                                      String[][] parentHashes, String commitHash1, String commitHash2) {
        NodeManager nodeManager = NodeManager.getNodeManager();
        for (String str : commitHashes) {
            nodeManager.createNode(str);
        }
        for (int i = 0; i < parentHashes.length; i++) {
            String[] parents = parentHashes[i];
            Node<String> childNode = nodeManager.getNode(commitHashes[i]);
            if (parents != null) {
                for (String parent : parents) {
                    childNode.parents.add(nodeManager.getNode(parent));
                }
            }
        }
        return nodeManager.getCommonParent(nodeManager.getNode(commitHash1), nodeManager.getNode(commitHash2));
    }

    static class Node<T> {
        public T value;
        public List<Node<T>> parents = new LinkedList<Node<T>>();


        public Node(T t) {
            this.value = t;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (value != null ? !value.equals(node.value) : node.value != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }

    static class NodeManager<T> {
        static NodeManager nodeManager = new NodeManager();
        Set<Node<T>> createdNodes = new HashSet<Node<T>>();

        private NodeManager() {

        }

        public static NodeManager getNodeManager() {
            return nodeManager;
        }

        public Node<T> createNode(T value) {
            Node<T> tempNode = new Node<T>(value);
            if (createdNodes.contains(tempNode)) {
                return getNode(value);
            } else {
                createdNodes.add(tempNode);
                return tempNode;
            }
        }

        public Node<T> getNode(T targetNode) {
            Node<T> tempNode = new Node<T>(targetNode);
            for (Node<T> oneNode : createdNodes) {
                if (oneNode.equals(tempNode)) {
                    return oneNode;
                }
            }
            return null;
        }

        public String getCommonParent(Node commitHash1, Node commitHash2) {
            List<Node<T>> firstParent = commitHash1.parents;
            if (commitHash1.equals(commitHash2)) {
                return (String) commitHash1.value;
            } else {
                for (Node<T> oneParentNode : firstParent) {
                    if (checkIfInPath(oneParentNode, commitHash2)) {
                        return (String) oneParentNode.value;
                    } else {
                        return getCommonParent(oneParentNode, commitHash2);
                    }
                }
            }
            return null;
        }

        private boolean checkIfInPath(Node oneParentNode, Node commitHash2) {
            if (oneParentNode.equals(commitHash2)) {
                return true;
            } else {
                List<Node<T>> firstParent = commitHash2.parents;
                for (Node oneCommitHash2 : firstParent) {
                    return checkIfInPath(oneParentNode, oneCommitHash2);
                }
            }
            return false;
        }
    }

}
