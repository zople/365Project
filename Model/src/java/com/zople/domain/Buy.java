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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *@描   述:   求购表
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Entity
@Table(name = "tbl_buy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buy.findAll", query = "SELECT b FROM Buy b"),
    @NamedQuery(name = "Buy.findById", query = "SELECT b FROM Buy b WHERE b.id = :id"),
    @NamedQuery(name = "Buy.findByContent", query = "SELECT b FROM Buy b WHERE b.content = :content"),
    @NamedQuery(name = "Buy.findByCreateTime", query = "SELECT b FROM Buy b WHERE b.createTime = :createTime"),
    @NamedQuery(name = "Buy.findByTitle", query = "SELECT b FROM Buy b WHERE b.title = :title"),
    @NamedQuery(name = "Buy.findByCount", query = "SELECT b FROM Buy b WHERE b.count = :count"),
    @NamedQuery(name = "Buy.findByEndtime", query = "SELECT b FROM Buy b WHERE b.endtime = :endtime"),
    @NamedQuery(name = "Buy.findByFlg", query = "SELECT b FROM Buy b WHERE b.flg = :flg"),
    @NamedQuery(name = "Buy.findByName", query = "SELECT b FROM Buy b WHERE b.name = :name")})
public class Buy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Column(name = "count")
    private Integer count;
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
    @JoinColumn(name = "en_enterprise_id")
    @ManyToOne
    private EnEnterprise company_id;

    public Buy() {
    }

    public Buy(Long id) {
        this.id = id;
    }

    public Buy(Long id, int flg) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buy)) {
            return false;
        }
        Buy other = (Buy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Buy[ id=" + id + " ]";
    }

}
