package com.afu.test62.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Data
public class Base implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false, columnDefinition = "timestamp default current_timestamp")
    @JsonIgnore
    private Date creationDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    @JsonIgnore
    private Integer createdBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    @JsonIgnore
    private Date modificationDate;

    @LastModifiedBy
    @Column(name = "updated_by")
    @JsonIgnore
    private Integer modifiedBy;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    @JsonIgnore
    private Date deletedDate;

    @Column(name = "deleted_by")
    @JsonIgnore
    private Integer deletedBy;

    @PrePersist
    public void prePersist() {
        this.creationDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationDate = new Date();
    }

    @PreRemove
    public void preRemove(){this.deletedDate = new Date();}


}
