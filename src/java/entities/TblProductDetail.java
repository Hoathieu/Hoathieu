/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblProductDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProductDetail.findAll", query = "SELECT t FROM TblProductDetail t"),
    @NamedQuery(name = "TblProductDetail.findByProDetailId", query = "SELECT t FROM TblProductDetail t WHERE t.proDetailId = :proDetailId"),
    @NamedQuery(name = "TblProductDetail.findByDescription", query = "SELECT t FROM TblProductDetail t WHERE t.description = :description"),
    @NamedQuery(name = "TblProductDetail.findByPrice", query = "SELECT t FROM TblProductDetail t WHERE t.price = :price"),
    @NamedQuery(name = "TblProductDetail.findByQuantity", query = "SELECT t FROM TblProductDetail t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TblProductDetail.findByCreateDate", query = "SELECT t FROM TblProductDetail t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblProductDetail.findByStatus", query = "SELECT t FROM TblProductDetail t WHERE t.status = :status")})
public class TblProductDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "proDetailId")
    private Integer proDetailId;
    @Size(max = 2500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "proDetailId")
    private Collection<TblCommentProduct> tblCommentProductCollection;
    @OneToMany(mappedBy = "proDetailId")
    private Collection<TblRating> tblRatingCollection;
    @JoinColumn(name = "colorId", referencedColumnName = "colorId")
    @ManyToOne
    private TblColor colorId;
    @JoinColumn(name = "matId", referencedColumnName = "colorId")
    @ManyToOne
    private TblColor matId;
    @JoinColumn(name = "proId", referencedColumnName = "proId")
    @ManyToOne
    private TblProduct proId;
    @JoinColumn(name = "sizeId", referencedColumnName = "sizeId")
    @ManyToOne
    private TblSize sizeId;
    @OneToMany(mappedBy = "proDetailId")
    private Collection<TblImage> tblImageCollection;

    public TblProductDetail() {
    }

    public TblProductDetail(Integer proDetailId) {
        this.proDetailId = proDetailId;
    }

    public TblProductDetail(Integer proDetailId, double price, int quantity) {
        this.proDetailId = proDetailId;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getProDetailId() {
        return proDetailId;
    }

    public void setProDetailId(Integer proDetailId) {
        this.proDetailId = proDetailId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblCommentProduct> getTblCommentProductCollection() {
        return tblCommentProductCollection;
    }

    public void setTblCommentProductCollection(Collection<TblCommentProduct> tblCommentProductCollection) {
        this.tblCommentProductCollection = tblCommentProductCollection;
    }

    @XmlTransient
    public Collection<TblRating> getTblRatingCollection() {
        return tblRatingCollection;
    }

    public void setTblRatingCollection(Collection<TblRating> tblRatingCollection) {
        this.tblRatingCollection = tblRatingCollection;
    }

    public TblColor getColorId() {
        return colorId;
    }

    public void setColorId(TblColor colorId) {
        this.colorId = colorId;
    }

    public TblColor getMatId() {
        return matId;
    }

    public void setMatId(TblColor matId) {
        this.matId = matId;
    }

    public TblProduct getProId() {
        return proId;
    }

    public void setProId(TblProduct proId) {
        this.proId = proId;
    }

    public TblSize getSizeId() {
        return sizeId;
    }

    public void setSizeId(TblSize sizeId) {
        this.sizeId = sizeId;
    }

    @XmlTransient
    public Collection<TblImage> getTblImageCollection() {
        return tblImageCollection;
    }

    public void setTblImageCollection(Collection<TblImage> tblImageCollection) {
        this.tblImageCollection = tblImageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proDetailId != null ? proDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProductDetail)) {
            return false;
        }
        TblProductDetail other = (TblProductDetail) object;
        if ((this.proDetailId == null && other.proDetailId != null) || (this.proDetailId != null && !this.proDetailId.equals(other.proDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblProductDetail[ proDetailId=" + proDetailId + " ]";
    }
    
}
