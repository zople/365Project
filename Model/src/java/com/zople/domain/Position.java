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
 *
 * @author think
 */
@Entity
@Table(name = "position")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p"),
    @NamedQuery(name = "Position.findById", query = "SELECT p FROM Position p WHERE p.id = :id"),
    @NamedQuery(name = "Position.findByPositionName", query = "SELECT p FROM Position p WHERE p.positionName = :positionName"),
    @NamedQuery(name = "Position.findByNeedCount", query = "SELECT p FROM Position p WHERE p.needCount = :needCount"),
    @NamedQuery(name = "Position.findByGenderRequirement", query = "SELECT p FROM Position p WHERE p.genderRequirement = :genderRequirement"),
    @NamedQuery(name = "Position.findByAcademicRequirement", query = "SELECT p FROM Position p WHERE p.academicRequirement = :academicRequirement"),
    @NamedQuery(name = "Position.findByWorkExperience", query = "SELECT p FROM Position p WHERE p.workExperience = :workExperience"),
    @NamedQuery(name = "Position.findByWorkNature", query = "SELECT p FROM Position p WHERE p.workNature = :workNature"),
    @NamedQuery(name = "Position.findBySalaryRange", query = "SELECT p FROM Position p WHERE p.salaryRange = :salaryRange"),
    @NamedQuery(name = "Position.findByLanguageRequirement", query = "SELECT p FROM Position p WHERE p.languageRequirement = :languageRequirement"),
    @NamedQuery(name = "Position.findByWorkAddress", query = "SELECT p FROM Position p WHERE p.workAddress = :workAddress"),
    @NamedQuery(name = "Position.findByCreateTime", query = "SELECT p FROM Position p WHERE p.createTime = :createTime"),
    @NamedQuery(name = "Position.findByEndTime", query = "SELECT p FROM Position p WHERE p.endTime = :endTime"),
    @NamedQuery(name = "Position.findByOtherRequirement", query = "SELECT p FROM Position p WHERE p.otherRequirement = :otherRequirement"),
    @NamedQuery(name = "Position.findByPositionDescription", query = "SELECT p FROM Position p WHERE p.positionDescription = :positionDescription"),
    @NamedQuery(name = "Position.findByPositionRequirement", query = "SELECT p FROM Position p WHERE p.positionRequirement = :positionRequirement")})
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 225)
    @Column(name = "position_name")
    private String positionName;
    @Column(name = "need_count")
    private Integer needCount;
    @Size(max = 10)
    @Column(name = "gender_requirement")
    private String genderRequirement;
    @Size(max = 225)
    @Column(name = "academic_requirement")
    private String academicRequirement;
    @Size(max = 225)
    @Column(name = "work_experience")
    private String workExperience;
    @Size(max = 225)
    @Column(name = "work_nature")
    private String workNature;
    @Size(max = 100)
    @Column(name = "salary_range")
    private String salaryRange;
    @Size(max = 225)
    @Column(name = "language_requirement")
    private String languageRequirement;
    @Size(max = 225)
    @Column(name = "work_address")
    private String workAddress;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.DATE)
    private Date endTime;
    @Size(max = 225)
    @Column(name = "other_requirement")
    private String otherRequirement;
    @Size(max = 225)
    @Column(name = "position_description")
    private String positionDescription;
    @Size(max = 225)
    @Column(name = "position_requirement")
    private String positionRequirement;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company companyId;

    public Position() {
    }

    public Position(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getNeedCount() {
        return needCount;
    }

    public void setNeedCount(Integer needCount) {
        this.needCount = needCount;
    }

    public String getGenderRequirement() {
        return genderRequirement;
    }

    public void setGenderRequirement(String genderRequirement) {
        this.genderRequirement = genderRequirement;
    }

    public String getAcademicRequirement() {
        return academicRequirement;
    }

    public void setAcademicRequirement(String academicRequirement) {
        this.academicRequirement = academicRequirement;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getWorkNature() {
        return workNature;
    }

    public void setWorkNature(String workNature) {
        this.workNature = workNature;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getLanguageRequirement() {
        return languageRequirement;
    }

    public void setLanguageRequirement(String languageRequirement) {
        this.languageRequirement = languageRequirement;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOtherRequirement() {
        return otherRequirement;
    }

    public void setOtherRequirement(String otherRequirement) {
        this.otherRequirement = otherRequirement;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public String getPositionRequirement() {
        return positionRequirement;
    }

    public void setPositionRequirement(String positionRequirement) {
        this.positionRequirement = positionRequirement;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
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
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Position[ id=" + id + " ]";
    }
    
}
