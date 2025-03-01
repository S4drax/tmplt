package com.sadrax.tmplt.infrastructure.entity.generated;
// Generated by Hibernate Tools 5.6.15.Final


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

    /**
 * UsersEntity generated by hbm2java
*/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users"
)
public class UsersEntity  implements java.io.Serializable {


     private UUID userId;
     private String login;
     private String password;
     private String createUser;
     private LocalDateTime createDate;
     private String updateUser;
     private LocalDateTime updateDate;
     @Builder.Default private Set<UserPermissionsEntity> userPermissionsEntities = new HashSet<UserPermissionsEntity>(0);

     @GenericGenerator(name="com.sadrax.tmplt.infrastructure.entity.generated.UsersEntityIdGenerator", strategy="org.hibernate.id.UUIDGenerator")@Id @GeneratedValue(generator="com.sadrax.tmplt.infrastructure.entity.generated.UsersEntityIdGenerator")

    
    @Column(name="user_id", unique=true, nullable=false)
    public UUID getUserId() {
        return this.userId;
    }
    
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    
    @Column(name="login", length=250)
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    
    @Column(name="password", length=250)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="create_user", nullable=false, length=30)
    public String getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    
    @Column(name="create_date", nullable=false, length=29)
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    
    @Column(name="update_user", length=30)
    public String getUpdateUser() {
        return this.updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    
    @Column(name="update_date", length=29)
    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY, mappedBy="usersEntity")
    public Set<UserPermissionsEntity> getUserPermissionsEntities() {
        return this.userPermissionsEntities;
    }
    
    public void setUserPermissionsEntities(Set<UserPermissionsEntity> userPermissionsEntities) {
        this.userPermissionsEntities = userPermissionsEntities;
    }




  }


