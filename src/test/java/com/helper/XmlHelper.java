package com.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlHelper {

    private static final Logger LOGGER;

    private static JAXBContext jaxbContext;

    private static Marshaller marshaller;


    static {
        LOGGER = LoggerFactory.getLogger(XmlHelper.class);

        try {
            jaxbContext = JAXBContext.newInstance(com.dto.test.ValidTakeoverProfiles.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            LOGGER.error("Problem in creating jaxb context: " + e.getMessage(), e);
        }
    }

    public static String toXml(Object dto) {
        String res = "";
        try {

            StringWriter out = new StringWriter();
            marshaller.marshal(dto, out);
            res = out.toString();
        } catch (JAXBException e) {
            LOGGER.error("Problem marshaling payload to XML", e);
        }

        return res;
    }

}
