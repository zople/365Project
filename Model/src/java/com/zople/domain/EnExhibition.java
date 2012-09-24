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
 * @author 王文彦
 */
@Entity
@Table(name = "en_exhibition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnExhibition.findAll", query = "SELECT e FROM EnExhibition e"),
    @NamedQuery(name = "EnExhibition.findById", query = "SELECT e FROM EnExhibition e WHERE e.id = :id"),
    @NamedQuery(name = "EnExhibition.findByContent", query = "SELECT e FROM EnExhibition e WHERE e.content = :content"),
    @NamedQuery(name = "EnExhibition.findByAddress", query = "SELECT e FROM EnExhibition e WHERE e.address = :address"),
    @NamedQuery(name = "EnExhibition.findByAuthorize", query = "SELECT e FROM EnExhibition e WHERE e.authorize = :authorize"),
    @NamedQuery(name = "EnExhibition.findByCreateTime", query = "SELECT e FROM EnExhibition e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EnExhibition.findByDescription", query = "SELECT e FROM EnExhibition e WHERE e.description = :description"),
    @NamedQuery(name = "EnExhibition.findByHotline", query = "SELECT e FROM EnExhibition e WHERE e.hotline = :hotline"),
    @NamedQuery(name = "EnExhibition.findByLine", query = "SELECT e FROM EnExhibition e WHERE e.line = :line"),
    @NamedQuery(name = "EnExhibition.findByMsn", query = "SELECT e FROM EnExhibition e WHERE e.msn = :msn"),
    @NamedQuery(name = "EnExhibition.findByOrganizer", query = "SELECT e FROM EnExhibition e WHERE e.organizer = :organizer"),
    @NamedQuery(name = "EnExhibition.findByPhone", query = "SELECT e FROM EnExhibition e WHERE e.phone = :phone"),
    @NamedQuery(name = "EnExhibition.findByQq", query = "SELECT e FROM EnExhibition e WHERE e.qq = :qq"),
    @NamedQuery(name = "EnExhibition.findBySponsor", query = "SELECT e FROM EnExhibition e WHERE e.sponsor = :sponsor"),
    @NamedQuery(name = "EnExhibition.findByStartTime", query = "SELECT e FROM EnExhibition e WHERE e.startTime = :startTime"),
    @NamedQuery(name = "EnExhibition.findByTitle", query = "SELECT e FROM EnExhibition e WHERE e.title = :title"),
    @NamedQuery(name = "EnExhibition.findByUrl", query = "SELECT e FROM EnExhibition e WHERE e.url = :url"),
    @NamedQuery(name = "EnExhibition.findByName", query = "SELECT e FROM EnExhibition e WHERE e.name = :name")})
public class EnExhibition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "authorize")
    private String authorize;
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "hotline")
    private String hotline;
    @Size(max = 255)
    @Column(name = "line")
    private String line;
    @Size(max = 255)
    @Column(name = "msn")
    private String msn;
    @Size(max = 255)
    @Column(name = "organizer")
    private String organizer;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qq")
    private int qq;
    @Size(max = 255)
    @Column(name = "sponsor")
    private String sponsor;
    @Column(name = "start_time")
    @Temporal(TemporalType.DATE)
    private Date startTime;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    public EnExhibition() {
    }

    public EnExhibition(Long id) {
        this.id = id;
    }

    public EnExhibition(Long id, int qq) {
        this.id = id;
        this.qq = qq;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof EnExhibition)) {
            return false;
        }
        EnExhibition other = (EnExhibition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.EnExhibition[ id=" + id + " ]";
    }
    
}
