
package de.jonashackt.springbootvuejs.model.gsonobject.yandex;

import java.util.HashMap;
import java.util.Map;

public class State {

    private String isOpenNow;
    private String text;
    private String shortText;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIsOpenNow() {
        return isOpenNow;
    }

    public void setIsOpenNow(String isOpenNow) {
        this.isOpenNow = isOpenNow;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
