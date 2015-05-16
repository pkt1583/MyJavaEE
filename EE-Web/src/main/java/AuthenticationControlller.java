import com.auth.model.LoginInfo;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by pankaj on 16-05-2015.
 */
@Named(value = "authenticationController")
public class AuthenticationControlller {
    @Inject
    LoginInfo loginInfo;
    public boolean authenticate(){
        return true;
    }
}
