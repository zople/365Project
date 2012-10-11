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
 * @author wangxiu
 * 系统功能菜单模块实体
 */
@Entity
@Table(name = "tbl_menus_info")
@NamedQueries({
    @NamedQuery(name = "MenusInfo.findAll", query = "SELECT m FROM MenusInfo m"),
    @NamedQuery(name = "MenusInfo.findByMenuid", query = "SELECT m FROM MenusInfo m WHERE m.menuid = :menuid"),
    @NamedQuery(name = "MenusInfo.findByPid", query = "SELECT m FROM MenusInfo m WHERE m.pid = :pid"),
    @NamedQuery(name = "MenusInfo.findByTexts", query = "SELECT m FROM MenusInfo m WHERE m.texts = :texts"),
    @NamedQuery(name = "MenusInfo.findByMenuName", query = "SELECT m FROM MenusInfo m WHERE m.menuName = :menuName"),
    @NamedQuery(name = "MenusInfo.findByIconCls", query = "SELECT m FROM MenusInfo m WHERE m.iconCls = :iconCls"),
    @NamedQuery(name = "MenusInfo.findByMenucontrol", query = "SELECT m FROM MenusInfo m WHERE m.menucontrol = :menucontrol"),
    @NamedQuery(name = "MenusInfo.findByMenuview", query = "SELECT m FROM MenusInfo m WHERE m.menuview = :menuview"),
    @NamedQuery(name = "MenusInfo.findByDescription", query = "SELECT m FROM MenusInfo m WHERE m.description = :description"),
    @NamedQuery(name = "MenusInfo.findByMenuType", query = "SELECT m FROM MenusInfo m WHERE m.menuType = :menuType"),
    @NamedQuery(name = "MenusInfo.findByExpanded", query = "SELECT m FROM MenusInfo m WHERE m.expanded = :expanded"),
    @NamedQuery(name = "MenusInfo.findByTreeId", query = "SELECT m FROM MenusInfo m WHERE m.treeId = :treeId"),
    @NamedQuery(name = "MenusInfo.findByMenustore", query = "SELECT m FROM MenusInfo m WHERE m.menustore = :menustore"),
    @NamedQuery(name = "MenusInfo.findBySorts", query = "SELECT m FROM MenusInfo m WHERE m.sorts = :sorts"),
    @NamedQuery(name = "MenusInfo.findByCreator", query = "SELECT m FROM MenusInfo m WHERE m.creator = :creator"),
    @NamedQuery(name = "MenusInfo.findByUpdateUser", query = "SELECT m FROM MenusInfo m WHERE m.updateUser = :updateUser"),
    @NamedQuery(name = "MenusInfo.findByUpdateTime", query = "SELECT m FROM MenusInfo m WHERE m.updateTime = :updateTime"),
    @NamedQuery(name = "MenusInfo.findByCreateTime", query = "SELECT m FROM MenusInfo m WHERE m.createTime = :createTime")})
public class MenusInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "menuid")
    private Long menuid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pid")
    private long pid;
    @Size(max = 50)
    @Column(name = "texts")
    private String texts;
    @Size(max = 100)
    @Column(name = "menu_name")
    private String menuName;
    @Size(max = 50)
    @Column(name = "icon_cls")
    private String iconCls;
    @Size(max = 100)
    @Column(name = "menucontrol")
    private String menucontrol;
    @Size(max = 100)
    @Column(name = "menuview")
    private String menuview;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Column(name = "menu_type")
    private Integer menuType;
    @Column(name = "expanded")
    private Integer expanded;
    @Column(name = "tree_id")
    private BigInteger treeId;
    @Size(max = 50)
    @Column(name = "menustore")
    private String menustore;
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

    public MenusInfo() {
    }

    public MenusInfo(Long menuid) {
        this.menuid = menuid;
    }

    public MenusInfo(Long menuid, long pid) {
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
        if (!(object instanceof MenusInfo)) {
            return false;
        }
        MenusInfo other = (MenusInfo) object;
        if ((this.menuid == null && other.menuid != null) || (this.menuid != null && !this.menuid.equals(other.menuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.MenusInfo[ menuid=" + menuid + " ]";
    }
    
}
