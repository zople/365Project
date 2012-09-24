/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "en_businessmen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnBusinessmen.findAll", query = "SELECT e FROM EnBusinessmen e"),
    @NamedQuery(name = "EnBusinessmen.findById", query = "SELECT e FROM EnBusinessmen e WHERE e.id = :id"),
    @NamedQuery(name = "EnBusinessmen.findByGroupName", query = "SELECT e FROM EnBusinessmen e WHERE e.groupName = :groupName"),
    @NamedQuery(name = "EnBusinessmen.findByDescription", query = "SELECT e FROM EnBusinessmen e WHERE e.description = :description"),
    @NamedQuery(name = "EnBusinessmen.findByFlg", query = "SELECT e FROM EnBusinessmen e WHERE e.flg = :flg"),
    @NamedQuery(name = "EnBusinessmen.findByName", query = "SELECT e FROM EnBusinessmen e WHERE e.name = :name")})
public class EnBusinessmen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 50)
    @Column(name = "group_name")
    private String groupName;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "flg")
    private BigDecimal flg;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    @ManyToOne
    private EnEnterprise friendId;
    @JoinColumn(name = "en_enterprise_id", referencedColumnName = "id")
    @ManyToOne
    private EnEnterprise enEnterpriseId;

    public EnBusinessmen() {
    }

    public EnBusinessmen(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getFlg() {
        return flg;
    }

    public void setFlg(BigDecimal flg) {
        this.flg = flg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnEnterprise getFriendId() {
        return friendId;
    }

    public void setFriendId(EnEnterprise friendId) {
        this.friendId = friendId;
    }

    public EnEnterprise getEnEnterpriseId() {
        return enEnterpriseId;
    }

    public void setEnEnterpriseId(EnEnterprise enEnterpriseId) {
        this.enEnterpriseId = enEnterpriseId;
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
        if (!(object instanceof EnBusinessmen)) {
            return false;
        }
        EnBusinessmen other = (EnBusinessmen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.EnBusinessmen[ id=" + id + " ]";
    }
    
}
