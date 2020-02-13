package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.manager.session.DefaultSessionManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class RequiresLoginBean {

    @PostConstruct
    public void init() {
        if (!DefaultSessionManager.getInstance().hasLoggedUser())
            FacesUtil.redirect(FacesUtil.LOGIN_URI);
    }
}
