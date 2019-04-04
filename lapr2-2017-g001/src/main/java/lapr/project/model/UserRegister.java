/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class UserRegister {

    private List<User> userList;

    /**
     * Constructor
     *
     * @param userList List of user to be considered
     */
    public UserRegister(List<User> userList) {
        this.userList = userList;
    }

    /**
     * Constructor
     */
    public UserRegister() {
        this.userList = new ArrayList<>();
    }

    /**
     * @return the userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     *
     * @param user to be added
     * @return boolean value according to the user add
     */
    public boolean addUser(User user) {
        if (userExists(user)) {
            return false;
        } else {
            return this.userList.add(user);
        }
    }

    /**
     * Method to check if the user already exists
     *
     * @param user User to be validated
     * @return boolean value relative to the user existence
     */
    public boolean userExists(User user) {
        //email e username são únicos no sistema
        for (User temp : this.userList) {
            if (temp.getUsername().equals(user.getUsername())) {
                return true;
            }
            if (temp.getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to get Available Users without organisers
     *
     * @param organisers list of organisers to be removed
     * @return List of users without organisers
     */
    public List<User> getAvailableUsersWithoutOrganisers(List<Organiser> organisers) {
        List<User> usersExhibitionCentreCopyWithoutOrganisers = Utils.getCopia(this.userList);
        List<User> usersToRemove = new ArrayList<>();
        for (Organiser org : organisers) {
            for (User user : usersExhibitionCentreCopyWithoutOrganisers) {
                if (user.equals(org.getOrganiser())) {
                    usersToRemove.add(user);
                }
            }
        }
        usersExhibitionCentreCopyWithoutOrganisers.removeAll(usersToRemove);
        return usersExhibitionCentreCopyWithoutOrganisers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.userList);
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
        final UserRegister other = (UserRegister) obj;
        return Objects.equals(this.userList, other.userList);
    }

    /**
     * Method to get available Users without Staff Members
     *
     * @param staffList list of staff menmbers to be removed
     * @param filterUserRegisterByNoOrganiserEventSelectedCopy list of Users
     * @return list without staff members
     */
    public List<User> getAvailableUsersWithoutStaffMember(List<StaffMember> staffList, List<User> filterUserRegisterByNoOrganiserEventSelectedCopy) {
        List<User> filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff = filterUserRegisterByNoOrganiserEventSelectedCopy;
        List<User> usersToRemove = new ArrayList<>();
        for (StaffMember staffMember : staffList) {
            for (User user : filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff) {
                if (user.equals(staffMember.getStaff()) || !user.getRole().equals(Role.EMPLOYEE)) {
                    usersToRemove.add(user);
                }
            }
        }
        filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff.removeAll(usersToRemove);
        return filterUserRegisterByNoOrganiserEventSelectedAndNoEventStaff;
    }
}
