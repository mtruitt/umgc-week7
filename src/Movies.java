/**
 *
 * Author: Mark Truitt
 * Class: CMIS 242 - Week 6
 * Date: 2023/02/17
 *
 */
class Movies {

    private String title;
    private String year;
    private String rating;
    private String runtime;
    private String actors;
    private Genre genre;

    // Adding Colors for read ability
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String CYAN_BOLD = "\033[1;36m";   // Bold CYAN
    public static final String RED_BOLD = "\033[1;31m";    // Bold RED

    public Movies(String title, String year, String rating, String runtime, String actors) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.runtime = runtime;
        this.actors = actors;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws EmptyTitleException {
        if (title.isEmpty()) {
            throw new EmptyTitleException("Title cannot be empty");
        }
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getActors() {
        return actors;
    }

    public void setActor(String actors) {
        this.actors = actors;
    }

    // Method to set multiple actors
    public void setActor(String[] actors) {
        this.actors = String.join(", ", actors);
    }

    public void display() {
        System.out.println(Movies.CYAN_BOLD + "Title: " + Movies.RESET + getTitle());
        System.out.println(Movies.CYAN_BOLD + "Year: " + Movies.RESET + getYear());
        System.out.println(Movies.CYAN_BOLD + "Rating: " + Movies.RESET + getRating());
        System.out.println(Movies.CYAN_BOLD + "Runtime: " + Movies.RESET + getRuntime());
        System.out.println(Movies.CYAN_BOLD + "Actions: " + Movies.RESET + getActors());
    }

}