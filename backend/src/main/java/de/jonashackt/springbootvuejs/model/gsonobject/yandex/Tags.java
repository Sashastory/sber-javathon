
package de.jonashackt.springbootvuejs.model.gsonobject.yandex;

import java.util.HashMap;
import java.util.Map;

public class Tags {

    private String tag;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
