package com.afu.test62.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "COORDINATES")
@Where(clause = "deleted_at is NULL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates extends Base {

    @Column(name = "LATITUDE")
    public Double latitude;
    @Column(name = "LONGITUDE")
    public Double longitude;

}
