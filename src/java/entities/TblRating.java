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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblRating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRating.findAll", query = "SELECT t FROM TblRating t"),
    @NamedQuery(name = "TblRating.findByRateId", query = "SELECT t FROM TblRating t WHERE t.rateId = :rateId"),
    @NamedQuery(name = "TblRating.findByRateNumber", query = "SELECT t FROM TblRating t WHERE t.rateNumber = :rateNumber"),
    @NamedQuery(name = "TblRating.findByStatus", query = "SELECT t FROM TblRating t WHERE t.status = :status")})
public class TblRating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rateId")
    private Integer rateId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rateNumber")
    private Double rateNumber;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "accId", referencedColumnName = "accId")
    @ManyToOne
    private TblAccount accId;
    @JoinColumn(name = "proDetailId", referencedColumnName = "proDetailId")
    @ManyToOne
    private TblProductDetail proDetailId;

    public TblRating() {
    }

    public TblRating(Integer rateId) {
        this.rateId = rateId;
    }

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public Double getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(Double rateNumber) {
        this.rateNumber = rateNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TblAccount getAccId() {
        return accId;
    }

    public void setAccId(TblAccount accId) {
        this.accId = accId;
    }

    public TblProductDetail getProDetailId() {
        return proDetailId;
    }

    public void setProDetailId(TblProductDetail proDetailId) {
        this.proDetailId = proDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateId != null ? rateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRating)) {
            return false;
        }
        TblRating other = (TblRating) object;
        if ((this.rateId == null && other.rateId != null) || (this.rateId != null && !this.rateId.equals(other.rateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblRating[ rateId=" + rateId + " ]";
    }
    
}
