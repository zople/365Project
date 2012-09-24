/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "tbl_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i"),
    @NamedQuery(name = "Image.findById", query = "SELECT i FROM Image i WHERE i.id = :id"),
    @NamedQuery(name = "Image.findByImageType", query = "SELECT i FROM Image i WHERE i.imageType = :imageType"),
    @NamedQuery(name = "Image.findByTitle", query = "SELECT i FROM Image i WHERE i.title = :title"),
    @NamedQuery(name = "Image.findByName", query = "SELECT i FROM Image i WHERE i.name = :name")})
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name="IMAGE_GEN",table="TBL_PRIMARY_KEY_GENERATOR",pkColumnName="KEY",valueColumnName="VALUE",pkColumnValue="IMAGE_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="IMAGE_GEN")
    private Long id;
    @Size(max = 20)
    @Column(name = "image_type")
    private String imageType;
    @Column(name = "small")
    private byte[] small;
    @Column(name = "middle")
    private byte[] middle;
    @Column(name = "big")
    private byte[] big;
    @Size(max = 200)
    @Column(name = "title")
    private String title;
    @Size(max = 200)
    @Column(name = "name")
    private String name;

    public Image() {
    }

    public Image(Long id) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Image[ id=" + id + " ]";
    }
    
}
