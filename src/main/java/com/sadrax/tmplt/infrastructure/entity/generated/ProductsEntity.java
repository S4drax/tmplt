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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
 * ProductsEntity generated by hbm2java
*/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="products"
)
public class ProductsEntity  implements java.io.Serializable {


     private UUID productId;
     private DictionaryEntity dictionaryEntity;
     private ProducentsEntity producentsEntity;
     private String name;
     private String compareValue;
     private String description;
     private String createUser;
     private LocalDateTime createDate;
     private String updateUser;
     private LocalDateTime updateDate;
     @Builder.Default private Set<TransactionItemsEntity> transactionItemsEntities = new HashSet<TransactionItemsEntity>(0);

     @GenericGenerator(name="com.sadrax.tmplt.infrastructure.entity.generated.ProductsEntityIdGenerator", strategy="org.hibernate.id.UUIDGenerator")@Id @GeneratedValue(generator="com.sadrax.tmplt.infrastructure.entity.generated.ProductsEntityIdGenerator")

    
    @Column(name="product_id", unique=true, nullable=false)
    public UUID getProductId() {
        return this.productId;
    }
    
    public void setProductId(UUID productId) {
        this.productId = productId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false)
    public DictionaryEntity getDictionaryEntity() {
        return this.dictionaryEntity;
    }
    
    public void setDictionaryEntity(DictionaryEntity dictionaryEntity) {
        this.dictionaryEntity = dictionaryEntity;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="producent_id", nullable=false)
    public ProducentsEntity getProducentsEntity() {
        return this.producentsEntity;
    }
    
    public void setProducentsEntity(ProducentsEntity producentsEntity) {
        this.producentsEntity = producentsEntity;
    }

    
    @Column(name="name", nullable=false, length=250)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="compare_value", length=250)
    public String getCompareValue() {
        return this.compareValue;
    }
    
    public void setCompareValue(String compareValue) {
        this.compareValue = compareValue;
    }

    
    @Column(name="description", length=250)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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

@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.LAZY, mappedBy="productsEntity")
    public Set<TransactionItemsEntity> getTransactionItemsEntities() {
        return this.transactionItemsEntities;
    }
    
    public void setTransactionItemsEntities(Set<TransactionItemsEntity> transactionItemsEntities) {
        this.transactionItemsEntities = transactionItemsEntities;
    }




  }


