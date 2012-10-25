/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.basic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author wangxiu
 */
@Entity
@Table(name = "machining_info")
@NamedQueries({
    @NamedQuery(name = "MachiningInfo.findAll", query = "SELECT m FROM MachiningInfo m"),
    @NamedQuery(name = "MachiningInfo.findByMachiningInfoId", query = "SELECT m FROM MachiningInfo m WHERE m.machiningInfoId = :machiningInfoId"),
    @NamedQuery(name = "MachiningInfo.findByMachiningTitle", query = "SELECT m FROM MachiningInfo m WHERE m.machiningTitle = :machiningTitle"),
    @NamedQuery(name = "MachiningInfo.findByMachiningType", query = "SELECT m FROM MachiningInfo m WHERE m.machiningType = :machiningType"),
    @NamedQuery(name = "MachiningInfo.findByMachiningEquipment", query = "SELECT m FROM MachiningInfo m WHERE m.machiningEquipment = :machiningEquipment"),
    @NamedQuery(name = "MachiningInfo.findByProcessingCapability", query = "SELECT m FROM MachiningInfo m WHERE m.processingCapability = :processingCapability"),
    @NamedQuery(name = "MachiningInfo.findByDescription", query = "SELECT m FROM MachiningInfo m WHERE m.description = :description"),
    @NamedQuery(name = "MachiningInfo.findByCreator", query = "SELECT m FROM MachiningInfo m WHERE m.creator = :creator"),
    @NamedQuery(name = "MachiningInfo.findByUpdateUser", query = "SELECT m FROM MachiningInfo m WHERE m.updateUser = :updateUser"),
    @NamedQuery(name = "MachiningInfo.findByUpdateTime", query = "SELECT m FROM MachiningInfo m WHERE m.updateTime = :updateTime"),
    @NamedQuery(name = "MachiningInfo.findByCreateTime", query = "SELECT m FROM MachiningInfo m WHERE m.createTime = :createTime"),
    @NamedQuery(name = "MachiningInfo.findByEnterpriseContactId", query = "SELECT m FROM MachiningInfo m WHERE m.enterpriseContactId = :enterpriseContactId"),
    @NamedQuery(name = "MachiningInfo.findByEnterpriseId", query = "SELECT m FROM MachiningInfo m WHERE m.enterpriseId = :enterpriseId")})
public class MachiningInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @TableGenerator(name="MACHININGINFO_GEN",table="TBL_PRIMARY_KEY_GENERATOR",pkColumnName="KEY",valueColumnName="VALUE",pkColumnValue="MACHININGINFO_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="MACHININGINFO_GEN")
    @Column(name = "machining_info_id")
    private Long machiningInfoId;
    @Size(max = 100)
    @Column(name = "machining_title")
    private String machiningTitle;
    @Column(name = "machining_type")
    private Integer machiningType;
    @Size(max = 50)
    @Column(name = "machining_equipment")
    private String machiningEquipment;
    @Size(max = 100)
    @Column(name = "processing_capability")
    private String processingCapability;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Size(max = 50)
    @Column(name = "creator")
    private String creator;
    @Size(max = 50)
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "enterprise_id")
    private Long enterpriseId;
    @Column(name = "enterprise_contact_id")
    private Long enterpriseContactId;
    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseContactId() {
        return enterpriseContactId;
    }

    public void setEnterpriseContactId(Long enterpriseContactId) {
        this.enterpriseContactId = enterpriseContactId;
    }
   

    public MachiningInfo() {
    }

    public MachiningInfo(Long machiningInfoId) {
        this.machiningInfoId = machiningInfoId;
    }

    public Long getMachiningInfoId() {
        return machiningInfoId;
    }

    public void setMachiningInfoId(Long machiningInfoId) {
        this.machiningInfoId = machiningInfoId;
    }

    public String getMachiningTitle() {
        return machiningTitle;
    }

    public void setMachiningTitle(String machiningTitle) {
        this.machiningTitle = machiningTitle;
    }

    public Integer getMachiningType() {
        return machiningType;
    }

    public void setMachiningType(Integer machiningType) {
        this.machiningType = machiningType;
    }

    public String getMachiningEquipment() {
        return machiningEquipment;
    }

    public void setMachiningEquipment(String machiningEquipment) {
        this.machiningEquipment = machiningEquipment;
    }

    public String getProcessingCapability() {
        return processingCapability;
    }

    public void setProcessingCapability(String processingCapability) {
        this.processingCapability = processingCapability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (machiningInfoId != null ? machiningInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MachiningInfo)) {
            return false;
        }
        MachiningInfo other = (MachiningInfo) object;
        if ((this.machiningInfoId == null && other.machiningInfoId != null) || (this.machiningInfoId != null && !this.machiningInfoId.equals(other.machiningInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.service.common.MachiningInfo[ machiningInfoId=" + machiningInfoId + " ]";
    }
    
}
