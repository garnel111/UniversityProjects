package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author marco
 */
public class Administrator {

    /**
     * Id, atribute of administrator.
     */
    private long idAdministrator;

    /**
     * Name, atribute of administrator.
     */
    private String name;
    /**
     * Email, atribute of administrator.
     */
    private String email;
    /**
     * Password, atribute of administrator.
     */
    private String password;

    /**
     * Empty contructor
     */
    public Administrator() {
    }

    /**
     * Constructor: receives a string with the administrator email and a string
     * with password.
     *
     * @param email
     * @param password
     */
    public Administrator(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     ** Complete constructor: receives a long with id, a string with a name, a
     * string with the administrator email, a string with password and assigns
     * it to the administrator attributes.
     *
     * @param name
     * @param email
     * @param password
     */
    public Administrator(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Method that returns the id of an administrator
     *
     * @return idAdministrator
     */
    public long getIdAdministrator() {
        return idAdministrator;
    }

    /**
     * Method that returns the username of an administrator
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method that returns the email of an administrator
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method that returns the password of an administrator
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set idAdministrator to instance.
     *
     * @param idAdministrator
     */
    public void setIdAdministrator(long idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    /**
     * Set name to instance.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.idAdministrator ^ (this.idAdministrator >>> 32));
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.password);
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
        final Administrator other = (Administrator) obj;
        if (this.idAdministrator != other.idAdministrator) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

}
