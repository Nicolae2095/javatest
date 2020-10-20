package com.example.javatest.service;

import com.example.javatest.domain.CursValutar;
import com.example.javatest.dto.CursValutarDto;

public interface CursValutarService {

    CursValutar getCurrentCursValutar(String valtua);

    CursValutar save(CursValutarDto cursValutarDto);
}
