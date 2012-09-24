/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
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
@Table(name = "en_money")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnMoney.findAll", query = "SELECT e FROM EnMoney e"),
    @NamedQuery(name = "EnMoney.findById", query = "SELECT e FROM EnMoney e WHERE e.id = :id"),
    @NamedQuery(name = "EnMoney.findByMoney", query = "SELECT e FROM EnMoney e WHERE e.money = :money"),
    @NamedQuery(name = "EnMoney.findByName", query = "SELECT e FROM EnMoney e WHERE e.name = :name")})
public class EnMoney implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "money")
    private int money;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "en_enterprise_id", referencedColumnName = "id")
    @ManyToOne
    private EnEnterprise enEnterpriseId;

    public EnMoney() {
    }

    public EnMoney(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof EnMoney)) {
            return false;
        }
        EnMoney other = (EnMoney) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.EnMoney[ id=" + id + " ]";
    }
    
}
