/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.service.common;

import java.util.List;

/**
 *
 * @author 王文彦
 */
public class PagingResultValue<T> {
    /**总记录数*/
    private int count;
    /**总页数*/
    private int pageSize;
    /**当前页*/
    private int currentPage;   
    private  List<T> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    
}
