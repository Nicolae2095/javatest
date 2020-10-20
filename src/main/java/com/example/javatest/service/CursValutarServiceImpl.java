package com.example.javatest.service;

import com.example.javatest.domain.CursValutar;
import com.example.javatest.dto.CursValutarDto;
import com.example.javatest.service.repository.CursValutarRepository;
import com.example.javatest.service.repository.DictionarValutarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class CursValutarServiceImpl implements CursValutarService {

    @Autowired
    private CursValutarRepository cursValutarRepository;

    @Autowired
    private DictionarValutarRepository dictionarValutarRepository;

    @Override
    public CursValutar getCurrentCursValutar(String valtua) {
        return cursValutarRepository.getByDataCursAndDictionarValutarCode(getCurrentDate(), valtua);
    }

    @Override
    public CursValutar save(CursValutarDto cursValutarDto) {
        CursValutar newCursValutar = new CursValutar();
        newCursValutar.setDictionarValutar(dictionarValutarRepository.getByCode(cursValutarDto.getValuta()));
        newCursValutar.setRata(cursValutarDto.getRata());
        newCursValutar.setCurs(cursValutarDto.getCurs());
        newCursValutar.setDataCurs(getCurrentDate());
        return cursValutarRepository.save(newCursValutar);
    }

    private Date getCurrentDate(){
        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
