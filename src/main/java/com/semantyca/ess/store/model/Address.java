package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kaira on 10/31/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Address")
public class Address {
    @XmlElement(name = "Street")
    private String street;
    @XmlElement(name = "Town")
    private String town;
    @XmlElement(name = "County")
    private String county;
    @XmlElement(name = "Postcode")
    private String postcode;
    @XmlElement(name = "CountryCode")
    private String countryCode;
    @XmlElement(name = "GridLocation")
    GridLocation gridLocation;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public GridLocation getGridLocation() {
        return gridLocation;
    }

    public void setGridLocation(GridLocation gridLocation) {
        this.gridLocation = gridLocation;
    }
}
