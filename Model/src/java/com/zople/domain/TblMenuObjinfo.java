/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigInteger;
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

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_menu_objinfo")
@NamedQueries({
    @NamedQuery(name = "TblMenuObjinfo.findAll", query = "SELECT t FROM TblMenuObjinfo t"),
    @NamedQuery(name = "TblMenuObjinfo.findByMenuobjId", query = "SELECT t FROM TblMenuObjinfo t WHERE t.menuobjId = :menuobjId"),
    @NamedQuery(name = "TblMenuObjinfo.findByMenuId", query = "SELECT t FROM TblMenuObjinfo t WHERE t.menuId = :menuId"),
    @NamedQuery(name = "TblMenuObjinfo.findByDataobjId", query = "SELECT t FROM TblMenuObjinfo t WHERE t.dataobjId = :dataobjId"),
    @NamedQuery(name = "TblMenuObjinfo.findBySorts", query = "SELECT t FROM TblMenuObjinfo t WHERE t.sorts = :sorts"),
    @NamedQuery(name = "TblMenuObjinfo.findByCreator", query = "SELECT t FROM TblMenuObjinfo t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblMenuObjinfo.findByUpdateUser", query = "SELECT t FROM TblMenuObjinfo t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblMenuObjinfo.findByUpdateTime", query = "SELECT t FROM TblMenuObjinfo t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblMenuObjinfo.findByCreateTime", query = "SELECT t FROM TblMenuObjinfo t WHERE t.createTime = :createTime")})
public class TblMenuObjinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "menuobj_id", nullable = false)
    private Long menuobjId;
    @Column(name = "menu_id")
    private BigInteger menuId;
    @Column(name = "dataobj_id")
    private BigInteger dataobjId;
    @Column(name = "sorts")
    private Integer sorts;
    @Size(max = 50)
    @Column(name = "creator", length = 50)
    private String creator;
    @Size(max = 50)
    @Column(name = "update_user", length = 50)
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    public TblMenuObjinfo() {
    }

    public TblMenuObjinfo(Long menuobjId) {
        this.menuobjId = menuobjId;
    }

    public Long getMenuobjId() {
        return menuobjId;
    }

    public void setMenuobjId(Long menuobjId) {
        this.menuobjId = menuobjId;
    }

    public BigInteger getMenuId() {
        return menuId;
    }

    public void setMenuId(BigInteger menuId) {
        this.menuId = menuId;
    }

    public BigInteger getDataobjId() {
        return dataobjId;
    }

    public void setDataobjId(BigInteger dataobjId) {
        this.dataobjId = dataobjId;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuobjId != null ? menuobjId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMenuObjinfo)) {
            return false;
        }
        TblMenuObjinfo other = (TblMenuObjinfo) object;
        if ((this.menuobjId == null && other.menuobjId != null) || (this.menuobjId != null && !this.menuobjId.equals(other.menuobjId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblMenuObjinfo[ menuobjId=" + menuobjId + " ]";
    }
    
}
