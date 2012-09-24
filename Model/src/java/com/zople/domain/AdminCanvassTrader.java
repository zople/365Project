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
 *@描   述:   招商管理
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Entity
@Table(name = "admin_canvass_trader")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminCanvassTrader.findAll", query = "SELECT a FROM AdminCanvassTrader a"),
    @NamedQuery(name = "AdminCanvassTrader.findById", query = "SELECT a FROM AdminCanvassTrader a WHERE a.id = :id"),
    @NamedQuery(name = "AdminCanvassTrader.findByDescription", query = "SELECT a FROM AdminCanvassTrader a WHERE a.description = :description"),
    @NamedQuery(name = "AdminCanvassTrader.findByFactoryName", query = "SELECT a FROM AdminCanvassTrader a WHERE a.factoryName = :factoryName"),
    @NamedQuery(name = "AdminCanvassTrader.findByTraderName", query = "SELECT a FROM AdminCanvassTrader a WHERE a.traderName = :traderName"),
    @NamedQuery(name = "AdminCanvassTrader.findByAddress", query = "SELECT a FROM AdminCanvassTrader a WHERE a.address = :address"),
    @NamedQuery(name = "AdminCanvassTrader.findByEndtime", query = "SELECT a FROM AdminCanvassTrader a WHERE a.endtime = :endtime"),
    @NamedQuery(name = "AdminCanvassTrader.findByKind", query = "SELECT a FROM AdminCanvassTrader a WHERE a.kind = :kind"),
    @NamedQuery(name = "AdminCanvassTrader.findByName", query = "SELECT a FROM AdminCanvassTrader a WHERE a.name = :name"),
    @NamedQuery(name = "AdminCanvassTrader.findByPack", query = "SELECT a FROM AdminCanvassTrader a WHERE a.pack = :pack"),
    @NamedQuery(name = "AdminCanvassTrader.findByStandard", query = "SELECT a FROM AdminCanvassTrader a WHERE a.standard = :standard"),
    @NamedQuery(name = "AdminCanvassTrader.findByTitle", query = "SELECT a FROM AdminCanvassTrader a WHERE a.title = :title")})
public class AdminCanvassTrader implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "factory_name")
    private String factoryName;
    @Size(max = 100)
    @Column(name = "trader_name")
    private String traderName;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Column(name = "endtime")
    @Temporal(TemporalType.DATE)
    private Date endtime;
    @Size(max = 255)
    @Column(name = "kind")
    private String kind;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "pack")
    private String pack;
    @Size(max = 255)
    @Column(name = "standard")
    private String standard;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @JoinColumn(name = "en_enterprise_id", referencedColumnName = "id")
    @ManyToOne
    private EnEnterprise enEnterpriseId;

    public EnEnterprise getEnEnterpriseId() {
        return enEnterpriseId;
    }

    public void setEnEnterpriseId(EnEnterprise enEnterpriseId) {
        this.enEnterpriseId = enEnterpriseId;
    }

    public AdminCanvassTrader() {
    }

    public AdminCanvassTrader(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getTraderName() {
        return traderName;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
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
        if (!(object instanceof AdminCanvassTrader)) {
            return false;
        }
        AdminCanvassTrader other = (AdminCanvassTrader) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.AdminCanvassTrader[ id=" + id + " ]";
    }


}
