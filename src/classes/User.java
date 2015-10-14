package classes;


import java.util.Scanner;

/**
 * Created by piorkows on 10/12/2015.
 */
public class User {
String firstName, lastName;
    int userID, totalRentedBooks, bookIdNumber1,bookIdNumber2, bookIdNumber3;

    public void getNewUserDetailsFromUser(){
        System.out.println("Enter new user ID: ");
        Scanner userInputNewUserID = new Scanner(System.in);
        this.userID= userInputNewUserID.nextInt();
        System.out.println("Enter first name: ");
        Scanner userInputFirstName = new Scanner(System.in);
        this.firstName= userInputFirstName.nextLine();
        System.out.println("Enter last name: ");
        Scanner userInputLastName = new Scanner(System.in);
        this.lastName= userInputLastName.nextLine();
        this.totalRentedBooks=0;
        this.bookIdNumber1=0;
        this.bookIdNumber2=0;
        this.bookIdNumber3 =0;
    }

    public String newUserDetails(){
        return this.userID + "|" + this.firstName + "|" + this.lastName + "|" + this.totalRentedBooks + "|" + this.bookIdNumber1 + "|" + this.bookIdNumber2 + "|" + this.bookIdNumber3 + "\n";
    }


}
