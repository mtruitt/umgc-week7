/**
 *
 * Author: Mark Truitt
 * Class: CMIS 242 - Week 3
 * Date: 2023/01/28
 *
 */
public class Studio extends Movies {
    private String studio;

    public Studio(String title, String year, String rating, String runtime, String actors, String studio) {
        super(title, year, rating, runtime, actors);
        this.studio = studio;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}