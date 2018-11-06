package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "StoreDetails")
@XmlAccessorType(XmlAccessType.FIELD)
public class StoreDetails {

    @XmlElement(name = "Location")
    private List<Location> locations;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
