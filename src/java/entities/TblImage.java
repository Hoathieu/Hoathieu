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
@Table(name = "tblImage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblImage.findAll", query = "SELECT t FROM TblImage t"),
    @NamedQuery(name = "TblImage.findByProImageId", query = "SELECT t FROM TblImage t WHERE t.proImageId = :proImageId"),
    @NamedQuery(name = "TblImage.findByImage", query = "SELECT t FROM TblImage t WHERE t.image = :image"),
    @NamedQuery(name = "TblImage.findByStatus", query = "SELECT t FROM TblImage t WHERE t.status = :status")})
public class TblImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "proImageId")
    private Integer proImageId;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "proDetailId", referencedColumnName = "proDetailId")
    @ManyToOne
    private TblProductDetail proDetailId;

    public TblImage() {
    }

    public TblImage(Integer proImageId) {
        this.proImageId = proImageId;
    }

    public Integer getProImageId() {
        return proImageId;
    }

    public void setProImageId(Integer proImageId) {
        this.proImageId = proImageId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
        hash += (proImageId != null ? proImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblImage)) {
            return false;
        }
        TblImage other = (TblImage) object;
        if ((this.proImageId == null && other.proImageId != null) || (this.proImageId != null && !this.proImageId.equals(other.proImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblImage[ proImageId=" + proImageId + " ]";
    }
    
}
