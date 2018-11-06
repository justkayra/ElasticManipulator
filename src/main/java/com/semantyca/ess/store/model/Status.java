package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.*;

/**
 * Created by kaira on 10/31/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Status")
public class Status {
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
