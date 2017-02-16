package com.andersonbco.shortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonbco.shortener.domain.Statistics;

public interface StatisticsRepository extends JpaRepository<Statistics, String>{
}
