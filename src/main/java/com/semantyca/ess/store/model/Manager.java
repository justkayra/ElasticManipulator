package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by kaira on 10/31/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Manager")
public class Manager {
    @XmlElement(name="Name")
    private String name;
    @XmlElement(name="Email")
    private String eMail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
