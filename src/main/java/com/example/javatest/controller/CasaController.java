package com.example.javatest.controller;

import com.example.javatest.domain.CursValutar;
import com.example.javatest.dto.CursValutarDto;
import com.example.javatest.service.CursValutarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CasaController {

    @Autowired
    private CursValutarService cursValutarService;

    @PostMapping("/addCursValutar")
    void addNewCursValutar(@RequestBody CursValutarDto cursValutarDto) {
        cursValutarService.save(cursValutarDto);
    }

    @GetMapping("/curs-valutar/{code}")
    Map<String, Object> getCursValutar(@PathVariable String code) {
        CursValutar cursValutar = cursValutarService.getCurrentCursValutar(code);

        Map<String, Object> cursValutarMapping = new HashMap<>();
        if (cursValutar != null) {
            cursValutarMapping.put("valuta", cursValutar.getDictionarValutar().getCode());
            cursValutarMapping.put("rata", cursValutar.getRata());
            cursValutarMapping.put("curs", cursValutar.getCurs());
        }
        return cursValutarMapping;
    }

}
