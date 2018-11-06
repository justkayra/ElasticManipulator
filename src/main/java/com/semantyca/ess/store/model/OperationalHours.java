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
@XmlRootElement(name = "OperationalHours")
public class OperationalHours {
    @XmlElement(name="DayOfWeek")
    private List<DayOfWeek> dayOfWeeks;

    public List<DayOfWeek> getDayOfWeeks() {
        return dayOfWeeks;
    }

    public void setDayOfWeeks(List<DayOfWeek> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }
}
