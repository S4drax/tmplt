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
 * AddressesEntity generated by hbm2java
*/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="addresses"
)
public class AddressesEntity  implements java.io.Serializable {


     private UUID addressId;
     private String street;
     private Integer houseNumber;
     private Integer flatNumber;
     private String zipCode;
     private String city;
     private String country;
     private String createUser;
     private LocalDateTime createDate;
     private String updateUser;
     private LocalDateTime updateDate;
     @Builder.Default private Set<ClientsEntity> clientsEntitiesForAddressId = new HashSet<ClientsEntity>(0);
     @Builder.Default private Set<ProducentsEntity> producentsEntities = new HashSet<ProducentsEntity>(0);
     @Builder.Default private Set<ClientsEntity> clientsEntitiesForBillingAddressId = new HashSet<ClientsEntity>(0);

     @GenericGenerator(name="com.sadrax.tmplt.infrastructure.entity.generated.AddressesEntityIdGenerator", strategy="org.hibernate.id.UUIDGenerator")@Id @GeneratedValue(generator="com.sadrax.tmplt.infrastructure.entity.generated.AddressesEntityIdGenerator")

    
    @Column(name="address_id", unique=true, nullable=false)
    public UUID getAddressId() {
        return this.addressId;
    }
    
    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }

    
    @Column(name="street", length=250)
    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    
    @Column(name="house_number", precision=6, scale=0)
    public Integer getHouseNumber() {
        return this.houseNumber;
    }
    
    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    
    @Column(name="flat_number", precision=6, scale=0)
    public Integer getFlatNumber() {
        return this.flatNumber;
    }
    
    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    
    @Column(name="zip_code", length=20)
    public String getZipCode() {
        return this.zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    
    @Column(name="city", length=50)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="country", length=50)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
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

@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY, mappedBy="addressesEntityByAddressId")
    public Set<ClientsEntity> getClientsEntitiesForAddressId() {
        return this.clientsEntitiesForAddressId;
    }
    
    public void setClientsEntitiesForAddressId(Set<ClientsEntity> clientsEntitiesForAddressId) {
        this.clientsEntitiesForAddressId = clientsEntitiesForAddressId;
    }

@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY, mappedBy="addressesEntity")
    public Set<ProducentsEntity> getProducentsEntities() {
        return this.producentsEntities;
    }
    
    public void setProducentsEntities(Set<ProducentsEntity> producentsEntities) {
        this.producentsEntities = producentsEntities;
    }

@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY, mappedBy="addressesEntityByBillingAddressId")
    public Set<ClientsEntity> getClientsEntitiesForBillingAddressId() {
        return this.clientsEntitiesForBillingAddressId;
    }
    
    public void setClientsEntitiesForBillingAddressId(Set<ClientsEntity> clientsEntitiesForBillingAddressId) {
        this.clientsEntitiesForBillingAddressId = clientsEntitiesForBillingAddressId;
    }




  }


