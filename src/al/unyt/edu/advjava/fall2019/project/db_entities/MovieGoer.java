package al.unyt.edu.advjava.fall2019.project.db_entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_goers", schema = "movie_review", catalog = "")
public class MovieGoer {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Basic
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
        return id == movieGoer.id &&
                Objects.equals(name, movieGoer.name) &&
                Objects.equals(surname, movieGoer.surname) &&
                Objects.equals(email, movieGoer.email) &&
                Objects.equals(password, movieGoer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password);
    }
}
