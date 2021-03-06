package al.unyt.edu.advjava.fall2019.project.core.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.sql.Date;

@FacesConverter(
        value = "al.unyt.edu.advjava.fall2019.project.bean.DateConverter",
        forClass = Date.class
)

//fixme not safe
public class DateConverter implements Converter<Date> {
    @Override
    public Date getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return Date.valueOf(value);
        }
        catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Date value) {
        return value.toString();
    }
}
