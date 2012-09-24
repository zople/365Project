/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name="tbl_enterprise")
public class Enterprise implements Serializable {
    @Id
    @TableGenerator(name="ENTERPRISE_GEN",table="TBL_PRIMARY_KEY_GENERATOR",pkColumnName="KEY",valueColumnName="VALUE",pkColumnValue="ENTERPRISE_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="ENTERPRISE_GEN")
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy="enterprise",cascade = {CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Product> products;
    @OneToOne(cascade={CascadeType.ALL})
    private Image logo;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Enterprise() {
    }

    public Enterprise(Long id) {
        this.id = id;
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
        if (!(object instanceof Enterprise)) {
            return false;
        }
        Enterprise other = (Enterprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Enterprise[ id=" + id + " ]";
    }
    
}
