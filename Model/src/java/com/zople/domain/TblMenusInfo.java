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
@Table(name = "tbl_menus_info")
@NamedQueries({
    @NamedQuery(name = "TblMenusInfo.findAll", query = "SELECT t FROM TblMenusInfo t"),
    @NamedQuery(name = "TblMenusInfo.findByMenuid", query = "SELECT t FROM TblMenusInfo t WHERE t.menuid = :menuid"),
    @NamedQuery(name = "TblMenusInfo.findByPid", query = "SELECT t FROM TblMenusInfo t WHERE t.pid = :pid"),
    @NamedQuery(name = "TblMenusInfo.findByTexts", query = "SELECT t FROM TblMenusInfo t WHERE t.texts = :texts"),
    @NamedQuery(name = "TblMenusInfo.findByMenuName", query = "SELECT t FROM TblMenusInfo t WHERE t.menuName = :menuName"),
    @NamedQuery(name = "TblMenusInfo.findByIconCls", query = "SELECT t FROM TblMenusInfo t WHERE t.iconCls = :iconCls"),
    @NamedQuery(name = "TblMenusInfo.findByMenucontrol", query = "SELECT t FROM TblMenusInfo t WHERE t.menucontrol = :menucontrol"),
    @NamedQuery(name = "TblMenusInfo.findByMenuview", query = "SELECT t FROM TblMenusInfo t WHERE t.menuview = :menuview"),
    @NamedQuery(name = "TblMenusInfo.findByDescription", query = "SELECT t FROM TblMenusInfo t WHERE t.description = :description"),
    @NamedQuery(name = "TblMenusInfo.findByMenuType", query = "SELECT t FROM TblMenusInfo t WHERE t.menuType = :menuType"),
    @NamedQuery(name = "TblMenusInfo.findByExpanded", query = "SELECT t FROM TblMenusInfo t WHERE t.expanded = :expanded"),
    @NamedQuery(name = "TblMenusInfo.findByTreeId", query = "SELECT t FROM TblMenusInfo t WHERE t.treeId = :treeId"),
    @NamedQuery(name = "TblMenusInfo.findByMenustore", query = "SELECT t FROM TblMenusInfo t WHERE t.menustore = :menustore"),
    @NamedQuery(name = "TblMenusInfo.findBySorts", query = "SELECT t FROM TblMenusInfo t WHERE t.sorts = :sorts"),
    @NamedQuery(name = "TblMenusInfo.findByCreator", query = "SELECT t FROM TblMenusInfo t WHERE t.creator = :creator"),
    @NamedQuery(name = "TblMenusInfo.findByUpdateUser", query = "SELECT t FROM TblMenusInfo t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TblMenusInfo.findByUpdateTime", query = "SELECT t FROM TblMenusInfo t WHERE t.updateTime = :updateTime"),
    @NamedQuery(name = "TblMenusInfo.findByCreateTime", query = "SELECT t FROM TblMenusInfo t WHERE t.createTime = :createTime")})
public class TblMenusInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "menuid", nullable = false)
    private Long menuid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pid", nullable = false)
    private long pid;
    @Size(max = 50)
    @Column(name = "texts", length = 50)
    private String texts;
    @Size(max = 100)
    @Column(name = "menu_name", length = 100)
    private String menuName;
    @Size(max = 50)
    @Column(name = "icon_cls", length = 50)
    private String iconCls;
    @Size(max = 100)
    @Column(name = "menucontrol", length = 100)
    private String menucontrol;
    @Size(max = 100)
    @Column(name = "menuview", length = 100)
    private String menuview;
    @Size(max = 100)
    @Column(name = "description", length = 100)
    private String description;
    @Column(name = "menu_type")
    private Integer menuType;
    @Column(name = "expanded")
    private Integer expanded;
    @Column(name = "tree_id")
    private BigInteger treeId;
    @Size(max = 50)
    @Column(name = "menustore", length = 50)
    private String menustore;
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

    public TblMenusInfo() {
    }

    public TblMenusInfo(Long menuid) {
        this.menuid = menuid;
    }

    public TblMenusInfo(Long menuid, long pid) {
        this.menuid = menuid;
        this.pid = pid;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getMenucontrol() {
        return menucontrol;
    }

    public void setMenucontrol(String menucontrol) {
        this.menucontrol = menucontrol;
    }

    public String getMenuview() {
        return menuview;
    }

    public void setMenuview(String menuview) {
        this.menuview = menuview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public Integer getExpanded() {
        return expanded;
    }

    public void setExpanded(Integer expanded) {
        this.expanded = expanded;
    }

    public BigInteger getTreeId() {
        return treeId;
    }

    public void setTreeId(BigInteger treeId) {
        this.treeId = treeId;
    }

    public String getMenustore() {
        return menustore;
    }

    public void setMenustore(String menustore) {
        this.menustore = menustore;
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
        hash += (menuid != null ? menuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMenusInfo)) {
            return false;
        }
        TblMenusInfo other = (TblMenusInfo) object;
        if ((this.menuid == null && other.menuid != null) || (this.menuid != null && !this.menuid.equals(other.menuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.TblMenusInfo[ menuid=" + menuid + " ]";
    }
    
}
