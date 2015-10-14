package classes;

import java.util.Scanner;

/**
 * Created by piorkows on 10/12/2015.
 */
public class MainMenu {

    int userChoice;

    public String getMainMenu() {
        return "\n     Choose one of the following:\n" +
                "          1.Borrow a book\n" +
                "          2.Return a book\n" +
                "          3.Add a new user\n" +
                "          4.Add a new book\n" +
                "          5.List all books\n" +
                "          6.List all users with the borrowed books\n" +
                "          7.Exit\n\n" +
                "Enter your choice (digits from 1 to 6):";
    }

    public int getUserChoice(){
        Scanner userInput = new Scanner(System.in);
        userChoice= userInput.nextInt();
        return userChoice;
    }

    public void processUserChoice(){
        switch (userChoice){
            case(1):
                System.out.println("1");
                break;
            case(2): System.out.println("1");
                break;
           /* case(3): rentBook();
                break;
            case(4): rentBook();
                break;
            case(5): rentBook();
                break;
            case(6): rentBook();
                break;*/
            case(7):
                System.out.println("Thank you for using the service\nHave a nice day :-)");
                System.exit(0);
                break;

        }
    }

    public void registerNewUser(String firstNameFromUserInput, String lastNameFromUserInput){
         this.validateIfUserExists(firstNameFromUserInput, lastNameFromUserInput);

    }

    private void validateIfUserExists(String firstNameFromUserInput, String lastNameFromUserInput) {

    }

    public void showUserChoice(){
        System.out.println("You chose " + this.getUserChoice());
    }

}
