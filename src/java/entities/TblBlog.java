/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nhine
 */
@Entity
@Table(name = "tblBlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBlog.findAll", query = "SELECT t FROM TblBlog t"),
    @NamedQuery(name = "TblBlog.findByBlogId", query = "SELECT t FROM TblBlog t WHERE t.blogId = :blogId"),
    @NamedQuery(name = "TblBlog.findByContent", query = "SELECT t FROM TblBlog t WHERE t.content = :content"),
    @NamedQuery(name = "TblBlog.findByCreateDate", query = "SELECT t FROM TblBlog t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TblBlog.findByUpdateDate", query = "SELECT t FROM TblBlog t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TblBlog.findByBlogImage", query = "SELECT t FROM TblBlog t WHERE t.blogImage = :blogImage"),
    @NamedQuery(name = "TblBlog.findByStatus", query = "SELECT t FROM TblBlog t WHERE t.status = :status")})
public class TblBlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "blogId")
    private Integer blogId;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Size(max = 50)
    @Column(name = "blogImage")
    private String blogImage;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "blogId")
    private Collection<TblBlogComment> tblBlogCommentCollection;

    public TblBlog() {
    }

    public TblBlog(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<TblBlogComment> getTblBlogCommentCollection() {
        return tblBlogCommentCollection;
    }

    public void setTblBlogCommentCollection(Collection<TblBlogComment> tblBlogCommentCollection) {
        this.tblBlogCommentCollection = tblBlogCommentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blogId != null ? blogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBlog)) {
            return false;
        }
        TblBlog other = (TblBlog) object;
        if ((this.blogId == null && other.blogId != null) || (this.blogId != null && !this.blogId.equals(other.blogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblBlog[ blogId=" + blogId + " ]";
    }
    
}
