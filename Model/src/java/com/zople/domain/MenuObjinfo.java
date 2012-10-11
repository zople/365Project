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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wangxiu
 * 菜单对应的权限对象信息实体
 */
@Entity
@Table(name = "tbl_menu_objinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuObjinfo.findAll", query = "SELECT m FROM MenuObjinfo m"),
    @NamedQuery(name = "MenuObjinfo.findByMenuobjId", query = "SELECT m FROM MenuObjinfo m WHERE m.menuobjId = :menuobjId"),
    @NamedQuery(name = "MenuObjinfo.findByMenuId", query = "SELECT m FROM MenuObjinfo m WHERE m.menuId = :menuId"),
    @NamedQuery(name = "MenuObjinfo.findByDataobjId", query = "SELECT m FROM MenuObjinfo m WHERE m.dataobjId = :dataobjId"),
    @NamedQuery(name = "MenuObjinfo.findBySorts", query = "SELECT m FROM MenuObjinfo m WHERE m.sorts = :sorts"),
    @NamedQuery(name = "MenuObjinfo.findByCreator", query = "SELECT m FROM MenuObjinfo m WHERE m.creator = :creator"),
    @NamedQuery(name = "MenuObjinfo.findByUpdateUser", query = "SELECT m FROM MenuObjinfo m WHERE m.updateUser = :updateUser"),
    @NamedQuery(name = "MenuObjinfo.findByUpdateTime", query = "SELECT m FROM MenuObjinfo m WHERE m.updateTime = :updateTime"),
    @NamedQuery(name = "MenuObjinfo.findByCreateTime", query = "SELECT m FROM MenuObjinfo m WHERE m.createTime = :createTime")})
public class MenuObjinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "menuobj_id")
    private Long menuobjId;
    @Column(name = "menu_id")
    private BigInteger menuId;
    @Column(name = "dataobj_id")
    private BigInteger dataobjId;
    @Column(name = "sorts")
    private Integer sorts;
    @Size(max = 50)
    @Column(name = "creator")
    private String creator;
    @Size(max = 50)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    public MenuObjinfo() {
    }

    public MenuObjinfo(Long menuobjId) {
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
        if (!(object instanceof MenuObjinfo)) {
            return false;
        }
        MenuObjinfo other = (MenuObjinfo) object;
        if ((this.menuobjId == null && other.menuobjId != null) || (this.menuobjId != null && !this.menuobjId.equals(other.menuobjId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.MenuObjinfo[ menuobjId=" + menuobjId + " ]";
    }
    
}
