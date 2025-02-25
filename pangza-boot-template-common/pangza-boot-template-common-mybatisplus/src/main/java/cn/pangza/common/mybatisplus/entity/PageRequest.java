package cn.pangza.common.mybatisplus.entity;

import java.util.Map;

public class PageRequest<T> {
    private Integer pageNum;
    private Integer pageSize;
    private T form;

    private Map<String, Object> sort;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getForm() {
        return form;
    }

    public void setForm(T form) {
        this.form = form;
    }

    public Map<String, Object> getSort() {
        return sort;
    }

    public void setSort(Map<String, Object> sort) {
        this.sort = sort;
    }
}
