package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.faces.FacesUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EditMovieBean extends RequiresLoginBean {

    @Override
    public void init() {
        try {
            super.init();
            boolean editMode = getMovieController().isEditMode();
            if (!editMode)
                FacesUtil.redirect(FacesUtil.INDEX_URI);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Redirected from super.init()");
        }
    }
}
