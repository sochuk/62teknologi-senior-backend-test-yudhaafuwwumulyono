package com.afu.test62.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "BUSINESS")
@Where(clause = "deleted_at is NULL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business extends Base {
    @Column(name = "ALIAS")
    public String alias;
    @OneToOne
    @JoinColumn(name = "COORDINATE_ID", columnDefinition = "int")
    public Coordinates coordinates;
    @Column(name = "DISPLAY_PHONE")
    public String displayPhone;
    @Column(name = "DISTANCE")
    public Double distance;
    @Column(name = "IMAGE_URL")
    public String imageUrl;
    @Column(name = "IS_CLOSED")
    public Boolean isClosed;
    @OneToOne
    @JoinColumn(name = "LOCATION_ID", columnDefinition = "int")
    public Location location;
    @Column(name = "NAME")
    public String name;
    @Column(name = "PHONE")
    public String phone;
    @Column(name = "PRICE")
    public String price;
    @Column(name = "RATING")
    public Integer rating;
    @Column(name = "REVIEW_COUNT")
    public Integer reviewCount;
    @Column(name = "TRANSACTIONS", columnDefinition = "text[]")
    public String[] transactions;
    @Column(name = "URL")
    public String url;
    @ManyToOne
    @JoinColumn(name = "TRX_BUSINESS_ID", columnDefinition = "int")
    public TrxBusiness trxBusiness;
}

