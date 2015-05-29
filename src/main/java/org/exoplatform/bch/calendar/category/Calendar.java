package org.exoplatform.bch.calendar.category;

/**
 * Created by rosso on 5/15/15.
 */
public class Calendar {
    private String id;
    private String href;
    private String name;
    private String owner;
    private String type;
    private String[] groups;
    private String timeZone;
    private String color;
    private String description;
    private String icsURL;
    private String viewPermision;
    private String publicUrl;
    private String privateUrl;
    private String editPermission;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String[] getGroups() {
        return groups;
    }

    public void setGroups(String[] groups) {
        this.groups = groups;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcsURL() {
        return icsURL;
    }

    public void setIcsURL(String icsURL) {
        this.icsURL = icsURL;
    }

    public String getViewPermission() {
        return viewPermision;
    }

    public void setViewPermission(String viewPermission) {
        this.viewPermision = viewPermission;
    }

    public String getPublicUrl() {
        return publicUrl;
    }

    public void setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
    }

    public String getPrivateUrl() {
        return privateUrl;
    }

    public void setPrivateUrl(String privateUrl) {
        this.privateUrl = privateUrl;
    }

    public String getEditPermission() {
        return editPermission;
    }

    public void setEditPermission(String editPermission) {
        this.editPermission = editPermission;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


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