/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblAccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAccount.findAll", query = "SELECT t FROM TblAccount t"),
    @NamedQuery(name = "TblAccount.findByAccId", query = "SELECT t FROM TblAccount t WHERE t.accId = :accId"),
    @NamedQuery(name = "TblAccount.findByAccLogin", query = "SELECT t FROM TblAccount t WHERE t.accLogin = :accLogin"),
    @NamedQuery(name = "TblAccount.findByAccPassword", query = "SELECT t FROM TblAccount t WHERE t.accPassword = :accPassword"),
    @NamedQuery(name = "TblAccount.findByCreateDate", query = "SELECT t FROM TblAccount t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblAccount.findByStatus", query = "SELECT t FROM TblAccount t WHERE t.status = :status")})
public class TblAccount implements Serializable {
    @OneToMany(mappedBy = "accId")
    private Collection<TblCart> tblCartCollection;
    @OneToMany(mappedBy = "accId")
    private Collection<TblUser> tblUserCollection;
    @OneToMany(mappedBy = "accId")
    private Collection<TblBlogComment> tblBlogCommentCollection;
    @OneToMany(mappedBy = "accId")
    private Collection<TblWishlist> tblWishlistCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accId")
    private Integer accId;
    @Size(max = 255)
    @Column(name = "accLogin")
    private String accLogin;
    @Size(max = 50)
    @Column(name = "accPassword")
    private String accPassword;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "status")
    private Boolean status;

    public TblAccount() {
    }

    public TblAccount(Integer accId) {
        this.accId = accId;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getAccLogin() {
        return accLogin;
    }

    public void setAccLogin(String accLogin) {
        this.accLogin = accLogin;
    }

    public String getAccPassword() {
        return accPassword;
    }

    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accId != null ? accId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAccount)) {
            return false;
        }
        TblAccount other = (TblAccount) object;
        if ((this.accId == null && other.accId != null) || (this.accId != null && !this.accId.equals(other.accId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblAccount[ accId=" + accId + " ]";
    }

    @XmlTransient
    public Collection<TblCart> getTblCartCollection() {
        return tblCartCollection;
    }

    public void setTblCartCollection(Collection<TblCart> tblCartCollection) {
        this.tblCartCollection = tblCartCollection;
    }

    @XmlTransient
    public Collection<TblUser> getTblUserCollection() {
        return tblUserCollection;
    }

    public void setTblUserCollection(Collection<TblUser> tblUserCollection) {
        this.tblUserCollection = tblUserCollection;
    }

    @XmlTransient
    public Collection<TblBlogComment> getTblBlogCommentCollection() {
        return tblBlogCommentCollection;
    }

    public void setTblBlogCommentCollection(Collection<TblBlogComment> tblBlogCommentCollection) {
        this.tblBlogCommentCollection = tblBlogCommentCollection;
    }

    @XmlTransient
    public Collection<TblWishlist> getTblWishlistCollection() {
        return tblWishlistCollection;
    }

    public void setTblWishlistCollection(Collection<TblWishlist> tblWishlistCollection) {
        this.tblWishlistCollection = tblWishlistCollection;
    }
    
}
