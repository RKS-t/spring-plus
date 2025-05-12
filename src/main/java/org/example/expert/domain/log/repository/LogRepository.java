package org.example.expert.domain.log.repository;

import org.example.expert.domain.log.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long> {


}
