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

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "sppl_categoryattrinfo")
@NamedQueries({
    @NamedQuery(name = "SpplCategoryattrinfo.findAll", query = "SELECT s FROM SpplCategoryattrinfo s"),
    @NamedQuery(name = "SpplCategoryattrinfo.findById", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.id = :id"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByCategoryId", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.categoryId = :categoryId"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByAttrname", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.attrname = :attrname"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByAttrtype", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.attrtype = :attrtype"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByRequired", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.required = :required"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByDisplay", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.display = :display"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByDisporder", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.disporder = :disporder"),
    @NamedQuery(name = "SpplCategoryattrinfo.findBySorts", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.sorts = :sorts"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByCreator", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.creator = :creator"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByUpdateUser", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.updateUser = :updateUser"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByCreateTime", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.createTime = :createTime"),
    @NamedQuery(name = "SpplCategoryattrinfo.findByUpdateTime", query = "SELECT s FROM SpplCategoryattrinfo s WHERE s.updateTime = :updateTime")})
public class SpplCategoryattrinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "category_id", nullable = false, length = 32)
    private String categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "attrname", nullable = false, length = 40)
    private String attrname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "attrtype", nullable = false, length = 2)
    private String attrtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "required", nullable = false)
    private boolean required;
    @Basic(optional = false)
    @NotNull
    @Column(name = "display", nullable = false)
    private boolean display;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disporder", nullable = false)
    private short disporder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sorts", nullable = false)
    private short sorts;
    @Size(max = 20)
    @Column(name = "creator", length = 20)
    private String creator;
    @Size(max = 30)
    @Column(name = "update_user", length = 30)
    private String updateUser;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public SpplCategoryattrinfo() {
    }

    public SpplCategoryattrinfo(Long id) {
        this.id = id;
    }

    public SpplCategoryattrinfo(Long id, String categoryId, String attrname, String attrtype, boolean required, boolean display, short disporder, short sorts) {
        this.id = id;
        this.categoryId = categoryId;
        this.attrname = attrname;
        this.attrtype = attrtype;
        this.required = required;
        this.display = display;
        this.disporder = disporder;
        this.sorts = sorts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getAttrname() {
        return attrname;
    }

    public void setAttrname(String attrname) {
        this.attrname = attrname;
    }

    public String getAttrtype() {
        return attrtype;
    }

    public void setAttrtype(String attrtype) {
        this.attrtype = attrtype;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean getDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public short getDisporder() {
        return disporder;
    }

    public void setDisporder(short disporder) {
        this.disporder = disporder;
    }

    public short getSorts() {
        return sorts;
    }

    public void setSorts(short sorts) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        if (!(object instanceof SpplCategoryattrinfo)) {
            return false;
        }
        SpplCategoryattrinfo other = (SpplCategoryattrinfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.SpplCategoryattrinfo[ id=" + id + " ]";
    }
    
}
