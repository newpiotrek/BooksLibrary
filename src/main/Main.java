package main;

import classes.Book;
import classes.FileProcessor;
import classes.MainMenu;
import classes.User;

import java.io.IOException;


/**
 * Created by piorkows on 10/12/2015.
 */
public class Main {
    //explain lambda, streams in Java8, Consumer argument (stream.forEach())
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        System.out.println(mainMenu.getMainMenu());
        mainMenu.showUserChoice();
/*        while(mainMenu.getUserChoice()!=6) mainMenu.processUserChoice();*/

        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.readAllDataFromFile("books.txt");
        fileProcessor.readAllDataFromFile("users.txt");
        /*fileProcessor.writeNewDataToFile("Karol Poznanski 5\n", "users.txt");*/
        /*fileProcessor.readAllDataFromFile("users.txt");*/

      /*  Book newBook = new Book();
        newBook.getBookDetailsFromUser();
        System.out.println(newBook.newBookDetails());
        fileProcessor.writeNewDataToFile(newBook.newBookDetails(), "books.txt");*/

        /*User newUser = new User();
        newUser.getNewUserDetailsFromUser();
        System.out.println(newUser.newUserDetails());
        fileProcessor.writeNewDataToFile(newUser.newUserDetails(), "users.txt");*/
        try {
            fileProcessor.listAllUsersWithTheirBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

