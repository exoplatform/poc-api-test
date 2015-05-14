package org.exoplatform.client.retrofit;

import org.exoplatform.bch.calendar.category.Category;

import java.util.List;

/**
 * Created by rosso on 5/14/15.
 */
public class CategorySearchResult {
    private int limit;
    private int size;
    private int offset;
    private List<Category> data;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<Category> getData() {
        return data;
    }

    public void setData(List<Category> data) {
        this.data = data;
    }
}
