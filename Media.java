package com.company;

public class Media {
    private String title;
    private String attach;
    private String des;
    private String comment;

    public Media(){
        title = null;
        attach = null;
        des = null;
        comment = null;
    }

    public Media(String title, String attach, String des, String comment) {
        this.title = new String(title);
        this.attach = new String(attach);
        this.des = new String(des);
        this.comment = new String(comment);
    }

    public boolean compare(String title){
        return this.title.equalsIgnoreCase(title);
    }

    public void delete(){
        this.title = null;
        this.attach = null;
        this.des = null;
        this.comment = null;
    }

    public void display(){
        System.out.println("===================================================");
        System.out.println("The video's title: "+title+"\nAttachments: "+attach+"\nDescription: "+des+"\nComments: "+comment);
    }

    public String get_title() {
        return this.title;
    }

    public String get_attach() {
        return this.attach;
    }

    public String get_des() {
        return this.des;
    }

    public String get_comment() {
        return this.comment;
    }

    public String get_cc() {
        return null;
    }

    public String get_quest() {
        return null;
    }

    public String what_type() {
        return "Quest";
    }

}
