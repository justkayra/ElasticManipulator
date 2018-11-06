package com.semantyca.ess.store.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kaira on 10/31/18.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Hierarchy")
public class Hierarchy {
    @XmlElement(name = "RegionID")
    private int regionID;
    @XmlElement(name = "RegionName")
    private String regionName;
    @XmlElement(name = "AreaID")
    private int areaID;
    @XmlElement(name = "AreaName")
    private String areaName;
    @XmlElement(name = "DivisionID")
    private int divisionID;
    @XmlElement(name = "DivisionName")
    private String divisionName;

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
