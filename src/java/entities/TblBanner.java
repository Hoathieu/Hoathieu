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
@Table(name = "tblBanner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBanner.findAll", query = "SELECT t FROM TblBanner t"),
    @NamedQuery(name = "TblBanner.findByBannerId", query = "SELECT t FROM TblBanner t WHERE t.bannerId = :bannerId"),
    @NamedQuery(name = "TblBanner.findByContent", query = "SELECT t FROM TblBanner t WHERE t.content = :content"),
    @NamedQuery(name = "TblBanner.findByBnImage", query = "SELECT t FROM TblBanner t WHERE t.bnImage = :bnImage"),
    @NamedQuery(name = "TblBanner.findByStatus", query = "SELECT t FROM TblBanner t WHERE t.status = :status")})
public class TblBanner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bannerId")
    private Integer bannerId;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Size(max = 255)
    @Column(name = "bnImage")
    private String bnImage;
    @Column(name = "status")
    private Boolean status;

    public TblBanner() {
    }

    public TblBanner(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBnImage() {
        return bnImage;
    }

    public void setBnImage(String bnImage) {
        this.bnImage = bnImage;
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
        hash += (bannerId != null ? bannerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBanner)) {
            return false;
        }
        TblBanner other = (TblBanner) object;
        if ((this.bannerId == null && other.bannerId != null) || (this.bannerId != null && !this.bannerId.equals(other.bannerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblBanner[ bannerId=" + bannerId + " ]";
    }
    
}
