package lapr.project.utils;

import org.w3c.dom.Node;

import javax.xml.parsers.ParserConfigurationException;

/**
 * All domains classes should include this interface.
 * Created by Nuno Bettencourt (nmb@isep.ipp.pt) on 29/05/16.
 */
@FunctionalInterface
public interface Importable<T extends Exportable> {
    /**
     * Imports the object content from an XML format.
     *
     * @param node Node to be parsed.
     * @return Structured String containing content.
     * @throws ParserConfigurationException Throws an exception if can not be parsed.
     */
    T importContentFromXMLNode(Node node) throws ParserConfigurationException;
}
