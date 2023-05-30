package com.afu.test62.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "CATEGORY")
@Where(clause = "deleted_at is NULL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends Base {
    @Column(name = "BUSINESS_ID")
    public Integer businessId;
    @Column(name = "ALIAS")
    public String alias;
    @Column(name = "TITLE")
    public String title;
}
