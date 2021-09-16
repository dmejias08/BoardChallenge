package com.project;

public class Node {


    private Object data;
    public Node next;
    public Node previous;

    

    public Node(Object data){ // No entiendo que hace este método
        this.next = null;
        this.data = data;
        this.previous = null;
    }
    public Object getData() {
        return this.data;
    }
    public void setData(Object data){
        this.data = data;
    }
    public Node getNext(){
        return this.next;
    }
    public Node getPrevious(){
        return this.previous;
    }
    public void setNext(Node node){
        this.next = node;
    }
    public void setPrevious(Node node){
        this.previous = node;
    }
}
