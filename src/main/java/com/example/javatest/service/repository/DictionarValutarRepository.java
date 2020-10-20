package com.example.javatest.service.repository;

import com.example.javatest.domain.DictionarValutar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionarValutarRepository extends JpaRepository<DictionarValutar, Long> {

    DictionarValutar getByCode(String code);
}
