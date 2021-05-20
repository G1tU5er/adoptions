package com.p5.adoptions.model;

import java.util.ArrayList;
import java.util.List;

public class ListDTO<T> {
    private Integer totalCount;
    private List<T> data;

    public ListDTO(Integer totalCount, List<T> data) {
        this.totalCount = totalCount;
        this.data = data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
