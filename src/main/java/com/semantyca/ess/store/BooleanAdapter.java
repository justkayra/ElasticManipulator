package com.semantyca.ess.store;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by kaira on 11/1/18.
 */
public class BooleanAdapter extends XmlAdapter<String, Boolean> {
    public Boolean unmarshal(String v) throws Exception {
        if ("Y".equalsIgnoreCase(v)) {
            return true;
        } else {
            return false;
        }
    }

    public String marshal(Boolean v) throws Exception {
        if (v){
            return "Y";
        }else{
            return "N";
        }
    }
}
