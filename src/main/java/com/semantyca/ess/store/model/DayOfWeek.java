package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dayofweek")
public class DayOfWeek {
    @XmlAttribute(name = "special")
    private String special;
    @XmlAttribute(name = "day")
    private String day;
    @XmlElement(name = "Main")
    private Main main;
    @XmlElement(name = "Pharmacy")
    private Pharmacy pharmacy;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

}
