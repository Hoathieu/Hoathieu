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
@Table(name = "tblBlogComment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBlogComment.findAll", query = "SELECT t FROM TblBlogComment t"),
    @NamedQuery(name = "TblBlogComment.findByBlogCmtId", query = "SELECT t FROM TblBlogComment t WHERE t.blogCmtId = :blogCmtId"),
    @NamedQuery(name = "TblBlogComment.findByComment", query = "SELECT t FROM TblBlogComment t WHERE t.comment = :comment"),
    @NamedQuery(name = "TblBlogComment.findByStatus", query = "SELECT t FROM TblBlogComment t WHERE t.status = :status")})
public class TblBlogComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blogCmtId")
    private Integer blogCmtId;
    @Size(max = 2000)
    @Column(name = "comment")
    private String comment;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "accId", referencedColumnName = "accId")
    @ManyToOne
    private TblAccount accId;
    @JoinColumn(name = "blogId", referencedColumnName = "blogId")
    @ManyToOne
    private TblBlog blogId;

    public TblBlogComment() {
    }

    public TblBlogComment(Integer blogCmtId) {
        this.blogCmtId = blogCmtId;
    }

    public Integer getBlogCmtId() {
        return blogCmtId;
    }

    public void setBlogCmtId(Integer blogCmtId) {
        this.blogCmtId = blogCmtId;
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

    public TblBlog getBlogId() {
        return blogId;
    }

    public void setBlogId(TblBlog blogId) {
        this.blogId = blogId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blogCmtId != null ? blogCmtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBlogComment)) {
            return false;
        }
        TblBlogComment other = (TblBlogComment) object;
        if ((this.blogCmtId == null && other.blogCmtId != null) || (this.blogCmtId != null && !this.blogCmtId.equals(other.blogCmtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblBlogComment[ blogCmtId=" + blogCmtId + " ]";
    }
    
}
