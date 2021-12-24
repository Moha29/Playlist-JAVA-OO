package com.company;

public class v_node {
    private v_node next;
    private Media data;

    public v_node(){
        this.next = null;
        this.data = null;
    }

    public v_node(Media source){
        this.data = new Media();
        this.data = source;
    }

    public v_node getNext() {
        return next;
    }

    public void setNext(v_node next) {
        this.next = next;
    }

    public void setData(Media source){
        this.data = source;
    }

    public boolean compare_media(String title){
        return this.data.compare(title);
    }

    public void delete_data(){
        this.data.delete();
        this.data = null;
    }

    public void display(){
        this.data.display();
    }

    public String get_title() {
        return data.get_title();
    }
    public String get_attach() {
        return data.get_attach();
    }

    public String get_des() {
        return data.get_des();
    }

    public String get_comment() {
        return data.get_comment();
    }

    public String get_quest() {
        return data.get_quest();
    }

    public String get_cc() {
        return data.get_cc();
    }

    public String what_type() {
        return data.what_type();
    }
}


