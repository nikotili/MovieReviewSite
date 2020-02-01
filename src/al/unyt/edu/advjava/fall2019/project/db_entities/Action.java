package al.unyt.edu.advjava.fall2019.project.db_entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actions", schema = "movie_review", catalog = "")
public class Action {
    private int id;
    private String code;
    private String description;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 15)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return id == action.id &&
                Objects.equals(code, action.code) &&
                Objects.equals(description, action.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, description);
    }
}
