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
@Table(name = "contact_messages")
@NamedQueries({
    @NamedQuery(name = "ContactMessages.findAll", query = "SELECT c FROM ContactMessages c"),
    @NamedQuery(name = "ContactMessages.findByKeyId", query = "SELECT c FROM ContactMessages c WHERE c.keyId = :keyId"),
    @NamedQuery(name = "ContactMessages.findByUserId", query = "SELECT c FROM ContactMessages c WHERE c.userId = :userId"),
    @NamedQuery(name = "ContactMessages.findByFirstname", query = "SELECT c FROM ContactMessages c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "ContactMessages.findByEmail", query = "SELECT c FROM ContactMessages c WHERE c.email = :email"),
    @NamedQuery(name = "ContactMessages.findByPhone", query = "SELECT c FROM ContactMessages c WHERE c.phone = :phone"),
    @NamedQuery(name = "ContactMessages.findByMessage", query = "SELECT c FROM ContactMessages c WHERE c.message = :message"),
    @NamedQuery(name = "ContactMessages.findByNote", query = "SELECT c FROM ContactMessages c WHERE c.note = :note"),
    @NamedQuery(name = "ContactMessages.findByStatus", query = "SELECT c FROM ContactMessages c WHERE c.status = :status")})
public class ContactMessages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "key_id")
    private Integer keyId;
    @Column(name = "user_id")
    private Integer userId;
    @Size(max = 45)
    @Column(name = "firstname")
    private String firstname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "phone")
    private String phone;
    @Size(max = 245)
    @Column(name = "message")
    private String message;
    @Size(max = 145)
    @Column(name = "note")
    private String note;
    @Size(max = 5)
    @Column(name = "status")
    private String status;

    public ContactMessages() {
    }

    public ContactMessages(Integer keyId) {
        this.keyId = keyId;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (keyId != null ? keyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactMessages)) {
            return false;
        }
        ContactMessages other = (ContactMessages) object;
        if ((this.keyId == null && other.keyId != null) || (this.keyId != null && !this.keyId.equals(other.keyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rashjz.info.com.az.entity.ContactMessages[ keyId=" + keyId + " ]";
    }
    
}
