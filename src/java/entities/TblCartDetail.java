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
@Table(name = "tblCartDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCartDetail.findAll", query = "SELECT t FROM TblCartDetail t"),
    @NamedQuery(name = "TblCartDetail.findById", query = "SELECT t FROM TblCartDetail t WHERE t.id = :id"),
    @NamedQuery(name = "TblCartDetail.findByQuantity", query = "SELECT t FROM TblCartDetail t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TblCartDetail.findByTotalEach", query = "SELECT t FROM TblCartDetail t WHERE t.totalEach = :totalEach"),
    @NamedQuery(name = "TblCartDetail.findByStatus", query = "SELECT t FROM TblCartDetail t WHERE t.status = :status")})
public class TblCartDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "totalEach")
    private Integer totalEach;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
    @ManyToOne
    private TblCart cartId;
    @JoinColumn(name = "proId", referencedColumnName = "proId")
    @ManyToOne
    private TblProduct proId;

    public TblCartDetail() {
    }

    public TblCartDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalEach() {
        return totalEach;
    }

    public void setTotalEach(Integer totalEach) {
        this.totalEach = totalEach;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public TblCart getCartId() {
        return cartId;
    }

    public void setCartId(TblCart cartId) {
        this.cartId = cartId;
    }

    public TblProduct getProId() {
        return proId;
    }

    public void setProId(TblProduct proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCartDetail)) {
            return false;
        }
        TblCartDetail other = (TblCartDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCartDetail[ id=" + id + " ]";
    }
    
}
