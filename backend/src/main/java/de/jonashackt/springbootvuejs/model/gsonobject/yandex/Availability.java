
package de.jonashackt.springbootvuejs.model.gsonobject.yandex;

import java.util.List;

public class Availability {

    private Boolean everyday;
    private List<Interval> intervals = null;

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

}
