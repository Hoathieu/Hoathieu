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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOrder.findAll", query = "SELECT t FROM TblOrder t"),
    @NamedQuery(name = "TblOrder.findByOrdId", query = "SELECT t FROM TblOrder t WHERE t.ordId = :ordId"),
    @NamedQuery(name = "TblOrder.findByCusName", query = "SELECT t FROM TblOrder t WHERE t.cusName = :cusName"),
    @NamedQuery(name = "TblOrder.findByCusAddress", query = "SELECT t FROM TblOrder t WHERE t.cusAddress = :cusAddress"),
    @NamedQuery(name = "TblOrder.findByCusPhone", query = "SELECT t FROM TblOrder t WHERE t.cusPhone = :cusPhone"),
    @NamedQuery(name = "TblOrder.findByCusEmail", query = "SELECT t FROM TblOrder t WHERE t.cusEmail = :cusEmail"),
    @NamedQuery(name = "TblOrder.findByNote", query = "SELECT t FROM TblOrder t WHERE t.note = :note"),
    @NamedQuery(name = "TblOrder.findByStatus", query = "SELECT t FROM TblOrder t WHERE t.status = :status")})
public class TblOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ordId")
    private Integer ordId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cusName")
    private String cusName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cusAddress")
    private String cusAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cusPhone")
    private String cusPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cusEmail")
    private String cusEmail;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
    @ManyToOne
    private TblCart cartId;
    @JoinColumn(name = "couId", referencedColumnName = "couId")
    @ManyToOne
    private TblCoupon couId;
    @JoinColumn(name = "payId", referencedColumnName = "payId")
    @ManyToOne
    private TblPaymentMethod payId;

    public TblOrder() {
    }

    public TblOrder(Integer ordId) {
        this.ordId = ordId;
    }

    public TblOrder(Integer ordId, String cusName, String cusAddress, String cusPhone, String cusEmail) {
        this.ordId = ordId;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public TblCoupon getCouId() {
        return couId;
    }

    public void setCouId(TblCoupon couId) {
        this.couId = couId;
    }

    public TblPaymentMethod getPayId() {
        return payId;
    }

    public void setPayId(TblPaymentMethod payId) {
        this.payId = payId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordId != null ? ordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrder)) {
            return false;
        }
        TblOrder other = (TblOrder) object;
        if ((this.ordId == null && other.ordId != null) || (this.ordId != null && !this.ordId.equals(other.ordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblOrder[ ordId=" + ordId + " ]";
    }
    
}
