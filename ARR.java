package com.company;

import java.io.*;
import java.util.Scanner;

public class ARR {
    private LLL list[];
    private playlist data;
    private int size;

    public ARR(){
        size = 5;
        data = null;
        this.list = new LLL[5];
        this.list[0] = null;
        this.list[1] = null;
        this.list[2] = null;
        this.list[3] = null;
        this.list[4] = null;

    }

    public int load_playlists() throws FileNotFoundException {
        File file = new File ("data.txt");
        String name,des,title,attach,des1,comment,cc,quest,type;
        int index = 0;
        try{
            Scanner get = new Scanner(file).useDelimiter("#");
            while(get.hasNext()){
                name = get.next();
                des = get.next();
                playlist source = new playlist(name,des);
                add_playlist(source);
                get.useDelimiter(",");
                while(get.hasNext()){
                    type = get.next();
                    if(type.compareToIgnoreCase("Quest") == 0){
                        title = get.next();
                        attach = get.next();
                        des1 = get.next();
                        comment = get.next();
                        quest = get.next();
                        Media my_media = new Quiz (title,attach,des1,comment,quest);
                        add_new_media(my_media,index);
                    }
                    else{
                        title = get.next();
                        attach = get.next();
                        des1 = get.next();
                        comment = get.next();
                        cc = get.next();
                        Media my_media = new CC (title,attach,des1,comment,cc);
                        add_new_media(my_media,index);
                    }
                }
                get.useDelimiter("#");
                index = index + 1;
            }
            get.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return 1;
    }

    public void save() throws IOException {
        for(int i = 0; i<5; ++i){
            if(list[i] != null)
                list[i].save_list();
        }

    }

    public int add_playlist(playlist source) {
        if (list == null)
            return 0;

        int index = get_index_wrapper();
        if(index == 5)
            return 0;
        list[index] = new LLL();
        return list[index].add_playlist_info(source);

    }

    public int get_index_wrapper(){
        if(list == null)
            return 0;
        int i = 0;
        return get_index(list,i);
    }

    public int get_index(LLL [] list, int i){
        if(list[i] == null){
            return i;
        }
        return get_index(list,i+1);
    }

    public int add_new_media(Media source, int index){
        if(list[index] == null){
            System.out.println("There is no playlist");
            return 0;
        }
        return list[index].add_media_wrapper(source);
    }

    public int delete_media(int index, String title){
        if(list[index] == null)
            return 0;
        return list[index].delete_media_wrapper(title);
    }

    public int delete_playlist(int index){
        if(list[index] == null){
            return 0;
        }
        list[index].remove_all_wrapper();
        list[index] = null;
        return 1;
    }

    public int display_all_lists_wrapper(){
        if(list == null)
            return 0;
        int i = 0;
        return display_all_lists(list,i);
    }

    public int display_all_lists(LLL []list, int i){
        if(i == 5)
            return 0;

        if(list[i] != null) {
            System.out.println("             (" + (i + 1) + ")");
            list[i].display_playlist();
        }
        return display_all_lists(list,i+1);
    }

    public int display_media_list(int index){
        if(list[index] == null)
            return 0;
        return list[index].display_wrapper();
    }
}
