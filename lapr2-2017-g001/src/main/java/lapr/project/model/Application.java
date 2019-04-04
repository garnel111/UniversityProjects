package lapr.project.model;

import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Candidatura class.
 *
 * @author by Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
public class Application implements Importable<Application>, Exportable {



    private static final String ROOT_ELEMENT_NAME = "application";
    private static final String DESCRIPTION_ELEMENT_NAME = "description";
    private static final String KEYWORDS_ELEMENT_NAME = "keywords";
    private String nameOfCompany;
    private int phoneNumber;
    private int vatNumber;
    private List<Keyword> keywordList;
    private List<Review> listReview;
    private String description;
    private double boothArea;
    private int numberInvites;
    private List<Workshop> workshopList;
    private ApplicationState state;
    private User userThatSubmited;
    private Stand assignedStand;

    /**
     * Constructor for Application
     *
     * @param description CandidaturaDescription
     * @param keywordList Keyword List
     * @param listReview
     */
    public Application(String description, List<Keyword> keywordList, List<Review> listReview) {
        this.description = description;
        this.keywordList= keywordList;
        this.listReview=  listReview;
        this.workshopList= new ArrayList<>();
        this.userThatSubmited= new User();

    }
    
    public Application(String description, List<Keyword> keywordList) {
        this.description = description;
        this.keywordList= keywordList;
        this.workshopList= new ArrayList<>();
        this.userThatSubmited= new User();

    }
    /**
     * Default public constructor.
     */
    public Application() {
        this.keywordList= new ArrayList<>();
        this.listReview= new ArrayList<>();
        this.workshopList= new ArrayList<>();
        this.userThatSubmited= new User();
    }

    public Application(String description) {
      this.description = description;
        this.keywordList= new ArrayList<>();
        this.listReview= new ArrayList<>();
        this.workshopList= new ArrayList<>();
        this.userThatSubmited= new User();

    }
    /**
     * @return the nameOfCompany
     */
    public String getNameOfCompany() {
        return nameOfCompany;
    }

    /**
     * @return the phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return the vatNumber
     */
    public int getVatNumber() {
        return vatNumber;
    }
    /**
     * Obtain Candidatura's description.
     *
     * @return Candidatura description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Add a keyword to Candidatura.
     *
     * @param keyword Keyword to be added.
     */
    public void addKeyword(Keyword keyword) {
        getKeywordList().add(keyword);
    }

    /**
     * Obtain the list of existing keywords.
     *
     * @return A list of existing keywords.
     */
    public List<Keyword> getKeywordList() {
        return keywordList;

    }

    @Override
    public Node exportContentToXMLNode() throws ParserConfigurationException {
        Node rootNode = null;

        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        //Create document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Obtain a new document
        Document document = builder.newDocument();

        //Create root element
        Element elementCandidatura = document.createElement(ROOT_ELEMENT_NAME);

        //Create a sub-element
        Element elementDescription = document.createElement(DESCRIPTION_ELEMENT_NAME);

        //Set the sub-element value
        elementDescription.setTextContent(getDescription());

        //Add sub-element to root element
        elementCandidatura.appendChild(elementDescription);

        //Create a sub-element
        Element elementKeywords = document.createElement(KEYWORDS_ELEMENT_NAME);
        elementCandidatura.appendChild(elementKeywords);

        //iterate over keywords
        for (Keyword keyword : getKeywordList()
                ) {
            Node keywordNode = keyword.exportContentToXMLNode();
            elementKeywords.appendChild(document.importNode(keywordNode, true));
        }

        //Add root element to document
        document.appendChild(elementCandidatura);

        //It exports only the element representation to XMÇ, ommiting the XML header
        rootNode = elementCandidatura;

        return rootNode;
    }

    @Override
    public Application importContentFromXMLNode(Node node) throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //Create document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Obtain a new document
        Document document = builder.newDocument();
        document.appendChild(document.importNode(node, true));

        NodeList elementsCandidatura = document.getElementsByTagName(ROOT_ELEMENT_NAME);

        Node elementCandidatura = elementsCandidatura.item(0);

        //Get description
        this.setDescription(elementCandidatura.getFirstChild().getFirstChild().getNodeValue());

        NodeList elementsKeywords = document.getElementsByTagName(KEYWORDS_ELEMENT_NAME);

        NodeList keywords = elementsKeywords.item(0).getChildNodes();
        for (int position = 0; position < keywords.getLength(); position++) {
            Node keyword = keywords.item(position);
            Keyword keywordExample = new Keyword();

            keywordExample = keywordExample.importContentFromXMLNode(keyword);
            addKeyword(keywordExample);
        }

        return this;
    }

     @Override
    public int hashCode() {
        int result = getDescription().hashCode();
        result = 31 * result + getKeywordList().hashCode();
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Application)) {
            return false;
        }
        Application that = (Application) o;
        if (!getDescription().equals(that.getDescription())) {
            return false;
        }
        if(Double.compare(this.boothArea, that.boothArea)!=0){
            return false;
        }
        if(!this.getState().equals(that.getState())){
            return false;
        }
        
        if(!this.getWorkshopList().equals(that.getWorkshopList())){
            return false;
        }
        
        if(!this.listReview.equals(that.listReview)){
            return false;
        }
        
        return getKeywordList().equals(that.getKeywordList());
    }
    /**
     * @return the boothArea
     */
    public double getBoothArea() {
        return boothArea;
    }

    /**
     * @param boothArea the boothArea to set
     */
    public void setBoothArea(double boothArea) {
        this.boothArea = boothArea;
    }

    /**
     * @return the numberInvites
     */
    public int getNumberInvites() {
        return numberInvites;
    }

    /**
     * @param numberInvites the numberInvites to set
     */
    public void setNumberInvites(int numberInvites) {
        this.numberInvites = numberInvites;
    }

    /**
     * @param keywordList the keywordList to set
     */
    public void setKeywordList(List<Keyword> keywordList) {
        this.keywordList = keywordList;
    }

    /**
     * @return the listReview
     */
    public List<Review> getListReview() {
        return listReview;
    }

    /**
     * @param listReview the listReview to set
     */
    public void setListReview(List<Review> listReview) {
        this.listReview = listReview;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the state
     */
    public ApplicationState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(ApplicationState state) {
        this.state = state;
    }
    
    /**
     * @return the workshopList
     */
    public List<Workshop> getWorkshopList() {
        return workshopList;
    }

    /**
     * @param nameOfCompany the nameOfCompany to set
     */
    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @param vatNumber the vatNumber to set
     */
    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }

    /**
     * @param workshopList the workshopList to set
     */
    public void setWorkshopList(List<Workshop> workshopList) {
        this.workshopList = workshopList;
    }

    /**
     * @return the userThatSubmited
     */
    public User getUserThatSubmited() {
        return userThatSubmited;
    }

    /**
     * @param userThatSubmited the userThatSubmited to set
     */
    public void setUserThatSubmited(User userThatSubmited) {
        this.userThatSubmited = userThatSubmited;
    }
    
    
    public Stand getAssignedStand() {
        return assignedStand;
    }

    public void setAssignedStand(Stand assignedStand) {
        this.assignedStand = assignedStand;
    }
}
