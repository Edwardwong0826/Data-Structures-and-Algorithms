package com.wong.data_structures.nonlinear.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private ArrayList<String> vertexList; // stored vertex set
    private int[][] edges; // stores graph connected martix
    private int numOfEdges;

    public static void main(String[] args){
        int n = 5;
        String Vertexes[] = {"A","B","C","D,","E"};
        Graph graph = new Graph(n);

        for(String vertex: Vertexes){
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4 ,1);

        graph.showGraph();
    }

    public Graph(int n) {
        this.edges = new int[n][n];;
        vertexList = new ArrayList<String>();
        numOfEdges = 0;
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }

    // return vertex value by index, 0->A, 1->B, 2->C
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    // return v1 and v2 weight
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    public void showGraph(){
        for(int[] link :edges){
            System.out.println(Arrays.toString(link));
        }
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
