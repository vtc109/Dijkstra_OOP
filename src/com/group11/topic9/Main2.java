package com.group11.topic9;

import com.group11.topic9.action.Draw;
import com.group11.topic9.algorithm.Dijkstra;
import com.group11.topic9.graph.Graph;
import com.group11.topic9.graph.Vertex;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static final float INFINITE = 1000;

    public static void main(String[] args) {
        // write your code here
        ArrayList<Vertex> checkVertex = new ArrayList<Vertex>();

        Draw dr = new Draw();
        Graph testGraph = dr.drawGraph();
        testGraph.showGraph();

        //ae test cac truong hop ben duoi
        Dijkstra dijkstra = new Dijkstra();

        System.out.print("Nhap id dinh Start: ");
        Scanner sc1 = new Scanner(System.in);
        int startID = sc1.nextInt();

        Vertex Start = new Vertex();
        Start = testGraph.getVertex(startID);

//        checkVertex.add(Start);

        for (int i=0; i<testGraph.getListVertex().size(); i++){
            if (testGraph.getListVertex().get(i) == Start){
                testGraph.getListVertex().get(i).setPre(0);
                testGraph.getListVertex().get(i).setDis(0.0f);
            }
        }

//        System.out.print("Nhap id dinh Target: ");
//        Scanner sc2 = new Scanner(System.in);
//        int targetID = sc2.nextInt();
//
//        Vertex Target = new Vertex();
//        Target = testGraph.getVertex(targetID);
//        Target.setDis(INFINITE);
//        Target.setPre(0);

        checkVertex.addAll(testGraph.getListVertex());

        for (int i = 0; i < testGraph.getListVertex().size(); i++) {  //todo: khoi tao vo cung
            testGraph.getListVertex().get(i).setDis(INFINITE);
        }
        Start.setDis(0.0f);
        Start.setPre(0);
        Start.setVisited(true);

//        while (checkVertex.size() != 0){
//            System.out.println(" Hello ");
//            System.out.println("Checkvertex size is : " +checkVertex.size());
//            for (int i = 0; i < testGraph.getListVertex().size(); i++) {
//                System.out.println("---------------Lan lap thu "+i+"---------------------");
//                //so lan lap cua checkvertex
//                //tim ra dinh nho nhat, danh dau true
//                Vertex temp = new Vertex();
//
//                System.out.println("|Danh sach cac dinh checkVertex "+i+" truoc khi relax|");
//                temp = dijkstra.extractMin(checkVertex);
//                for (int k=0; k< checkVertex.size();k++){
//                    testGraph.getListVertex().get(k).showVerInfor();
//                }
//
//                //duyet tat cac ke cua dinh do
//                for (int j = 0; j < checkVertex.size(); j++) {
//                    //neu la dinh ke va chua duoc tham
//                    if (testGraph.hasEdgeFrom(temp, checkVertex.get(j)) && checkVertex.get(j) !=temp) {     //
//                        dijkstra.Relaxing1(testGraph, temp, checkVertex.get(j));
//                    }
//                }
//
//                System.out.println("|Danh sach cac dinh checkVertex "+i+" sau khi relax|");
//                temp = dijkstra.extractMin(checkVertex);
//                for (int k=0; k< checkVertex.size();k++){
//                    testGraph.getListVertex().get(k).showVerInfor();
//                }
//
//                //remove extractMin
//                for (int j = 0; j < checkVertex.size(); j++) {
//                    if (checkVertex.get(j).getId() == temp.getId() && checkVertex.get(j) != null) {
//                        System.out.println("---");
//                        System.out.println("ID remove : " + checkVertex.get(j).getId());
////                        System.out.println("---");
//                        checkVertex.remove(j);
//                    }
//                }
//                System.out.println("------------------------------------------------\n");
//            }
//        }
        while (checkVertex.size() != 0){
            System.out.println(" Hello ");
            System.out.println("Checkvertex size is : " +checkVertex.size());
            for (int i = 0; i < testGraph.getListVertex().size(); i++) {
                System.out.println("---------------Lan lap thu "+i+"---------------------");
                //so lan lap cua checkvertex
                //tim ra dinh nho nhat, danh dau true
                Vertex temp = new Vertex();

                System.out.println("|Danh sach cac dinh checkVertex "+i+" truoc khi relax|");
                temp = dijkstra.extractMin(checkVertex);
                for (int k=0; k< checkVertex.size();k++){
                    testGraph.getListVertex().get(k).showVerInfor();
                }

                //duyet tat cac ke cua dinh do
                for (int j = 0; j < checkVertex.size(); j++) {
                    //neu la dinh ke va chua duoc tham
                    if (testGraph.hasEdgeFrom(temp, checkVertex.get(j)) && checkVertex.get(j) !=temp) {     //
                        dijkstra.Relaxing1(testGraph, temp, checkVertex.get(j));
                    }
                }

                System.out.println("|Danh sach cac dinh checkVertex "+i+" sau khi relax|");
                temp = dijkstra.extractMin(checkVertex);
                for (int k=0; k< checkVertex.size();k++){
                    testGraph.getListVertex().get(k).showVerInfor();
                }

                //remove extractMin
                for (int j = 0; j < checkVertex.size(); j++) {
                    if (checkVertex.get(j).getId() == temp.getId() && checkVertex.get(j) != null) {
                        System.out.println("---");
                        System.out.println("ID remove : " + checkVertex.get(j).getId());
//                        System.out.println("---");
                        checkVertex.remove(j);
                    }
                }
                System.out.println("------------------------------------------------\n");
            }
        }

        System.out.println("|Danh sach cac dinh ");
        for (int k=0; k< testGraph.getListVertex().size();k++){
            testGraph.getListVertex().get(k).showVerInfor();
        }
    }
}







