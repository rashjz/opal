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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Mobby
 */
@Entity
@Table(name = "sliderImage")
@NamedQueries({
    @NamedQuery(name = "SliderImage.findAll", query = "SELECT s FROM SliderImage s"),
    @NamedQuery(name = "SliderImage.findById", query = "SELECT s FROM SliderImage s WHERE s.id = :id"),
    @NamedQuery(name = "SliderImage.findByImageName", query = "SELECT s FROM SliderImage s WHERE s.imageName = :imageName"),
    @NamedQuery(name = "SliderImage.findByDescription", query = "SELECT s FROM SliderImage s WHERE s.description = :description"),
    @NamedQuery(name = "SliderImage.findByProductId", query = "SELECT s FROM SliderImage s WHERE s.productId = :productId"),
    @NamedQuery(name = "SliderImage.findByStatus", query = "SELECT s FROM SliderImage s WHERE s.status = :status")})
public class SliderImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 500)
    @Column(name = "image_name")
    private String imageName;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "status")
    private Integer status;

    public SliderImage() {
    }

    public SliderImage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SliderImage)) {
            return false;
        }
        SliderImage other = (SliderImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rashjz.info.com.az.entity.SliderImage[ id=" + id + " ]";
    }
    
}
