package com.example.javatest.domain;

import javax.persistence.*;


@Entity
@Table(name = "SCHIMB_VALUTAR")
public class SchimbValutar implements java.io.Serializable {

    private Long id;

    private Numerar numerar;

    private Angajat angajat;

    private CursValutar cursValutar;

    public SchimbValutar() {
    }

    public SchimbValutar(Long id, Numerar numerar, Angajat angajat, CursValutar cursValutar) {
        this.id = id;
        this.numerar = numerar;
        this.angajat = angajat;
        this.cursValutar = cursValutar;
    }

    @SequenceGenerator(name = "generator", sequenceName = "SCHIMB_VALUTAR_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NUMERAR_ID", nullable = false)
    public Numerar getNumerar() {
        return this.numerar;
    }

    public void setNumerar(Numerar numerar) {
        this.numerar = numerar;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANGAJAT_ID", nullable = false)
    public Angajat getAngajat() {
        return this.angajat;
    }

    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURS_VALUTAR_ID", nullable = false)
    public CursValutar getCursValutar() {
        return this.cursValutar;
    }

    public void setCursValutar(CursValutar cursValutar) {
        this.cursValutar = cursValutar;
    }

}
