package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LLL {
    protected v_node head;
    private playlist play_list;

    public LLL(){
        head = null;
        play_list = null;
    }

    public void save_list() throws IOException {
        if(play_list == null)
            return;
        FileWriter file;
        try{
            file = new FileWriter("data.txt");
            BufferedWriter in = new BufferedWriter(file);
            in.write(play_list.get_name());
            in.write('#');
            in.write(play_list.get_des());
            in.write('#');
            while(head != null){
                in.write(head.get_title());
                in.write(',');
                in.write(head.get_attach());
                in.write(',');
                in.write(head.get_des());
                in.write(',');
                in.write(head.get_comment());
                in.write(',');
                in.write(head.what_type());
                in.write(',');
                if(head.what_type().compareToIgnoreCase("Quest") == 0){
                    in.write(head.get_quest());
                }
                else {
                    in.write(head.get_cc());
                }
                in.write(',');
                head = head.getNext();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int add_playlist_info(playlist source){
        if(play_list == null){
            play_list = new playlist();
            play_list = source;
            return 1;
        }
        else
            return 0;
    }

    public int add_media_wrapper(Media source){
        if(head == null){
            head = new v_node();
            head.setData(source);
            return 1;
        }
        add_media(head,source);
        return 1;
    }

    public v_node add_media(v_node head, Media source){
        if(head == null){
            head = new v_node();
            head.setData(source);
            return head;
        }
        head.setNext(add_media(head.getNext(),source));
        return head;
    }

    public int delete_media_wrapper(String title){
        if(head == null)
            return 0;
        if(head.compare_media(title)) {
            head = head.getNext();
            return 1;
        }
        v_node prev = head;
        return delete_media(title,head,prev);
    }

    public int delete_media(String title, v_node head, v_node prev){
        if(head == null)
            return 0;
        if(head.compare_media(title)){
            if(head.getNext() == null){
                //head.delete_data();
                prev.setNext(null);
                head = null;
                return 1;
            }
            if(head.getNext() != null) {
                prev.setNext(head.getNext());
                v_node temp = head.getNext();
                head = null;
                head = temp;
                return 1;
            }
        }
        prev = head;
        return delete_media(title,head.getNext(),prev);
    }

    public int remove_all_wrapper(){
        if(play_list == null)
            return 0;
        play_list = null;
        if(head == null)
            return 0;
        v_node temp = head;
        remove_all(head,temp);
        this.head = null;
        temp = null;
        return 1;
    }

    public int remove_all(v_node head, v_node temp){
        if(head == null)
            return 0;
        head = head.getNext();
        temp = head;
        return remove_all(head, temp);
    }

    public int display_wrapper(){
        if(head == null)
            return 0;
        return display(head);
    }

    public int display(v_node head){
        if(head == null)
            return 0;
        head.display();
        return display(head.getNext());
    }

    public void display_playlist(){
        if(play_list==null)
            return;
        play_list.display();
    }


}
