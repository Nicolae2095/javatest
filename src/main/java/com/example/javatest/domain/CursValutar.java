package com.example.javatest.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "CURS_VALUTAR")
public class CursValutar implements java.io.Serializable {

    private Long id;

    private DictionarValutar dictionarValutar;

    private Integer rata;

    private Double curs;

    private Date dataCurs;

    private Set<SchimbValutar> schimbValutars = new HashSet<SchimbValutar>(0);

    public CursValutar() {
    }

    public CursValutar(Long id, DictionarValutar dictionarValutar, Integer rata, Double curs, Date dataCurs) {
        this.id = id;
        this.dictionarValutar = dictionarValutar;
        this.rata = rata;
        this.curs = curs;
        this.dataCurs = dataCurs;
    }

    public CursValutar(Long id, DictionarValutar dictionarValutar, Integer rata, Double curs, Date dataCurs, Set<SchimbValutar> schimbValutars) {
        this.id = id;
        this.dictionarValutar = dictionarValutar;
        this.rata = rata;
        this.curs = curs;
        this.dataCurs = dataCurs;
        this.schimbValutars = schimbValutars;
    }

    @SequenceGenerator(name = "generator", sequenceName = "CURS_VALUTAR_ID_SEQ", allocationSize = 1)
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
    @JoinColumn(name = "VALUTA_ID", nullable = false)
    public DictionarValutar getDictionarValutar() {
        return this.dictionarValutar;
    }

    public void setDictionarValutar(DictionarValutar dictionarValutar) {
        this.dictionarValutar = dictionarValutar;
    }

    @Column(name = "RATA", nullable = false, precision = 22, scale = 0)
    public Integer getRata() {
        return this.rata;
    }

    public void setRata(Integer rata) {
        this.rata = rata;
    }

    @Column(name = "CURS", nullable = false, precision = 16, scale = 4)
    public Double getCurs() {
        return this.curs;
    }

    public void setCurs(Double curs) {
        this.curs = curs;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_CURS", nullable = false, length = 7)
    public Date getDataCurs() {
        return this.dataCurs;
    }

    public void setDataCurs(Date dataCurs) {
        this.dataCurs = dataCurs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cursValutar")
    public Set<SchimbValutar> getSchimbValutars() {
        return this.schimbValutars;
    }

    public void setSchimbValutars(Set<SchimbValutar> schimbValutars) {
        this.schimbValutars = schimbValutars;
    }
}
