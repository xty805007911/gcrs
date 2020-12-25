package com.ctsi.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页查询返回包装类
 * <p>Title: PageResult</p>
 * <p>Description: </p>
 * @author Tianyu Xiao
 * @date 2019年3月19日
 */
public class PageResult<T> {
    private int page;//当前页
    private Number total;//总条数
    private int rows;//每页条数
    private int pageSize;//总页数
    private List<T> list;//每页数据集合
    private PageInfo<T> pageInfo;//pagehelper分页信息

    public PageResult(PageInfo<T> pageInfo) {
        //this.pageInfo = pageInfo;
        //设置当前页
        this.setPage(pageInfo.getPageNum());
        //分页集合
        this.setList(pageInfo.getList());
        //每页条数
        this.setRows(pageInfo.getPageSize());
        //总条数
        this.setTotal(pageInfo.getTotal());
        //总页数
        this.setPageSize(pageInfo.getPages());
    }

    public PageResult() {}

    public int getPage() {
        return page;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Number getTotal() {
        return total;
    }

    public void setTotal(Number total) {
        this.total = total;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
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