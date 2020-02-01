package al.unyt.edu.advjava.fall2019.project.db_entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "action_logs", schema = "movie_review", catalog = "")
public class ActionLog {
    private int id;
    private String actionValue;
    private Timestamp timeStamp;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "action_value", nullable = true, length = 255)
    public String getActionValue() {
        return actionValue;
    }

    public void setActionValue(String actionValue) {
        this.actionValue = actionValue;
    }

    @Basic
    @Column(name = "time_stamp", nullable = false)
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionLog actionLog = (ActionLog) o;
        return id == actionLog.id &&
                Objects.equals(actionValue, actionLog.actionValue) &&
                Objects.equals(timeStamp, actionLog.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionValue, timeStamp);
    }
}
