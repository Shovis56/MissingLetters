package com.company;

import static java.lang.System.out;
import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);
        int size;

        out.println("Welcome to Multiplication Tables");
        out.println("How large would you like to see them?");

        size = keyboard.nextInt();
        while(size > 20 || size < 1){
            out.println("Please enter a number between 1-20.");
            size = keyboard.nextInt();
        }


        for(int row = 0; row <= size; row++) {
            for(int col = 0; col <= size; col++)
            out.println(row +"*"+col+ "=" +(row*col));
        }
    }
}
