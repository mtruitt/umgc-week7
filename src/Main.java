/**
 *
 * Author: Mark Truitt
 * Class: CMIS 242 - Week 3
 * Date: 2023/01/28
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // create a scanner object for user input
        Scanner sc = new Scanner(System.in);

        // attributes
        String title;
        String year;
        String rating;
        String runtime;
        String actors;
        String genre;
        String studio;
        boolean isCorrect;

        // loop until user enters correct information
        do {
            // loop until user enters a non-blank title
            do {
                System.out.print("Enter movie title: ");
                title = sc.nextLine();
                if (title.isBlank()) {
                    System.out.println("Title cannot be blank. Please enter a valid title.");
                }
            } while (title.isBlank());

            // get the rest of the information from the user
            System.out.print("Enter year: ");
            year = sc.nextLine();
            System.out.print("Enter rating: ");
            rating = sc.nextLine();
            System.out.print("Enter runtime (minutes): ");
            runtime = sc.nextLine();
            System.out.print("Enter actors: ");
            actors = sc.nextLine();

            // Genre subclass
            System.out.print("\n");
            Genre.displayGenres();
            System.out.print("\n");
            System.out.print("Enter genre: ");
            genre = sc.nextLine();
            Genre movieGenre = new Genre(title, year, rating, runtime, actors, genre);

            // Studio subclass
            System.out.print("Enter the studio: ");
            studio = sc.nextLine();
            Studio movie = new Studio(title, year, rating, runtime, actors, studio);

            // print the information entered by the user
            System.out.println("You entered:");
            System.out.println(Movies.CYAN_BOLD + "Title: " + Movies.RESET + movieGenre.getTitle());
            System.out.println(Movies.CYAN_BOLD + "Year: " + Movies.RESET + movieGenre.getYear());
            System.out.println(Movies.CYAN_BOLD + "Rating: " + Movies.RESET + movieGenre.getRating());
            System.out.println(Movies.CYAN_BOLD + "Runtime: " + Movies.RESET + movieGenre.getRuntime());
            System.out.println(Movies.CYAN_BOLD + "Actors: " + Movies.RESET + movieGenre.getActors());
            System.out.println(Movies.CYAN_BOLD + "Genre: " + Movies.RESET + Genre.getGenre()); // Gets Genre
            System.out.println(Movies.CYAN_BOLD + "Studio: " + Movies.RESET + movie.getStudio()); // Gets Studio
            System.out.print(Movies.RED_BOLD + "Is this information correct? (y/n) " + Movies.RESET );
            String confirm = sc.nextLine();
            isCorrect = confirm.equalsIgnoreCase("y");
        } while (!isCorrect);
        // close scanner
        sc.close();

        // Movie display method
        System.out.println("\n");
        System.out.println("New display method to demonstrate overriding. - From Movies.java");
        Movies singleMovie = new Movies("The Phantom Menace", "1999", "PG", "133", "Liam Neeson");
        singleMovie.display();

        // Overriding the display method in Genre.java
        System.out.println("\n");
        System.out.println("Overriding the display method to output the addition with genre included - From Genre.java");
        Movies displayMovie = new Genre("The Phantom Menace", "1999", "PG", "133", "Liam Neeson, Natalie Portman, Jake Lloyd", "Action");
        displayMovie.display();
        System.out.println("\n\n");

        // Demonstrating Overloading
        System.out.println("Overloading demonstration");
        singleMovie.setActor("Sponge Bob");
        singleMovie.display();

        System.out.println("\n");
        String[] newActors = {"Liam Neeson, Natalie Portman, Jake Lloyd"};
        singleMovie.setActor(newActors);
        singleMovie.display();
        System.out.println("\n\n");

        // Write to CSV
        FileWriter csvWriter = new FileWriter("movies.csv", true);
        csvWriter.append(title);
        csvWriter.append(",");
        csvWriter.append(year);
        csvWriter.append(",");
        csvWriter.append(rating);
        csvWriter.append(",");
        csvWriter.append(runtime);
        csvWriter.append(",");
        csvWriter.append(genre);
        csvWriter.append(",");
        csvWriter.append(studio);
        csvWriter.append(",");
        csvWriter.append(actors);
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();

        // Read from CSV
        BufferedReader csvReader = new BufferedReader(new FileReader("movies.csv"));
        String row;
        System.out.printf("\033[1;34m%-20s %-10s %-10s %-10s %-10s %-20s %-30s \033[m\n", "Title", "Year", "Rating", "Runtime", "Genre", "Studio", "Actors");
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",", -1);
            System.out.printf("%-20s %-10s %-10s %-10s %-10s %-20s %-30s\n", data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
            System.out.println("-----------------------------------------------------------------------------------------");
        }
        csvReader.close();
    }
}