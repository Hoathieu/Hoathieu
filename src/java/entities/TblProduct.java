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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProduct.findAll", query = "SELECT t FROM TblProduct t"),
    @NamedQuery(name = "TblProduct.findByProId", query = "SELECT t FROM TblProduct t WHERE t.proId = :proId"),
    @NamedQuery(name = "TblProduct.findByProName", query = "SELECT t FROM TblProduct t WHERE t.proName = :proName"),
    @NamedQuery(name = "TblProduct.findByStatus", query = "SELECT t FROM TblProduct t WHERE t.status = :status")})
public class TblProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "proId")
    private Integer proId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "proName")
    private String proName;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "proId")
    private Collection<TblCartDetail> tblCartDetailCollection;
    @JoinColumn(name = "catId", referencedColumnName = "catId")
    @ManyToOne
    private TblCategory catId;
    @OneToMany(mappedBy = "proId")
    private Collection<TblProductDetail> tblProductDetailCollection;
    @OneToMany(mappedBy = "proId")
    private Collection<TblWishlistDetal> tblWishlistDetalCollection;

    public TblProduct() {
    }

    public TblProduct(Integer proId) {
        this.proId = proId;
    }

    public TblProduct(Integer proId, String proName) {
        this.proId = proId;
        this.proName = proName;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblCartDetail> getTblCartDetailCollection() {
        return tblCartDetailCollection;
    }

    public void setTblCartDetailCollection(Collection<TblCartDetail> tblCartDetailCollection) {
        this.tblCartDetailCollection = tblCartDetailCollection;
    }

    public TblCategory getCatId() {
        return catId;
    }

    public void setCatId(TblCategory catId) {
        this.catId = catId;
    }

    @XmlTransient
    public Collection<TblProductDetail> getTblProductDetailCollection() {
        return tblProductDetailCollection;
    }

    public void setTblProductDetailCollection(Collection<TblProductDetail> tblProductDetailCollection) {
        this.tblProductDetailCollection = tblProductDetailCollection;
    }

    @XmlTransient
    public Collection<TblWishlistDetal> getTblWishlistDetalCollection() {
        return tblWishlistDetalCollection;
    }

    public void setTblWishlistDetalCollection(Collection<TblWishlistDetal> tblWishlistDetalCollection) {
        this.tblWishlistDetalCollection = tblWishlistDetalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProduct)) {
            return false;
        }
        TblProduct other = (TblProduct) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblProduct[ proId=" + proId + " ]";
    }
    
}
