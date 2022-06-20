/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblCoupon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCoupon.findAll", query = "SELECT t FROM TblCoupon t"),
    @NamedQuery(name = "TblCoupon.findByCouId", query = "SELECT t FROM TblCoupon t WHERE t.couId = :couId"),
    @NamedQuery(name = "TblCoupon.findByCode", query = "SELECT t FROM TblCoupon t WHERE t.code = :code"),
    @NamedQuery(name = "TblCoupon.findByCodeValue", query = "SELECT t FROM TblCoupon t WHERE t.codeValue = :codeValue"),
    @NamedQuery(name = "TblCoupon.findByStatus", query = "SELECT t FROM TblCoupon t WHERE t.status = :status")})
public class TblCoupon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "couId")
    private Integer couId;
    @Column(name = "code")
    private Integer code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "codeValue")
    private Double codeValue;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "couId")
    private Collection<TblOrder> tblOrderCollection;

    public TblCoupon() {
    }

    public TblCoupon(Integer couId) {
        this.couId = couId;
    }

    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(Double codeValue) {
        this.codeValue = codeValue;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblOrder> getTblOrderCollection() {
        return tblOrderCollection;
    }

    public void setTblOrderCollection(Collection<TblOrder> tblOrderCollection) {
        this.tblOrderCollection = tblOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couId != null ? couId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCoupon)) {
            return false;
        }
        TblCoupon other = (TblCoupon) object;
        if ((this.couId == null && other.couId != null) || (this.couId != null && !this.couId.equals(other.couId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCoupon[ couId=" + couId + " ]";
    }
    
}
