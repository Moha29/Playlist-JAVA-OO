package com.company;

public class Quiz extends Media {
    private String quest;

    public Quiz(){
        quest = null;
    }

    public Quiz(String title, String attach, String des, String comment, String quest){
        super(title,attach,des,comment);
        this.quest = new String(quest);
    }

    public void display() {
        super.display();
        System.out.println("The question is: "+quest);
    }

    public String what_type() {
        return "Quest";
    }

    public void delete(){
        this.quest = null;
        super.delete();
    }
    public String get_quest() {
        return this.quest;
    }
}
