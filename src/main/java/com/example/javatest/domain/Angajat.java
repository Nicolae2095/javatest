package com.example.javatest.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ANGAJAT"
        , uniqueConstraints = @UniqueConstraint(columnNames = "CODE_UTILIZATOR"))

public class Angajat implements java.io.Serializable {

    private Long id;

    private String codeUtilizator;

    private Set<SchimbValutar> schimbValutars = new HashSet<SchimbValutar>(0);

    public Angajat() {
    }

    public Angajat(Long id, String codeUtilizator) {
        this.id = id;
        this.codeUtilizator = codeUtilizator;
    }

    public Angajat(Long id, String codeUtilizator, Set<SchimbValutar> schimbValutars) {
        this.id = id;
        this.codeUtilizator = codeUtilizator;
        this.schimbValutars = schimbValutars;
    }

    @SequenceGenerator(name = "generator", sequenceName = "ANGAJAT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CODE_UTILIZATOR", unique = true, nullable = false, length = 400)
    public String getCodeUtilizator() {
        return this.codeUtilizator;
    }

    public void setCodeUtilizator(String codeUtilizator) {
        this.codeUtilizator = codeUtilizator;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "angajat")
    public Set<SchimbValutar> getSchimbValutars() {
        return this.schimbValutars;
    }

    public void setSchimbValutars(Set<SchimbValutar> schimbValutars) {
        this.schimbValutars = schimbValutars;
    }

}


