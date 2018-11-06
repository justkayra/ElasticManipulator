package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.*;

/**
 * Created by kaira on 10/31/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Currency")
public class Currency {
    @XmlAttribute
    private CurrencyCodeType code;
    @XmlValue
    private String value;

    public CurrencyCodeType getCode() {
        return code;
    }

    public void setCode(CurrencyCodeType code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
