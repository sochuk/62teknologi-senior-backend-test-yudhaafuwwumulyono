package com.afu.test62.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "TRX_BUSINESS")
@Where(clause = "deleted_at is NULL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxBusiness extends Base {
    @OneToOne
    @JoinColumn(name = "REGION_ID")
    public Region region;
    @Column(name = "TOTAL")
    public Integer total;
}
