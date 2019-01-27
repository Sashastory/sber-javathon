
package de.jonashackt.springbootvuejs.model.gsonobject.yandex;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyMetaData {

    private String id;
    private String name;
    private String shortName;
    private String address;
    private String postalCode;
    private String url;
    @Field("Categories")
    private List<Category> categories = null;
    @Field("Phones")
    private List<Phone> phones = null;
    @Field("Hours")
    private Hours hours;
    @Field("Features")
    private List<PropertyFeature> features = null;
    @Field("Snippet")
    private Snippet snippet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public List<PropertyFeature> getFeatures() {
        return features;
    }

    public void setFeatures(List<PropertyFeature> features) {
        this.features = features;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

}
