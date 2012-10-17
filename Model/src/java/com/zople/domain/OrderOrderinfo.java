/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 王文彦
 */
@Entity
@Table(name = "order_orderinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderOrderinfo.findAll", query = "SELECT o FROM OrderOrderinfo o"),
    @NamedQuery(name = "OrderOrderinfo.findById", query = "SELECT o FROM OrderOrderinfo o WHERE o.id = :id"),
    @NamedQuery(name = "OrderOrderinfo.findByOrderNo", query = "SELECT o FROM OrderOrderinfo o WHERE o.orderNo = :orderNo"),
    @NamedQuery(name = "OrderOrderinfo.findByOrderState", query = "SELECT o FROM OrderOrderinfo o WHERE o.orderState = :orderState"),
    @NamedQuery(name = "OrderOrderinfo.findByStateTime", query = "SELECT o FROM OrderOrderinfo o WHERE o.stateTime = :stateTime"),
    @NamedQuery(name = "OrderOrderinfo.findByReasonCode", query = "SELECT o FROM OrderOrderinfo o WHERE o.reasonCode = :reasonCode"),
    @NamedQuery(name = "OrderOrderinfo.findByRemark", query = "SELECT o FROM OrderOrderinfo o WHERE o.remark = :remark"),
    @NamedQuery(name = "OrderOrderinfo.findByDistributionModel", query = "SELECT o FROM OrderOrderinfo o WHERE o.distributionModel = :distributionModel"),
    @NamedQuery(name = "OrderOrderinfo.findByPayModel", query = "SELECT o FROM OrderOrderinfo o WHERE o.payModel = :payModel"),
    @NamedQuery(name = "OrderOrderinfo.findByPayState", query = "SELECT o FROM OrderOrderinfo o WHERE o.payState = :payState"),
    @NamedQuery(name = "OrderOrderinfo.findByReceivableAmount", query = "SELECT o FROM OrderOrderinfo o WHERE o.receivableAmount = :receivableAmount"),
    @NamedQuery(name = "OrderOrderinfo.findByPrePayment", query = "SELECT o FROM OrderOrderinfo o WHERE o.prePayment = :prePayment"),
    @NamedQuery(name = "OrderOrderinfo.findByFinishTime", query = "SELECT o FROM OrderOrderinfo o WHERE o.finishTime = :finishTime"),
    @NamedQuery(name = "OrderOrderinfo.findByVenderCode", query = "SELECT o FROM OrderOrderinfo o WHERE o.venderCode = :venderCode"),
    @NamedQuery(name = "OrderOrderinfo.findByFreight", query = "SELECT o FROM OrderOrderinfo o WHERE o.freight = :freight"),
    @NamedQuery(name = "OrderOrderinfo.findByWeight", query = "SELECT o FROM OrderOrderinfo o WHERE o.weight = :weight"),
    @NamedQuery(name = "OrderOrderinfo.findByInvoice", query = "SELECT o FROM OrderOrderinfo o WHERE o.invoice = :invoice"),
    @NamedQuery(name = "OrderOrderinfo.findByEnterpriseIdBuy", query = "SELECT o FROM OrderOrderinfo o WHERE o.enterpriseIdBuy = :enterpriseIdBuy"),
    @NamedQuery(name = "OrderOrderinfo.findByOrderTime", query = "SELECT o FROM OrderOrderinfo o WHERE o.orderTime = :orderTime"),
    @NamedQuery(name = "OrderOrderinfo.findByOrderRemaek", query = "SELECT o FROM OrderOrderinfo o WHERE o.orderRemaek = :orderRemaek"),
    @NamedQuery(name = "OrderOrderinfo.findBySaleAmount", query = "SELECT o FROM OrderOrderinfo o WHERE o.saleAmount = :saleAmount"),
    @NamedQuery(name = "OrderOrderinfo.findByTerminateType", query = "SELECT o FROM OrderOrderinfo o WHERE o.terminateType = :terminateType"),
    @NamedQuery(name = "OrderOrderinfo.findByEnterpriseIdSell", query = "SELECT o FROM OrderOrderinfo o WHERE o.enterpriseIdSell = :enterpriseIdSell"),
    @NamedQuery(name = "OrderOrderinfo.findByReceivesTime", query = "SELECT o FROM OrderOrderinfo o WHERE o.receivesTime = :receivesTime"),
    @NamedQuery(name = "OrderOrderinfo.findByExpressId", query = "SELECT o FROM OrderOrderinfo o WHERE o.expressId = :expressId"),
    @NamedQuery(name = "OrderOrderinfo.findByNeedInvoice", query = "SELECT o FROM OrderOrderinfo o WHERE o.needInvoice = :needInvoice"),
    @NamedQuery(name = "OrderOrderinfo.findByReceivedAmount", query = "SELECT o FROM OrderOrderinfo o WHERE o.receivedAmount = :receivedAmount")})
public class OrderOrderinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name="ORDERORDERINFO_GEN",table="TBL_PRIMARY_KEY_GENERATOR",pkColumnName="KEY",valueColumnName="VALUE",pkColumnValue="ORDERORDERINFO_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="ORDERORDERINFO_GEN")

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 200)
    @Column(name = "order_no")
    private String orderNo;
    @Size(max = 8)
    @Column(name = "order_state")
    private String orderState;
    @Column(name = "state_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stateTime;
    @Size(max = 32)
    @Column(name = "reason_code")
    private String reasonCode;
    @Size(max = 32)
    @Column(name = "remark")
    private String remark;
    @Size(max = 32)
    @Column(name = "distribution_model")
    private String distributionModel;
    @Size(max = 32)
    @Column(name = "pay_model")
    private String payModel;
    @Size(max = 20)
    @Column(name = "pay_state")
    private String payState;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "receivable_amount")
    private BigDecimal receivableAmount;
    @Size(max = 32)
    @Column(name = "pre_payment")
    private String prePayment;
    @Column(name = "finish_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishTime;
    @Size(max = 32)
    @Column(name = "vender_code")
    private String venderCode;
    @Column(name = "freight")
    private BigDecimal freight;
    @Column(name = "weight")
    private BigDecimal weight;
    @Size(max = 32)
    @Column(name = "invoice")
    private String invoice;
    @Column(name = "enterprise_id_buy")
    private Long enterpriseIdBuy;
    @Column(name = "order_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;
    @Size(max = 32)
    @Column(name = "order_remaek")
    private String orderRemaek;
    @Column(name = "sale_amount")
    private BigDecimal saleAmount;
    @Size(max = 32)
    @Column(name = "terminate_type")
    private String terminateType;
    @Column(name = "enterprise_id_sell")
    private Long enterpriseIdSell;
    @Column(name = "receives_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivesTime;
    @Size(max = 32)
    @Column(name = "express_id")
    private String expressId;
    @Size(max = 32)
    @Column(name = "need_invoice")
    private String needInvoice;
    @Column(name = "received_amount")
    private BigDecimal receivedAmount;
    
    //订单项
    @OneToMany(mappedBy = "Orderinfo",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    private List<OrderOrderproduct> orderItemsList=new ArrayList();

    public List<OrderOrderproduct> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderOrderproduct> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }
    
    //订单状态
    @OneToMany(cascade={CascadeType.ALL})
    private List<OrderAudit> orderAudit = new ArrayList();
    
    public OrderOrderinfo() {
    }

    public OrderOrderinfo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Date getStateTime() {
        return stateTime;
    }

    public void setStateTime(Date stateTime) {
        this.stateTime = stateTime;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDistributionModel() {
        return distributionModel;
    }

    public void setDistributionModel(String distributionModel) {
        this.distributionModel = distributionModel;
    }

    public String getPayModel() {
        return payModel;
    }

    public void setPayModel(String payModel) {
        this.payModel = payModel;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(BigDecimal receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public String getPrePayment() {
        return prePayment;
    }

    public void setPrePayment(String prePayment) {
        this.prePayment = prePayment;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getVenderCode() {
        return venderCode;
    }

    public void setVenderCode(String venderCode) {
        this.venderCode = venderCode;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Long getEnterpriseIdBuy() {
        return enterpriseIdBuy;
    }

    public void setEnterpriseIdBuy(Long enterpriseIdBuy) {
        this.enterpriseIdBuy = enterpriseIdBuy;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderRemaek() {
        return orderRemaek;
    }

    public void setOrderRemaek(String orderRemaek) {
        this.orderRemaek = orderRemaek;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getTerminateType() {
        return terminateType;
    }

    public void setTerminateType(String terminateType) {
        this.terminateType = terminateType;
    }




    public Date getReceivesTime() {
        return receivesTime;
    }

    public void setReceivesTime(Date receivesTime) {
        this.receivesTime = receivesTime;
    }

    public Long getEnterpriseIdSell() {
        return enterpriseIdSell;
    }

    public void setEnterpriseIdSell(Long enterpriseIdSell) {
        this.enterpriseIdSell = enterpriseIdSell;
    }

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    public String getNeedInvoice() {
        return needInvoice;
    }

    public void setNeedInvoice(String needInvoice) {
        this.needInvoice = needInvoice;
    }

    public BigDecimal getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(BigDecimal receivedAmount) {
        this.receivedAmount = receivedAmount;
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
        if (!(object instanceof OrderOrderinfo)) {
            return false;
        }
        OrderOrderinfo other = (OrderOrderinfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.OrderOrderinfo[ id=" + id + " ]";
    }

    public List<OrderAudit> getOrderAudit() {
        return orderAudit;
    }

    public void setOrderAudit(List<OrderAudit> orderAudit) {
        this.orderAudit = orderAudit;
    }

 
    
}
