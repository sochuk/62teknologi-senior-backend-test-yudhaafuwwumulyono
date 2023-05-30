package com.afu.test62.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;


@Entity
@Table(name = "LOCATION")
@Where(clause = "deleted_at is NULL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location extends Base {
    @Column(name = "ADDRESS_1")
    public String address1;
    @Column(name = "ADDRESS_2")
    public String address2;
    @Column(name = "ADDRESS_3")
    public String address3;
    @Column(name = "CITY")
    public String city;
    @Column(name = "COUNTRY")
    public String country;
    @Column(name = "DISPLAY_ADDRESS", columnDefinition = "text[]")
    public String[] displayAddress;
    @Column(name = "STATE")
    public String state;
    @Column(name = "ZIPCODE")
    public String zipCode;

}
