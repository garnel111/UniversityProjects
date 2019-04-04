package lapr.project.model;

import lapr.project.controller.LoginController;
import org.apache.commons.codec.binary.Base64;
import java.util.Objects;

/**
 *
 * @author marco
 */
public class User {

    /**
     * Id, atribute of user.
     */
    private long idUser;
    /**
     * Username, atribute of user.
     */
    private String username;
    /**
     * Email, atribute of user.
     */
    private String email;
    /**
     * Password, atribute of user.
     */
    private String password;
    /**
     * Credit card number, atribute of user.
     */
    private String cardNumber;
    /**
     * Height, atribute of user.
     */
    private double height;
    /**
     * Weight, atribute of user.
     */
    private double weight;
    /**
     * Points, atribute of user.
     */
    private long points;
    /**
     * Initial cost, atribute of user.
     */
    private double initialCost;
    private double mass;

    /**
     * /**
     * Complete constructor: receives a long with id, a string with a username,
     * a string with the user email, a string with password, a string with
     * credit card number, a double whith height, a double with weight and a
     * double with initialCost and assigns it to the user attributes.
     *
     * @param username
     * @param email
     * @param password
     * @param cardNumber
     * @param height
     * @param weight
     * @param points
     * @param initialCost
     */
    public User(String username, String email, String password,
            String cardNumber, double height, double weight, long points, double initialCost) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.cardNumber = cardNumber;
        this.height = height;
        this.weight = weight;
        this.points = points;
        this.initialCost = initialCost;
    }

    /**
     * Constructor: receives a string with the user email and a string with
     * password.
     *
     * @param email
     * @param password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Empty contructor
     */
    public User() {

    }

    /**
     * Method that returns the id of an user
     *
     * @return idUser
     */
    public long getIdUser() {
        return idUser;
    }

    /**
     * Method that returns the username of an user
     *
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Method that returns the email of an user
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Method that returns the password of an user
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method that returns the cardNumber of an user
     *
     * @return cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Method that returns the height of an user
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Method that returns the weight of an user
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Method that returns the points of an user
     *
     * @return points
     */
    public long getPoints() {
        return points;
    }

    /**
     * Method that returns the initial cost of an user
     *
     * @return initialCost
     */
    public double getInitialCost() {
        return initialCost;
    }

    /**
     * Set idUser to instance.
     *
     * @param idUser
     */
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    /**
     * Set username to instance.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set email to instance.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set password to instance.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set cardNumber to instance.
     *
     * @param cardNumber
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Set height to instance.
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Set weight to instance.
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Set points to instance.
     *
     * @param points
     */
    public void setPoints(long points) {
        this.points = points;
    }

    /**
     * Set initialCost to instance.
     *
     * @param initialCost
     */
    public void setInitialCost(double initialCost) {
        this.initialCost = initialCost;
    }

    /**
     * Encrypt string on base 64 (Encoder)
     *
     * @param password
     * @return string encrypted
     */
    public static String encryptBase64Encoder(String password) {
        return new Base64().encodeToString(password.getBytes());
    }

    /**
     * Decrypt string on base 64 (Decoder)
     *
     * @param password
     * @return string decrypted
     */
    public static String decryptBase64Decoder(String password) {
        return new String(new Base64().decode(password));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.idUser ^ (this.idUser >>> 32));
        hash = 89 * hash + Objects.hashCode(this.username);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.cardNumber);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 89 * hash + (int) (this.points ^ (this.points >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.initialCost) ^ (Double.doubleToLongBits(this.initialCost) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (this.points != other.points) {
            return false;
        }
        if (Double.doubleToLongBits(this.initialCost) != Double.doubleToLongBits(other.initialCost)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.cardNumber, other.cardNumber);
    }



    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", username=" + username + ", email=" + email + ", password=" + password + ", cardNumber=" + cardNumber + ", height=" + height + ", weight=" + weight + ", points=" + points + ", initialCost=" + initialCost + '}';
    }


    public double getMass(User user) {
        LoginController lCtrl = new LoginController();
       return lCtrl.getUserDB().getUserMass(user.getUsername());
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
