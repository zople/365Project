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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *@描   述:   
 *@ author:  yuzhijian_yuxia2217@163.com
 *@version: 1.0
 */
@Entity
@Table(name = "en_recruitment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnRecruitment.findAll", query = "SELECT e FROM EnRecruitment e"),
    @NamedQuery(name = "EnRecruitment.findById", query = "SELECT e FROM EnRecruitment e WHERE e.id = :id"),
    @NamedQuery(name = "EnRecruitment.findByDescription", query = "SELECT e FROM EnRecruitment e WHERE e.description = :description"),
    @NamedQuery(name = "EnRecruitment.findByName", query = "SELECT e FROM EnRecruitment e WHERE e.name = :name"),
    @NamedQuery(name = "EnRecruitment.findByPhone", query = "SELECT e FROM EnRecruitment e WHERE e.phone = :phone"),
    @NamedQuery(name = "EnRecruitment.findByCount", query = "SELECT e FROM EnRecruitment e WHERE e.count = :count"),
    @NamedQuery(name = "EnRecruitment.findByCreateTime", query = "SELECT e FROM EnRecruitment e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EnRecruitment.findByExperience", query = "SELECT e FROM EnRecruitment e WHERE e.experience = :experience"),
    @NamedQuery(name = "EnRecruitment.findByItRequire", query = "SELECT e FROM EnRecruitment e WHERE e.itRequire = :itRequire"),
    @NamedQuery(name = "EnRecruitment.findByPay", query = "SELECT e FROM EnRecruitment e WHERE e.pay = :pay"),
    @NamedQuery(name = "EnRecruitment.findByRequire", query = "SELECT e FROM EnRecruitment e WHERE e.require = :require"),
    @NamedQuery(name = "EnRecruitment.findByAddress", query = "SELECT e FROM EnRecruitment e WHERE e.address = :address"),
    @NamedQuery(name = "EnRecruitment.findByEducation", query = "SELECT e FROM EnRecruitment e WHERE e.education = :education"),
    @NamedQuery(name = "EnRecruitment.findByEndTime", query = "SELECT e FROM EnRecruitment e WHERE e.endTime = :endTime"),
    @NamedQuery(name = "EnRecruitment.findByQuale", query = "SELECT e FROM EnRecruitment e WHERE e.quale = :quale"),
    @NamedQuery(name = "EnRecruitment.findBySex", query = "SELECT e FROM EnRecruitment e WHERE e.sex = :sex"),
    @NamedQuery(name = "EnRecruitment.findByForeignLang", query = "SELECT e FROM EnRecruitment e WHERE e.foreignLang = :foreignLang"),
    @NamedQuery(name = "EnRecruitment.findByRelatedinfo", query = "SELECT e FROM EnRecruitment e WHERE e.relatedinfo = :relatedinfo")})
public class EnRecruitment implements Serializable {
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
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count")
    private int count;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "experience")
    private int experience;
    @Size(max = 255)
    @Column(name = "it_require")
    private String itRequire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pay")
    private int pay;
    @Size(max = 255)
    @Column(name = "require")
    private String require;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "education")
    private String education;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 255)
    @Column(name = "quale")
    private String quale;
    @Size(max = 255)
    @Column(name = "sex")
    private String sex;
    @Size(max = 255)
    @Column(name = "foreign_lang")
    private String foreignLang;
    @Size(max = 200)
    @Column(name = "relatedinfo")
    private String relatedinfo;

    public EnRecruitment() {
    }

    public EnRecruitment(Long id) {
        this.id = id;
    }

    public EnRecruitment(Long id, int count, int experience, int pay) {
        this.id = id;
        this.count = count;
        this.experience = experience;
        this.pay = pay;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getItRequire() {
        return itRequire;
    }

    public void setItRequire(String itRequire) {
        this.itRequire = itRequire;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getQuale() {
        return quale;
    }

    public void setQuale(String quale) {
        this.quale = quale;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getForeignLang() {
        return foreignLang;
    }

    public void setForeignLang(String foreignLang) {
        this.foreignLang = foreignLang;
    }

    public String getRelatedinfo() {
        return relatedinfo;
    }

    public void setRelatedinfo(String relatedinfo) {
        this.relatedinfo = relatedinfo;
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
        if (!(object instanceof EnRecruitment)) {
            return false;
        }
        EnRecruitment other = (EnRecruitment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.EnRecruitment[ id=" + id + " ]";
    }

}
