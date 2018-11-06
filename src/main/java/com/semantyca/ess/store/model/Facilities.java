package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by kaira on 11/1/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Facilities")
public class Facilities {
    @XmlElement(name="Facility")
    private List<Facility> facilities;


    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }


}
