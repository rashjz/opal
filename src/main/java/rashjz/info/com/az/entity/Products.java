/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mobby
 */
@Entity
@Table(name = "products")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByPId", query = "SELECT p FROM Products p WHERE p.pId = :pId"),
    @NamedQuery(name = "Products.findByTitle", query = "SELECT p FROM Products p WHERE p.title = :title"),
    @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description"),
    @NamedQuery(name = "Products.findByInsertDate", query = "SELECT p FROM Products p WHERE p.insertDate = :insertDate"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price"),
    @NamedQuery(name = "Products.findByViewCount", query = "SELECT p FROM Products p WHERE p.viewCount = :viewCount"),
    @NamedQuery(name = "Products.findByNote", query = "SELECT p FROM Products p WHERE p.note = :note"),
    @NamedQuery(name = "Products.findByStatus", query = "SELECT p FROM Products p WHERE p.status = :status")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "p_id")
    public Integer pId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 545)
    @Column(name = "description")
    private String description;
    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Column(name = "price")
    private Integer price;
    @Column(name = "view_count")
    private Integer viewCount;
    @Size(max = 105)
    @Column(name = "note")
    private String note;
    @Size(max = 1)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    private Collection<OrderMessage> orderMessageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<ProductImage> productImageCollection;
    @OneToMany(mappedBy = "productId")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "insert_user", referencedColumnName = "user_id")
    @ManyToOne
    private Users insertUser;
    @JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
    @ManyToOne
    private Gender genderId;
    @JoinColumn(name = "category_id", referencedColumnName = "cat_id")
    @ManyToOne
    private Category categoryId;
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne
    private Brand brandId;
    @Transient//not entity field
    private Date toDate;
    @Transient//not entity field
    private Date fromDate;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }


    public Products() {
    }

    public Products(Integer pId) {
        this.pId = pId;
    }

    public Products(Integer pId, String title, String description) {
        this.pId = pId;
        this.title = title;
        this.description = description;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<OrderMessage> getOrderMessageCollection() {
        return orderMessageCollection;
    }

    public void setOrderMessageCollection(Collection<OrderMessage> orderMessageCollection) {
        this.orderMessageCollection = orderMessageCollection;
    }

    public Collection<ProductImage> getProductImageCollection() {
        return productImageCollection;
    }

    public void setProductImageCollection(Collection<ProductImage> productImageCollection) {
        this.productImageCollection = productImageCollection;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Users getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(Users insertUser) {
        this.insertUser = insertUser;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rashjz.info.com.az.entity.Products[ pId=" + pId + " ]";
    }
    
}
