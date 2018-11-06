package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.*;

/**
 * Created by kaira on 10/31/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "VanRoute")
public class VanRoute {
    @XmlAttribute
    private int code;
    @XmlValue
    private String value;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
