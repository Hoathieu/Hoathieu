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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblPaymentMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPaymentMethod.findAll", query = "SELECT t FROM TblPaymentMethod t"),
    @NamedQuery(name = "TblPaymentMethod.findByPayId", query = "SELECT t FROM TblPaymentMethod t WHERE t.payId = :payId"),
    @NamedQuery(name = "TblPaymentMethod.findByPayName", query = "SELECT t FROM TblPaymentMethod t WHERE t.payName = :payName"),
    @NamedQuery(name = "TblPaymentMethod.findByStatus", query = "SELECT t FROM TblPaymentMethod t WHERE t.status = :status")})
public class TblPaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payId")
    private Integer payId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "payName")
    private String payName;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "payId")
    private Collection<TblOrder> tblOrderCollection;

    public TblPaymentMethod() {
    }

    public TblPaymentMethod(Integer payId) {
        this.payId = payId;
    }

    public TblPaymentMethod(Integer payId, String payName) {
        this.payId = payId;
        this.payName = payName;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
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
        hash += (payId != null ? payId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPaymentMethod)) {
            return false;
        }
        TblPaymentMethod other = (TblPaymentMethod) object;
        if ((this.payId == null && other.payId != null) || (this.payId != null && !this.payId.equals(other.payId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblPaymentMethod[ payId=" + payId + " ]";
    }
    
}
