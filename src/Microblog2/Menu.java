package Microblog2;

import static java.lang.System.out;


import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;



public class Menu {


    public static void mainMenu(String user) {



        out.println("Main Menu");
        out.println("1) Create a new user");
        out.println("2) Become an existing user");
        out.println("3) Create a post as the current user");
        out.println("4) Print all posts");
        out.println("5) Print all users");
        out.println("6) To Exit Microblog");
        out.println("What would you like to do today?");

    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int option;
        String currentUser = "";
        int numPosts = 0;
        String comment;
        String fullName, userName, webAddress, emailAddress;


        List<User> userList = new ArrayList<>();
        userList.add(0, new User("", "", "", ""));

        List<Post> postList = new ArrayList<>();

        String currentPost = "First Post";


        int pickUser = 0;



        if (pickUser != 0) {
            currentUser = String.valueOf(userList.get(pickUser).getUserName());
        } else if (userList != null && !userList.isEmpty()) {

            currentUser = String.valueOf((userList.get(userList.size() - 1).getUserName()));
        }


        do {


            if (postList != null && !postList.isEmpty())
            {
                currentPost = String.valueOf((postList.get(postList.size()-1).getPost()));
            }

            mainMenu(currentUser);
            option = keyboard.nextInt();
            while (option >= 7 || option <= 0) {
                out.println("I don't understand you choice, please choose from 1 through 6");
                option = keyboard.nextInt();
            }

                if (option == 1) {


                    keyboard.nextLine();
                    out.println("Full name: ");
                    fullName = keyboard.nextLine();
                    out.println("User Name: ");
                    userName = keyboard.nextLine();
                    out.println("Web address: ");
                    webAddress = keyboard.nextLine();
                    out.println("Email Address: ");
                    emailAddress = keyboard.nextLine();
                    out.println();

                    User user = new User(userName, fullName, webAddress, emailAddress);


                    userList.add(user);


                } else if (option == 2) {
                    out.println("Which user would you like to use?");

                for (int i = 1; i < userList.size(); i++) {
                        out.println(userList.get(i).pickUserName());

                }

                option = keyboard.nextInt();
                    out.println();
                    out.println("You are now user " + userList.get(option).getUserName());
                    currentUser=userList.get(option).getUserName();
                }
                else if (option == 3) {

                int userPost = -1;
                    for (int i =0;i < postList.size(); i++) {
                        if (postList.get(i).getUser().equals(currentUser)) {
                            userPost = i;
                        }
                    }
                    if (userPost > -1) {
                        out.println("This was your last post: ");
                        out.println(postList.get(userPost).getPost());
                    } else {
                        out.println("No post by current user");
                    }

                    keyboard.nextLine();
                    out.println("Enter in your post: ");

                    comment = keyboard.nextLine();
                    postList.add(new Post(currentUser, comment));

                    out.println("Post entered successfully!");


                } else if (option == 4) {
                    for (int i = 0; i < postList.size(); i++) {
                        out.println(postList.get(i).allPosts());
                    }
                    out.println();

                } else if (option == 5) {
                    for (int i = 0; i < userList.size(); i++) {
                        out.println(userList.get(i).getUserName());
                    }


                }

            }while(option != 6);
        {
            out.println("Thank you for using Microblog");
        }
        }
    }


