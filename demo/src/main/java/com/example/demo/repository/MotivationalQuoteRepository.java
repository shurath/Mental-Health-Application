package com.example.demo.repository;

import com.example.demo.entity.MotivationalQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivationalQuoteRepository extends JpaRepository<MotivationalQuote, Long> {
    @Query(value = "SELECT * FROM motivational_quote ORDER BY RAND() LIMIT 1", nativeQuery = true)
    MotivationalQuote findRandomQuote();
}
