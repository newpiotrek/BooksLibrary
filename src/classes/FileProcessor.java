package classes;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;

/**
 * Created by piorkows on 10/13/2015.
 */
public class FileProcessor {
// dodac Library Class, wykorzystac Serializable Interface (zobaczyc czy powstaje drugi rodzaj plikow (.dat), na koncu zapisac zmiany, pomyslec o klasie Borrow
    // design pattern Strategy - zaimplementowac w Library w odniesieniu do FileProcessor'a. Zeby klasy Book i User implementoaly Serializable

    public void readAllDataFromFile(String fileName){
       /* Path pathToUsersFile = Paths.get("C:\\Users\\PIORKOWS\\IdeaProjects\\BooksLibrary\\src\\textFiles\\" + fileName);*/
        Path pathToUsersFile = Paths.get("C:\\Users\\Piork\\IdeaProjects\\BooksLibrary\\src\\textFiles\\"+fileName);
        Stream<String> allDataFromFile;
        try {
            allDataFromFile = Files.lines(pathToUsersFile, StandardCharsets.UTF_8);
            allDataFromFile.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNewDataToFile(String newDataToBeAdded, String fileName){
        byte[] data = newDataToBeAdded.getBytes();
       /* Path path = Paths.get("C:\\Users\\PIORKOWS\\IdeaProjects\\BooksLibrary\\src\\textFiles\\" + fileName);*/
        Path path = Paths.get("C:\\Users\\Piork\\IdeaProjects\\BooksLibrary\\src\\textFiles\\" + fileName);

        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(path, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public void listAllUsersWithTheirBooks() throws IOException {
        /*Path pathToUsersFile = Paths.get("C:\\Users\\PIORKOWS\\IdeaProjects\\BooksLibrary\\src\\textFiles\\" + fileName);*/
        Path pathToUsersFile = Paths.get("C:\\Users\\Piork\\IdeaProjects\\BooksLibrary\\src\\textFiles\\users.txt");
      /*  Path pathToUsersFile = Paths.get("C:\\Users\\PIORKOWS\\IdeaProjects\\BooksLibrary\\src\\textFiles\\users.txt");*/
        /*Path pathToBooksFile = Paths.get("C:\\Users\\PIORKOWS\\IdeaProjects\\BooksLibrary\\src\\textFiles\\books.txt");*/
        Path pathToBooksFile = Paths.get("C:\\Users\\Piork\\IdeaProjects\\BooksLibrary\\src\\textFiles\\books.txt");
        String fileName = "C:\\Users\\PIORKOWS\\IdeaProjects\\BooksLibrary\\src\\textFiles\\users.txt";
        /*String fileName = "C:\\Users\\Piork\\IdeaProjects\\BooksLibrary\\src\\textFiles\\users.txt";*/
        String[] userToBeMatchedWithBooks={};
        String[] firstBookMatchedToAUser={};
        String[] secondBookMatchedToAUser={};
        String[] thirdBookMatchedToAUser={};
        List<String> allLinesInUsersFile = Files.readAllLines(pathToUsersFile);
        for (String oneLineInUsersFile: allLinesInUsersFile){
            /*System.out.println(oneLineInUsersFile);*/
            String[] lineSplitUsersFile = oneLineInUsersFile.split(Pattern.quote("|"));
            /*System.out.println(Arrays.toString(lineSplitUsersFile) + " here linesplit");*/
            String userID = lineSplitUsersFile[0];
            String userFirstName = lineSplitUsersFile[1];
            String userLasttName = lineSplitUsersFile[2];
            /*String userTotalBooksRented = lineSplitUsersFile[3];*/
            String userFirstBookRentedID = lineSplitUsersFile[4];
            String userSecondBookRentedID = lineSplitUsersFile[5];
            String userThirdBookRentedID = lineSplitUsersFile[6];

            List<String> allLinesInBooksFile = Files.readAllLines(pathToBooksFile);
            for (String oneLineInBooksFile: allLinesInBooksFile){
                /*System.out.println(oneLineInBooksFile);*/
                String[] lineSplitBooksFile = oneLineInBooksFile.split(Pattern.quote("|"));
                String bookID = lineSplitBooksFile[0];
                String bookTitle = lineSplitBooksFile[1];
                String bookAuthor = lineSplitBooksFile[2];
                String bookPublishingYear = lineSplitBooksFile[3];
                String bookISBN = lineSplitBooksFile[4];
                String bookIsRented = lineSplitBooksFile[5];

                if (Objects.equals(bookIsRented, "true")){
                    if (Objects.equals(userFirstBookRentedID, bookID)){
                        firstBookMatchedToAUser = lineSplitBooksFile;
                        /*System.out.println(oneLineInBooksFile);*/
                    }
                }
                if (Objects.equals(bookIsRented, "true")){
                    if (Objects.equals(userSecondBookRentedID, bookID)){
                        secondBookMatchedToAUser = lineSplitBooksFile;
                        /*System.out.println(oneLineInBooksFile);*/
                    }
                }
                if (Objects.equals(bookIsRented, "true")){
                    if (Objects.equals(userThirdBookRentedID, bookID)){
                        thirdBookMatchedToAUser = lineSplitBooksFile;
                        /*System.out.println(oneLineInBooksFile);*/
                    }
                }
            }
            /*userToBeMatchedWithBooks = lineSplitUsersFile;*/


           /* System.out.println(firstBookMatchedToAUser[1]);
            System.out.println(firstBookMatchedToAUser[2]);
            System.out.println(firstBookMatchedToAUser[3]);
            System.out.println(firstBookMatchedToAUser[4]);*/

            if (firstBookMatchedToAUser.length != 0) {
                System.out.println("\nUser: " + userFirstName + " " + userLasttName);
                System.out.println("Has the following books borrowed:" );
                if (firstBookMatchedToAUser[1] != null) {
                    System.out.println("Title: " + firstBookMatchedToAUser[1] + ", Author: " + firstBookMatchedToAUser[2] + ", Published in: " + firstBookMatchedToAUser[3]
                + " with ISBN: " + firstBookMatchedToAUser[4]);
                }
                if (secondBookMatchedToAUser[1] != null) {
                    System.out.println("Title: " + secondBookMatchedToAUser[1] + ", Author: " + secondBookMatchedToAUser[2] + ", Published in: " + secondBookMatchedToAUser[3]
                + " with ISBN: " + secondBookMatchedToAUser[4]);
                }
                if (thirdBookMatchedToAUser[1] != null) {
                    System.out.println("Title: " + thirdBookMatchedToAUser[1] + ", Author: " + thirdBookMatchedToAUser[2] + ", Published in: " + thirdBookMatchedToAUser[3]
                + " with ISBN: " + thirdBookMatchedToAUser[4]);
                }
            }


            firstBookMatchedToAUser = new String[6];
            secondBookMatchedToAUser = new String[6];
            thirdBookMatchedToAUser = new String[6];

        }

    }
}
