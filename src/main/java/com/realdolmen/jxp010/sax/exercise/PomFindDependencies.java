package com.realdolmen.jxp010.sax.exercise;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EWTAX45 on 24/09/2015.
 */
public class PomFindDependencies implements ContentHandler {
    boolean foundDependency = false;
    boolean foundGroupId = false;
    List<String> allGroupIds = new ArrayList<>();

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {
        for (String allGroupId : allGroupIds) {
            System.out.println(allGroupId);
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if(qName.equals("dependency"))  {
            foundDependency = true;
        }   else if (foundDependency && qName.equals("groupId")) {
            foundGroupId = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(foundDependency && qName.equals("groupId"))  {
            foundDependency = false;
            foundGroupId = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(foundDependency && foundGroupId)   {
            allGroupIds.add(new String(ch, start, length));
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}
