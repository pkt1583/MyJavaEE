package com.pkt.barclays;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class NodeManagerTest  {



    public void testAddDestination() throws Exception {
        NodeManager nodeManager=NodeManager.getInstance();
        nodeManager.clearAll();
        Node tickettingSystemNode=nodeManager.createNode("Concourse_A_Ticketing");
        Node a5Node=nodeManager.createNode("A5");
        Node a10Node=nodeManager.createNode("A10");
        Node a1Node=nodeManager.createNode("A1");
        Node a2Node=nodeManager.createNode("A2");
        Node a3Node=nodeManager.createNode("A3");
        Node a4Node=nodeManager.createNode("A4");
        tickettingSystemNode.addToDestination(a5Node,5);
        a5Node.addToDestination(a10Node,4);
        a5Node.addToDestination(a1Node,6);
    }

    @Test
    public void testCreateNode() throws Exception {
        NodeManager nodeManager=NodeManager.getInstance();
        nodeManager.clearAll();
        Node tickettingSystemNode=nodeManager.createNode("Concourse_A_Ticketing");
        Node a5Node=nodeManager.createNode("A5");
        Node a10Node=nodeManager.createNode("A10");
        Node a2Node=nodeManager.createNode("A2");
        Node a1Node=nodeManager.createNode("A1");
        Node a3Node=nodeManager.createNode("A3");
        Node a4Node=nodeManager.createNode("A4");

        Node a9Node=nodeManager.createNode("A9");
        Node a8Node=nodeManager.createNode("A8");
        Node a7Node=nodeManager.createNode("A7");
        Node a6Node=nodeManager.createNode("A6");
        Node a11Node=nodeManager.createNode("A6");
        nodeManager.nodeList.size();
        // assertEquals(6, nodeManager.nodeList.size());
        Node testNode=new Node("A5");
        // assertEquals("A5", nodeManager.getNode(testNode).getNodeName());
        tickettingSystemNode.addToDestination(a5Node,5);
        a5Node.addToDestination(a10Node,4);
        a5Node.addToDestination(a1Node,6);
        a1Node.addToDestination(a2Node,1);
        a2Node.addToDestination(a3Node,1);
        a3Node.addToDestination(a4Node,1);
        a10Node.addToDestination(a9Node,1);
        a9Node.addToDestination(a8Node,1);
        a9Node.addToDestination(a11Node,1);
        a11Node.addToDestination(a7Node,2);
        a8Node.addToDestination(a7Node,1);
        a7Node.addToDestination(a6Node,1);
        a2Node.addToDestination(a7Node,2);
        System.out.println(nodeManager.getPath(a5Node, a7Node));

    }
}
