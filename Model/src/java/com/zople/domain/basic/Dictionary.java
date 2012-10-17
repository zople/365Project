/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zople.domain.basic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Lucene词库字典表
 * @author 王文彦
 */
@Entity
@Table(name="tbl_dictionary")
public class Dictionary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name="DICTIONARY_GEN",table="TBL_PRIMARY_KEY_GENERATOR",pkColumnName="KEY",valueColumnName="VALUE",pkColumnValue="DICTIONARY_ID",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.TABLE, generator="DICTIONARY_GEN")
    private Long id;
    
    private String word;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dictionary)) {
            return false;
        }
        Dictionary other = (Dictionary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zople.domain.basic.Dictionary[ id=" + id + " ]";
    }
    
}
