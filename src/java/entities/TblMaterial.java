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
@Table(name = "tblMaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMaterial.findAll", query = "SELECT t FROM TblMaterial t"),
    @NamedQuery(name = "TblMaterial.findByMatId", query = "SELECT t FROM TblMaterial t WHERE t.matId = :matId"),
    @NamedQuery(name = "TblMaterial.findByMatName", query = "SELECT t FROM TblMaterial t WHERE t.matName = :matName"),
    @NamedQuery(name = "TblMaterial.findByStatus", query = "SELECT t FROM TblMaterial t WHERE t.status = :status")})
public class TblMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matId")
    private Integer matId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "matName")
    private String matName;
    @Column(name = "status")
    private Boolean status;

    public TblMaterial() {
    }

    public TblMaterial(Integer matId) {
        this.matId = matId;
    }

    public TblMaterial(Integer matId, String matName) {
        this.matId = matId;
        this.matName = matName;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
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
        hash += (matId != null ? matId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMaterial)) {
            return false;
        }
        TblMaterial other = (TblMaterial) object;
        if ((this.matId == null && other.matId != null) || (this.matId != null && !this.matId.equals(other.matId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblMaterial[ matId=" + matId + " ]";
    }
    
}
