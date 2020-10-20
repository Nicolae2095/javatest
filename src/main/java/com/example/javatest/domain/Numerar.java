package com.example.javatest.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NUMERAR")
public class Numerar implements java.io.Serializable {

    private Long id;

    private Double value;

    private Set<SchimbValutar> schimbValutars = new HashSet<SchimbValutar>(0);

    public Numerar() {
    }

    public Numerar(Long id, Double value) {
        this.id = id;
        this.value = value;
    }

    public Numerar(Long id, Double value, Set<SchimbValutar> schimbValutars) {
        this.id = id;
        this.value = value;
        this.schimbValutars = schimbValutars;
    }

    @SequenceGenerator(name = "generator", sequenceName = "NUMERAR_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "VALUE", nullable = false, precision = 22, scale = 4)
    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "numerar")
    public Set<SchimbValutar> getSchimbValutars() {
        return this.schimbValutars;
    }

    public void setSchimbValutars(Set<SchimbValutar> schimbValutars) {
        this.schimbValutars = schimbValutars;
    }
}
