package com.pkt.barclays;

import java.util.*;

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

    public List<Node> getDestinationList(){
        List<Node> nodeList=new ArrayList<>();
        for(Map.Entry<Node,Integer> entry:destinations.entrySet()){
            nodeList.add(entry.getKey());
        }
        return nodeList;
    }

    public void setDestinations(Map<Node,Integer>destinations) {
        this.destinations = destinations;
    }



    public boolean canReachDestination(Node destination,List<Node> vistedNode){
        vistedNode.add(this);
        if(this.equals(destination)){
            return true;
        }
        for(Map.Entry<Node,Integer> probableDestinationEntry:destinations.entrySet()){
            Node probableDestination=probableDestinationEntry.getKey();
            if(probableDestination.canReachDestination(destination,vistedNode)){
                return true;
            }
        }
        vistedNode.remove(this);
        return false;
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


