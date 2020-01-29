package pckg;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class City {
    private int id;
    private String name;
    private String district;
    private int population;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 35)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "District", nullable = false, length = 20)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "Population", nullable = false)
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id &&
                population == city.population &&
                Objects.equals(name, city.name) &&
                Objects.equals(district, city.district);
    }


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, district, population);
    }
}
