package com.realdolmen.jxp010.sax.exercise;

import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by EWTAX45 on 24/09/2015.
 */
public class ExtractMovieTitles {

    public static void main(String[] args) {
        XMLReader parser;

        try {
            SAXParserFactory sf = SAXParserFactory.newInstance();
            sf.setNamespaceAware(false);
            sf.setValidating(false);
            parser = sf.newSAXParser().getXMLReader();
            parser.setContentHandler(new FindTitles());
            parser.parse("./src/main/resources/movies.xml");

        } catch (Exception e)   {
            System.out.println("something went wrong :(");
        }
    }
}
