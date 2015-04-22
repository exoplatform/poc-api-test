package org.exoplatform.bch.activity;

/**
 * Created by bdechateauvieux on 4/21/15.
 */
public class Activity {
    private long id;
    private String title;

    public Activity(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
