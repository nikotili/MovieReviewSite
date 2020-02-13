package al.unyt.edu.advjava.fall2019.project.faces.converter;

import al.unyt.edu.advjava.fall2019.project.faces.data.DirectorData;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Director;

import java.util.Set;
import java.util.stream.Collectors;

public class DirectorConverter {

    private static DirectorData toData(Director director) {
        return new DirectorData(director.getName(), director.getSurname());
    }

    public static Set<DirectorData> toDataSet(Set<Director> directors) {
        return directors
                .stream()
                .map(DirectorConverter::toData)
                .collect(Collectors.toSet());
    }
}
