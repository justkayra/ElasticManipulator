package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.*;

/**
 * Created by kaira on 10/31/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PMAClassification")
public class PMAClassification {
    @XmlAttribute
    private String code;
    @XmlValue
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
