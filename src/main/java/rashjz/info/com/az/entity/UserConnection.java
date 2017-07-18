/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mobby
 */
@Entity
@Table(name = "UserConnection")
@NamedQueries({
    @NamedQuery(name = "UserConnection.findAll", query = "SELECT u FROM UserConnection u"),
    @NamedQuery(name = "UserConnection.findByUserId", query = "SELECT u FROM UserConnection u WHERE u.userConnectionPK.userId = :userId"),
    @NamedQuery(name = "UserConnection.findByProviderId", query = "SELECT u FROM UserConnection u WHERE u.userConnectionPK.providerId = :providerId"),
    @NamedQuery(name = "UserConnection.findByProviderUserId", query = "SELECT u FROM UserConnection u WHERE u.userConnectionPK.providerUserId = :providerUserId"),
    @NamedQuery(name = "UserConnection.findByRank", query = "SELECT u FROM UserConnection u WHERE u.rank = :rank"),
    @NamedQuery(name = "UserConnection.findByDisplayName", query = "SELECT u FROM UserConnection u WHERE u.displayName = :displayName"),
    @NamedQuery(name = "UserConnection.findByProfileUrl", query = "SELECT u FROM UserConnection u WHERE u.profileUrl = :profileUrl"),
    @NamedQuery(name = "UserConnection.findByImageUrl", query = "SELECT u FROM UserConnection u WHERE u.imageUrl = :imageUrl"),
    @NamedQuery(name = "UserConnection.findByAccessToken", query = "SELECT u FROM UserConnection u WHERE u.accessToken = :accessToken"),
    @NamedQuery(name = "UserConnection.findBySecret", query = "SELECT u FROM UserConnection u WHERE u.secret = :secret"),
    @NamedQuery(name = "UserConnection.findByRefreshToken", query = "SELECT u FROM UserConnection u WHERE u.refreshToken = :refreshToken"),
    @NamedQuery(name = "UserConnection.findByExpireTime", query = "SELECT u FROM UserConnection u WHERE u.expireTime = :expireTime")})
public class UserConnection implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserConnectionPK userConnectionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rank")
    private int rank;
    @Size(max = 255)
    @Column(name = "displayName")
    private String displayName;
    @Size(max = 512)
    @Column(name = "profileUrl")
    private String profileUrl;
    @Size(max = 512)
    @Column(name = "imageUrl")
    private String imageUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "accessToken")
    private String accessToken;
    @Size(max = 512)
    @Column(name = "secret")
    private String secret;
    @Size(max = 512)
    @Column(name = "refreshToken")
    private String refreshToken;
    @Column(name = "expireTime")
    private BigInteger expireTime;

    public UserConnection() {
    }

    public UserConnection(UserConnectionPK userConnectionPK) {
        this.userConnectionPK = userConnectionPK;
    }

    public UserConnection(UserConnectionPK userConnectionPK, int rank, String accessToken) {
        this.userConnectionPK = userConnectionPK;
        this.rank = rank;
        this.accessToken = accessToken;
    }

    public UserConnection(String userId, String providerId, String providerUserId) {
        this.userConnectionPK = new UserConnectionPK(userId, providerId, providerUserId);
    }

    public UserConnectionPK getUserConnectionPK() {
        return userConnectionPK;
    }

    public void setUserConnectionPK(UserConnectionPK userConnectionPK) {
        this.userConnectionPK = userConnectionPK;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public BigInteger getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(BigInteger expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userConnectionPK != null ? userConnectionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserConnection)) {
            return false;
        }
        UserConnection other = (UserConnection) object;
        if ((this.userConnectionPK == null && other.userConnectionPK != null) || (this.userConnectionPK != null && !this.userConnectionPK.equals(other.userConnectionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rashjz.info.com.az.entity.UserConnection[ userConnectionPK=" + userConnectionPK + " ]";
    }
    
}
