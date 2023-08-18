package com.Demo.Enum.repository;

import com.Demo.Enum.entity.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorRepository extends JpaRepository<ErrorEntity, Long>{

}
