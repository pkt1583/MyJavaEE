package com.pkt.barclays;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pankaj on 2/28/15.
 */
import java.util.*;


public class NodeManager {

    Node initialNode=new Node("FirstNode");
    List<Node> nodeList=new LinkedList<>();
    private static NodeManager nodeManager=new NodeManager();

    public static NodeManager getInstance(){
        if(nodeManager==null){
            nodeManager=new NodeManager();
        }
        return nodeManager;
    }
    private NodeManager(){    }

    public Node getNode(String nodeName){
        for(Node node:nodeList){
            if(node.getNodeName().equalsIgnoreCase(nodeName)){
                return node;
            }
        }
        return null;
    }

    public Node getNode(Node sourceNode){
        for(Node node:nodeList){
            if(node.equals(sourceNode)){
                return node;
            }
        }
        return null;
    }

    public Node addDestination(Node sourceNode,Node destinationNode,Integer weight){
        Node targetSourceNode=getNode(sourceNode);
        if(targetSourceNode!=null){
            targetSourceNode.addToDestination(destinationNode,weight);
        }
        return targetSourceNode;
    }

    public Node createNode(String name){
        Node newNode=new Node(name);
        Node targetSourceNode=getNode(newNode);
        if(targetSourceNode!=null){
            return targetSourceNode;
        }else{
            nodeList.add(newNode);
            return newNode;
        }
    }


    public void clearAll() {
        nodeList.clear();
    }

    Set<Set<Node>> allPossiblePath=new HashSet<>();

    public List<Node> getPath(Node source, Node target) {
        reachTillDestination(source,target);
        for(Set<Node> paths:allPossiblePath) {
            System.out.println("Printing " + paths);
        }
        return null;
    }


    Set<Node> paths=new HashSet<>();
    List<Node> vistedNodes=new ArrayList<>();



    private Node reachTillDestination(Node source,Node target){
        //check from child
        for(Node destinationNode:source.getDestinationList()){
            System.out.println("Checking for [ "+destinationNode+" ] ");
           /* if(source.equals(destinationNode) ){
                continue;
            }else {*/
                if(!destinationNode.isVisited()){
                    if (destinationNode.canReachDestination(target, vistedNodes)) {
                        System.out.println(vistedNodes);
                        vistedNodes.clear();
                    }
                }//else
                reachTillDestination(destinationNode,target);
            //}
        }
        return null;
    }


}

