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

/**
 *
 * @author wangxiu
 */
@Entity
@Table(name = "order_audit")
@NamedQueries({
    @NamedQuery(name = "OrderAudit.findAll", query = "SELECT o FROM OrderAudit o"),
    @NamedQuery(name = "OrderAudit.findByAuditId", query = "SELECT o FROM OrderAudit o WHERE o.auditId = :auditId"),
    @NamedQuery(name = "OrderAudit.findByOrderno", query = "SELECT o FROM OrderAudit o WHERE o.orderno = :orderno"),
    @NamedQuery(name = "OrderAudit.findByAuditState", query = "SELECT o FROM OrderAudit o WHERE o.auditState = :auditState"),
    @NamedQuery(name = "OrderAudit.findByAuditContent", query = "SELECT o FROM OrderAudit o WHERE o.auditContent = :auditContent"),
    @NamedQuery(name = "OrderAudit.findByAuditTime", query = "SELECT o FROM OrderAudit o WHERE o.auditTime = :auditTime")})
public class OrderAudit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "audit_id")
    private Long auditId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "orderno")
    private String orderno;
    @Column(name = "audit_state")
    private Integer auditState;
    @Size(max = 100)
    @Column(name = "audit_content")
    private String auditContent;
    @Column(name = "audit_time")
    @Temporal(TemporalType.TIME)
    private Date auditTime;


    public OrderAudit() {
    }

    public OrderAudit(Long auditId) {
        this.auditId = auditId;
    }

    public OrderAudit(Long auditId, String orderno) {
        this.auditId = auditId;
        this.orderno = orderno;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auditId != null ? auditId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderAudit)) {
            return false;
        }
        OrderAudit other = (OrderAudit) object;
        if ((this.auditId == null && other.auditId != null) || (this.auditId != null && !this.auditId.equals(other.auditId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.OrderAudit[ auditId=" + auditId + " ]";
    }
    
}
