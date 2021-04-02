import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TreeMap;

/**
 *  Goal class
 *  Written Using Java 15
 *  @author Emily Wirth
 *  @version 1.0
 *  @since 2021-03-22
 */
public class Goal
{
    /**
     * Goal class
     * Main class in charge of the Goal object
     * in charge of having all the getters and setters for the Goal Object
     */
    private String name;
    private String description;
    private String categoryName;
    private boolean isShort;
    private boolean isGood;
    private String start;
    private boolean completed;
    private String end;
    Habit habit1 = new Habit(1,"TBD","TBD");

    Goal()
    {
        name = "TBD";
        description = "TBD";
        categoryName = "TBD";
        isShort = false;
        isGood = false;
        start = null;
        completed = false;
        end = null;

    }
    //TODO Temporary for testing, will be removed
    Goal(String name){
        this.name = name;
        description = "TBD";
        categoryName = "TBD";
        isShort = false;
        isGood = false;
        start = null;
        completed = false;
        end = null;
    }
    //Getter methods

    /**
     * Get name of goal
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get Description of the Goal
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the category the Goal belongs too
     * @return String category Name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Get whether the Goal is short or long term
     * @return false if long true if short
     */
    public boolean getShortLong() {
        return isShort;
    }

    /**
     * Get whether the goal is the creation of a good habit or a breaking of a bad habit
     * @return false if bad true if good
     */
    public boolean getGoodBad() {
        return isGood;
    }

    /**
     * Gets the start String of the Goal
     * @return String object
     */
    public String getStart() {
        return start;
    }

    /**
     * Get whether the goal is completed or not
     * @return True if complete false if incomplete
     */
    public boolean getCompleted()
    {
        return completed;
    }

    /**
     * Returns the end String of the object. Can be Null if the goal does not end.
     * @return end
     */
    public String getEnd() {
        return end;
    }
    //Setter Methods

    /**
     * Sets the Goals name to param name
     * @param name name of goal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets Goals description to param description
     * @param description description of goal
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets Goals categoryName to param categoryName
     * @param categoryName category name of the goal
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Sets Goals isShort to short or long
     * @param aShort  either short or long term short is true and long is false
     */
    public void setShortLong(boolean aShort) {
        isShort = aShort;
    }

    /**
     * Sets Goals isGood to good or bad
     * @param gb sets whether the goal is good or bad good is true and bad is false
     */
    public void setGoodBad(boolean gb) {
        isGood = gb;
    }

    /**
     * Sets the start String of Goal to start
     * @param start string date formatted "yyyy-mm-dd"
     */
    public void setStart(String start) {
        this.start = start;
        habit1.setLastCheckIn(start);
    }

    /**
     * Sets completed status to true or false
     * @param completed sets the goal to be complete or not
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Sets the End String of the goal
     * @param end String
     */
    public void setEnd(String end) {
        this.end = end;

    }

    /**
     * Sets message to value
     * @param mess string going over what the habit is checking
     */
    public void setMessage(String mess)
    {
        habit1.setMessage(mess);
    }

    /**
     * sets the frequency in which the check in will be done
     * @param day int value of days between checkins
     */
    public void setFrequency(int day)
    {
        habit1.setFrequency(day);
    }

    /**
     * to string method for debugging
     * @return string version of important fields in both goal and habit
     */
    public String toString()
    {
        return "Name: " + name + " description: " + description + " category: " + categoryName + " start: " + start + " end: " + end + " " + habit1.toString();
    }

    /**
     * Gets the next check in date from habit and calculates if it ias after end date if it is marks goal as complete
     * @return string version of date for next check in
     */
    public String getNextCheck()
    {
        String nextCheck = habit1.getNextCheckIn();
        if(end == null)
        {
            return nextCheck;
        }
        else
        {

            //Specifying date format that matches the given date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Calendar endDay = Calendar.getInstance();
            try{
                c.setTime(sdf.parse(nextCheck));
                endDay.setTime(sdf.parse(end));
            }catch(ParseException e){
                e.printStackTrace();
            }

            if(c.after(endDay))
            {
                completed = true;
                return "Congratulations for completing a Goal!";
            }
            else
            {
                return nextCheck;
            }

        }

    }




}