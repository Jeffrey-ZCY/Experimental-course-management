package com.xidian.pojo;

import java.util.List;

public class PageBean<T> {

    private int pageNo = 1;
    private int pageTotalCount;
    private int pageTotal;
    private int pageSize = 5;

    private List<T> list;

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNo=" + pageNo +
                ", pageTotalCount=" + pageTotalCount +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(int pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
