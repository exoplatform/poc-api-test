package org.exoplatform.bch.calendar.category;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Category {
    private String id;
    private String href;
    private String name;

    public Category(String id, String href, String name) {
        this.id = id;
        this.href = href;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gethref() {
        return href;
    }

    public void sethref(String href) {
        this.href = href;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
