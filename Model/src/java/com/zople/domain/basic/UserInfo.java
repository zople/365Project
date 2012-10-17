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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 王文彦
 * 1，用户基本信息实体
 *    用户登陆实体
 */
@Entity
@Table(name = "tbl_userinfo")
@XmlRootElement
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userid")  //用户ID
    private Long id;
    @Column(name = "username")//登陆用户名
    private String loginName;
    @Column(name = "password")//密码
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date effetDate;//账号生效日期
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date failDate;//账号失效日期
    private int locking;//是否锁定用户
    private int flag;//用户状态
    private String creator;//创建人
    private String updateUser;//修改人
    private int sorts;//排序
    private String remarks;//备注
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lockTime;//用户锁定时间
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date preLoginTime;//上次登陆时间
    @Column(name = "usertype")
    private Integer userType;//用户类型
    private int errornum;//密码输错次数
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatetime;//修改时间
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdate;//创建时间

    public Date getEffetDate() {
        return effetDate;
    }

    public void setEffetDate(Date effetDate) {
        this.effetDate = effetDate;
    }

    public Date getFailDate() {
        return failDate;
    }

    public void setFailDate(Date failDate) {
        this.failDate = failDate;
    }

    public int getLocking() {
        return locking;
    }

    public void setLocking(int locking) {
        this.locking = locking;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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

    public int getSorts() {
        return sorts;
    }

    public void setSorts(int sorts) {
        this.sorts = sorts;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public Date getPreLoginTime() {
        return preLoginTime;
    }

    public void setPreLoginTime(Date preLoginTime) {
        this.preLoginTime = preLoginTime;
    }

    public int getErrornum() {
        return errornum;
    }

    public void setErrornum(int errornum) {
        this.errornum = errornum;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    
    public UserInfo() {
    }

    public UserInfo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.dal.domain.TblUser[ id=" + id + " ]";
    }
    
}
