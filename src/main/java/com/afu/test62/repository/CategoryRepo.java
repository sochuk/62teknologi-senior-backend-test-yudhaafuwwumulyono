package com.afu.test62.repository;

import com.afu.test62.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends BaseRepo<Category> {
    Optional<List<Category>> findByBusinessId(Integer businessId);
}
