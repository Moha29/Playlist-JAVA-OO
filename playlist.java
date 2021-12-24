package com.company;

public class playlist {
    private String name;
    private String des;

    public playlist(){
        name = null;
        des = null;
    }

    public playlist(String name, String des) {
        this.name = name;
        this.des = des;
    }


    public void display(){

        System.out.println("The playlist's name:" + this.name + "\nDescription: "+des);
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
    }

    public String get_name() {
        return this.name;
    }

    public String get_des() {
        return this.des;
    }
}
