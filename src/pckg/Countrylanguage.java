package pckg;

import javax.persistence.*;
import java.util.Objects;


@NamedQueries({
        @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
        @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
        @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name"),
        @NamedQuery(name = "City.findByDistrict", query = "SELECT c FROM City c WHERE c.district = :district"),
        @NamedQuery(name = "City.findByPopulation", query = "SELECT c FROM City c WHERE c.population = :population")})
@Entity
@IdClass(CountrylanguagePK.class)
public class Countrylanguage {
    private String countryCode;
    private String language;
    private boolean isOfficial;
    private double percentage;

    @Id
    @Column(name = "CountryCode", nullable = false, length = 3)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Id
    @Column(name = "Language", nullable = false, length = 30)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "IsOfficial", nullable = false)
    public boolean getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    @Basic
    @Column(name = "Percentage", nullable = false, precision = 1)
    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countrylanguage that = (Countrylanguage) o;
        return Double.compare(that.percentage, percentage) == 0 &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(language, that.language) &&
                Objects.equals(isOfficial, that.isOfficial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, language, isOfficial, percentage);
    }
}
