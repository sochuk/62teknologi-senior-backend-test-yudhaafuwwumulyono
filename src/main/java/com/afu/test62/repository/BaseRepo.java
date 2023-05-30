package com.afu.test62.repository;

import com.afu.test62.model.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Date;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepo<T extends Base> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
    Optional<T> findById(Integer id);

    /**
     * Need to set deletedBy at controller
     * @param entity
     */
    default void softDelete(T entity){
        if(findById(entity.getId()).isPresent()){
            entity.setDeletedDate(new Date());
            save(entity);
        }
    }
}
