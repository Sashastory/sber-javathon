
package de.jonashackt.springbootvuejs.model.gsonobject.yandex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Availability {

    private Boolean everyday;
    private List<Interval> intervals = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getEveryday() {
        return everyday;
    }

    public void setEveryday(Boolean everyday) {
        this.everyday = everyday;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<Interval> intervals) {
        this.intervals = intervals;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
