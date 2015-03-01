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
        Node a3Node=nodeManager.createNode("A3");
        Node a4Node=nodeManager.createNode("A4");
        assertEquals(6, nodeManager.nodeList.size());
        Node testNode=new Node("A5");
        assertEquals("A5", nodeManager.getNode(testNode).getNodeName());

    }
}