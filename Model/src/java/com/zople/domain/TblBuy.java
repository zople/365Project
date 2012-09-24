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
@Table(name = "tbl_buy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBuy.findAll", query = "SELECT t FROM TblBuy t"),
    @NamedQuery(name = "TblBuy.findById", query = "SELECT t FROM TblBuy t WHERE t.id = :id"),
    @NamedQuery(name = "TblBuy.findByContent", query = "SELECT t FROM TblBuy t WHERE t.content = :content"),
    @NamedQuery(name = "TblBuy.findByCount", query = "SELECT t FROM TblBuy t WHERE t.count = :count"),
    @NamedQuery(name = "TblBuy.findByCreateTime", query = "SELECT t FROM TblBuy t WHERE t.createTime = :createTime"),
    @NamedQuery(name = "TblBuy.findByEndtime", query = "SELECT t FROM TblBuy t WHERE t.endtime = :endtime"),
    @NamedQuery(name = "TblBuy.findByFlg", query = "SELECT t FROM TblBuy t WHERE t.flg = :flg"),
    @NamedQuery(name = "TblBuy.findByName", query = "SELECT t FROM TblBuy t WHERE t.name = :name"),
    @NamedQuery(name = "TblBuy.findByTitle", query = "SELECT t FROM TblBuy t WHERE t.title = :title")})
public class TblBuy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Column(name = "count")
    private Integer count;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Column(name = "endtime")
    @Temporal(TemporalType.DATE)
    private Date endtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flg")
    private int flg;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "title")
    private String title;

    public TblBuy() {
    }

    public TblBuy(Long id) {
        this.id = id;
    }

    public TblBuy(Long id, int flg) {
        this.id = id;
        this.flg = flg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getFlg() {
        return flg;
    }

    public void setFlg(int flg) {
        this.flg = flg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBuy)) {
            return false;
        }
        TblBuy other = (TblBuy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblBuy[ id=" + id + " ]";
    }
    
}
