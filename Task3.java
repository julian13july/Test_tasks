package com.company;

import java.util.*;

/**
 * Task3.java - The program calculates the shortest distance between selected vertices in the graph.
 */
public class Task3 {

    private final static int[] FIRST_LINE = {5, 5};
    private final static int[][] EDGE_LINES = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {4, 5}};
    private final static int[] LAST_LINE = {1, 5};

    public static void main(String[] args) {
        if (isValid()) {
            try {
                Node[] nodes = readLines();
                System.out.println(findShortestPath(nodes[LAST_LINE[0]], nodes[LAST_LINE[1]]));
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Error: Please check the entered lines. " + ex.getMessage());
            }
        }
    }

    /**
     * Check and return the result if the last line is correct.
     *
     * @return The result of the check as a boolean
     */
    private static boolean isValid() {
        if (LAST_LINE[0] < 1 || LAST_LINE[0] > FIRST_LINE[0] || LAST_LINE[1] < 1 || LAST_LINE[1] > FIRST_LINE[0]) {
            System.out.println("Error: Please check the last line. The values given there should be >= 1, but <= " + FIRST_LINE[0]);
            return false;
        }
        return true;
    }

    /**
     * Read and return an array of values specified in constants.
     *
     * @return The result of reading as an array of nodes
     */
    private static Node[] readLines() {
        Node[] nodes = new Node[FIRST_LINE[0] + 1];
        for (int i = 1; i <= FIRST_LINE[0]; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < FIRST_LINE[1]; i++) {
            nodes[EDGE_LINES[i][0]].addNeighbor(nodes[EDGE_LINES[i][1]]);
        }
        return nodes;
    }

    /**
     * Find and return the shortest distance between nodes, or -1, if there is no such route in the given graph.
     *
     * @param startNode Start node
     * @param endNode End node
     * @return Distance between nodes as an integer
     */
    private static int findShortestPath(Node startNode, Node endNode) {
        int distance = -1;
        Queue<Node> queueNodes = new LinkedList<>();
        startNode.setVisited(true);
        queueNodes.add(startNode);
        while (!queueNodes.isEmpty()) {
            Node currentNode = queueNodes.poll();
            for (Node neighborNode : currentNode.getNeighbours()) {
                if (!neighborNode.getVisited()) {
                    neighborNode.setVisited(true);
                    queueNodes.add(neighborNode);
                    neighborNode.setPrevious(currentNode);
                    if (neighborNode == endNode) {
                        queueNodes.clear();
                        break;
                    }
                }
            }
        }
        while (endNode != null) {
            distance++;
            endNode = endNode.getPrevious();
        }
        if (distance == 0) {
            distance = -1;
        }
        return distance;
    }

}

/**
 * Node class.
 */
class Node {

    private List<Node> neighbours;
    private boolean visited;
    private Node previous;

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void addNeighbor(Node node) {
        neighbours.add(node);
        node.neighbours.add(this);
    }

    Node() {
        neighbours = new ArrayList<>();
    }

}