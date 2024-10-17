package com.java.springboot.kafka.repository;

import com.java.springboot.kafka.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaData,Long> {
}
