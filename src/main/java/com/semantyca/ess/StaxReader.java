package com.semantyca.ess;

import com.semantyca.ess.store.model.Location;
import com.semantyca.ess.store.model.StoreDetails;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StaxReader {

    public static void main(String[] args) {
        List<Location> list = new StaxReader().get();
        System.out.println(list);

    }


    public List<Location> get(){
        File file = new File("C:\\Users\\kairat.kuliyev\\Downloads\\Projects\\Boots\\storemasterdata\\storemasterdata.xml");
        List<Location> locations = new ArrayList<>();
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(StoreDetails.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StoreDetails storeDetails = (StoreDetails) jaxbUnmarshaller.unmarshal(file);

            locations = storeDetails.getLocations();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return locations;

    }

}
