package lapr.project.controller;

import lapr.project.data.ParkDB;
import lapr.project.data.UserDB;
import lapr.project.model.User;

/**
 *
 * @author marco
 */
public class UserController {

    //Static variables 
    private static final long CHARACTER_NUMBER = 6;

    UserDB userDataBase;
    ParkDB parkDatabase;

    /**
     * An user.
     */
    private User user;

    /**
     * Empty constructor
     */
    public UserController() {
        userDataBase = new UserDB();
        user = new User();
        parkDatabase = new ParkDB();
    }

    /**
     * Complete contructor: it creates an UserRegistrationController object with
     * the user.
     *
     * @param user
     */
    public UserController(User user) {
        this.user = user;
        parkDatabase = new ParkDB();
    }

    /**
     * Method that creates a new instance of User and add to data base.
     *
     * @param username
     * @param email
     * @param password
     * @param cardNumber
     * @param height
     * @param weight
     * @param points
     * @param initialCost
     * @return true
     */
    public boolean newUser(String username, String email, String password,
            String cardNumber, double height, double weight,
            long points, double initialCost) {

        if (!validateUser(email)) {
            User nUser = new User(username, email, password, cardNumber,
                    height, weight, points, initialCost);
            return userDataBase.newUser(nUser);
        }
        return false;
    }

    /**
     * Method that returns the user.
     *
     * @param email
     * @return user
     */
    public User getUserByEmail(String email) {
        user = userDataBase.getUserByEmail(email);
         return user;
    }

    /**
     * Set userDataBase to instance.
     *
     * @param userDataBase
     */
    public void setUserDataBase(UserDB userDataBase) {
        this.userDataBase = userDataBase;
    }

    public void setParkDatabase(ParkDB parkDatabase) {
        this.parkDatabase = parkDatabase;
    }

    /**
     * Method that verifies if the user exists through your email
     *
     * @param email
     * @return true case if user exists or false in case of not exists
     */
    public boolean validateUser(String email) {
        boolean validEmail = true;
        if (userDataBase.getUserByEmail(email) != null) {
            return validEmail;
        }
        return false;
    }

    /**
     * Method that verifies if a email follows the minimun request: verifies if
     * it contains "@" and ".".
     *
     * @param email
     * @return true case it follows the request or false in case of not
     * following.
     */
    public boolean validateEmail(String email) {
        boolean validEmail = true;
        if (email.contains("@") && email.contains(".")) {
            return validEmail;
        }
        return false;
    }

    //public boolean 
    /**
     * Method that verifies if a password follows the minimun request: verifies
     * if it has six or more characters.
     *
     * @param password
     * @return true case it follows the request or false in case of not
     * following.
     */
    public boolean validatePassword(String password) {
        boolean validPassword = true;
        if (password.length() >= CHARACTER_NUMBER) {
            return validPassword;
        }
        return false;
    }

    public long requestFreeSlot(String destinationParkName, String bicycleTYpe) {

        long getfreeslot = parkDatabase.getFreeSlot(destinationParkName, bicycleTYpe);
        return getfreeslot;
    }
}
