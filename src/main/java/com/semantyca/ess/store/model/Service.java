package com.semantyca.ess.store.model;


import com.semantyca.ess.store.BooleanAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by kaira on 10/31/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Service")
public class Service {
    @XmlAttribute
    @XmlJavaTypeAdapter(value = BooleanAdapter.class)
    private Boolean active;
    @XmlValue
    private String value;

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
