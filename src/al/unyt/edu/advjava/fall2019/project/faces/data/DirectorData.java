package al.unyt.edu.advjava.fall2019.project.faces.data;

public class DirectorData {
    private String name;
    private String surname;

    public DirectorData(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
