package com.example.javatest.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "DICTIONAR_VALUTAR"
        , uniqueConstraints = @UniqueConstraint(columnNames = "CODE"))
public class DictionarValutar implements java.io.Serializable {

    private Long id;

    private String code;

    private String name;

    private Set<CursValutar> cursValutars = new HashSet<CursValutar>(0);

    public DictionarValutar() {
    }

    public DictionarValutar(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public DictionarValutar(Long id, String code, String name, Set<CursValutar> cursValutars) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.cursValutars = cursValutars;
    }

    @SequenceGenerator(name = "generator", sequenceName = "DICTIONAR_VALUTAR_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CODE", unique = true, nullable = false, length = 6)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "NAME", length = 400)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dictionarValutar")
    public Set<CursValutar> getCursValutars() {
        return this.cursValutars;
    }

    public void setCursValutars(Set<CursValutar> cursValutars) {
        this.cursValutars = cursValutars;
    }
}
