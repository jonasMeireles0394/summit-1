package org.uniube.summit.repositories.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "eventaddres")
public class EventAddresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eventaddres_seq")
    @SequenceGenerator(name = "eventaddres_seq", sequenceName = "eventaddres_seq", allocationSize=1)

    private Long id;
    private Long number;
    private String uf;
    private String place;
    private String district;
    private String city;
    private String complement;
    private String zipcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZipCode() {
        return zipcode;
    }

    public void setZipCode(String zipCode) {
        this.zipcode = zipCode;
    }

    @Override
    public String toString() {
        return "EventAddres{" +
                "id=" + id +
                ", number=" + number +
                ", uf='" + uf + '\'' +
                ", place='" + place + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", complement='" + complement + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
