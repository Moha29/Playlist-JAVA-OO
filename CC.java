package com.company;

public class CC extends Media{
    private String file;

    public CC(){
        this.file = null;
    }

    public CC(String title, String attach, String des, String comment, String file){
        super(title,attach,des,comment);
        this.file = new String(file);
    }

    public void delete(){
        this.file = null;
        super.delete();
    }

    public void display(){
        super.display();
        System.out.println("The attached file is: "+file);
    }
    public String get_cc() {
        return this.file;
    }
    public String what_type() {
        return "CC";
    }
}

