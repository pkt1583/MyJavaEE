package com.pkt.barclays;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pankaj on 2/28/15.
 */
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
            return newNode;
        }
    }


    public void clearAll() {
        nodeList.clear();
    }
}
