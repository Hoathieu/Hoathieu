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
@Table(name = "tblWishlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblWishlist.findAll", query = "SELECT t FROM TblWishlist t"),
    @NamedQuery(name = "TblWishlist.findByWishId", query = "SELECT t FROM TblWishlist t WHERE t.wishId = :wishId"),
    @NamedQuery(name = "TblWishlist.findByStatus", query = "SELECT t FROM TblWishlist t WHERE t.status = :status")})
public class TblWishlist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishId")
    private Integer wishId;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "accId", referencedColumnName = "accId")
    @ManyToOne
    private TblAccount accId;

    public TblWishlist() {
    }

    public TblWishlist(Integer wishId) {
        this.wishId = wishId;
    }

    public Integer getWishId() {
        return wishId;
    }

    public void setWishId(Integer wishId) {
        this.wishId = wishId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wishId != null ? wishId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblWishlist)) {
            return false;
        }
        TblWishlist other = (TblWishlist) object;
        if ((this.wishId == null && other.wishId != null) || (this.wishId != null && !this.wishId.equals(other.wishId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblWishlist[ wishId=" + wishId + " ]";
    }
    
}
