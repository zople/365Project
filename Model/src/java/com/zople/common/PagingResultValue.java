/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.common;

import java.util.List;

/**
 *
 * @author 王文彦
 */
public class PagingResultValue<T> {
    /**总记录数*/
    private int totalCount;
    /**总页数*/
    private int pageCount;
    /**当前页记录数*/
    private int pageSize;
    /**页码*/
    private int pageNumber;  
    
    private  List<T> data;
    
    public PagingResultValue(){
    
    }
    public PagingResultValue(int start,int pageSize,int totalCount){  
        
    }
    
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    
    
}
