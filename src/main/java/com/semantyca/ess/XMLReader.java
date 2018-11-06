package com.semantyca.ess;

import com.semantyca.ess.store.model.Location;
import com.semantyca.ess.store.model.StoreDetails;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {
    private String xmlFilePath;


    public XMLReader(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    public List<Location> get(){
        File file = new File(xmlFilePath);
        List<Location> locations = new ArrayList<>();
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(StoreDetails.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StoreDetails storeDetails = (StoreDetails) jaxbUnmarshaller.unmarshal(file);

            for(Location location : storeDetails.getLocations()) {
                locations.add(location);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return locations;

    }

}
