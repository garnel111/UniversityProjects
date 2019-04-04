/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;


import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author andre
 */
public class ApplicationRegisterTest {
    
    public ApplicationRegisterTest() {
    }

    /**
     * Test of addApplication method, of class ApplicationRegister.
     */
    @Test
    public void testAddApplication() {
        System.out.println("addApplication");
        
        Application app1 = new Application("description");
        
        Keyword keyword1 = new Keyword("keyword1");
        Keyword keyword2 = new Keyword("keyword2");
        Keyword keyword3 = new Keyword("keyword3");
        Keyword keyword4 = new Keyword("keyword4");
        
        List<Keyword> listKey = new ArrayList<>();
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        app1.setKeywordList(listKey);
        
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        
        Workshop w1 = new Workshop("description w1", 3, necessaryEquip);
        w1.setWantToAttend(wantToAttend);
        Workshop w2 = new Workshop("description w2", 2, necessaryEquip);
        w2.setWantToAttend(wantToAttend);        
        List<Workshop> listWo = new ArrayList<>();
        listWo.add(w2);
        listWo.add(w1);
        app1.setWorkshopList(listWo);
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        app1.setBoothArea(5);
        app1.setState(ApplicationState.CREATED);
        app1.setNameOfCompany("nameOfCompany");
        app1.setDescription("description");
        app1.setUserThatSubmited(user);
        app1.setListReview(listRev);
        
        List<Application> listApp = new ArrayList<>();
        listApp.add(app1);
        
        ApplicationRegister instance = new ApplicationRegister(listApp);
        boolean result = instance.addApplication(app1);
        assertTrue(result);
    }

    /**
     * Test of getApplicationList method, of class ApplicationRegister.
     */
    @Test
    public void testSetAndGetApplicationList() {
        System.out.println("set/getApplicationList");
        ApplicationRegister instance = new ApplicationRegister();
        
        Application app1 = new Application("description");
        Application app2 = new Application("description2");
        
        Keyword keyword1 = new Keyword("keyword1");
        Keyword keyword2 = new Keyword("keyword2");
        Keyword keyword3 = new Keyword("keyword3");
        Keyword keyword4 = new Keyword("keyword4");
        
        List<Keyword> listKey = new ArrayList<>();
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        app1.setKeywordList(listKey);
        app2.setKeywordList(listKey);
        
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        
        Workshop w1 = new Workshop("description w1", 3, necessaryEquip);
        w1.setWantToAttend(wantToAttend);
        Workshop w2 = new Workshop("description w2", 2, necessaryEquip);
        w2.setWantToAttend(wantToAttend);        
        List<Workshop> listWo = new ArrayList<>();
        listWo.add(w2);
        listWo.add(w1);
        app1.setWorkshopList(listWo);
        app2.setWorkshopList(listWo);
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        app1.setBoothArea(5);
        app1.setState(ApplicationState.CREATED);
        app1.setNameOfCompany("nameOfCompany");
        app1.setDescription("description");
        app1.setUserThatSubmited(user);
        app1.setListReview(listRev);
        
        app2.setBoothArea(5);
        app2.setState(ApplicationState.CREATED);
        app2.setNameOfCompany("nameOfCompany");
        app2.setDescription("description");
        app2.setUserThatSubmited(user);
        app2.setListReview(listRev);
        
        List<Application> expResult = new ArrayList<>();
        expResult.add(app1);
        expResult.add(app2);
        instance.setApplicationList(expResult);
        List<Application> result = instance.getApplicationList();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class ApplicationRegister.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        ApplicationRegister instanc = new ApplicationRegister();
        boolean expResult = false;
        boolean result = instanc.equals(o);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of equals method, of class ApplicationRegister.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        
        Application app1 = new Application("description");
        Application app2 = new Application("description2");
        
        Keyword keyword1 = new Keyword("keyword1");
        Keyword keyword2 = new Keyword("keyword2");
        Keyword keyword3 = new Keyword("keyword3");
        Keyword keyword4 = new Keyword("keyword4");
        
        List<Keyword> listKey = new ArrayList<>();
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        app1.setKeywordList(listKey);
        app2.setKeywordList(listKey);
        
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        
        Workshop w1 = new Workshop("description w1", 3, necessaryEquip);
        w1.setWantToAttend(wantToAttend);
        Workshop w2 = new Workshop("description w2", 2, necessaryEquip);
        w2.setWantToAttend(wantToAttend);        
        List<Workshop> listWo = new ArrayList<>();
        listWo.add(w2);
        listWo.add(w1);
        app1.setWorkshopList(listWo);
        app2.setWorkshopList(listWo);
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        app1.setBoothArea(5);
        app1.setState(ApplicationState.CREATED);
        app1.setNameOfCompany("nameOfCompany");
        app1.setDescription("description");
        app1.setUserThatSubmited(user);
        app1.setListReview(listRev);
        
        app2.setBoothArea(5);
        app2.setState(ApplicationState.CREATED);
        app2.setNameOfCompany("nameOfCompany");
        app2.setDescription("description");
        app2.setUserThatSubmited(user);
        app2.setListReview(listRev);
        
        ApplicationRegister instance2 = new ApplicationRegister();
        instance2.addApplication(app1);
        Object o = instance2;
        
        ApplicationRegister instance = new ApplicationRegister();
        instance.addApplication(app1);
        
        boolean result = instance.equals(o);
        assertTrue(result);
    }
    
    /**
     * Test of equals method, of class ApplicationRegister.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals3");
        
        Application app1 = new Application("description");
        Application app2 = new Application("description2");
        
        Keyword keyword1 = new Keyword("keyword1");
        Keyword keyword2 = new Keyword("keyword2");
        Keyword keyword3 = new Keyword("keyword3");
        Keyword keyword4 = new Keyword("keyword4");
        
        List<Keyword> listKey = new ArrayList<>();
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        app1.setKeywordList(listKey);
        app2.setKeywordList(listKey);
        
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        
        Workshop w1 = new Workshop("description w1", 3, necessaryEquip);
        w1.setWantToAttend(wantToAttend);
        Workshop w2 = new Workshop("description w2", 2, necessaryEquip);
        w2.setWantToAttend(wantToAttend);        
        List<Workshop> listWo = new ArrayList<>();
        listWo.add(w2);
        listWo.add(w1);
        app1.setWorkshopList(listWo);
        app2.setWorkshopList(listWo);
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        app1.setBoothArea(5);
        app1.setState(ApplicationState.IN_EVALUALTION);
        app1.setNameOfCompany("nameOfCompany");
        app1.setDescription("description");
        app1.setUserThatSubmited(user);
        app1.setListReview(listRev);
        
        app2.setBoothArea(5);
        app2.setState(ApplicationState.CREATED);
        app2.setNameOfCompany("nameOfCompany2");
        app2.setDescription("description2");
        app2.setUserThatSubmited(user);
        app2.setListReview(listRev);
        
        ApplicationRegister instance2 = new ApplicationRegister();
        instance2.addApplication(app2);
        Object o = instance2;
        
        ApplicationRegister instance = new ApplicationRegister();
        instance.addApplication(app1);
        
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class ApplicationRegister.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals4");
        
        Application app1 = new Application("description");
        
        Keyword keyword1 = new Keyword("keyword1");
        Keyword keyword2 = new Keyword("keyword2");
        Keyword keyword3 = new Keyword("keyword3");
        Keyword keyword4 = new Keyword("keyword4");
        
        List<Keyword> listKey = new ArrayList<>();
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        app1.setKeywordList(listKey);
        
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        
        Workshop w1 = new Workshop("description w1", 3, necessaryEquip);
        w1.setWantToAttend(wantToAttend);
        Workshop w2 = new Workshop("description w2", 2, necessaryEquip);
        w2.setWantToAttend(wantToAttend);        
        List<Workshop> listWo = new ArrayList<>();
        listWo.add(w2);
        listWo.add(w1);
        app1.setWorkshopList(listWo);
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        app1.setBoothArea(5);
        app1.setState(ApplicationState.IN_EVALUALTION);
        app1.setNameOfCompany("nameOfCompany");
        app1.setDescription("description");
        app1.setUserThatSubmited(user);
        app1.setListReview(listRev);
        
        Stand st = new Stand("Stand 1", 20.0);
        
        Object o = st;
        
        ApplicationRegister instance = new ApplicationRegister();
        instance.addApplication(app1);
        
        boolean result = instance.equals(o);
        assertFalse(result);
    }

    /**
     * Test of hashCode method, of class ApplicationRegister.
     */
    
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        
        Application app1 = new Application("description");
        
        Keyword keyword1 = new Keyword("keyword1");
        Keyword keyword2 = new Keyword("keyword2");
        Keyword keyword3 = new Keyword("keyword3");
        Keyword keyword4 = new Keyword("keyword4");
        
        List<Keyword> listKey = new ArrayList<>();
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        app1.setKeywordList(listKey);
        
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        
        Workshop w1 = new Workshop("description w1", 3, necessaryEquip);
        w1.setWantToAttend(wantToAttend);
        Workshop w2 = new Workshop("description w2", 2, necessaryEquip);
        w2.setWantToAttend(wantToAttend);        
        List<Workshop> listWo = new ArrayList<>();
        listWo.add(w2);
        listWo.add(w1);
        app1.setWorkshopList(listWo);
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        app1.setBoothArea(5);
        app1.setState(ApplicationState.IN_EVALUALTION);
        app1.setNameOfCompany("nameOfCompany");
        app1.setDescription("description");
        app1.setUserThatSubmited(user);
        app1.setListReview(listRev);
        
        ApplicationRegister instance = new ApplicationRegister();
        instance.addApplication(app1);      
        
        int expResult = 870953765;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    
}
