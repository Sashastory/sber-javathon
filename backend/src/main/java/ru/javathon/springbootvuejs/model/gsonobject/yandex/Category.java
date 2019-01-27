
package ru.javathon.springbootvuejs.model.gsonobject.yandex;

import org.springframework.data.mongodb.core.mapping.Field;

public class Category {

    @Field("class")
    private String _class;
    private String name;
    @Field("Tags")
    private Tags tags;

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

}
