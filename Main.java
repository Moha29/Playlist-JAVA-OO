package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner input = null;
    public static void main(String[] args) throws IOException {
	    input = new Scanner(System.in);
	    String name;
	    String des;
	    int ans = 0;
	    String title;
        String attach;
        String des1;
        String comment;
        String quest;
        String file;
	    int choice = 0;
	    int index = 0;
	    ARR my_arr;
	    my_arr = new ARR();
	    playlist my_playlist;
	    my_arr.load_playlists();

	    System.out.println("      -------Welcome!-------"+ "\nThis program will help you create a playlist that can have a series of videos that you will be able to enter.");

	    while(choice != 7){
	        System.out.println("----------MENU---------");
	        System.out.println("(1) Create a new playlist. \n(2) Create a new video. \n(3) Remove a playlist. \n(4) Remove a video. \n(5) Display a playlist. \n(6) Display all playlists. \n(7) Quit.");
	        System.out.println("Enter the number of your option: ");
	        choice = input.nextInt();
            input.nextLine();
	        if(choice == 1){
	            System.out.println("Enter the name of the playlist: ");
	            name = input.nextLine();

                System.out.println("Enter the description of the playlist: ");
                des = input.nextLine();

                my_playlist = new playlist(name, des);
                my_arr.add_playlist(my_playlist);
            }

	        if(choice == 2){
                //Display playlist for the user to choose where to insert the new video
                my_arr.display_all_lists_wrapper();
                System.out.println("Enter the number of the playlist you want to enter the video in: ");
                index = input.nextInt() - 1;
                input.nextLine();
                //Display the options of videos
                System.out.println("What type of video do you want to enter: ");
                System.out.println("(1) Quiz. \n(2) Closed Caption.");
                System.out.println("Enter the number of the option: ");
                ans = input.nextInt();
                input.nextLine();


                //Video with a quiz
                if(ans == 1){
                    System.out.println("Enter the title of the video: ");
                    title = input.nextLine();

                    System.out.println("Enter any attachments: ");
                    attach = input.nextLine();

                    System.out.println("Enter the description for this video: ");
                    des1 = input.nextLine();

                    System.out.println("Enter the comments: ");
                    comment = input.nextLine();

                    System.out.println("Enter a question: ");
                    quest = input.nextLine();

                    Media my_media = new Quiz(title,attach,des1,comment,quest);
                    my_arr.add_new_media(my_media,index);

                }

                //Video with a CC
                if(ans == 2){
                    System.out.println("Enter the title of the video: ");
                    title = input.nextLine();

                    System.out.println("Enter any attachments: ");
                    attach = input.nextLine();

                    System.out.println("Enter the description for this video: ");
                    des1 = input.nextLine();

                    System.out.println("Enter the comments: ");
                    comment = input.nextLine();

                    System.out.println("Enter the CC file: ");
                    file = input.nextLine();

                    Media my_media = new CC(title,attach,des1,comment,file);
                    my_arr.add_new_media(my_media,index);

                }
            }
	        if(choice == 3){
                //Display playlist for the user to choose which to remove
                my_arr.display_all_lists_wrapper();
                System.out.println("Enter the number of the playlist you want to remove: ");
                index = input.nextInt() - 1;
                input.nextLine();
                //call removal
                if(index < 5 && index > -1) {
                    if (my_arr.delete_playlist(index) == 1)
                        System.out.println("Removed!");
                    else
                        System.out.println("There is no list!");
                }
            }

	        if(choice == 4){

                //Display playlist for the user to choose which to remove the video from
                my_arr.display_all_lists_wrapper();
                System.out.println("Enter the number of the playlist you want to remove the video from: ");
                index = input.nextInt() - 1;
                input.nextLine();
                if(index < 5 && index > -1) {
                    //Display videos of that playlists
                    my_arr.display_media_list(index);
                    //Get the title
                    System.out.println("What is the title of the video you want to remove: ");
                    title = input.nextLine();
                    //Call removal
                    if (my_arr.delete_media(index, title) == 0)
                        System.out.println("This list is empty");
                    else
                        System.out.println("Removed!");
                }
                else
                    System.out.println("List doesn't exist!");
            }
	        if(choice == 5) {
	            //Display all lists
                my_arr.display_all_lists_wrapper();
                System.out.println("Enter the number of the playlist you want to display the videos for: ");
                index = input.nextInt() - 1;
                input.nextLine();
                //Get the list index
                if(index < 5 && index > -1) {
                    //Display videos of that playlists
                    my_arr.display_media_list(index);
                }
            }
	        if(choice == 6){
                my_arr.display_all_lists_wrapper();
            }
        }
        my_arr.save();


    }
}
