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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblCommentProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCommentProduct.findAll", query = "SELECT t FROM TblCommentProduct t"),
    @NamedQuery(name = "TblCommentProduct.findByCmtProId", query = "SELECT t FROM TblCommentProduct t WHERE t.cmtProId = :cmtProId"),
    @NamedQuery(name = "TblCommentProduct.findByComment", query = "SELECT t FROM TblCommentProduct t WHERE t.comment = :comment"),
    @NamedQuery(name = "TblCommentProduct.findByStatus", query = "SELECT t FROM TblCommentProduct t WHERE t.status = :status")})
public class TblCommentProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cmtProId")
    private Integer cmtProId;
    @Size(max = 2000)
    @Column(name = "comment")
    private String comment;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "accId", referencedColumnName = "accId")
    @ManyToOne
    private TblAccount accId;
    @JoinColumn(name = "proDetailId", referencedColumnName = "proDetailId")
    @ManyToOne
    private TblProductDetail proDetailId;

    public TblCommentProduct() {
    }

    public TblCommentProduct(Integer cmtProId) {
        this.cmtProId = cmtProId;
    }

    public Integer getCmtProId() {
        return cmtProId;
    }

    public void setCmtProId(Integer cmtProId) {
        this.cmtProId = cmtProId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        hash += (cmtProId != null ? cmtProId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCommentProduct)) {
            return false;
        }
        TblCommentProduct other = (TblCommentProduct) object;
        if ((this.cmtProId == null && other.cmtProId != null) || (this.cmtProId != null && !this.cmtProId.equals(other.cmtProId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCommentProduct[ cmtProId=" + cmtProId + " ]";
    }
    
}
