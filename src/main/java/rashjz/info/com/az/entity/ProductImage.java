/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.entity;

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
import javax.validation.constraints.Size;

/**
 *
 * @author Mobby
 */
@Entity
@Table(name = "product_image")
@NamedQueries({
    @NamedQuery(name = "ProductImage.findAll", query = "SELECT p FROM ProductImage p"),
    @NamedQuery(name = "ProductImage.findByDetId", query = "SELECT p FROM ProductImage p WHERE p.detId = :detId"),
    @NamedQuery(name = "ProductImage.findByImgName", query = "SELECT p FROM ProductImage p WHERE p.imgName = :imgName"),
    @NamedQuery(name = "ProductImage.findByStatus", query = "SELECT p FROM ProductImage p WHERE p.status = :status")})
public class ProductImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "det_id")
    private Integer detId;
    @Size(max = 545)
    @Column(name = "img_name")
    private String imgName;
    @Size(max = 1)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "product_id", referencedColumnName = "p_id")
    @ManyToOne(optional = false)
    private Products productId;

    public ProductImage() {
    }

    public ProductImage(Integer detId) {
        this.detId = detId;
    }

    public Integer getDetId() {
        return detId;
    }

    public void setDetId(Integer detId) {
        this.detId = detId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detId != null ? detId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductImage)) {
            return false;
        }
        ProductImage other = (ProductImage) object;
        if ((this.detId == null && other.detId != null) || (this.detId != null && !this.detId.equals(other.detId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rashjz.info.com.az.entity.ProductImage[ detId=" + detId + " ]";
    }
    
}
