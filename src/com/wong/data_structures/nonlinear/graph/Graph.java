package com.wong.data_structures.nonlinear.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {


    private ArrayList<String> vertexList; // stored vertex set
    private int[][] edges; // stores graph adjacent martix,
    private int numOfEdges;
    private boolean[] isVisited; // define one boolean array to record the vertex is it visit

    public static void main(String[] args){
        int n = 5;
        String Vertexes[] = {"A","B","C","D","E"};
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

        // DFS traverse
        System.out.println();
        graph.dfs();

    }

    public Graph(int n) {
        this.edges = new int[n][n];;
        vertexList = new ArrayList<String>();
        numOfEdges = 0;
        isVisited = new boolean[5];
    }

    // get first adjacent vertex index w
    public int getFirstNeighbor(int index){
        for(int j = 0; j <vertexList.size(); j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    // according previous adjacent vertex index to get next adjacent vertex
    public int getNextNeighborhood(int v1, int v2){
        for(int j = v2 + 1; j < vertexList.size(); j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    // DFS
    // i first time is 0
    public void dfsSearch(boolean[] isVisited, int i){
        // first we visit the vertex and output
        System.out.print(getValueByIndex(i) + "->");
        // set vertex to isVisited
        isVisited[i] = true;
        // search the vertex i first adjacent vertex w
        int w = getFirstNeighbor(i);

        while(w != -1){
            if(!isVisited[w]){
                dfsSearch(isVisited, w);
            }
            // if w vertex is visited
            w = getNextNeighborhood(i,w);
        }
    }

    // 对DFS进行一个重载, traverse all vertexes, and continue DFS
    public void dfs(){
        for(int i=0; i < getNumOfVertex(); i++){
            if(!isVisited[i]){
                dfsSearch(isVisited,i);
            }
        }
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

        //   A B C D E
        // A 0 1 1 0 0
        // B 1 0 1 1 1
        // C 1 1 0 0 0
        // D 0 1 0 0 0
        // E 0 1 0 0 0

        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
