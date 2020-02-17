package al.unyt.edu.advjava.fall2019.project.faces.data;

public class MovieGoerData {
    private String name;
    private String surname;
    private String email;

    public MovieGoerData(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return name + " " + surname;
    }
}
