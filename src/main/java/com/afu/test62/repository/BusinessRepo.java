package com.afu.test62.repository;

import com.afu.test62.model.Business;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessRepo extends BaseRepo<Business> {
    Optional<List<Business>> findByTrxBusinessId(Integer trxBusinessId);
}
