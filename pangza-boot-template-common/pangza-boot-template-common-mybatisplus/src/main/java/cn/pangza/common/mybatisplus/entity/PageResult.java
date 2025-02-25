package cn.pangza.common.mybatisplus.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public class PageResult <T>{
    private Integer pageNum;

    private Integer pageSize;

    private long total;

    private long totalPages;

    private List<T> list;

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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public static <T> PageResult<T> generatePage(IPage<T> iPage) {
        PageResult<T> myPageResult = new PageResult<>();
        myPageResult.setList(iPage.getRecords());
        myPageResult.setPageNum((int) iPage.getCurrent());
        myPageResult.setTotal(iPage.getTotal());
        myPageResult.setPageSize((int) iPage.getSize());
        myPageResult.setTotalPages(iPage.getPages());
        return myPageResult;
    }
}
