package com.example.javatest.service.repository;

import com.example.javatest.domain.CursValutar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CursValutarRepository extends JpaRepository<CursValutar, Long> {

    CursValutar getByDataCursAndDictionarValutarCode(Date date, String code);

}
