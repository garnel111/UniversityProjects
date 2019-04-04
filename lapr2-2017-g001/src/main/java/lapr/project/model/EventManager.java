/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

/**
 *
 * @author MariaJoão
 */
public class EventManager {
    
    private User eventManager;
    
    public EventManager(User eventManager) {
        this.eventManager = eventManager;
    }
    
    public EventManager() {
        this.eventManager = new User();
    }
    
    /**
     * @return the eventManager
     */
    public User getEventManager() {
        return eventManager;
    }
    
    /**
     * @param eventManager the eventManager to set
     */
    public void setEventManager(User eventManager) {
        this.eventManager = eventManager;
    }
}
