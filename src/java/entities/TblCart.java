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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tblCart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCart.findAll", query = "SELECT t FROM TblCart t"),
    @NamedQuery(name = "TblCart.findByCartId", query = "SELECT t FROM TblCart t WHERE t.cartId = :cartId"),
    @NamedQuery(name = "TblCart.findByTotalCash", query = "SELECT t FROM TblCart t WHERE t.totalCash = :totalCash"),
    @NamedQuery(name = "TblCart.findByStatus", query = "SELECT t FROM TblCart t WHERE t.status = :status")})
public class TblCart implements Serializable {
    @OneToMany(mappedBy = "cartId")
    private Collection<TblCartDetail> tblCartDetailCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cartId")
    private Integer cartId;
    @Column(name = "totalCash")
    private Integer totalCash;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "accId", referencedColumnName = "accId")
    @ManyToOne
    private TblAccount accId;
    @OneToMany(mappedBy = "cartId")
    private Collection<TblOrder> tblOrderCollection;

    public TblCart() {
    }

    public TblCart(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(Integer totalCash) {
        this.totalCash = totalCash;
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
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCart)) {
            return false;
        }
        TblCart other = (TblCart) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCart[ cartId=" + cartId + " ]";
    }

    @XmlTransient
    public Collection<TblCartDetail> getTblCartDetailCollection() {
        return tblCartDetailCollection;
    }

    public void setTblCartDetailCollection(Collection<TblCartDetail> tblCartDetailCollection) {
        this.tblCartDetailCollection = tblCartDetailCollection;
    }
    
}
