/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblImage.findAll", query = "SELECT t FROM TblImage t"),
    @NamedQuery(name = "TblImage.findById", query = "SELECT t FROM TblImage t WHERE t.id = :id"),
    @NamedQuery(name = "TblImage.findByImageType", query = "SELECT t FROM TblImage t WHERE t.imageType = :imageType"),
    @NamedQuery(name = "TblImage.findByName", query = "SELECT t FROM TblImage t WHERE t.name = :name"),
    @NamedQuery(name = "TblImage.findByTitle", query = "SELECT t FROM TblImage t WHERE t.title = :title")})
public class TblImage implements Serializable {
    @Lob
    @Column(name = "small")
    private byte[] small;
    @Lob
    @Column(name = "middle")
    private byte[] middle;
    @Lob
    @Column(name = "big")
    private byte[] big;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 20)
    @Column(name = "image_type")
    private String imageType;
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "logoId")
    private List<TblEnterprise> tblEnterpriseList;

    public TblImage() {
    }

    public TblImage(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public List<TblEnterprise> getTblEnterpriseList() {
        return tblEnterpriseList;
    }

    public void setTblEnterpriseList(List<TblEnterprise> tblEnterpriseList) {
        this.tblEnterpriseList = tblEnterpriseList;
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
        if (!(object instanceof TblImage)) {
            return false;
        }
        TblImage other = (TblImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblImage[ id=" + id + " ]";
    }

    public byte[] getSmall() {
        return small;
    }

    public void setSmall(byte[] small) {
        this.small = small;
    }

    public byte[] getMiddle() {
        return middle;
    }

    public void setMiddle(byte[] middle) {
        this.middle = middle;
    }

    public byte[] getBig() {
        return big;
    }

    public void setBig(byte[] big) {
        this.big = big;
    }
    
}
