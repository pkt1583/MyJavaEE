package com.pkt.barclays;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pankaj on 2/28/15.
 */
public class Node {
    private String nodeName;
    private Node sourceNode;
    private Map<Node,Integer> destinations=new LinkedHashMap<>() ;

    public Node(String nodeName){
        this.nodeName=nodeName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Node getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(Node sourceNode) {
        this.sourceNode = sourceNode;
    }

    public Map<Node,Integer> getDestinations() {
        return destinations;
    }

    public void setDestinations(Map<Node,Integer>destinations) {
        this.destinations = destinations;
    }



    public Integer addToDestination(Node destination,Integer weight){
       return this.destinations.put(destination,weight);

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("nodeName='").append(nodeName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (!nodeName.equals(node.nodeName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nodeName.hashCode();
    }
}
