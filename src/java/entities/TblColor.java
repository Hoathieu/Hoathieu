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
@Table(name = "tblColor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblColor.findAll", query = "SELECT t FROM TblColor t"),
    @NamedQuery(name = "TblColor.findByColorId", query = "SELECT t FROM TblColor t WHERE t.colorId = :colorId"),
    @NamedQuery(name = "TblColor.findByColorName", query = "SELECT t FROM TblColor t WHERE t.colorName = :colorName"),
    @NamedQuery(name = "TblColor.findByColorCode", query = "SELECT t FROM TblColor t WHERE t.colorCode = :colorCode"),
    @NamedQuery(name = "TblColor.findByStatus", query = "SELECT t FROM TblColor t WHERE t.status = :status")})
public class TblColor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colorId")
    private Integer colorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "colorName")
    private String colorName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "colorCode")
    private String colorCode;
    @Column(name = "status")
    private Boolean status;

    public TblColor() {
    }

    public TblColor(Integer colorId) {
        this.colorId = colorId;
    }

    public TblColor(Integer colorId, String colorName, String colorCode) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.colorCode = colorCode;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
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
        hash += (colorId != null ? colorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblColor)) {
            return false;
        }
        TblColor other = (TblColor) object;
        if ((this.colorId == null && other.colorId != null) || (this.colorId != null && !this.colorId.equals(other.colorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblColor[ colorId=" + colorId + " ]";
    }
    
}
