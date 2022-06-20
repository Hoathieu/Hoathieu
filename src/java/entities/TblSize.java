/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblSize")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSize.findAll", query = "SELECT t FROM TblSize t"),
    @NamedQuery(name = "TblSize.findBySizeId", query = "SELECT t FROM TblSize t WHERE t.sizeId = :sizeId"),
    @NamedQuery(name = "TblSize.findBySizeName", query = "SELECT t FROM TblSize t WHERE t.sizeName = :sizeName"),
    @NamedQuery(name = "TblSize.findByStatus", query = "SELECT t FROM TblSize t WHERE t.status = :status")})
public class TblSize implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sizeId")
    private Integer sizeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sizeName")
    private String sizeName;
    @Column(name = "status")
    private Boolean status;

    public TblSize() {
    }

    public TblSize(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public TblSize(Integer sizeId, String sizeName) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sizeId != null ? sizeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSize)) {
            return false;
        }
        TblSize other = (TblSize) object;
        if ((this.sizeId == null && other.sizeId != null) || (this.sizeId != null && !this.sizeId.equals(other.sizeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblSize[ sizeId=" + sizeId + " ]";
    }
    
}
