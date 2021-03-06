package al.unyt.edu.advjava.fall2019.project.persistence.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movie_goers", schema = "movie_review")
public class MovieGoer {
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<Rating> ratings;

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 30)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Id
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieGoer movieGoer = (MovieGoer) o;
        return Objects.equals(name, movieGoer.name) &&
                Objects.equals(surname, movieGoer.surname) &&
                Objects.equals(email, movieGoer.email) &&
                Objects.equals(password, movieGoer.password);
    }

    @OneToMany(mappedBy = "movieGoer", fetch = FetchType.EAGER)
    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String fullName() {
        return getName() + " " + getSurname();
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, password);
    }
}
