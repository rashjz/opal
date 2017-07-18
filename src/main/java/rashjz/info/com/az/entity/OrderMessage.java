/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Mobby
 */
@Entity
@Table(name = "order_message")
@NamedQueries({
    @NamedQuery(name = "OrderMessage.findAll", query = "SELECT o FROM OrderMessage o"),
    @NamedQuery(name = "OrderMessage.findByKey", query = "SELECT o FROM OrderMessage o WHERE o.key = :key"),
    @NamedQuery(name = "OrderMessage.findByName", query = "SELECT o FROM OrderMessage o WHERE o.name = :name"),
    @NamedQuery(name = "OrderMessage.findByPhone", query = "SELECT o FROM OrderMessage o WHERE o.phone = :phone"),
    @NamedQuery(name = "OrderMessage.findByMessage", query = "SELECT o FROM OrderMessage o WHERE o.message = :message"),
    @NamedQuery(name = "OrderMessage.findByInsertDate", query = "SELECT o FROM OrderMessage o WHERE o.insertDate = :insertDate"),
    @NamedQuery(name = "OrderMessage.findByStatus", query = "SELECT o FROM OrderMessage o WHERE o.status = :status")})
public class OrderMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "key")
    private Integer key;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone")
    private String phone;
    @Size(max = 405)
    @Column(name = "message")
    private String message;
    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Size(max = 1)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Users userId;
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    @ManyToOne(optional = false)
    public Products pId;

    public OrderMessage() {
    }

    public OrderMessage(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Products getPId() {
        return pId;
    }

    public void setPId(Products pId) {
        this.pId = pId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (key != null ? key.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderMessage)) {
            return false;
        }
        OrderMessage other = (OrderMessage) object;
        if ((this.key == null && other.key != null) || (this.key != null && !this.key.equals(other.key))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rashjz.info.com.az.entity.OrderMessage[ key=" + key + " ]";
    }
    
}
