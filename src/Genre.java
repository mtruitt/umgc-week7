/**
 *
 * Author: Mark Truitt
 * Class: CMIS 242 - Week 6
 * Date: 2023/02/17
 *
 */
public class Genre extends Movies {

    private static String genre;
    private static Type type;

    public enum Type {
        ACTION("Action"),
        DRAMA("Drama"),
        COMEDY("Comedy"),
        HORROR("Horror"),
        THRILLER("Thriller"),
        SCI_FI("Sci-Fi"),
        ROMANCE("Romance"),
        MUSICAL("Musical");

        private final String displayName;

        Type(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public static Type fromString(String genre) {
            for (Type type : Type.values()) {
                if (genre.equalsIgnoreCase(type.getDisplayName())) {
                    return type;
                }
            }
            return null;
        }
    }

    public Genre(String title, String year, String rating, String runtime, String actors, String genre) {
        super(title, year, rating, runtime, actors);
        Genre.genre = genre;
    }

    public static void displayGenres() {
        System.out.println("Available genres: ");
        for (Type type : Type.values()) {
            System.out.println(type.getDisplayName());
        }
    }

    public static String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        Genre.genre = genre;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void display() {
        System.out.println(Movies.CYAN_BOLD + "Title: " + Movies.RESET + super.getTitle());
        System.out.println(Movies.CYAN_BOLD + "Type: " + Movies.RESET + getGenre());
        System.out.println(Movies.CYAN_BOLD + "Year: " + Movies.RESET + super.getYear());
        System.out.println(Movies.CYAN_BOLD + "Rating: " + Movies.RESET + super.getRating());
        System.out.println(Movies.CYAN_BOLD + "Runtime: " + Movies.RESET + super.getRuntime());
        System.out.println(Movies.CYAN_BOLD + "Actions: " + Movies.RESET + super.getActors());
    }
}