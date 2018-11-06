package com.semantyca.ess.store.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GridLocation")
public class GridLocation {
    @XmlElement(name = "PropertyEasting")
    private long propertyEasting;
    @XmlElement(name = "PropertyNorthing")
    private long propertyNorthing;
    @XmlElement(name = "Latitude")
    @JsonIgnore()
    private float latitude;
    @JsonIgnore()
    @XmlElement(name = "Longitude")
    private float longitude;

    public long getPropertyEasting() {
        return propertyEasting;
    }

    public void setPropertyEasting(long propertyEasting) {
        this.propertyEasting = propertyEasting;
    }

    public long getPropertyNorthing() {
        return propertyNorthing;
    }

    public void setPropertyNorthing(long propertyNorthing) {
        this.propertyNorthing = propertyNorthing;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @JsonGetter
    public String getLatLong() {
        return Float.toString(latitude) + "," + Float.toHexString(longitude);
    }

}
