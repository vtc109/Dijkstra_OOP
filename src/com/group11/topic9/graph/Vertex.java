package com.group11.topic9.graph;

import java.util.Objects;

public class Vertex {
    private int id;

    private int pre;    //previous Vertex's ID

    private boolean visited;    // travered or not, true or false
    private float dis;    //distance from Start Node to this vertex

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public boolean getVisted(){
        return this.visited;
    }

    public int getId() {
        return id;
    }

    public void setPre(int pre){
        this.pre = pre;
    }

    public int getPre(){
        return pre;
    }

    public void setDis( float dis){
        this.dis = dis;
    }

    public float getDis(){
        return dis;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
    public Vertex (){
        super();
    }
    public Vertex(int id) {
        this.id = id;
    }
    //todo: compare vertex
    public boolean equals(Vertex v){
        return this.id == v.getId();
    }

    public void showVerInfor(){
//        System.out.println("---");
        System.out.print("ID : "+this.getId());
        System.out.println("("+this.getDis()+", "+this.getPre()+")");
    }

}
