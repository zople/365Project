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
 * @author 王文彦
 */
@Entity
@Table(name = "order_invoice")
@NamedQueries({
    @NamedQuery(name = "OrderInvoice.findAll", query = "SELECT o FROM OrderInvoice o"),
    @NamedQuery(name = "OrderInvoice.findById", query = "SELECT o FROM OrderInvoice o WHERE o.id = :id"),
    @NamedQuery(name = "OrderInvoice.findByInvoiceType", query = "SELECT o FROM OrderInvoice o WHERE o.invoiceType = :invoiceType"),
    @NamedQuery(name = "OrderInvoice.findByHead", query = "SELECT o FROM OrderInvoice o WHERE o.head = :head"),
    @NamedQuery(name = "OrderInvoice.findByHeadType", query = "SELECT o FROM OrderInvoice o WHERE o.headType = :headType"),
    @NamedQuery(name = "OrderInvoice.findByCorpName", query = "SELECT o FROM OrderInvoice o WHERE o.corpName = :corpName"),
    @NamedQuery(name = "OrderInvoice.findByTaxpayerNo", query = "SELECT o FROM OrderInvoice o WHERE o.taxpayerNo = :taxpayerNo"),
    @NamedQuery(name = "OrderInvoice.findByInvoiceTime", query = "SELECT o FROM OrderInvoice o WHERE o.invoiceTime = :invoiceTime")})
public class OrderInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 20)
    @Column(name = "invoice_type", length = 20)
    private String invoiceType;
    @Size(max = 20)
    @Column(name = "head", length = 20)
    private String head;
    @Size(max = 20)
    @Column(name = "head_type", length = 20)
    private String headType;
    @Size(max = 20)
    @Column(name = "corp_name", length = 20)
    private String corpName;
    @Size(max = 20)
    @Column(name = "taxpayer_no", length = 20)
    private String taxpayerNo;
    @Column(name = "invoice_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceTime;

    public OrderInvoice() {
    }

    public OrderInvoice(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHeadType() {
        return headType;
    }

    public void setHeadType(String headType) {
        this.headType = headType;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getTaxpayerNo() {
        return taxpayerNo;
    }

    public void setTaxpayerNo(String taxpayerNo) {
        this.taxpayerNo = taxpayerNo;
    }

    public Date getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(Date invoiceTime) {
        this.invoiceTime = invoiceTime;
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
        if (!(object instanceof OrderInvoice)) {
            return false;
        }
        OrderInvoice other = (OrderInvoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.OrderInvoice[ id=" + id + " ]";
    }
    
}
