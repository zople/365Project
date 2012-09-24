/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "wj_goods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WjGoods.findAll", query = "SELECT w FROM WjGoods w"),
    @NamedQuery(name = "WjGoods.findByGoodsId", query = "SELECT w FROM WjGoods w WHERE w.goodsId = :goodsId"),
    @NamedQuery(name = "WjGoods.findByCategoryId", query = "SELECT w FROM WjGoods w WHERE w.categoryId = :categoryId"),
    @NamedQuery(name = "WjGoods.findByGoodsCreateTime", query = "SELECT w FROM WjGoods w WHERE w.goodsCreateTime = :goodsCreateTime"),
    @NamedQuery(name = "WjGoods.findByGoodsDescription", query = "SELECT w FROM WjGoods w WHERE w.goodsDescription = :goodsDescription"),
    @NamedQuery(name = "WjGoods.findByGoodsEndTime", query = "SELECT w FROM WjGoods w WHERE w.goodsEndTime = :goodsEndTime"),
    @NamedQuery(name = "WjGoods.findByGoodsName", query = "SELECT w FROM WjGoods w WHERE w.goodsName = :goodsName"),
    @NamedQuery(name = "WjGoods.findByState", query = "SELECT w FROM WjGoods w WHERE w.state = :state")})
public class WjGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "goods_id")
    private Long goodsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private long categoryId;
    @Column(name = "goods_create_time")
    @Temporal(TemporalType.DATE)
    private Date goodsCreateTime;
    @Size(max = 255)
    @Column(name = "goods_description")
    private String goodsDescription;
    @Column(name = "goods_end_time")
    @Temporal(TemporalType.DATE)
    private Date goodsEndTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "goods_name")
    private String goodsName;
    @Column(name = "state")
    private Integer state;

    public WjGoods() {
    }

    public WjGoods(Long goodsId) {
        this.goodsId = goodsId;
    }

    public WjGoods(Long goodsId, long categoryId, String goodsName) {
        this.goodsId = goodsId;
        this.categoryId = categoryId;
        this.goodsName = goodsName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(Date goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public Date getGoodsEndTime() {
        return goodsEndTime;
    }

    public void setGoodsEndTime(Date goodsEndTime) {
        this.goodsEndTime = goodsEndTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (goodsId != null ? goodsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WjGoods)) {
            return false;
        }
        WjGoods other = (WjGoods) object;
        if ((this.goodsId == null && other.goodsId != null) || (this.goodsId != null && !this.goodsId.equals(other.goodsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.WjGoods[ goodsId=" + goodsId + " ]";
    }
    
}
