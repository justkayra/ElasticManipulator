package com.semantyca.ess.store.model;

import com.semantyca.ess.store.BooleanAdapter;
import com.semantyca.ess.store.LocalTimeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalTime;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Main")
public class Main {
    @XmlElement(name="Closed")
    @XmlJavaTypeAdapter(value = BooleanAdapter.class)
    private Boolean closed;
    @XmlElement(name="OpenTime")
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    private LocalTime openTime;
    @XmlElement(name="CloseTime")
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
    private LocalTime closeTime;


    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }
}
