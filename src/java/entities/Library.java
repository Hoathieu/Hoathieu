/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "Library")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Library.findAll", query = "SELECT l FROM Library l"),
    @NamedQuery(name = "Library.findByLibId", query = "SELECT l FROM Library l WHERE l.libId = :libId"),
    @NamedQuery(name = "Library.findByLibImage", query = "SELECT l FROM Library l WHERE l.libImage = :libImage"),
    @NamedQuery(name = "Library.findByCreateDate", query = "SELECT l FROM Library l WHERE l.createDate = :createDate"),
    @NamedQuery(name = "Library.findByStatus", query = "SELECT l FROM Library l WHERE l.status = :status")})
public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "libId")
    private Integer libId;
    @Size(max = 255)
    @Column(name = "libImage")
    private String libImage;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "status")
    private Boolean status;

    public Library() {
    }

    public Library(Integer libId) {
        this.libId = libId;
    }

    public Integer getLibId() {
        return libId;
    }

    public void setLibId(Integer libId) {
        this.libId = libId;
    }

    public String getLibImage() {
        return libImage;
    }

    public void setLibImage(String libImage) {
        this.libImage = libImage;
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
        hash += (libId != null ? libId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Library)) {
            return false;
        }
        Library other = (Library) object;
        if ((this.libId == null && other.libId != null) || (this.libId != null && !this.libId.equals(other.libId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Library[ libId=" + libId + " ]";
    }
    
}
