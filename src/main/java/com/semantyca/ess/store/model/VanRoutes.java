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
@XmlRootElement(name = "VanRoutes")
public class VanRoutes {
    @XmlElement(name="VanRoute")
    private List<VanRoute> vanRoutes;

    public List<VanRoute> getVanRoutes() {
        return vanRoutes;
    }

    public void setVanRoutes(List<VanRoute> vanRoutes) {
        this.vanRoutes = vanRoutes;
    }
}
