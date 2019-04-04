package lapr.project.model;

import lapr.project.utils.StringUtil;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Class to demonstrate a Candidatura simple example.
 *
 * @author Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
public class ApplicationTest {

    /**
     * StringUtil variable to access utils for Strings.
     */
    private StringUtil stringUtil = new StringUtil();

    /**
     * Get OS independent line break.
     *
     * @return OS independent line break "%n".
     */
    private String getLineBreak() {
        if (stringUtil == null) {
            stringUtil = new StringUtil();
        }
        return stringUtil.getLineBreak();
    }

    @Test
    public void ensureAddKeywordIsWorking() throws Exception {
        List<Keyword> expectedKeywordList = new ArrayList<>();
        expectedKeywordList.add(new Keyword("Doors"));

        Application candidatura = new Application("MyCandidatura", new ArrayList<>());
        candidatura.addKeyword(new Keyword("Doors"));

        List<Keyword> resultList = candidatura.getKeywordList();

        assertArrayEquals(expectedKeywordList.toArray(), resultList.toArray());

    }

    @Test
    public void ensureXMLElementExportToStringIsValid() throws Exception {
        String expected = "<application>" + getLineBreak() +
                "<description>MyApplication</description>" + getLineBreak() +
                "<keywords>" + getLineBreak() +
                "<keyword>" + getLineBreak() +
                "<value>Doors</value>" + getLineBreak() +
                "</keyword>" + getLineBreak() +
                "<keyword>" + getLineBreak() +
                "<value>Windows</value>" + getLineBreak() +
                "</keyword>" + getLineBreak() +
                "</keywords>" + getLineBreak() +
                "</application>" + getLineBreak();

        List<Keyword> keywordList = new ArrayList<>();
        keywordList.add(new Keyword("Doors"));
        keywordList.add(new Keyword("Windows"));
        Application application = new Application("MyApplication", keywordList);
        String result = application.exportContentToString();
        assertEquals(expected, result);
    }

    @Test
    public void ensureSameObjectIsEqual() {
        String description = "MyCandidatura";

        List<Keyword> keywords = new ArrayList<>();
        keywords.add(new Keyword("Doors"));
        keywords.add(new Keyword("Windows"));

        Application expected = new Application(description, keywords);

        assertEquals(expected, expected);
    }

    @Test
    public void ensureDifferentObjectsAreNotEqual() {
        String description = "MyCandidatura";

        List<Keyword> keywords = new ArrayList<>();
        keywords.add(new Keyword("Doors"));
        keywords.add(new Keyword("Windows"));

        Application expected = new Application(description, keywords);

        Object result = new Object();
        assertNotEquals(expected, result);
    }

    @Test
    public void ensureDifferentDescriptionMakeObjectsNotEqual() {
        String description1 = "MyCandidatura1";
        String description2 = "MyCandidatura2";

        List<Keyword> keywords = new ArrayList<>();
        keywords.add(new Keyword("Doors"));
        keywords.add(new Keyword("Windows"));

        Application expected = new Application(description1, keywords);
        Application result = new Application(description2, keywords);

        assertNotEquals(expected, result);
    }

    @Test
    public void ensureHashCodeIsCorrect() {
        String description = "MyCandidatura";

        List<Keyword> keywords = new ArrayList<>();
        keywords.add(new Keyword("Doors"));
        keywords.add(new Keyword("Windows"));

        Application application = new Application(description, keywords);

        int expected = 461375881;
        int result = application.hashCode();
        assertEquals(expected, result);

    }

    /**
     * Test of set/getNameOfCompany method, of class Application.
     */
    @Test
    public void testSetAndGetNameOfCompany() {
        System.out.println("set/getNameOfCompany");
        Application instance = new Application();
        String expResult = "Company Air";
        instance.setNameOfCompany(expResult);
        String result = instance.getNameOfCompany();
        assertEquals(expResult, result);
    }

    /**
     * Test of set/getPhoneNumber method, of class Application.
     */
    @Test
    public void testSetAndGetPhoneNumber() {
        System.out.println("set/getPhoneNumber");
        Application instance = new Application();
        int expResult = 912222222;
        instance.setPhoneNumber(expResult);
        int result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVatNumber method, of class Application.
     */
    @Test
    public void testSetAndGetVatNumber() {
        System.out.println("set/getVatNumber");
        Application instance = new Application();
        int expResult = 223542123;
        instance.setVatNumber(expResult);
        int result = instance.getVatNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of set/getDescription method, of class Application.
     */
    @Test
    public void testSetAndGetDescription() {
        System.out.println("set/getDescription");
        Application instance = new Application();
        String expResult = "Description";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of addKeyword method, of class Application.
     */
    @Test
    public void testAddKeyword() {
        System.out.println("addKeyword");
        Keyword keyword = new Keyword("keyword");
        Application instance = new Application();
        instance.addKeyword(keyword);
    }

    /**
     * Test of set/getKeywordList method, of class Application.
     */
    @Test
    public void testSetAndGetKeywordList() {
        System.out.println("set/getKeywordList");
        Application instance = new Application("description");
        Keyword keyword1 = new Keyword("keyword1");
        Keyword keyword2 = new Keyword("keyword2");
        Keyword keyword3 = new Keyword("keyword3");
        Keyword keyword4 = new Keyword("keyword4");
        List<Keyword> expResult = new ArrayList<>();
        expResult.add(keyword1);
        expResult.add(keyword2);
        expResult.add(keyword3);
        expResult.add(keyword4);
        instance.setKeywordList(expResult);
        List<Keyword> result = instance.getKeywordList();
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Application.
     */
    @Test
    public void testExportContentToXMLNode() throws Exception {
        System.out.println("exportContentToXMLNode");
        Application instance = new Application();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Application.
     */
    
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Application instance = new Application("description");
        Keyword keyword1 = new Keyword("keyword1");
        Keyword keyword2 = new Keyword("keyword2");
        Keyword keyword3 = new Keyword("keyword3");
        Keyword keyword4 = new Keyword("keyword4");
        List<Keyword> listKey = new ArrayList<>();
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        instance.setKeywordList(listKey);
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        int expResult = 870953223;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Application.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Application instance = new Application();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Application.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals1");
        
        Keyword keyword1 = new Keyword("keyword1");
        Keyword keyword2 = new Keyword("keyword2");
        Keyword keyword3 = new Keyword("keyword3");
        Keyword keyword4 = new Keyword("keyword4");
        List<Keyword> listKey = new ArrayList<>();
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        
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
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        Application instance = new Application("description", listKey, listRev);
        instance.setWorkshopList(listWo);
        instance.setBoothArea(20.2);
        instance.setState(ApplicationState.CREATED);
        instance.setNameOfCompany("nameOfCompany");
        instance.setUserThatSubmited(user);
        
        Application instance2 = new Application();
        
        List<Boolean> wantToAttend2 = new ArrayList<>();
        wantToAttend2.add(Boolean.TRUE);
        wantToAttend2.add(Boolean.TRUE);
        wantToAttend2.add(Boolean.FALSE);
        
        List<String> necessaryEquip2 = new ArrayList<>();
        necessaryEquip2.add("Lavatorio");
        necessaryEquip2.add("Agua potavél");
        necessaryEquip2.add("Quadro");
        
        instance2.setWorkshopList(listWo);
        instance2.setListReview(listRev);
        instance2.setBoothArea(29.2);
        instance2.setState(ApplicationState.CREATED);
        instance2.setNameOfCompany("nameOfCompany");
        instance2.setDescription("description");
        instance2.setUserThatSubmited(user);
        
        Object o = instance2;
        boolean result = false;
        result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Application.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        Application instance = new Application();
        
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
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        instance.setWorkshopList(listWo);
        instance.setListReview(listRev);
        instance.setBoothArea(20.2);
        instance.setState(ApplicationState.CREATED);
        instance.setNameOfCompany("nameOfCompany");
        instance.setDescription("description");
        instance.setUserThatSubmited(user);
        
        Application instance2 = new Application();
        
        List<Boolean> wantToAttend2 = new ArrayList<>();
        wantToAttend2.add(Boolean.TRUE);
        wantToAttend2.add(Boolean.TRUE);
        wantToAttend2.add(Boolean.FALSE);
        
        List<String> necessaryEquip2 = new ArrayList<>();
        necessaryEquip2.add("Lavatorio");
        necessaryEquip2.add("Agua potavél");
        necessaryEquip2.add("Quadro");
        
        instance2.setWorkshopList(listWo);
        instance2.setListReview(listRev);
        instance2.setBoothArea(20.2);
        instance2.setState(ApplicationState.ACCEPTED);
        instance2.setNameOfCompany("nameOfCompany");
        instance2.setDescription("description");
        instance2.setUserThatSubmited(user);
        
        Object o = instance2;
        
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Application.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals3");
        Application instance = new Application();
        
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
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        instance.setWorkshopList(listWo);
        instance.setListReview(listRev);
        instance.setBoothArea(20.2);
        instance.setState(ApplicationState.CREATED);
        instance.setNameOfCompany("nameOfCompany");
        instance.setDescription("description");
        instance.setUserThatSubmited(user);
        
        Application instance2 = new Application();
        
        List<Boolean> wantToAttend2 = new ArrayList<>();
        wantToAttend2.add(Boolean.TRUE);
        wantToAttend2.add(Boolean.TRUE);
        wantToAttend2.add(Boolean.FALSE);
        
        List<String> necessaryEquip2 = new ArrayList<>();
        necessaryEquip2.add("Lavatorio");
        necessaryEquip2.add("Agua potavél");
        necessaryEquip2.add("Quadro");
        
        Workshop w3 = new Workshop("description w3", 5, necessaryEquip);
        w3.setWantToAttend(wantToAttend);
        Workshop w4 = new Workshop("description w4", 1, necessaryEquip);
        w4.setWantToAttend(wantToAttend);        
        List<Workshop> listWo2 = new ArrayList<>();
        listWo2.add(w4);
        listWo2.add(w3);
        
        instance2.setWorkshopList(listWo2);
        instance2.setListReview(listRev);
        instance2.setBoothArea(20.2);
        instance2.setState(ApplicationState.CREATED);        
        instance2.setNameOfCompany("nameOfCompany");
        instance2.setDescription("description");
        instance2.setUserThatSubmited(user);
        
        Object o = instance2;
        
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Application.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals4");
        Application instance = new Application();
        
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
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev = new ArrayList<>();
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        instance.setWorkshopList(listWo);
        instance.setListReview(listRev);
        instance.setBoothArea(20.2);
        instance.setState(ApplicationState.CREATED);
        instance.setNameOfCompany("nameOfCompany");
        instance.setDescription("description");
        instance.setUserThatSubmited(user);
        
        Application instance2 = new Application();
        
        List<Boolean> wantToAttend2 = new ArrayList<>();
        wantToAttend2.add(Boolean.TRUE);
        wantToAttend2.add(Boolean.TRUE);
        wantToAttend2.add(Boolean.FALSE);
        
        List<String> necessaryEquip2 = new ArrayList<>();
        necessaryEquip2.add("Lavatorio");
        necessaryEquip2.add("Agua potavél");
        necessaryEquip2.add("Quadro");
        
        Review rv4 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> listRev2 = new ArrayList<>();
        listRev2.add(rv1);
        listRev2.add(rv2);
        listRev2.add(rv3);
        listRev2.add(rv4);
        
        instance2.setWorkshopList(listWo);
        instance2.setListReview(listRev2);
        instance2.setBoothArea(20.2);
        instance2.setState(ApplicationState.CREATED);
        instance2.setNameOfCompany("nameOfCompany");
        instance2.setDescription("description");
        instance2.setUserThatSubmited(user);
        
        Object o = instance2;
        
        boolean result = instance.equals(o);
        assertFalse(result);
    }

    /**
     * Test of set/getBoothArea method, of class Application.
     */
    @Test
    public void testGetBoothArea() {
        System.out.println("set/getBoothArea");
        Application instance = new Application();
        double expResult = 10.5;
        instance.setBoothArea(expResult);
        double result = instance.getBoothArea();
        assertEquals(expResult, result, 10.5);
    }

    /**
     * Test of set/getNumberInvites method, of class Application.
     */
    @Test
    public void testSetAndGetNumberInvites() {
        System.out.println("set/getNumberInvites");
        Application instance = new Application();
        int expResult = 10;
        instance.setNumberInvites(expResult);
        int result = instance.getNumberInvites();
        assertEquals(expResult, result);
    }

    /**
     * Test of set/getListReview method, of class Application.
     */
    @Test
    public void testGetListReview() {
        System.out.println("getListReview");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
        List<Review> expResult = new ArrayList<>();
        expResult.add(rv1);
        expResult.add(rv2);
        expResult.add(rv3);
        Application instance = new Application();
        instance.setListReview(expResult);
        List<Review> result = instance.getListReview();
        assertEquals(expResult, result);
    }

    /**
     * Test of set/getState method, of class Application.
     */
    @Test
    public void testSetAndGetState() {
        System.out.println("set/getState");
        Application instance = new Application();
        instance.setState(ApplicationState.CREATED);
        ApplicationState expResult = ApplicationState.CREATED;
        ApplicationState result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWorkshopList method, of class Application.
     */
    @Test
    public void testGetWorkshopList() {
        System.out.println("getWorkshopList");
        Application instance = new Application();
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
        List<Workshop> expResult = new ArrayList<>();
        expResult.add(w2);
        expResult.add(w1);
        instance.setWorkshopList(expResult);
        List<Workshop> result = instance.getWorkshopList();
        assertEquals(expResult, result);
    }

    /**
     * Test of set/getUserThatSubmited method, of class Application.
     */
    @Test
    public void testSetAndGetUserThatSubmited() {
        System.out.println("set/getUserThatSubmited");
        Application instance = new Application();
        User expResult = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        instance.setUserThatSubmited(expResult);
        User result = instance.getUserThatSubmited();        
        assertEquals(expResult, result);
    }

}