package com.nrahul32.movieapp.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
    @Id
    @GeneratedValue
    private int cityId;
    @Column(length = 20, nullable = false)
    private String cityName;

    @OneToMany (mappedBy = "city", fetch = FetchType.EAGER)
    private Set<Theatre> theatres;

    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(Set<Theatre> theatres) {
        this.theatres = theatres;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", theatres=" + theatres +
                '}';
    }
}
