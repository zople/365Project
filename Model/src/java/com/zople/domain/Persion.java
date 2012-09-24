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
 *
 * @author think
 */
@Entity
@Table(name = "persion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persion.findAll", query = "SELECT p FROM Persion p"),
    @NamedQuery(name = "Persion.findById", query = "SELECT p FROM Persion p WHERE p.id = :id"),
    @NamedQuery(name = "Persion.findByPersionName", query = "SELECT p FROM Persion p WHERE p.persionName = :persionName"),
    @NamedQuery(name = "Persion.findByPersionGender", query = "SELECT p FROM Persion p WHERE p.persionGender = :persionGender"),
    @NamedQuery(name = "Persion.findByPersionAge", query = "SELECT p FROM Persion p WHERE p.persionAge = :persionAge"),
    @NamedQuery(name = "Persion.findByNativePlace", query = "SELECT p FROM Persion p WHERE p.nativePlace = :nativePlace"),
    @NamedQuery(name = "Persion.findByPersionEducation", query = "SELECT p FROM Persion p WHERE p.persionEducation = :persionEducation"),
    @NamedQuery(name = "Persion.findByPersionTitle", query = "SELECT p FROM Persion p WHERE p.persionTitle = :persionTitle"),
    @NamedQuery(name = "Persion.findByPoliticalAffiliation", query = "SELECT p FROM Persion p WHERE p.politicalAffiliation = :politicalAffiliation"),
    @NamedQuery(name = "Persion.findByMaritalStatus", query = "SELECT p FROM Persion p WHERE p.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "Persion.findByJobIntention", query = "SELECT p FROM Persion p WHERE p.jobIntention = :jobIntention"),
    @NamedQuery(name = "Persion.findByExpectAddress", query = "SELECT p FROM Persion p WHERE p.expectAddress = :expectAddress"),
    @NamedQuery(name = "Persion.findByExpectSalary", query = "SELECT p FROM Persion p WHERE p.expectSalary = :expectSalary"),
    @NamedQuery(name = "Persion.findByContactTelephone", query = "SELECT p FROM Persion p WHERE p.contactTelephone = :contactTelephone"),
    @NamedQuery(name = "Persion.findByPersionPhone", query = "SELECT p FROM Persion p WHERE p.persionPhone = :persionPhone"),
    @NamedQuery(name = "Persion.findByPersionEmail", query = "SELECT p FROM Persion p WHERE p.persionEmail = :persionEmail"),
    @NamedQuery(name = "Persion.findByPersionQq", query = "SELECT p FROM Persion p WHERE p.persionQq = :persionQq"),
    @NamedQuery(name = "Persion.findByPersionAddress", query = "SELECT p FROM Persion p WHERE p.persionAddress = :persionAddress"),
    @NamedQuery(name = "Persion.findByGraduationSchool", query = "SELECT p FROM Persion p WHERE p.graduationSchool = :graduationSchool"),
    @NamedQuery(name = "Persion.findByPersionProfessional", query = "SELECT p FROM Persion p WHERE p.persionProfessional = :persionProfessional"),
    @NamedQuery(name = "Persion.findByPersionHonor", query = "SELECT p FROM Persion p WHERE p.persionHonor = :persionHonor"),
    @NamedQuery(name = "Persion.findByEducationIntroduction", query = "SELECT p FROM Persion p WHERE p.educationIntroduction = :educationIntroduction"),
    @NamedQuery(name = "Persion.findByWorkedName", query = "SELECT p FROM Persion p WHERE p.workedName = :workedName"),
    @NamedQuery(name = "Persion.findByWorkedDate", query = "SELECT p FROM Persion p WHERE p.workedDate = :workedDate"),
    @NamedQuery(name = "Persion.findByWorkedIntroduction", query = "SELECT p FROM Persion p WHERE p.workedIntroduction = :workedIntroduction"),
    @NamedQuery(name = "Persion.findByJobDate", query = "SELECT p FROM Persion p WHERE p.jobDate = :jobDate")})
public class Persion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 225)
    @Column(name = "persion_name")
    private String persionName;
    @Size(max = 10)
    @Column(name = "persion_gender")
    private String persionGender;
    @Column(name = "persion_age")
    private Integer persionAge;
    @Size(max = 225)
    @Column(name = "native_place")
    private String nativePlace;
    @Size(max = 225)
    @Column(name = "persion_education")
    private String persionEducation;
    @Size(max = 225)
    @Column(name = "persion_title")
    private String persionTitle;
    @Size(max = 225)
    @Column(name = "political_affiliation")
    private String politicalAffiliation;
    @Size(max = 225)
    @Column(name = "marital_status")
    private String maritalStatus;
    @Size(max = 225)
    @Column(name = "job_intention")
    private String jobIntention;
    @Size(max = 225)
    @Column(name = "expect_address")
    private String expectAddress;
    @Size(max = 225)
    @Column(name = "expect_salary")
    private String expectSalary;
    @Size(max = 225)
    @Column(name = "contact_telephone")
    private String contactTelephone;
    @Size(max = 225)
    @Column(name = "persion_phone")
    private String persionPhone;
    @Size(max = 225)
    @Column(name = "persion_email")
    private String persionEmail;
    @Size(max = 225)
    @Column(name = "persion_qq")
    private String persionQq;
    @Size(max = 225)
    @Column(name = "persion_address")
    private String persionAddress;
    @Size(max = 225)
    @Column(name = "graduation_school")
    private String graduationSchool;
    @Size(max = 225)
    @Column(name = "persion_professional")
    private String persionProfessional;
    @Size(max = 225)
    @Column(name = "persion_honor")
    private String persionHonor;
    @Size(max = 225)
    @Column(name = "education_introduction")
    private String educationIntroduction;
    @Size(max = 225)
    @Column(name = "worked_name")
    private String workedName;
    @Size(max = 225)
    @Column(name = "worked_date")
    private String workedDate;
    @Size(max = 225)
    @Column(name = "worked_introduction")
    private String workedIntroduction;
    @Column(name = "job_date")
    @Temporal(TemporalType.DATE)
    private Date jobDate;

    public Persion() {
    }

    public Persion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersionName() {
        return persionName;
    }

    public void setPersionName(String persionName) {
        this.persionName = persionName;
    }

    public String getPersionGender() {
        return persionGender;
    }

    public void setPersionGender(String persionGender) {
        this.persionGender = persionGender;
    }

    public Integer getPersionAge() {
        return persionAge;
    }

    public void setPersionAge(Integer persionAge) {
        this.persionAge = persionAge;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPersionEducation() {
        return persionEducation;
    }

    public void setPersionEducation(String persionEducation) {
        this.persionEducation = persionEducation;
    }

    public String getPersionTitle() {
        return persionTitle;
    }

    public void setPersionTitle(String persionTitle) {
        this.persionTitle = persionTitle;
    }

    public String getPoliticalAffiliation() {
        return politicalAffiliation;
    }

    public void setPoliticalAffiliation(String politicalAffiliation) {
        this.politicalAffiliation = politicalAffiliation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getJobIntention() {
        return jobIntention;
    }

    public void setJobIntention(String jobIntention) {
        this.jobIntention = jobIntention;
    }

    public String getExpectAddress() {
        return expectAddress;
    }

    public void setExpectAddress(String expectAddress) {
        this.expectAddress = expectAddress;
    }

    public String getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(String expectSalary) {
        this.expectSalary = expectSalary;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getPersionPhone() {
        return persionPhone;
    }

    public void setPersionPhone(String persionPhone) {
        this.persionPhone = persionPhone;
    }

    public String getPersionEmail() {
        return persionEmail;
    }

    public void setPersionEmail(String persionEmail) {
        this.persionEmail = persionEmail;
    }

    public String getPersionQq() {
        return persionQq;
    }

    public void setPersionQq(String persionQq) {
        this.persionQq = persionQq;
    }

    public String getPersionAddress() {
        return persionAddress;
    }

    public void setPersionAddress(String persionAddress) {
        this.persionAddress = persionAddress;
    }

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }

    public String getPersionProfessional() {
        return persionProfessional;
    }

    public void setPersionProfessional(String persionProfessional) {
        this.persionProfessional = persionProfessional;
    }

    public String getPersionHonor() {
        return persionHonor;
    }

    public void setPersionHonor(String persionHonor) {
        this.persionHonor = persionHonor;
    }

    public String getEducationIntroduction() {
        return educationIntroduction;
    }

    public void setEducationIntroduction(String educationIntroduction) {
        this.educationIntroduction = educationIntroduction;
    }

    public String getWorkedName() {
        return workedName;
    }

    public void setWorkedName(String workedName) {
        this.workedName = workedName;
    }

    public String getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(String workedDate) {
        this.workedDate = workedDate;
    }

    public String getWorkedIntroduction() {
        return workedIntroduction;
    }

    public void setWorkedIntroduction(String workedIntroduction) {
        this.workedIntroduction = workedIntroduction;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
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
        if (!(object instanceof Persion)) {
            return false;
        }
        Persion other = (Persion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.Persion[ id=" + id + " ]";
    }
    
}
