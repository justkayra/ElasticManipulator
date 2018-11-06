package com.semantyca.ess.store;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalTime;

/**
 * Created by kaira on 11/1/18.
 */
public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {
    public LocalTime unmarshal(String v) throws Exception {
        return LocalTime.parse(v);
    }

    public String marshal(LocalTime v) throws Exception {
        return v.toString();
    }
}
