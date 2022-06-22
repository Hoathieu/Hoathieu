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
@Table(name = "tblWishlistDetal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblWishlistDetal.findAll", query = "SELECT t FROM TblWishlistDetal t"),
    @NamedQuery(name = "TblWishlistDetal.findByWishlistDetailId", query = "SELECT t FROM TblWishlistDetal t WHERE t.wishlistDetailId = :wishlistDetailId"),
    @NamedQuery(name = "TblWishlistDetal.findByStatus", query = "SELECT t FROM TblWishlistDetal t WHERE t.status = :status")})
public class TblWishlistDetal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "wishlistDetailId")
    private Integer wishlistDetailId;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "proId", referencedColumnName = "proId")
    @ManyToOne
    private TblProduct proId;
    @JoinColumn(name = "wishId", referencedColumnName = "wishId")
    @ManyToOne
    private TblWishlist wishId;

    public TblWishlistDetal() {
    }

    public TblWishlistDetal(Integer wishlistDetailId) {
        this.wishlistDetailId = wishlistDetailId;
    }

    public Integer getWishlistDetailId() {
        return wishlistDetailId;
    }

    public void setWishlistDetailId(Integer wishlistDetailId) {
        this.wishlistDetailId = wishlistDetailId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TblProduct getProId() {
        return proId;
    }

    public void setProId(TblProduct proId) {
        this.proId = proId;
    }

    public TblWishlist getWishId() {
        return wishId;
    }

    public void setWishId(TblWishlist wishId) {
        this.wishId = wishId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wishlistDetailId != null ? wishlistDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblWishlistDetal)) {
            return false;
        }
        TblWishlistDetal other = (TblWishlistDetal) object;
        if ((this.wishlistDetailId == null && other.wishlistDetailId != null) || (this.wishlistDetailId != null && !this.wishlistDetailId.equals(other.wishlistDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblWishlistDetal[ wishlistDetailId=" + wishlistDetailId + " ]";
    }
    
}
