/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mobby
 */
@Embeddable
public class UserConnectionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "userId")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "providerId")
    private String providerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "providerUserId")
    private String providerUserId;

    public UserConnectionPK() {
    }

    public UserConnectionPK(String userId, String providerId, String providerUserId) {
        this.userId = userId;
        this.providerId = providerId;
        this.providerUserId = providerUserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (providerId != null ? providerId.hashCode() : 0);
        hash += (providerUserId != null ? providerUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserConnectionPK)) {
            return false;
        }
        UserConnectionPK other = (UserConnectionPK) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        if ((this.providerId == null && other.providerId != null) || (this.providerId != null && !this.providerId.equals(other.providerId))) {
            return false;
        }
        if ((this.providerUserId == null && other.providerUserId != null) || (this.providerUserId != null && !this.providerUserId.equals(other.providerUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rashjz.info.com.az.entity.UserConnectionPK[ userId=" + userId + ", providerId=" + providerId + ", providerUserId=" + providerUserId + " ]";
    }
    
}
